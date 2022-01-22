package com.example.savanna.model;

import com.example.savanna.animal.Animal;
import com.example.savanna.behavior.Fly;
import com.example.savanna.util.Constant;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void init() {
        initMoveBehaviorDropdown(null);
        initIsFlippedDropdown(null);
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

    public void initIsFlippedDropdown(String animalType) {
        animalIsFlipped.getItems().clear();
        if (animalType == null || animalType.isEmpty()) {
            animalIsFlipped.getItems().add(Constant.NA);
        } else {
            animalIsFlipped.getItems().addAll(Constant.BOOLEAN_DROPDOWN_LIST);
        }
    }

    public void initMoveBehaviorDropdown(String animalType) {
        this.animalMoveBehavior.getItems().clear();
        if (animalType == null || animalType.isEmpty()) {
            this.animalMoveBehavior.getItems().add(Constant.NA);
            return;
        }

        List<String> moveBehaviorList = new ArrayList<>();
        moveBehaviorList.add(Constant.MOVE_BEHAVIOR_WALK);
        if (Constant.FLYABLE_ANIMAL.contains(animalType)) {
            moveBehaviorList.add(Constant.MOVE_BEHAVIOR_FLY);
        }
        Collections.sort(moveBehaviorList);
        for (String mb : moveBehaviorList) {
            this.animalMoveBehavior.getItems().add(mb);
        }
    }

}
