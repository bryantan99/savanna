package com.example.savanna.controller;

import com.example.savanna.HelloApplication;
import com.example.savanna.animal.Animal;
import com.example.savanna.environment.EnvironmentSingleton;
import com.example.savanna.entity.MainUiFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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

    private MainUiFacade mainUiFacade;

    private MediaPlayer mediaPlayer;

    @FXML
    private Slider volumeSlider;

    @FXML
    private AnchorPane viewScreen;

    @FXML
    private ImageView skyImageView;

    @FXML
    private ImageView landImageView;

    @FXML
    private Button addAnimalButton;

    @FXML
    private ComboBox<String> animalDropdown;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        env = EnvironmentSingleton.getInstance();
        mainUiFacade = new MainUiFacade(skyImageView, landImageView, env, mediaPlayer, volumeSlider, animalDropdown, addAnimalButton);
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

    @FXML
    protected void addAnimal(ActionEvent event) throws URISyntaxException {
        Animal animal = env.addAnimal(animalDropdown.getValue());
        if (animal != null) {
            ImageView animalImageView = new ImageView(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/" + animal.getImage())).toURI().toString()));
            animalImageView.setPreserveRatio(true);
            animalImageView.setFitWidth(animal.getSize());
            viewScreen.getChildren().add(animalImageView);
            AnchorPane.setLeftAnchor(animalImageView, animal.getPositionX());
            AnchorPane.setBottomAnchor(animalImageView, animal.getPositionY());
        }
        animalDropdown.setPromptText("Select an animal");
        animalDropdown.setValue(null);
    }

}
