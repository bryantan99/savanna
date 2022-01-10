package com.example.savanna.behavior;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Walk implements MoveBehavior{
    private Pane container;
    private ImageView imageView;

    public Walk(Pane container, ImageView imageView) {
        this.container = container;
        this.imageView = imageView;
    }

    @Override
    public void move() {
        Random random = new Random();
        AnchorPane.setLeftAnchor(imageView, random.nextDouble(700));
        String url = imageView.getImage().getUrl();
    }
}
