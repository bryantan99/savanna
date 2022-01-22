package com.example.savanna.entity;

import com.example.savanna.HelloApplication;
import com.example.savanna.animal.Animal;
import com.example.savanna.environment.EnvironmentSingleton;
import com.example.savanna.model.AnimalForm;
import com.example.savanna.util.Constant;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MainUiFacade {
    public static final String IMAGE_DIRECTORY = "images/";

    private ImageView skyImageView;
    private ImageView landImageView;
    private EnvironmentSingleton env;
    private MediaPlayer mediaPlayer;
    private Slider volumeSlider;
    private ComboBox<String> animalDropdown;
    private Button addAnimalButton;
    private AnimalForm animalForm;

    public MainUiFacade(ImageView skyImageView, ImageView landImageView, Slider volumeSlider, ComboBox<String> animalDropdown, Button addAnimalButton, AnimalForm animalForm) {
        this.skyImageView = skyImageView;
        this.landImageView = landImageView;
        this.volumeSlider = volumeSlider;
        this.animalDropdown = animalDropdown;
        this.addAnimalButton = addAnimalButton;
        this.animalForm = animalForm;
        this.env = EnvironmentSingleton.getInstance();
    }

    public void init() {
        initViewScreen();
        initBgm();
        initVolumeSlider();
        initAddAnimalButton();
        initAnimalDropdown();
        initAnimalForm();
    }

    private void initAnimalForm() {
        animalForm.init();
    }

    private void initAddAnimalButton() {
        animalDropdown.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(animalDropdown.getPromptText());
                    addAnimalButton.setDisable(true);
                } else {
                    addAnimalButton.setDisable(false);
                    setText(item);
                }
            }
        });
    }

    private void initAnimalDropdown() {
        List<String> animalList = Constant.ANIMAL_LIST;
        Collections.sort(animalList);
        for (String animal : animalList) {
            this.animalDropdown.getItems().add(animal);
        }
    }

    public void destroy() {
        this.skyImageView.setImage(null);
        this.landImageView.setImage(null);
        this.mediaPlayer.stop();
    }

    private void initViewScreen() {
        String skyImageName = env.getSky().getImageName();
        String landImageName = env.getLand().getImageName();
        try {
            skyImageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource(IMAGE_DIRECTORY + skyImageName)).toURI().toString()));
            landImageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource(IMAGE_DIRECTORY + landImageName)).toURI().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        skyImageView.setOnMouseClicked(mouseEvent -> animalForm.reset());
        landImageView.setOnMouseClicked(mouseEvent -> animalForm.reset());
    }

    private void initVolumeSlider() {
        volumeSlider.setValue(mediaPlayer.getVolume() * 100);
        volumeSlider.valueProperty().addListener(observable -> mediaPlayer.setVolume(volumeSlider.getValue() / 100));
    }

    private void initBgm() {
        URL bgmUrl = HelloApplication.class.getResource(env.getSound());
        if (bgmUrl != null) {
            mediaPlayer = new MediaPlayer(new Media(bgmUrl.toString()));
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setVolume(0.2);
            mediaPlayer.play();
        }
    }

    public void patchAnimalForm(Animal animal) {
        animalForm.initIsFlippedDropdown(animal.getClass().getSimpleName());
        animalForm.initMoveBehaviorDropdown(animal.getClass().getSimpleName());
        animalForm.patchValue(animal);
    }

    public void resetAnimalForm() {
        animalForm.reset();
    }
}
