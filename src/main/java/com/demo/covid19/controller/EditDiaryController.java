package com.demo.covid19.controller;

import com.demo.covid19.Classes.UserHolder;
import com.demo.covid19.Connection.ConnectionDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EditDiaryController implements Initializable {

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
    TextArea editText;

    private Stage stage;
    private Scene scene;
    private Parent root;

    // Get database connection
    ConnectionDatabase connectionDatabase = new ConnectionDatabase();

    public void saveEditDiary(ActionEvent event) throws Exception {

        LocalDate date = datePicker.getValue();

        String myProvince = choiceBox.getValue();

        String myContent = editText.getText();

        System.out.println(UserHolder.getInstance().getUserId());

        int userID = UserHolder.getInstance().getUserId();
        Statement stmt = connectionDatabase.getConn().createStatement();

        String selectDiarySQL = "select * from user_diaries where user_id = ? and date = ? limit 1";
        PreparedStatement ps = connectionDatabase.getConn().prepareStatement(selectDiarySQL);
        ps.setInt(1, userID);
        ps.setDate(2, Date.valueOf(date));
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int diaryId = rs.getInt("id");

            String updateDiarySQL = "update user_diaries set country = ?, content = ? where id = ?";
            PreparedStatement ps2 = connectionDatabase.getConn().prepareStatement(updateDiarySQL);

            ps2.setString(1, myProvince);
            ps2.setString(2, myContent);
            ps2.setInt(3, diaryId);
            ps2.executeUpdate();

        } else {
            String insertAll = "INSERT INTO user_diaries (user_id, date, country, content) VALUES (?, ?, ?, ?)";
            PreparedStatement ps3 = connectionDatabase.getConn().prepareStatement(insertAll);

            //save date, country, content to database

            ps3.setInt(1, userID);
            ps3.setDate(2, Date.valueOf(date));
            ps3.setString(3, myProvince);
            ps3.setString(4, myContent);
            ps3.executeUpdate();
        }

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(country);
    }
}
