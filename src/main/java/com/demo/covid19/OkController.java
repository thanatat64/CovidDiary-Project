package com.demo.covid19;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class OkController {

    public void OkButton(ActionEvent event){

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }
}
