package com.demo.covid19;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

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

    public void saveCovidAlert() {

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

    }

}
