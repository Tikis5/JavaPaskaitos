import jdbc.JDBCConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudentDataExample {
    public static void main(String[] args) {
        try {
            JDBCConnector jdbcConnector = new JDBCConnector();
            Connection connect = jdbcConnector.connect();
            if (connect == null) {
                System.out.println("Cannot connection to db");
            }
            Statement statement = connect.createStatement();

            statement.execute("delete from students where id = 1");
        } catch (SQLException e) {
            System.out.println("SQL Exeption");
            System.out.println(e.getMessage());
        }
    }
}
