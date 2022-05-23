package com.demo.covid19;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DiaryController implements Initializable{

    @FXML
    DatePicker datePicker;

    @FXML
    ChoiceBox<String> choiceBox;
    private String[] country = {"Kamphaeng Phet", "Chiang Rai", "Chiang Mai", "Tak", "Nakhon Sawan", "Nan", "Phichit", "Phitsanulok", "Phetchabun", "Phrae"
            , "Mae Hong Son", "Lampang", "Lamphun", "Sukhothai", "Uttaradit", "Uthai Thani", "Phayao", "Bangkok", "Kanchanaburi", "Chanthaburi"
            , "Chachoengsao", "Chon Buri", "Trat", "Nakhon Nayok", "Nakhon Pathom", "Nonthaburi", "Pathum Thani", "Prachuap Khiri Khan", "Prachin Buri", "Phra Nakhon Si Ayutthaya"
            , "Phetchaburi", "Rayong", "Ratchaburi", "Lop Buri", "Samut Prakan", "Samut Songkhram", "Samut Sakhon", "Saraburi", "Sing Buri", "Suphan Buri"
            , "Ang Thong", "Sa Kaeo", "Kalasin", "Khon Kaen", "Chaiyaphum", "Yasothon", "Nakhon Phanom", "Nakhon Ratchasima", "Buri Ram", "Maha Sarakham"
            , "Roi Et", "Loei", "Si Sa Ket", "Sakon Nakhon", "Surin", "Nong Khai", "Udon Thani", "Ubon Ratchathani", "Mukdahan", "Amnat Charoen"
            , "Nong Bua Lam Phu", "Krabi", "Chumphon", "Trang", "Nakhon Si Thammarat", "Narathiwat", "Pattani", "Phangnga", "Phatthalung", "Phuket"
            , "Yala", "Ranong", "Songkhla", "Satun", "Surat Thani", "Chai Nat"};

    @FXML
    TextField textField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void goToSceneHome(ActionEvent event) throws IOException {
        // Go to next scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home-view.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToSceneShowDiary(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("show-diary-view.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToSceneLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToSceneCovidAlert(ActionEvent event) throws IOException {
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

    public void goToSceneEditDiary(ActionEvent event) throws IOException {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-diary-view.fxml"));
            root = loader.load();

            stage = new Stage();
            stage.setTitle("EDIT DIARY");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.out.println("Can't load new window");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(country);
    }

    public void saveDiary(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ok-view.fxml"));
            root = loader.load();

            stage = new Stage();
            stage.setTitle("SAVE");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("it's can't save");
        }



        //save date to database

        //save country to database

        //save detail to database
    }

//
//    public void insert() throws Exception {
//        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
//        String sql = "INSERT INTO users (username, created_date) VALUE (?, ?)";
//        PreparedStatement statement  = connectionDatabase.getConn().prepareStatement(sql);
//        statement.setString(1, userna);
//
//    }

//    public void getData(ActionEvent event) {
//
//        String myCountry = choiceBox.getValue();
//        LocalDate myDate = datePicker.getValue();
//        String myTextField = textField.getText();
//
//    }



//    public void insert() throws Exception {
//        Connection conn = null;
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "P@ssw0rd");
//        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, "Nichapat");
//        statement.setString(2, "password");
//        statement.execute();
//    }
}

