package com.demo.covid19;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowDiaryController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void goToSceneDiary (ActionEvent event) throws IOException {

        // Go to next scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("diary-view.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void goToSceneLogin (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void goToSceneHome (ActionEvent event) throws IOException {

        // Go to next scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home-view.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void goToSceneCovidAlert (ActionEvent event) throws IOException {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("covid-alert-view.fxml"));
            root = loader.load();

            stage = new Stage();
            stage.setTitle("COVID ALERT");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.out.println("Can't load new window");
        }
    }
}

