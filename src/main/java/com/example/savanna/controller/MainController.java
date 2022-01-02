package com.example.savanna.controller;

import com.example.savanna.HelloApplication;
import com.example.savanna.entity.EnvironmentSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Parent root;

    private Stage stage;

    private Scene scene;

    private EnvironmentSingleton env;

    private MediaPlayer mediaPlayer;

    @FXML
    private StackPane stackPane;

    @FXML
    private ImageView skyImageView;

    @FXML
    private ImageView landImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        env = EnvironmentSingleton.getInstance();
        initBgm();
        try {
            initEnvironmentView();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void switchToHelloView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    private void initBgm() {
        URL bgmUrl = HelloApplication.class.getResource(env.getSound());
        if (bgmUrl != null) {
            mediaPlayer = new MediaPlayer(new Media(bgmUrl.toString()));
            mediaPlayer.play();
        }
    }

    private void initEnvironmentView() throws URISyntaxException {
        String skyImageName = env.getSky().getImageName();
        String landImageName = env.getLand().getImageName();
        skyImageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource(skyImageName)).toURI().toString()));
        landImageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource(landImageName)).toURI().toString()));
        skyImageView.setFitHeight(stackPane.getHeight());
        landImageView.setFitHeight(stackPane.getHeight());
    }
}
