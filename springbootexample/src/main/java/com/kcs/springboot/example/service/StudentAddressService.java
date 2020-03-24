package com.kcs.springboot.example.service;

import com.kcs.springboot.example.data.Student;
import com.kcs.springboot.example.data.StudentAddress;
import com.kcs.springboot.example.jdbc.JDBCConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentAddressService {
    private JDBCConnector jdbcConnector;

    @Autowired
    public StudentAddressService(JDBCConnector jdbcConnector) {
        this.jdbcConnector = jdbcConnector;
    }

    public StudentAddress getStudentAddress(String studentId, String addressId) {

        try {
            PreparedStatement preparedStatement = jdbcConnector.getPreparedStatement("select * from student_address where student_id=? and id =  ?");
            preparedStatement.setInt(1, Integer.parseInt(studentId));
            preparedStatement.setInt(2, Integer.parseInt(addressId));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return convertStudentAddress(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<StudentAddress> getStudentAddresses(String studentId) {
        List<StudentAddress> studentAddresses = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = jdbcConnector.getPreparedStatement("select * from student_address where student_id=?");
            preparedStatement.setInt(1, Integer.parseInt(studentId));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                studentAddresses.add(convertStudentAddress(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return studentAddresses;
    }

    public StudentAddress createStudentAddress(StudentAddress studentAddress, String studentId) {

        try {
            studentAddress.setStudentId(Integer.parseInt(studentId));
            PreparedStatement preparedStatement = jdbcConnector.getPreparedStatement("insert into student_address" +
                    "(student_id, country, city, street, post_code)values (?,?,?,?,?)");
            preparedStatement.setInt(1, studentAddress.getStudentId());
            preparedStatement.setString(2, studentAddress.getCountry());
            preparedStatement.setString(3, studentAddress.getCity());
            preparedStatement.setString(4, studentAddress.getStreet());
            preparedStatement.setString(5, studentAddress.getPostCode());

            preparedStatement.execute();
            return getStudentAddresses(studentId).stream()
                    .filter(a -> a.equals(studentAddress))
                    .findFirst()
                    .orElse(null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public StudentAddress updateStudentAddress(StudentAddress studentAddress) {
        try {
            PreparedStatement preparedStatement = jdbcConnector.getPreparedStatement
                    ("update student_address set country= ?, city = ?, street = ?, post_code = ? where id = ?");
            preparedStatement.setString(1, studentAddress.getCountry());
            preparedStatement.setString(2, studentAddress.getCity());
            preparedStatement.setString(3, studentAddress.getStreet());
            preparedStatement.setString(4, studentAddress.getPostCode());
            preparedStatement.setInt(5, studentAddress.getId());

            preparedStatement.executeUpdate();

            return studentAddress;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void deleteStudentAddress(String studentId, String studentAddressId) {
        try {
            PreparedStatement preparedStatement = jdbcConnector.getPreparedStatement("delete from student_address where student_id= ? and id =?");
            preparedStatement.setInt(1, Integer.parseInt(studentId));
            preparedStatement.setInt(2, Integer.parseInt(studentAddressId));
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private StudentAddress convertStudentAddress(ResultSet resultSet) throws SQLException {
        return new StudentAddress(resultSet.getInt("id"),
                resultSet.getInt("student_id"),
                resultSet.getString("country"),
                resultSet.getString("city"),
                resultSet.getString("street"),
                resultSet.getString("post_code"));
    }
}

