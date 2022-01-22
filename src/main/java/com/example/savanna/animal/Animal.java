package com.example.savanna.animal;

import com.example.savanna.behavior.MoveBehavior;
import com.example.savanna.util.Constant;

import java.text.DecimalFormat;
import java.util.Random;

public class Animal {

    private Integer animalId;
    private Integer size;
    private String image;
    private Double positionX;
    private Double positionY;
    private Boolean isFlippedHorizontally;
    private MoveBehavior moveBehavior;

    public Animal(String image, Integer animalId) {
        Random r = new Random();
        DecimalFormat oneDigit = new DecimalFormat("#,##0.0");

        this.animalId = animalId;
        this.size = 150;
        this.image = image;
        this.positionX = Double.valueOf(oneDigit.format(r.nextDouble(Constant.VIEWSCREEN_WIDTH - 150.0)));
        this.positionY = 50.0;
        this.isFlippedHorizontally = false;
    }

    public Integer getAnimalId() {
        return animalId;
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

    public Boolean getFlippedHorizontally() {
        return isFlippedHorizontally;
    }

    public void setFlippedHorizontally(Boolean flippedHorizontally) {
        isFlippedHorizontally = flippedHorizontally;
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void move() {
        moveBehavior.move(positionX, positionY);
    }
}
