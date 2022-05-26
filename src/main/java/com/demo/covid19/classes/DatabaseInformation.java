package com.demo.covid19.classes;

import com.demo.covid19.connection.ConnectionDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseInformation {
    public ConnectionDatabase connectionDatabase = new ConnectionDatabase();
    private int countCough;
    private int countFever;
    private int countSorethroat;
    private int countTounge;
    private int countRunny;
    private int countTired;
    private int countPanting;
    private int countNo;

    public DatabaseInformation() throws SQLException {
        showAllAdvertise();
    }

    private int queryCount(String sql, ConnectionDatabase connectionDatabase) throws SQLException {
        try {
            PreparedStatement ps = connectionDatabase.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("count(id)");
            }
        } catch (Exception error) {
            System.out.println(error);
        }
        return 0;
    }


    public void showAllAdvertise() throws SQLException {

        //แสดงว่าติดโควิดกี่คน มีอาการอะไรบ้าง จาก database

        String sqlCough = "select count(id) from `user_symptoms` WHERE cough = 1 ";
        String sqlFever = "select count(id) from `user_symptoms` WHERE fever = 1 ";
        String sqlSore_throat = "select count(id) from `user_symptoms` WHERE sore_throat = 1 ";
        String sqlTounge = "select count(id) from `user_symptoms` WHERE tongue_does_not_taste = 1 ";
        String sqlRunny = "select count(id) from `user_symptoms` WHERE runny_nose = 1 ";
        String sqlTired = "select count(id) from `user_symptoms` WHERE tired = 1 ";
        String sqlPanting = "select count(id) from `user_symptoms` WHERE panting = 1 ";
        String sqlNo = "select count(id) from `user_symptoms` WHERE no_symptoms = 1 ";
        countCough = queryCount(sqlCough, connectionDatabase);
        countFever = queryCount(sqlFever, connectionDatabase);
        countSorethroat = queryCount(sqlSore_throat, connectionDatabase);
        countTounge = queryCount(sqlTounge, connectionDatabase);
        countRunny = queryCount(sqlRunny, connectionDatabase);
        countTired = queryCount(sqlTired, connectionDatabase);
        countPanting = queryCount(sqlPanting, connectionDatabase);
        countNo = queryCount(sqlNo, connectionDatabase);

    }
    public int getCountOfUsers() throws Exception {
        String countUsersSQL = "select count(1) as total from users";
        PreparedStatement ps = connectionDatabase.getConn().prepareStatement(countUsersSQL);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public int getCountOfDiaries() throws Exception {
        String countOfDiariesSQL = "select count(1) as total from user_diaries";
        PreparedStatement ps = connectionDatabase.getConn().prepareStatement(countOfDiariesSQL);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public int getCountCough(){
        return countCough;
    }

    public int getCountFever() {
        return countFever;
    }

    public int getCountSorethroat() {
        return countSorethroat;
    }

    public int getCountTounge() {
        return countTounge;
    }

    public int getCountRunny() {
        return countRunny;
    }

    public int getCountTired() {
        return countTired;
    }

    public int getCountPanting() {
        return countPanting;
    }

    public int getCountNo() {
        return countNo;
    }
}
