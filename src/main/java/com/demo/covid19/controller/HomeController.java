package com.demo.covid19.controller;

import com.demo.covid19.classes.DatabaseInformation;
import com.demo.covid19.classes.GoToScene;
import com.demo.covid19.classes.UserHolder;
import com.demo.covid19.connection.ConnectionDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HomeController extends GoToScene {

    private Stage stage;
    private Scene scene;
    private Parent root;
    DatabaseInformation info = new DatabaseInformation();

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
    @FXML
    PieChart pieChart;
    @FXML
    BarChart barChart;

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
            //Db
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
            //PieChart
            XYChart.Series<String,Integer> series = new XYChart.Series<>();
            series.setName("Symptoms barchart");
            series.getData().add(new XYChart.Data<>("cough", info.getCountCough()));
            series.getData().add(new XYChart.Data<>("fever", info.getCountFever()));
            series.getData().add(new XYChart.Data<>("sore throat", info.getCountSorethroat()));
            series.getData().add(new XYChart.Data<>("tongue does not taste", info.getCountTounge()));
            series.getData().add(new XYChart.Data<>("Runny nose", info.getCountRunny()));
            series.getData().add(new XYChart.Data<>("tired",info.getCountTired()));
            series.getData().add(new XYChart.Data<>("panting",info.getCountPanting()));
            series.getData().add(new XYChart.Data<>("no symptoms",info.getCountNo()));
            barChart.getData().addAll(series);
//            ObservableList<PieChart.Data>pieChartData
//                    = FXCollections.observableArrayList(
//                            new PieChart.Data("cough", info.getCountCough()),
//                            new PieChart.Data("fever", info.getCountFever()),
//                            new PieChart.Data("sore throat", info.getCountSorethroat()),
//                            new PieChart.Data("tongue does not taste", info.getCountTounge()),
//
//                            new PieChart.Data("Runny nose", info.getCountRunny()),
//                            new PieChart.Data("tired",info.getCountTired()),
//                            new PieChart.Data("panting",info.getCountPanting()),
//                            new PieChart.Data("no symptoms",info.getCountNo())
//            );
//            pieChart.setData(pieChartData);
//            pieChart.setStartAngle(90);
        } catch (Exception e) {
            System.out.println("can't pass value");
            throw new RuntimeException(e);
        }

    }
}
