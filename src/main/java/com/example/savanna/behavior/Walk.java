package com.example.savanna.behavior;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Walk implements MoveBehavior{
    private Pane container;
    private ImageView imageView;

    public Walk(Pane container, ImageView imageView) {
        this.container = container;
        this.imageView = imageView;
    }

    // ToDo Update left anchor and right anchor, replaced image with default image
    @Override
    public void move(Double posX, Double posY) {
        AnchorPane.setLeftAnchor(imageView, posX);
        String url = imageView.getImage().getUrl();
    }
}
