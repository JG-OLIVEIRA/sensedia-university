package com.sensedia.university.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection createConnection() throws SQLException {
        return DriverManager
                .getConnection("jdbc:mysql://localhost/university?useTimezone=true&serverTimezone=UTC&characterEncoding=UTF-8", "root", "root");
    }
}
