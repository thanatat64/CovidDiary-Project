package com.demo.covid19.classes;

import com.demo.covid19.controller.RegisterController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class GoToScene {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public GoToScene() {

    }

    public void goToSceneDiary (ActionEvent event) throws IOException, Exception {

        // Go to next scene
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("diary-view.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToSceneLogin (ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("login-view.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToSceneRegister (ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("register-view.fxml"));
        root = loader.load();
        RegisterController r = loader.getController();
        r.init();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToSceneShowDiary (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("show-diary-view.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToSceneCovidAlert (ActionEvent event) throws IOException {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("covid-alert-view.fxml"));
            root = loader.load();

            stage = new Stage();
            stage.setTitle("Covid Diary - Symptoms Check");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.out.println("Can't load new window");
        }
    }

    public void goToSceneHome(ActionEvent event) throws IOException {
        // Go to next scene
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("home-view.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

        public void goToSceneEditDiary(ActionEvent event) throws IOException {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("edit-diary-view.fxml"));
            root = loader.load();

            stage = new Stage();
            stage.setTitle("Covid Diary - Edit Diary ");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.out.println("Can't load new window");
        }
    }

    //ควรไปพบแพทย์

    public void goToSceneTakeCare (ActionEvent event) throws IOException {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("take-care-view.fxml"));
            root = loader.load();

            stage = new Stage();
            stage.setTitle("Covid Diary - Advice");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.out.println("Can't load new window");
        }
    }

}