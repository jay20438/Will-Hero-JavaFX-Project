package com.example.willherojavafxproject;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class TNT extends Obstacle
{
    private Image image;
    private ImageView imageView;
    private double x;
    private double y;
    private double height;
    private double width;
    private AnchorPane anchorPane;
    private int open;
    private CreateEntity createEntity;
    private FadeTransition fadeTransition;
    private boolean collided;

    public TNT(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, CreateEntity createEntity){
        this.createEntity = createEntity;
        collided = false;
        fadeTransition = new FadeTransition();
        this.anchorPane = anchorPane;
        this.height = height;
        this.width  = width;
        imageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        anchorPane.getChildren().add(imageView);
        imageView.setPreserveRatio(true);
    }


    public ImageView getImageView(){
        return imageView;
    }

    public void initiate(){
        fadeTransition.setDuration(Duration.millis(200));
        fadeTransition.setCycleCount(4);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setToValue(0.5);
        fadeTransition.setNode(imageView);
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
        double helpy  = imageView.getBoundsInParent().getMinY();
        double helpx = imageView.getBoundsInParent().getMinX();
        imageView.setOpacity(1);
        CommonAnimations.replaceImageView("tntFire", imageView);
        CommonAnimations.setCoordinates(imageView, helpx, helpy-60, createEntity.getHeightOfEntity("tntFire"), createEntity.getWidthOfEntity("tntFire"));
        fadeTransition2.setDuration(Duration.millis(2500));
        fadeTransition2.setToValue(0);
        fadeTransition2.setNode(imageView);
        fadeTransition2.play();

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(imageView.getOpacity()==0){
                    terminateTimer(timer);
                }
                createEntity.getBk().checkCollisionOfEntitiesAndFire(imageView);
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
}
