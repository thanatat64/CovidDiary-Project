package com.demo.covid19;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MySQLPlayground {

    // UPDATE users SET password = ? WHERE id = ?;

    public static void main(String... args) throws Exception {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "P@ssw0rd");
        String updateString = "UPDATE users SET password = ? ";

        PreparedStatement updatePassword = conn.prepareStatement(updateString);

        updatePassword.setString(1, "new_password");
        updatePassword.executeUpdate();
    }

    public void insert() throws Exception {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "P@ssw0rd");
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "Nichapat");
        statement.setString(2, "password");
        statement.execute();
    }

//    public void insert() throws Exception {
//        Connection conn = null;
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "P@ssw0rd");
//        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1,"nichapat");
//        statement.setString(2, "password");
//        statement.execute();
//    }

    public void query() throws Exception {
        String query = "SELECT id, username, password, created_at FROM users";
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "P@ssw0rd");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String created_at = rs.getString("created_at");
            System.out.println("ID: "+ id + " Username: " + username + " Password: " + password + " Created at: " + created_at);
        }
    }

    public void update() throws Exception {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "P@ssw0rd");
        String updateString = "update users set password = ? where username = ?";

        PreparedStatement updatePassword = conn.prepareStatement(updateString);

        updatePassword.setString(1, "new_Password");
        updatePassword.setString(2, "new_Username");
        updatePassword.executeUpdate();
    }

}
