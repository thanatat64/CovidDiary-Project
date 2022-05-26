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
        int userID = UserHolder.getInstance().getUserId();
        Statement stmt = connectionDatabase.getConn().createStatement();

        String selectSymptoms_IdSQL = "select * from user_symptoms where user_id = ? limit 1";
        PreparedStatement ps = connectionDatabase.getConn().prepareStatement(selectSymptoms_IdSQL);
        ps.setInt(1, userID);
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            int symptomsId = rs.getInt("id");

            String updateSymptoms = "update user_symptoms set cough = ?, fever = ?, sore_throat = ?, tongue_does_not_taste = ?, runny_nose = ?, tired = ?, panting = ?, no_symptoms = ? where id = ?";
            PreparedStatement ps2 = connectionDatabase.getConn().prepareStatement(updateSymptoms);

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

            ps2.setBoolean(1, cough);
            ps2.setBoolean(2, fever);
            ps2.setBoolean(3, soreThroat);
            ps2.setBoolean(4, tongueDoesNotTaste);
            ps2.setBoolean(5, runnyNose);
            ps2.setBoolean(6, tired);
            ps2.setBoolean(7, panting);
            ps2.setBoolean(8, noSymptoms);
            ps2.setInt(9, symptomsId);
            ps2.executeUpdate();

        } else {
            String insertAllOfCovid = "insert into user_symptoms (user_id, cough, fever, sore_throat, tongue_does_not_taste, runny_nose, tired, panting, no_symptoms) value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps3 = connectionDatabase.getConn().prepareStatement(insertAllOfCovid);

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

            ps3.setInt(1, userID);
            ps3.setBoolean(2, cough);
            ps3.setBoolean(3, fever);
            ps3.setBoolean(4, soreThroat);
            ps3.setBoolean(5, tongueDoesNotTaste);
            ps3.setBoolean(6, runnyNose);
            ps3.setBoolean(7, tired);
            ps3.setBoolean(8, panting);
            ps3.setBoolean(9, noSymptoms);
            ps3.executeUpdate();

        }

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();


    }


}
