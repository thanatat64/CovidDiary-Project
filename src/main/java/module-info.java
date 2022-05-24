module com.demo.covid {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;


    opens com.demo.covid19 to javafx.fxml;
    exports com.demo.covid19;
    exports com.demo.covid19.Classes;
    opens com.demo.covid19.Classes to javafx.fxml;
    exports com.demo.covid19.Connection;
    opens com.demo.covid19.Connection to javafx.fxml;

}