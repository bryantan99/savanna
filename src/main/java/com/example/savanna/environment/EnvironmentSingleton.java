package com.example.savanna.environment;

import com.example.savanna.animal.Animal;
import com.example.savanna.animal.AnimalFactory;
import com.example.savanna.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentSingleton {
    private volatile static EnvironmentSingleton uniqueInstance;
    private Sky sky;
    private Land land;
    private String sound;
    private boolean isRaining;
    private List<Animal> animalList;

    private EnvironmentSingleton() {
        this.sky = new Sky(Constant.SKY_DEFAULT);
        this.land = new Land(Constant.LAND_DEFAULT);
        this.sound = Constant.BGM_DEFAULT;
        this.isRaining = false;
        this.animalList = new ArrayList<>();
    }

    public Animal addAnimal(String type) {
        AnimalFactory factory = new AnimalFactory();
        Animal animal = factory.createAnimal(type);
        if (animal != null) {
            animalList.add(animal);
        }
        if (animalList != null) {
            System.out.println("Current animal list : " + animalList.size());
        }
        return animal;
    }

    public void removeAnimal(Integer animalId) {

    }

    public Animal getAnimal(Integer animalId) {
        if (animalList != null && !animalList.isEmpty()) {
            for (Animal a : animalList) {
                if (a.getAnimalId().equals(animalId)) {
                    return a;
                }
            }
        }
        return null;
    }

    public static EnvironmentSingleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (EnvironmentSingleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new EnvironmentSingleton();
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

    public boolean isRaining() {
        return isRaining;
    }

    public void setRaining(boolean raining) {
        isRaining = raining;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
