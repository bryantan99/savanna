package com.example.savanna.animal;

import java.util.Random;

public class Animal {
    private Integer animalId;
    private Integer size;
    private String image;
    private Double positionX;
    private Double positionY;

    public Animal (String image) {
        Random r = new Random();
        this.animalId = null;
        this.size = 150;
        this.image = image;
        this.positionX = (double) r.nextInt(700);
        this.positionY = (double) r.nextInt(160);
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
}
