package com.demo.covid19;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import  javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HomeController extends GoToScene implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Text usernameText ;

    //test

    @Override
    public void goToSceneDiary(ActionEvent event) throws IOException {
        super.goToSceneDiary(event);
    }

    @Override
    public void goToSceneLogin(ActionEvent event) throws IOException, SQLException {
        super.goToSceneLogin(event);
    }

    @Override
    public void goToSceneShowDiary(ActionEvent event) throws IOException {
        super.goToSceneShowDiary(event);
    }

    @Override
    public void goToSceneCovidAlert(ActionEvent event) throws IOException {
        super.goToSceneCovidAlert(event);
    }

    private int queryCount(String sql, ConnectionDatabase connectionDatabase)throws SQLException{
        try {
            PreparedStatement ps = connectionDatabase.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("count(id)");
            }
        }catch (Exception error)
        {
            System.out.println(error);
        }
        return  0;
    }
    public void showAllAdvertise() throws SQLException {

        //แสดงว่าติดโควิดกี่คน มีอาการอะไรบ้าง จาก database
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();

        String sqlCough = "select count(id) from `user_symptoms` WHERE cough = 1 ";
        String sqlFever = "select count(id) from `user_symptoms` WHERE fever = 1 ";
        String sqlSore_throat = "select count(id) from `user_symptoms` WHERE sore_throat = 1 ";
        String sqlTounge = "select count(id) from `user_symptoms` WHERE tongue_does_not_taste = 1 ";
        String sqlRunny = "select count(id) from `user_symptoms` WHERE runny_nose = 1 ";
        String sqlTired = "select count(id) from `user_symptoms` WHERE tired = 1 ";
        String sqlPanting = "select count(id) from `user_symptoms` WHERE panting = 1 ";
        String sqlNo = "select count(id) from `user_symptoms` WHERE no_symptoms = 1 ";
        int countCough = queryCount(sqlCough,connectionDatabase);
        int countFever = queryCount(sqlFever,connectionDatabase);
        int countSore_throat = queryCount(sqlSore_throat,connectionDatabase);
        int countTounge = queryCount(sqlTounge,connectionDatabase);
        int countRunny = queryCount(sqlRunny,connectionDatabase);
        int countTired = queryCount(sqlTired,connectionDatabase);
        int countPanting = queryCount(sqlPanting,connectionDatabase);
        int countNo = queryCount(sqlNo,connectionDatabase);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameText.setText(UserHolder.username);
    }
}
