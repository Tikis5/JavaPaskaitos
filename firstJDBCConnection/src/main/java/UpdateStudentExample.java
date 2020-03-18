import jdbc.JDBCConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudentExample {
    public static void main(String[] args) {
        /**
         * 1. sukurti connection object ir iskviesti connection metoda
         * 2. sukurti statmenta
         * 3. executinti statement.execute
         */
        try {
        JDBCConnector jdbcConnector = new JDBCConnector();
        Connection connect = jdbcConnector.connect();
        if (connect == null) {
            System.out.println("Cannot connection to db");
        }
            Statement statement = connect.createStatement();

            statement.execute("UPDATE students set name = 'Tomas' where id=1");
        } catch (SQLException e) {
            System.out.println("SQL Exeption");
            System.out.println(e.getMessage());
        }
    }
}
