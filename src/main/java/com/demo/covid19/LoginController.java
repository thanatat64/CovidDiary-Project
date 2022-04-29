package com.demo.covid19;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    @FXML
    TextField textField;

    @FXML
    PasswordField passwordField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent event) throws Exception {
        System.out.println("Click Login Button ...");

        // Get data from forms
        String username = textField.getText();
        String password = passwordField.getText();

        // Get database connection
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();

        // Query user by username
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement stmt = connectionDatabase.getConn().prepareStatement(sql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        // Check is found user by username or not
        if (rs.next()) {
            String hashedPassword = rs.getString("password");

            // Check password is correct
            if (BCrypt.checkpw(password, hashedPassword)) {
                // Go to next scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("home-view.fxml"));
                root = loader.load();

//                HomeController scene2Controller = loader.getController();
//                scene2Controller.displayEmail(username);

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                System.out.println("Password not correct");
            }
        } else {
            System.out.println("User " + username + " not found");
        }



    }
}