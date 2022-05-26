package com.demo.covid19.controller;

import com.demo.covid19.connection.ConnectionDatabase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.demo.covid19.classes.GoToScene;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;


public class RegisterController extends GoToScene {
    @FXML
    TextField textField;//username

    @FXML
    TextField userText;
    @FXML
    PasswordField passwordField;
    @FXML
    TextField hintPasswordText;
    @FXML
    CheckBox checkbox;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void changeVisibility(ActionEvent event) {
        hintPasswordText.setVisible(checkbox.isSelected());
        passwordField.setVisible(!checkbox.isSelected());
    }

    public void init() {

        hintPasswordText.setVisible(false);
        hintPasswordText.textProperty().bindBidirectional(passwordField.textProperty());
        userText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    userText.setText(newValue.replaceAll("[^\\d]", ""));
                }

            }
        });
    }


    public void register(ActionEvent event) throws Exception {

        System.out.println("Click Register Button .....");
        goToSceneLogin(event);
        String username = textField.getText();

        String password = passwordField.getText();
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());//convert to hashed code

        int userId = Integer.parseInt(userText.getText());

        Date created_at = new Date();

        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        Statement stmt = connectionDatabase.getConn().createStatement();

        String selectDiarySQL = "select * from users where username = ? or id = ? limit 1";
        PreparedStatement ps = connectionDatabase.getConn().prepareStatement(selectDiarySQL);
        ps.setString(1, username);
        ps.setInt(2, userId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("error-view.fxml"));
                root = loader.load();

                stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                System.out.println("it's can't run");
            }

        } else {
            String insertAccount = "INSERT INTO users (username, id, password) VALUES (?, ?, ?)";
            PreparedStatement ps2 = connectionDatabase.getConn().prepareStatement(insertAccount);

            ps2.setString(1, username);
            ps2.setInt(2, userId);
            ps2.setString(3, hashedPassword);
            ps2.executeUpdate();
        }


    }
}
