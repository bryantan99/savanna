package com.example.savanna.environment;

import com.example.savanna.animal.Animal;
import com.example.savanna.animal.AnimalFactory;
import com.example.savanna.command.AddCommand;
import com.example.savanna.command.Command;
import com.example.savanna.command.DeleteCommand;
import com.example.savanna.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentSingleton {
    private volatile static EnvironmentSingleton uniqueInstance;
    private Sky sky;
    private Land land;
    private String sound;
    private List<Animal> animalList;
    private AnimalFactory factory;
    private Command command;

    private void init() {
        factory = new AnimalFactory();
    }

    private EnvironmentSingleton() {
        this.sky = new Sky(Constant.SKY_DEFAULT);
        this.land = new Land(Constant.LAND_DEFAULT);
        this.sound = Constant.BGM_DEFAULT;
        this.animalList = new ArrayList<>();
    }

    public Animal addAnimal(String type) {
        Animal animal = factory.createAnimal(type);
        command = new AddCommand(animal);
        command.execute();
        return animal;
    }

    public void removeAnimal(Integer animalId) {
        command = new DeleteCommand(animalId);
        command.execute();
    }

    public static EnvironmentSingleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (EnvironmentSingleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new EnvironmentSingleton();
                    uniqueInstance.init();
                }
            }
        }
        return uniqueInstance;
    }

    public Sky getSky() {
        return sky;
    }

    public void setSky(Sky sky) {
        this.sky = sky;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
