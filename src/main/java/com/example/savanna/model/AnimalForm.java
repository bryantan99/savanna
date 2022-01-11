package com.example.savanna.model;

import com.example.savanna.animal.Animal;
import com.example.savanna.behavior.Fly;
import com.example.savanna.util.Constant;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AnimalForm {

    private Text animalId;
    private Text animalType;
    private TextField animalSize;
    private TextField animalPositionX;
    private TextField animalPositionY;
    private ComboBox<String> animalMoveBehavior;
    private ComboBox<String> animalIsFlipped;
    private Button updateButton;
    private Button deleteButton;

    public AnimalForm() {
    }

    public AnimalForm(Text animalId, Text animalType, TextField animalSize, TextField animalPositionX, TextField animalPositionY, ComboBox<String> animalMoveBehavior, Button updateButton, Button deleteButton, ComboBox<String> animalIsFlipped) {
        this.animalId = animalId;
        this.animalType = animalType;
        this.animalSize = animalSize;
        this.animalPositionX = animalPositionX;
        this.animalPositionY = animalPositionY;
        this.animalMoveBehavior = animalMoveBehavior;
        this.animalIsFlipped = animalIsFlipped;
        this.updateButton = updateButton;
        this.deleteButton = deleteButton;
    }

    public Text getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Text animalId) {
        this.animalId = animalId;
    }

    public Text getAnimalType() {
        return animalType;
    }

    public void setAnimalType(Text animalType) {
        this.animalType = animalType;
    }

    public TextField getAnimalSize() {
        return animalSize;
    }

    public void setAnimalSize(TextField animalSize) {
        this.animalSize = animalSize;
    }

    public TextField getAnimalPositionX() {
        return animalPositionX;
    }

    public void setAnimalPositionX(TextField animalPositionX) {
        this.animalPositionX = animalPositionX;
    }

    public TextField getAnimalPositionY() {
        return animalPositionY;
    }

    public void setAnimalPositionY(TextField animalPositionY) {
        this.animalPositionY = animalPositionY;
    }

    public ComboBox<String> getAnimalMoveBehavior() {
        return animalMoveBehavior;
    }

    public void setAnimalMoveBehavior(ComboBox<String> animalMoveBehavior) {
        this.animalMoveBehavior = animalMoveBehavior;
    }

    public ComboBox<String> getAnimalIsFlipped() {
        return animalIsFlipped;
    }

    public void setAnimalIsFlipped(ComboBox<String> animalIsFlipped) {
        this.animalIsFlipped = animalIsFlipped;
    }

    public void init() {
        animalIsFlipped.getItems().clear();
        initIsFlippedDropdown();
        animalId.setText(Constant.NA);
        animalType.setText(Constant.NA);
        animalSize.setText(Constant.NA);
        animalSize.setDisable(true);
        animalPositionX.setText(Constant.NA);
        animalPositionX.setDisable(true);
        animalPositionY.setText(Constant.NA);
        animalPositionY.setDisable(true);
        animalMoveBehavior.setValue(Constant.NA);
        animalMoveBehavior.setDisable(true);
        animalIsFlipped.setValue(Constant.NA);
        animalIsFlipped.setDisable(true);

        updateButton.setDisable(true);
        deleteButton.setDisable(true);
    }

    public void reset() {
        init();
    }

    public void patchValue(Animal animal) {
        if (animal != null) {
            animalId.setText(animal.getAnimalId().toString());
            animalType.setText(animal.getClass().getSimpleName());
            animalSize.setDisable(false);
            animalSize.setText(animal.getSize().toString());
            animalPositionX.setDisable(false);
            animalPositionX.setText(animal.getPositionX().toString());
            animalPositionY.setDisable(false);
            animalPositionY.setText(animal.getPositionY().toString());
            animalMoveBehavior.setDisable(false);
            animalMoveBehavior.setValue(animal.getMoveBehavior() instanceof Fly ? Constant.MOVE_BEHAVIOR_FLY : Constant.MOVE_BEHAVIOR_WALK);
            animalIsFlipped.setValue(animal.getFlippedHorizontally() ? Constant.BOOLEAN_TRUE : Constant.BOOLEAN_FALSE);
            animalIsFlipped.setDisable(false);
            updateButton.setDisable(false);
            deleteButton.setDisable(false);
        }
    }

    private void initIsFlippedDropdown() {
        animalIsFlipped.getItems().addAll(Constant.BOOLEAN_DROPDOWN_LIST);
    }

}
