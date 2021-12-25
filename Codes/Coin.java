package com.example.willherojavafxproject;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Random;

public class Coin {
    private Random random;
    private ImageView imageView;
    private double height;
    private double width;
    private AnchorPane anchorPane;
    private  boolean collided;
    private blankController bk;

    public Coin(String imageName, double x, double y, double height, double width, AnchorPane anchorPane) {
        bk = new blankController();
        this.height = height;
        this.width = width;
        try{
            imageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
            anchorPane.getChildren().add(imageView);
        }catch (Exception e){
        }
        random = new Random();
    }

    public ImageView getImageView(){
        return imageView;
    }

    public boolean isCollided(){
        return collided;
    }

    public void setCollided(boolean flag){
        collided = flag;
    }


    public void signal4CoinUpdating() {
//        ImageView iV = bk.getCoinSymbol();
//        TranslateTransition translateTransition = new TranslateTransition();
////        translateTransition.se
    }

    public int generateCollection(){
        signal4CoinUpdating();
        return random.nextInt(50);
    }

    public void fade(){
        imageView.setOpacity(0);
        signal4CoinUpdating();
    }
}
