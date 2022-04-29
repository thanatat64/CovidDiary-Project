package com.demo.covid19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

    public ConnectionDatabase() {

    }

    public Connection getConn() throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "P@ssw0rd");

        return conn;
    }
}
