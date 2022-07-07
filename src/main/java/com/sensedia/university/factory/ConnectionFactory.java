package com.sensedia.university.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    final static private String host = "jdbc:mysql://localhost/university?useTimezone=true&serverTimezone=UTC&characterEncoding=latin1";

    final static private String user = "root";

    final static private String password = "root";


    public static Connection createConnection() throws SQLException {
        return DriverManager
                .getConnection(host, user, password);
    }
}
