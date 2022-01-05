package com.example.savanna.controller;

import com.example.savanna.HelloApplication;
import com.example.savanna.entity.EnvironmentSingleton;
import com.example.savanna.entity.MainUiFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Parent root;

    private Stage stage;

    private Scene scene;

    private EnvironmentSingleton env;

    private MainUiFacade mainUiFacade;

    private MediaPlayer mediaPlayer;

    @FXML
    private Slider volumeSlider;

    @FXML
    private StackPane stackPane;

    @FXML
    private ImageView skyImageView;

    @FXML
    private ImageView landImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        env = EnvironmentSingleton.getInstance();
        mainUiFacade = new MainUiFacade(stackPane, skyImageView, landImageView, env, mediaPlayer, volumeSlider);
        mainUiFacade.init();
    }

    @FXML
    protected void switchToHelloView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("view/hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        mainUiFacade.destroy();
    }
}
