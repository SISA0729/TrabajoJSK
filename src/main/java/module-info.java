module com.example.trabajojsk {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.trabajojsk to javafx.fxml;
    exports com.example.trabajojsk;
    exports com.example.trabajojsk.Controller;
    opens com.example.trabajojsk.Controller to javafx.fxml;
}