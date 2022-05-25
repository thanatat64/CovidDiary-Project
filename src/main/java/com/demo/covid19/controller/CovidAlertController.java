package com.demo.covid19.controller;

import com.demo.covid19.classes.UserHolder;
import com.demo.covid19.connection.ConnectionDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.sql.*;

public class CovidAlertController {

    @FXML
    private CheckBox coughBox;

    @FXML
    private CheckBox feverBox;

    @FXML
    private CheckBox soreThroatBox;

    @FXML
    private CheckBox tongueDoesNotTasteBox;

    @FXML
    private CheckBox runnyNoseBox;

    @FXML
    private CheckBox tiredBox;

    @FXML
    private CheckBox pantingBox;

    @FXML
    private CheckBox noSymptomsBox;

    private boolean cough;
    private boolean fever;
    private boolean soreThroat;
    private boolean tongueDoesNotTaste;
    private boolean runnyNose;
    private boolean tired;
    private boolean panting;
    private boolean noSymptoms;

    // Get database connection
    ConnectionDatabase connectionDatabase = new ConnectionDatabase();

    public void saveCovidAlert(ActionEvent event) throws Exception {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        System.out.println(UserHolder.getInstance().getUserId());

        int userID = UserHolder.getInstance().getUserId();
        Statement stmt = connectionDatabase.getConn().createStatement();

        String sql = "INSERT INTO user_symptoms (user_id, cough, fever, sore_throat, tongue_does_not_taste, runny_nose, tired, panting, no_symptoms) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connectionDatabase.getConn().prepareStatement(sql);

        cough = coughBox.isSelected();
        fever = feverBox.isSelected();
        soreThroat = soreThroatBox.isSelected();
        tongueDoesNotTaste = tongueDoesNotTasteBox.isSelected();
        runnyNose = runnyNoseBox.isSelected();
        tired = tiredBox.isSelected();
        panting = pantingBox.isSelected();

        if (noSymptoms = noSymptomsBox.isSelected()) {
            cough = false;
            fever = false;
            soreThroat = false;
            tongueDoesNotTaste = false;
            runnyNose = false;
            tired = false;
            panting = false;
        }

        ps.setInt(1, userID);
        ps.setBoolean(2, cough);
        ps.setBoolean(3, fever);
        ps.setBoolean(4, soreThroat);
        ps.setBoolean(5, tongueDoesNotTaste);
        ps.setBoolean(6, runnyNose);
        ps.setBoolean(7, tired);
        ps.setBoolean(8, panting);
        ps.setBoolean(9, noSymptoms);
        ps.executeUpdate();


    }


}
