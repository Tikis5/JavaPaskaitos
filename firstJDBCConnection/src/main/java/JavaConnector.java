import data.Student;
import jdbc.JDBCConnector;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JavaConnector {
    public static void main(String[] args) {
        /**
         * 1. Sukurti connection
         * 2. is connection sukurti statment
         * 3. executinti statment
         */
        List<Student> students = new ArrayList<>();

        try {
            //1
            JDBCConnector jdbcConnector = new JDBCConnector();
            Connection connect = jdbcConnector.connect();
            if(connect == null){
                return;
            }
            //2
            Statement statement = connect.createStatement();
            //3
            ResultSet resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")));
            }
        }
        catch (SQLException e){
            System.out.println("SQL Exeption");
        }

        //students.forEach(System.out::println);
        students.forEach(s ->{
            System.out.println(s.getId());
            System.out.println(s.getName());
        });
    }
}
