package com.example.savanna.behavior;

import com.example.savanna.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fly implements MoveBehavior{
    private Pane container;
    private ImageView imageView;

    public Fly(Pane container, ImageView imageView) {
        this.container = container;
        this.imageView = imageView;
    }

    @Override
    public void move(Double posX, Double posY) {
        AnchorPane.setLeftAnchor(imageView, posX);
        AnchorPane.setBottomAnchor(imageView, posY);

        String url = imageView.getImage().getUrl();
        String pattern = "[-a-z]+\\.";

        Pattern r = Pattern.compile(pattern);
        try {
            Matcher m = r.matcher(url);
            String animalImage = m.find() ? m.group(0).substring(0, m.group(0).length() - 1) : null;

            if (animalImage == null) {
                throw new Exception();
            } else {
                if (!animalImage.contains("fly")) {
                    animalImage = animalImage + "-fly.png";
                } else {
                    animalImage = animalImage + ".png";
                }
                imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/" + animalImage)).toURI().toString()));
            }
        } catch (Exception e) {
            System.out.println("No match");
        }
    }
}
