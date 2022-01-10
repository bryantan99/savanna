package com.example.savanna.animal;

import com.example.savanna.behavior.Fly;
import com.example.savanna.behavior.MoveBehavior;
import com.example.savanna.behavior.Walk;

import java.util.Random;

public class Animal {

    private Integer animalId;
    private Integer size;
    private String image;
    private Double positionX;
    private Double positionY;
    private Boolean isFly;
    private MoveBehavior moveBehavior;

    public Animal(String image, Integer animalId) {
        Random r = new Random();
        this.animalId = animalId;
        this.size = 150;
        this.image = image;
        this.positionX = (double) r.nextInt(700);
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPositionX() {
        return positionX;
    }

    public void setPositionX(Double positionX) {
        this.positionX = positionX;
    }

    public Double getPositionY() {
        return positionY;
    }

    public void setPositionY(Double positionY) {
        this.positionY = positionY;
    }

    public Boolean getFly() {
        return isFly;
    }

    public void setFly(Boolean fly) {
        isFly = fly;
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void adjustPositionYAccordingToIsFly() {
        Random r = new Random();

        if (isFly) {
            this.positionY = (double) r.nextInt(350);
        } else {
            this.positionY = (double) r.nextInt(160);
        }
    }
}
