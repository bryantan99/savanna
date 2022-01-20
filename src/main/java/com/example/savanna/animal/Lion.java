package com.example.savanna.animal;

import com.example.savanna.util.Constant;

public class Lion extends Animal {
    public Lion() {
        super(Constant.IMAGE_LION, AnimalFactory.id++);
    }
}
