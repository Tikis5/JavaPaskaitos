package com.kcs.springboot.example.service;

import com.kcs.springboot.example.data.Student;
import com.kcs.springboot.example.data.StudentMark;
import com.kcs.springboot.example.jdbc.JDBCConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentMarkService {
    private JDBCConnector jdbcConnector;

    @Autowired
    public StudentMarkService(JDBCConnector jdbcConnector) {
        this.jdbcConnector = jdbcConnector;
    }

    public StudentMark getStudentMark(String studentId, String studentMarkId) {
        try {
            PreparedStatement preparedStatement = jdbcConnector.getPreparedStatement("select * from student_marks where student_id=? and id =  ?");
            preparedStatement.setInt(1, Integer.parseInt(studentId));
            preparedStatement.setInt(2, Integer.parseInt(studentMarkId));

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return convertStudentMark(resultSet);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<StudentMark> getStudentMarks(String studentId) {
        List<StudentMark> studentMarks = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = jdbcConnector.getPreparedStatement("select * from student_marks where student_id = ?");
            preparedStatement.setInt(1, Integer.parseInt(studentId));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                studentMarks.add(convertStudentMark(resultSet));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return studentMarks;
    }

    private StudentMark convertStudentMark(ResultSet resultSet) throws SQLException {
        return new StudentMark(resultSet.getInt("id"),
                resultSet.getInt("student_id"),
                resultSet.getString("title"),
                resultSet.getInt("mark"),
                resultSet.getDate("time_stamp"));
    }
}
