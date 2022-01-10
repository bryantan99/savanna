package com.example.savanna.command;

import com.example.savanna.animal.Animal;
import com.example.savanna.environment.EnvironmentSingleton;

import java.util.List;

public class DeleteCommand implements Command {

    private Integer animalId;

    public DeleteCommand(Integer animalId) {
        this.animalId = animalId;
    }

    @Override
    public void execute() {
        if (animalId != null) {
            List<Animal> animalList = EnvironmentSingleton.getInstance().getAnimalList();
            animalList.removeIf(animal -> animal.getAnimalId().equals(animalId));
        }
    }
}
