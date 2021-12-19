package com.example.willherojavafxproject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Enemy {

    private Image image;
    private ImageView imageView;

    public Enemy(double x, double y, double height, double width){
        image = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ "GreenOrcNew.png"));
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        CommonAnimations.makeYTranslationalObj(1, 3, true, Duration.INDEFINITE).play();
    }


    public void killPlayer(){

    }

    public void jump(){

    }

    public void die(){

    }

    public void slide(double change){

    }



}