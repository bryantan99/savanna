package com.example.savanna.command;

import com.example.savanna.animal.Animal;
import com.example.savanna.environment.EnvironmentSingleton;

import java.util.List;

public class DeleteCommand implements Command {

    private final Integer animalId;

    public DeleteCommand(Integer animalId) {
        this.animalId = animalId;
    }

    @Override
    public Animal execute() {
        Animal animal = null;
        if (animalId != null) {
            List<Animal> animalList = EnvironmentSingleton.getInstance().getAnimalList();
            for (Animal a : animalList) {
                if (a.getAnimalId().equals(animalId)) {
                    animal = a;
                    break;
                }
            }
            if (animal != null) {
                EnvironmentSingleton.getInstance().getAnimalList().remove(animal);
            }
        }
        return animal;
    }
}
