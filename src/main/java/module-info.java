module com.example.responsibillitychain {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.responsibillitychain to javafx.fxml;
    exports com.example.responsibillitychain;
}