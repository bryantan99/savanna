package com.example.savanna.behavior;

import com.example.savanna.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fly implements MoveBehavior{
    private Pane container;
    private ImageView imageView;
    private Boolean isChanged = false;

    public Fly(Pane container, ImageView imageView) {
        this.container = container;
        this.imageView = imageView;
    }

    @Override
    public void move() {
        Random random = new Random();
        AnchorPane.setLeftAnchor(imageView, random.nextDouble(700));
        AnchorPane.setBottomAnchor(imageView, random.nextDouble(350));

        if(!isChanged){
            String url = imageView.getImage().getUrl();
            String pattern = "[a-z]+\\.";

            Pattern r = Pattern.compile(pattern);
            try{
                Matcher m = r.matcher(url);
                String animalImage = m.find()? m.group(0).substring(0, m.group(0).length() - 1) + "-fly.png" : null;

                if(animalImage == null){
                    throw new Exception();
                }else{
                    imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/" + animalImage)).toURI().toString()));
                }
            }catch (Exception e){
                System.out.println("No match");
            }
            isChanged = true;
        }
    }
}
