package com.example.savanna.entity;

import com.example.savanna.HelloApplication;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.Objects;

public class MainUiFacade {
    public static final String IMAGE_DIRECTORY = "images/";

    private StackPane stackPane;
    private ImageView skyImageView;
    private ImageView landImageView;
    private EnvironmentSingleton env;
    private MediaPlayer mediaPlayer;
    private Slider volumeSlider;

    public MainUiFacade(StackPane stackPane, ImageView skyImageView, ImageView landImageView, EnvironmentSingleton env, MediaPlayer mediaPlayer, Slider volumeSlider) {
        this.stackPane = stackPane;
        this.skyImageView = skyImageView;
        this.landImageView = landImageView;
        this.env = env;
        this.mediaPlayer = mediaPlayer;
        this.volumeSlider = volumeSlider;
    }

    public void init() {
        initPreviewScreen();
        initBgm();
        initVolumeSlider();
    }

    public void destroy() {
        this.skyImageView.setImage(null);
        this.landImageView.setImage(null);
        this.mediaPlayer.stop();
    }

    private void initPreviewScreen() {
        String skyImageName = env.getSky().getImageName();
        String landImageName = env.getLand().getImageName();
        try {
            skyImageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource(IMAGE_DIRECTORY + skyImageName)).toURI().toString()));
            landImageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource(IMAGE_DIRECTORY + landImageName)).toURI().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        skyImageView.setFitHeight(stackPane.getHeight());
        landImageView.setFitHeight(stackPane.getHeight());
    }

    private void initVolumeSlider() {
        volumeSlider.setValue(mediaPlayer.getVolume() * 100);
        volumeSlider.valueProperty().addListener(observable -> mediaPlayer.setVolume(volumeSlider.getValue() / 100));
    }

    private void initBgm() {
        URL bgmUrl = HelloApplication.class.getResource(env.getSound());
        if (bgmUrl != null) {
            mediaPlayer = new MediaPlayer(new Media(bgmUrl.toString()));
            mediaPlayer.play();
        }
    }
}
