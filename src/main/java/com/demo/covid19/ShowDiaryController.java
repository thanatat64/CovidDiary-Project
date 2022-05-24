package com.demo.covid19;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowDiaryController extends GoToScene implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Text usernameText;

    @Override
    public void goToSceneDiary(ActionEvent event) throws IOException {
        super.goToSceneDiary(event);
    }

    @Override
    public void goToSceneLogin(ActionEvent event) throws IOException, SQLException {
        super.goToSceneLogin(event);
    }

    @Override
    public void goToSceneHome(ActionEvent event) throws IOException {
        super.goToSceneHome(event);
    }

    @Override
    public void goToSceneCovidAlert(ActionEvent event) throws IOException {
        super.goToSceneCovidAlert(event);
    }

    public void showAllYourDiary (){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameText.setText(UserHolder.username);
    }
}

