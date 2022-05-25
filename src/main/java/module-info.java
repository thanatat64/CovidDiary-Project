module com.demo.covid {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;


    opens com.demo.covid19 to javafx.fxml;
    exports com.demo.covid19;
    exports com.demo.covid19.classes;
    opens com.demo.covid19.classes to javafx.fxml;
    exports com.demo.covid19.connection;
    opens com.demo.covid19.connection to javafx.fxml;
    exports com.demo.covid19.controller;
    opens com.demo.covid19.controller to javafx.fxml;

}