module com.example.subnetcalculatorfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.subnetcalculatorfx to javafx.fxml;
    exports com.example.subnetcalculatorfx;
}