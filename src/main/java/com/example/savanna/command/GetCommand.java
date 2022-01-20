package com.example.savanna.command;

import com.example.savanna.animal.Animal;
import com.example.savanna.environment.EnvironmentSingleton;

import java.util.List;

public class GetCommand implements Command {

    private final Integer animalId;

    public GetCommand(int animalId) {
        this.animalId = animalId;
    }

    @Override
    public Animal execute() {
        List<Animal> list = EnvironmentSingleton.getInstance().getAnimalList();
        if (list != null && !list.isEmpty()) {
            for (Animal a : list) {
                if (a.getAnimalId().equals(animalId)) {
                    return a;
                }
            }
        }
        return null;
    }
}
