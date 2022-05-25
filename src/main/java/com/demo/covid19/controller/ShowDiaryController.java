package com.demo.covid19.controller;

import com.demo.covid19.classes.DiarySearch;
import com.demo.covid19.classes.GoToScene;
import com.demo.covid19.classes.UserHolder;
import com.demo.covid19.connection.ConnectionDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowDiaryController extends GoToScene implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    ConnectionDatabase connectionDatabase = new ConnectionDatabase();
    ObservableList<DiarySearch> diarySearchObservableList = FXCollections.observableArrayList();

    @FXML
    Text usernameText;

    @FXML
    TableView<DiarySearch> diarySearchTableView;
    @FXML
    TableColumn<DiarySearch, Date> diarySearchDateTableColumn;
    @FXML
    TableColumn<DiarySearch, String> diarySearchProvinceTableColumn;
    @FXML
    TableColumn<DiarySearch,String> diarySearchContentTableColumn;
    @FXML
    TextField keywordTextField;


    @Override
    public void goToSceneDiary(ActionEvent event) throws IOException, Exception {
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

    public void diaryTable (){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            usernameText.setText(UserHolder.username);
            int userID = UserHolder.getInstance().getUserId();
            String sql = "SELECT date, province, content FROM user_diaries WHERE user_id = ?";
            Statement stmt = connectionDatabase.getConn().createStatement();
            PreparedStatement ps = connectionDatabase.getConn().prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Date qDate = rs.getDate("date");
                String qProvince = rs.getString("province");
                String qContent = rs.getString("content");
                diarySearchObservableList.add(new DiarySearch(qDate,qProvince,qContent));
            }
            diarySearchDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            diarySearchProvinceTableColumn.setCellValueFactory(new PropertyValueFactory<>("province"));
            diarySearchContentTableColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
            diarySearchTableView.setItems(diarySearchObservableList);

            //sortedMethod
            FilteredList<DiarySearch> filterData = new FilteredList<>(diarySearchObservableList, b -> true );
            keywordTextField.textProperty().addListener((observable, oldValue, newValue)->{
                filterData.setPredicate(diarySearch -> {

                    if (newValue.isEmpty() || newValue.isBlank() ||newValue == null){
                        return  true;
                    }

                    String searchkeyword = newValue.toLowerCase();

                    if (diarySearch.getProvince().toLowerCase().indexOf(searchkeyword) > -1){
                        return  true;
                    }else if (diarySearch.getContent().toLowerCase().indexOf(searchkeyword) > -1){
                        return  true;
                    }else
                        return false;

                });
            });

            SortedList<DiarySearch> sortedData = new SortedList<>(filterData);
            sortedData.comparatorProperty().bind(diarySearchTableView.comparatorProperty());
            diarySearchTableView.setItems(sortedData);
            //sortedMethod

        } catch (SQLException e) {
            Logger.getLogger(DiaryController.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }


    }
}

