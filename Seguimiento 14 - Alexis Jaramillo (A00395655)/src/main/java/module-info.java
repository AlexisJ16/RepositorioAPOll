module com.example.ensayobanco {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ensayobanco to javafx.fxml;
    exports com.example.ensayobanco;
}