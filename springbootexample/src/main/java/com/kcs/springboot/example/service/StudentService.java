package com.kcs.springboot.example.service;

import com.kcs.springboot.example.data.Student;
import com.kcs.springboot.example.jdbc.JDBCConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService {
    private JDBCConnector jdbcConnector;

    @Autowired
    public StudentService(JDBCConnector jdbcConnector) {
        this.jdbcConnector = jdbcConnector;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = jdbcConnector.getPreparedStatement("select * from students");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                students.add(mapStudent(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public Student createStudent(Student student) {

        try {
            PreparedStatement preparedStatement = jdbcConnector.getPreparedStatement
                    ("insert into students(name, surname, phone, email) values (?,?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setString(4, student.getEmail());

            preparedStatement.execute();
            return getStudents().stream().filter(s -> s.equals(student)).findFirst().orElse(null);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Student updateStudent(Student student){
        Connection connection = jdbcConnector.createConnection();
        if (connection == null){
            return null;
        }
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement
                    ("update students set name = ?, surname = ?, phone = ?, email = ? where id =?");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setInt(5, student.getId());

            preparedStatement.execute();

            return student;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Student deleteStudent(String studentId) {
        Connection connection = jdbcConnector.createConnection();
        if (connection == null) {
            return null;
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id=?");
            preparedStatement.setInt(1, Integer.parseInt(studentId));
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Student getStudent(String studentId) {

        Connection connection = jdbcConnector.createConnection();
        if (connection == null) {
            return null;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from students where id = ?");
            preparedStatement.setInt(1, Integer.parseInt(studentId));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapStudent(resultSet);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Student mapStudent(ResultSet resultSet) throws SQLException {
        return new Student(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("phone"),
                resultSet.getString("email"));
    }
}
