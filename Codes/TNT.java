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

public class TNT extends Obstacle implements Serializable
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

    public TNT(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, CreateEntity createEntity){
        this.createEntity = createEntity;
        collided = false;
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
        double helpy  = mineImageView.getBoundsInParent().getMinY();
        double helpx = mineImageView.getBoundsInParent().getMinX();
        mineImageView.setOpacity(1);
        CommonAnimations.replaceImageView("tntFire", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, helpx, helpy-60, createEntity.getHeightOfEntity("tntFire"), createEntity.getWidthOfEntity("tntFire"));
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
        System.out.println("tnt before store x:"+mineImageView.getLayoutX() + " y:" + mineImageView.getLayoutY());
         x = mineImageView.getLayoutX();
         y = mineImageView.getLayoutY();
        System.out.println("tnt height and width before storing:" + mineImageView.getFitHeight()+" "+mineImageView.getFitWidth());
         height = mineImageView.getFitHeight();
         width = mineImageView.getFitWidth();
    }


    public void revive(AnchorPane anchorPane) throws InterruptedException {
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        System.out.println("tnt after revive x:" + mineImageView.getLayoutX() + " y:" + mineImageView.getLayoutY());
        System.out.println("tnt height and width after storing:" + mineImageView.getFitHeight()+" "+mineImageView.getFitWidth());
        anchorPane.getChildren().add(mineImageView);
    }
}
