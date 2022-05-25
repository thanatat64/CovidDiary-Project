package com.demo.covid19.controller;

import com.demo.covid19.Classes.DbInfo;
import com.demo.covid19.Classes.GoToScene;
import com.demo.covid19.Classes.UserHolder;
import com.demo.covid19.Connection.ConnectionDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HomeController extends GoToScene {

    private Stage stage;
    private Scene scene;
    private Parent root;
    DbInfo info = new DbInfo();

    @FXML
    Text usernameText;
    @FXML
    Text countUserText;
    @FXML
    Text countDiaryText;
    @FXML
    Text coughText;
    @FXML
    Text feverText;
    @FXML
    Text soreThroatText;
    @FXML
    Text tongueText;
    @FXML
    Text runnyText;
    @FXML
    Text tiredText;
    @FXML
    Text pantingText;
    @FXML
    Text noText;

    ConnectionDatabase connectionDatabase = new ConnectionDatabase();

    public HomeController() throws SQLException {
    }

    @Override
    public void goToSceneDiary(ActionEvent event) throws IOException, Exception {
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

    public void initialize() {
        try {
            usernameText.setText(UserHolder.username);
            countUserText.setText(String.valueOf(info.getCountOfUsers()));
            countDiaryText.setText(String.valueOf(info.getCountOfDiaries()));
            coughText.setText(String.valueOf(info.getCountCough()));
            feverText.setText(String.valueOf(info.getCountFever()));
            soreThroatText.setText(String.valueOf(info.getCountSorethroat()));
            tongueText.setText(String.valueOf(info.getCountTounge()));
            runnyText.setText(String.valueOf(info.getCountRunny()));
            tiredText.setText(String.valueOf(info.getCountTired()));
            pantingText.setText(String.valueOf(info.getCountPanting()));
            noText.setText(String.valueOf(info.getCountNo()));
        } catch (Exception e) {
            System.out.println("can't pass value");
            throw new RuntimeException(e);
        }

    }
}
