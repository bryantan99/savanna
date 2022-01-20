package com.example.savanna.command;

import com.example.savanna.animal.Animal;
import com.example.savanna.animal.AnimalFactory;
import com.example.savanna.environment.EnvironmentSingleton;

public class AddCommand implements Command {

    private final AnimalFactory factory = new AnimalFactory();
    private final String animalType;

    public AddCommand(String animalType) {
        this.animalType = animalType;
    }

    @Override
    public Animal execute() {
        Animal animal = factory.createAnimal(animalType);
        if (animal != null) {
            EnvironmentSingleton.getInstance().getAnimalList().add(animal);
        }
        return animal;
    }
}
