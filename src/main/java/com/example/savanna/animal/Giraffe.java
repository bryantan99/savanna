package com.example.savanna.animal;

import com.example.savanna.util.Constant;

public class Giraffe extends Animal {
    public Giraffe() {
        super(Constant.IMAGE_GIRAFFE, AnimalFactory.id++);
    }
}
