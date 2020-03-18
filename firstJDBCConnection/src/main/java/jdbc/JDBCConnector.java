package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
    public Connection connect(){
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kcs", "root", "");
        } catch (SQLException e) {
            System.out.println("Prisijungti nepavyko");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
