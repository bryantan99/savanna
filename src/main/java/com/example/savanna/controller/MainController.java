package com.example.savanna.controller;

import com.example.savanna.HelloApplication;
import com.example.savanna.animal.Animal;
import com.example.savanna.behavior.Fly;
import com.example.savanna.behavior.Walk;
import com.example.savanna.command.AddCommand;
import com.example.savanna.command.Command;
import com.example.savanna.command.DeleteCommand;
import com.example.savanna.command.GetCommand;
import com.example.savanna.entity.MainUiFacade;
import com.example.savanna.model.AnimalForm;
import com.example.savanna.util.Constant;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Parent root;

    private Stage stage;

    private Scene scene;

    private Command command;

    private MainUiFacade mainUiFacade;

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

    private AnimalForm animalForm;

    @FXML
    private Text animalId;

    @FXML
    private Text animalType;

    @FXML
    private TextField animalSize;

    @FXML
    private TextField animalPositionX;

    @FXML
    private TextField animalPositionY;

    @FXML
    private ComboBox<String> animalMoveBehavior;

    @FXML
    private ComboBox<String> animalIsFlipped;

    private ImageView selectedAnimalImageView;

    @FXML
    private Button updateAnimalButton;

    @FXML
    private Button deleteAnimalButton;

    @FXML
    private Text exportStatusMsg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        animalForm = new AnimalForm(animalId, animalType, animalSize, animalPositionX, animalPositionY, animalMoveBehavior, updateAnimalButton, deleteAnimalButton, animalIsFlipped);
        mainUiFacade = new MainUiFacade(skyImageView, landImageView, volumeSlider, animalDropdown, addAnimalButton, animalMoveBehavior, animalForm);
        mainUiFacade.init();
    }

    @FXML
    protected void switchToHelloView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("view/hello-view.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        mainUiFacade.destroy();
    }

    @FXML
    protected void addAnimal(ActionEvent event) throws URISyntaxException {
        command = new AddCommand(animalDropdown.getValue());
        Animal animal = command.execute();

        if (animal != null) {
            ImageView animalImageView = new ImageView(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/" + animal.getImage())).toURI().toString()));
            animalImageView.setPreserveRatio(true);
            animalImageView.setFitWidth(animal.getSize());
            viewScreen.getChildren().add(animalImageView);
            AnchorPane.setLeftAnchor(animalImageView, animal.getPositionX());
            AnchorPane.setBottomAnchor(animalImageView, animal.getPositionY());

            animal.setMoveBehavior(new Walk(animalImageView));
            animalImageView.setOnMouseClicked(event1 -> {
                MouseButton button = event1.getButton();
                if (button.equals(MouseButton.PRIMARY)) {
                    selectedAnimalImageView = animalImageView;
                    mainUiFacade.initMoveBehaviorDropdown(animal.getClass().getSimpleName());
                    animalForm.patchValue(animal);
                }
            });
        }
        animalDropdown.setPromptText("Select an animal");
        animalDropdown.setValue(null);
    }

    @FXML
    protected void updateAnimal(ActionEvent event) {
        command = new GetCommand(Integer.parseInt(animalId.getText()));
        Animal animal = command.execute();

        double width_ratio = selectedAnimalImageView.getImage().getWidth() / Double.parseDouble(animalSize.getText());
        boolean isValid = validateFormValues(Double.parseDouble(animalPositionX.getText()), Double.parseDouble(animalPositionY.getText()),
                selectedAnimalImageView.getImage().getWidth() / width_ratio, selectedAnimalImageView.getImage().getHeight() / width_ratio);
        if (animal != null && isValid) {
            animal.setPositionX(Double.parseDouble(animalPositionX.getText()));
            animal.setPositionY(Double.parseDouble(animalPositionY.getText()));
            animal.setMoveBehavior(Constant.MOVE_BEHAVIOR_FLY.equals(animalMoveBehavior.getValue()) ? new Fly(selectedAnimalImageView) : new Walk(selectedAnimalImageView));
            animal.setSize(Integer.parseInt(animalSize.getText()));
            animal.setFlippedHorizontally(Constant.BOOLEAN_TRUE.equals(animalIsFlipped.getValue()));

            selectedAnimalImageView.setFitWidth(animal.getSize());
            animal.move();
            selectedAnimalImageView.setScaleX(animal.getFlippedHorizontally() ? -1 : 1);
        }
    }

    @SuppressWarnings({})
    private boolean validateFormValues(Double positionX, Double positionY, double animalWidth, double animalHeight) {
        double upperPositionX = Constant.VIEWSCREEN_WIDTH - animalWidth;
        double upperPositionY = Constant.VIEWSCREEN_HEIGHT - animalHeight;

        boolean validatePositionX = positionX <= upperPositionX && positionX >= 0;
        boolean validatePositionY = positionY <= upperPositionY && positionY >= 0;


        Alert alert = new Alert(Alert.AlertType.NONE, null, ButtonType.CLOSE);
        alert.setTitle("Invalid form input");

        double ratio = animalWidth / animalHeight;

        if(animalWidth < 100){
            alert.setContentText("Make sure size >= 100");
            alert.show();
            return false;
        }

        if(animalWidth > Constant.VIEWSCREEN_WIDTH && animalHeight > Constant.VIEWSCREEN_HEIGHT){
            if(Constant.VIEWSCREEN_WIDTH <= Constant.VIEWSCREEN_HEIGHT * ratio){
                alert.setContentText("Make sure size <= %d".formatted(((Double)Constant.VIEWSCREEN_WIDTH).intValue()));
                alert.show();
                return false;
            }else{
                alert.setContentText("Make sure size <= %d".formatted(((Double)(Constant.VIEWSCREEN_HEIGHT * ratio)).intValue()));
                alert.show();
                return false;
            }
        }

        if(animalHeight > Constant.VIEWSCREEN_HEIGHT){
            alert.setContentText("Make sure size <= %d".formatted(((Double)(Constant.VIEWSCREEN_HEIGHT * ratio)).intValue()));
            alert.show();
            return false;
        }

        if(animalWidth > Constant.VIEWSCREEN_WIDTH){
                alert.setContentText("Make sure size <= %d".formatted(((Double)(Constant.VIEWSCREEN_WIDTH * ratio)).intValue()));
            alert.show();
            return false;
        }


        if(validatePositionX && validatePositionY){
            return true;
        }else if(!validatePositionX && !validatePositionY){
            alert.setContentText("Make sure 0 <= X <= %.3f, 0 <= Y <= %.3f".formatted(upperPositionX, upperPositionY));
            alert.show();
        }else if(!validatePositionY){
            alert.setContentText("Make sure 0 <= Y <= %.3f".formatted(upperPositionY));
            alert.show();
        }else{
            alert.setContentText("Make sure 0 <= X <= %.3f".formatted(upperPositionX));
            alert.show();
        }
        return false;
    }

    @FXML
    protected void deleteAnimal(ActionEvent event) {
        command = new DeleteCommand(Integer.parseInt(animalId.getText()));
        command.execute();

        viewScreen.getChildren().remove(selectedAnimalImageView);
        mainUiFacade.initMoveBehaviorDropdown(null);
        animalForm.reset();
    }

    @FXML
    protected void exportImg(ActionEvent event) {
        String directory = System.getProperty("user.home") + Constant.FILE_SEPARATOR + "Downloads" + Constant.FILE_SEPARATOR + "savanna.png";
        WritableImage image = viewScreen.snapshot(new SnapshotParameters(), null);
        File file = new File(directory);
        boolean isSuccess = false;
        try {
            isSuccess = ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isSuccess) {
            exportStatusMsg.setText("An image (savanna.png) has been exported to " + directory + ".");
        } else {
            exportStatusMsg.setText("There's an error when exporting image.");
        }
    }

}
