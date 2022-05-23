module com.demo.covid {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;


    opens com.demo.covid19 to javafx.fxml;
    exports com.demo.covid19;
}