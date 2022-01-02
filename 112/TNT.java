package com.example.willherojavafxproject;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class TNT implements Serializable
{

    private transient ImageView mineImageView;
    private double x;
    private double y;
    private double height;
    private double width;
    private String imageName;
    private transient AnchorPane anchorPane;
    private int open;
    private CreateEntity createEntity;
    private transient FadeTransition fadeTransition;
    private boolean collided;
    private boolean bursted;
    private double opacityOfImage;

    public TNT(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, CreateEntity createEntity){
        opacityOfImage = 1;
        this.createEntity = createEntity;
        collided = false;
        bursted = false;
        fadeTransition = new FadeTransition();
        this.anchorPane = anchorPane;
        this.imageName = imageName;
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        anchorPane.getChildren().add(mineImageView);
        mineImageView.setPreserveRatio(true);
    }


    public ImageView getImageView(){
        return mineImageView;
    }

    public void initiate(){
        bursted = true;
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(200));
        fadeTransition.setCycleCount(4);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setToValue(0.5);
        fadeTransition.setNode(mineImageView);
        fadeTransition.play();
        help();
    }

    public void help(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                blast();
            }
        };
        timer.schedule(task, 1200);
    }


    public void blast(){
        FadeTransition fadeTransition2 = new FadeTransition();
        //double mineImageView.getBoundsInParent().getMinY()  = mineImageView.getBoundsInParent().getMinY();
        //double mineImageView.getBoundsInParent().getMinX() = mineImageView.getBoundsInParent().getMinX();
        mineImageView.setOpacity(1);
        imageName = "tntFire";
        CommonAnimations.replaceImageView("tntFire", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY()-60, createEntity.getHeightOfEntity("tntFire"), createEntity.getWidthOfEntity("tntFire"));
        fadeTransition2.setDuration(Duration.millis(2500));
        fadeTransition2.setToValue(0);
        fadeTransition2.setNode(mineImageView);
        fadeTransition2.play();

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(mineImageView.getOpacity()==0){
                    terminateTimer(timer);
                }
                createEntity.getBk().checkCollisionOfEntitiesAndFire(mineImageView);
            }
        };
        timer.scheduleAtFixedRate(timerTask, 100, 100);

    }

    public void terminateTimer(Timer timer){
        timer.cancel();;
        timer.purge();
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


    public void revive(AnchorPane anchorPane) throws InterruptedException {
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        anchorPane.getChildren().add(mineImageView);
        if(imageName.equals("tntFire")){
            FadeTransition fadeTransition2 = new FadeTransition();
            fadeTransition2.setDuration(Duration.millis(1500));
            fadeTransition2.setToValue(0);
            fadeTransition2.setNode(mineImageView);
            fadeTransition2.play();
        }
    }
}
