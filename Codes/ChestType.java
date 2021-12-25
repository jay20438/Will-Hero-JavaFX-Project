package com.example.willherojavafxproject;

import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.Random;

public class ChestType {
    private Object typeOfReward;
    private Image image;
    private ImageView mineImageView;
    private double x;
    private double y;
    private double height;
    private double width;
    private int open;
    private CreateEntity createEntity;
    private AnchorPane anchorPane;
    private Random random;
    private blankController bk;
    private TranslateTransition translateTransition;
    private RotateTransition rotateTransition;
    private  FadeTransition fadeTransition;

    public ChestType(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, blankController bk){
        this.bk = bk;
        random = new Random();
        this.anchorPane = anchorPane;
        createEntity = new CreateEntity(null, null, null);
        this.height = height;
        this.width  = width;
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);;
        mineImageView.setPreserveRatio(true);
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
        int firstLevel = random.nextInt(2);
        if(firstLevel==0){
            int randomCoins = random.nextInt(50);
            player.getCoins(randomCoins);
            bk.updateCoin(randomCoins);
            generateTransition();
        }else{
            int secondLevel = random.nextInt(2);
            if(secondLevel == 0){
                player.getKnife(new Knife());
            }else{
                player.getMissile(new Missile());
            }
        }
        rotateTransition.pause();
    }

    public  void generateTransition(){
        ImageView tossedCoins  = CommonAnimations.makeImageAndSetCoord("coins", mineImageView.getLayoutX()+5, mineImageView.getLayoutY(), 46, 39);
        translateTransition = new TranslateTransition();
        translateTransition.setNode(tossedCoins);
        translateTransition.setDuration(Duration.millis(1000));
        translateTransition.setByY(tossedCoins.getLayoutY()-50);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);
        rotateTransition = new RotateTransition();
        rotateTransition.setNode(tossedCoins);
        rotateTransition.setDuration(Duration.millis(500));
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setByAngle(360);
        fadeTransition = new FadeTransition();
        fadeTransition.setNode(tossedCoins);
        fadeTransition.setByValue(0);
        fadeTransition.setDuration(Duration.millis(700));
        translateTransition.play();
        rotateTransition.play();
        fadeTransition.play();
    }

}
