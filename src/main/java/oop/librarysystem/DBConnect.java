package oop.librarysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public Connection connection;
    public Connection getConnection(){
        String dbName = "librarysystem";
        String dbUser = "root";
        String dbPassword = "";
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,dbUser,dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
