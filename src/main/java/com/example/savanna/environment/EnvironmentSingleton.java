package com.example.savanna.environment;

import com.example.savanna.animal.Animal;
import com.example.savanna.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentSingleton {
    private volatile static EnvironmentSingleton uniqueInstance;
    private final Sky sky;
    private final Land land;
    private final String sound;
    private List<Animal> animalList;

    private EnvironmentSingleton() {
        this.sky = new Sky(Constant.SKY_DEFAULT);
        this.land = new Land(Constant.LAND_DEFAULT);
        this.sound = Constant.BGM_DEFAULT;
        this.animalList = new ArrayList<>();
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

    public Land getLand() {
        return land;
    }

    public String getSound() {
        return sound;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }
}
