package com.example.savanna.command;

import com.example.savanna.animal.Animal;
import com.example.savanna.environment.EnvironmentSingleton;

public class AddCommand implements Command {

    private Animal animal;

    public AddCommand(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void execute() {
        if (animal != null) {
            EnvironmentSingleton.getInstance().getAnimalList().add(animal);
        }
    }
}
