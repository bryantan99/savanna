package com.example.savanna;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        try {
            URL url = getClass().getResource("icon.png");
            if (url != null) {
                Image appIcon = new Image(url.toURI().toString());
                stage.getIcons().add(appIcon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage.setTitle("Savanna");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}