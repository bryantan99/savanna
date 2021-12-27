module com.example.savanna {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.savanna to javafx.fxml;
    exports com.example.savanna;
}