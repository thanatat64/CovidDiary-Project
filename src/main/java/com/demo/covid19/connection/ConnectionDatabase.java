package com.demo.covid19.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

    public ConnectionDatabase() {

    }

    public Connection getConn() throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "P@ssw0rd");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://161.246.5.40:3777/myCovid", "root", "VwmCRG2nuWhGp9aA");

        return conn;
    }


}
