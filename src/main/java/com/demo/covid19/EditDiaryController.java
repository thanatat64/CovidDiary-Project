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

import java.net.URL;
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
    TextField textField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void saveEditDiary(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        //save date to database

        //save country to database

        //save detail to database
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(country);
    }
}
