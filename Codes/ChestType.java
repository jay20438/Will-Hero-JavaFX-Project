package com.example.willherojavafxproject;

import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.Random;

public class ChestType implements Serializable {
    private Object typeOfReward;
    private transient ImageView mineImageView;
    private double x;
    private double y;
    private double height;
    private double width;
    private String imageName;
    private int open;
    private CreateEntity createEntity;
    private transient AnchorPane anchorPane;
    private Random random;
    private Position bk;
    private transient TranslateTransition translateTransition;
    private transient RotateTransition rotateTransition;
    private  transient FadeTransition fadeTransition;
    private boolean collided;
    boolean flagOnlyForCoins;

    public ChestType(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, Position bk, boolean flagOnlyForCoins){
        this.flagOnlyForCoins = flagOnlyForCoins;
        this.bk = bk;
        this.imageName = imageName;
        random = new Random();
        collided = false;
        this.anchorPane = anchorPane;
        createEntity = new CreateEntity(null, null);
        this.height = height;
        this.width  = width;
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);;
        //mineImageView.setPreserveRatio(true);
        anchorPane.getChildren().add(mineImageView);
    }


    public void open(Player player){
        CommonAnimations.replaceImageView("openChest", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("openChest"), createEntity.getWidthOfEntity("openChest"));
        generateReward(player);
    }

    public ImageView getImageView(){
        return mineImageView;
    }

    public void generateReward(Player player){
        if(!flagOnlyForCoins) {
            int firstLevel = random.nextInt(2);
            if (firstLevel == 0) {
                Coin coinObj = new Coin(null, 0, 0, 0, 0, null, bk);
                int randomCoins = coinObj.generateCollection();
                player.getCoins(randomCoins);
                bk.updateCoin(randomCoins);
            } else {
                int secondLevel = random.nextInt(2);
                if (secondLevel == 0) {
                    player.getKnife(new Knife(anchorPane));
                } else {
                    player.getMissile(new Missile(anchorPane));
                }
            }
        }else{
            bk.updateCoin(100);
            player.getCoins(100);
        }
        //rotateTransition.pause();
    }

    public  void generateTransition(){
        ImageView tossedCoins  = CommonAnimations.makeImageAndSetCoord("coins", mineImageView.getLayoutX()+5, mineImageView.getLayoutY(), 46, 39);
        anchorPane.getChildren().add(tossedCoins);
        translateTransition = new TranslateTransition();
        translateTransition.setNode(tossedCoins);
        translateTransition.setDuration(Duration.millis(1000));
        translateTransition.setByY(tossedCoins.getLayoutY()-50);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);
        rotateTransition = new RotateTransition();
        rotateTransition.setNode(tossedCoins);
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setByAngle(360);
        fadeTransition = new FadeTransition();
        fadeTransition.setNode(tossedCoins);
        fadeTransition.setByValue(0);
        fadeTransition.setDuration(Duration.millis(1000));
        translateTransition.play();
        rotateTransition.play();
        fadeTransition.play();
    }

    public boolean isCollided(){
        return collided;
    }

    public void setCollided(boolean flag){
        collided = flag;
    }

    public void store(){
         x = mineImageView.getLayoutX();
         y = mineImageView.getLayoutY();
         height = mineImageView.getFitHeight();
         width = mineImageView.getFitWidth();
    }


    public void revive(AnchorPane anchorPane){
        this.anchorPane = anchorPane;
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        anchorPane.getChildren().add(mineImageView);
    }

}
