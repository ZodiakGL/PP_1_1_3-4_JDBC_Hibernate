package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/lesson2";
    public static final String DB_USERNAME = "ss";
    public static final String DB_PASSWORD = "";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("ЗАЕБИСЬ");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ХУЕВО");
            e.printStackTrace();
        }
        return connection;
    }
}
