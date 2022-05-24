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
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DiaryController extends GoToScene implements Initializable{

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
    TextArea textArea;

    @FXML
    Text usernameText ;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void goToSceneHome(ActionEvent event) throws IOException {
        super.goToSceneHome(event);
    }

    @Override
    public void goToSceneShowDiary(ActionEvent event) throws IOException {
        super.goToSceneShowDiary(event);
    }

    @Override
    public void goToSceneLogin(ActionEvent event) throws IOException, SQLException {
        super.goToSceneLogin(event);
    }

    @Override
    public void goToSceneCovidAlert(ActionEvent event) throws IOException {
        super.goToSceneCovidAlert(event);
    }

    @Override
    public void goToSceneEditDiary(ActionEvent event) throws IOException {
        super.goToSceneEditDiary(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().addAll(country);
        usernameText.setText(UserHolder.username);

    }

    // Get database connection
    ConnectionDatabase connectionDatabase = new ConnectionDatabase();

    public void saveDiary(ActionEvent event) throws Exception {

        LocalDate date = datePicker.getValue();

        String myCountry = choiceBox.getValue();

        String myContent = textArea.getText();

        System.out.println(UserHolder.getInstance().getUserId());

        int userID = UserHolder.getInstance().getUserId();
        Statement stmt = connectionDatabase.getConn().createStatement();

        String selectDiarySQL = "select * from user_diaries where user_id = ? and date = ? limit 1";
        PreparedStatement ps = connectionDatabase.getConn().prepareStatement(selectDiarySQL);
        ps.setInt(1, userID);
        ps.setDate(2, Date.valueOf(date));
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

        } else {
            String insertAll = "INSERT INTO user_diaries (user_id, date, country, content) VALUES (?, ?, ?, ?)";
            PreparedStatement ps3 = connectionDatabase.getConn().prepareStatement(insertAll);

            //save date, country, content to database

            ps3.setInt(1, userID);
            ps3.setDate(2, Date.valueOf(date));
            ps3.setString(3, myCountry);
            ps3.setString(4, myContent);
            ps3.executeUpdate();
        }

//        LocalDate date = datePicker.getValue();
//
//        String myCountry = choiceBox.getValue();
//
//        String myContent = textField.getText();
//
//
//        System.out.println(UserHolder.getInstance().getUserId());
//
//        int userID = UserHolder.getInstance().getUserId();
//        Statement stmt = connectionDatabase.getConn().createStatement();
//
//        String sql = "INSERT INTO user_diaries (user_id, date, country, content) VALUES (?, ?, ?, ?)";
//        PreparedStatement ps = connectionDatabase.getConn().prepareStatement(sql);
//
//        //save date, country, content to database
//
//        ps.setInt(1, userID);
//        ps.setDate(2, Date.valueOf(date));
//        ps.setString(3, myCountry);
//        ps.setString(4, myContent);
//        ps.executeUpdate();

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

// INSERT INTO user_diaries (user_id, date, country, content) VALUES (?, ?, ?, ?);