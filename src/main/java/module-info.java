module com.example.savanna {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.savanna to javafx.fxml;
    exports com.example.savanna;
    exports com.example.savanna.controller;
    opens com.example.savanna.controller to javafx.fxml;
    exports com.example.savanna.model;
    opens com.example.savanna.model to javafx.fxml;
}