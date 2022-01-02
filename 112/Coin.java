package com.example.willherojavafxproject;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;
import java.util.Random;

public class Coin implements Serializable {
    private double x;
    private double y;
    private double height;
    private double width;
    private String imageName;
    private Random random;
    private transient ImageView mineImageView;
    private transient AnchorPane anchorPane;
    private  boolean collided;
    private Position bk;

    public Coin(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, Position bk) {
        this.bk = bk;
        this.height = height;
        this.width = width;
        try{
            mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
            anchorPane.getChildren().add(mineImageView);
        }catch (Exception e){
        }
        this.imageName = imageName;
        this.anchorPane  = anchorPane;
        random = new Random();
    }

    public ImageView getImageView(){
        return mineImageView;
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
        mineImageView.setOpacity(0);
        signal4CoinUpdating();
    }

    public void store(){
         x = mineImageView.getLayoutX();
         y = mineImageView.getLayoutY();
         height = mineImageView.getFitHeight();
         width = mineImageView.getFitWidth();
    }


    public void revive(AnchorPane anchorPane){
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        anchorPane.getChildren().add(mineImageView);
    }
}
