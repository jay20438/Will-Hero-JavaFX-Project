package com.example.willherojavafxproject;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private int open;
    private Group gpContainedIn;
    private CreateEntity createEntity;
    private FadeTransition fadeTransition;

    public TNT(String imageName, Group gp, double x, double y, double height, double width){
        fadeTransition = new FadeTransition();
        createEntity = new CreateEntity(null, null);
        this.gpContainedIn = gp;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width  = width;
        imageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        gp.getChildren().add(imageView);
        imageView.setPreserveRatio(true);
    }

    public Group getGroupContainedIn(){
        return gpContainedIn;
    }

    public ImageView getImageView(){
        return imageView;
    }

    public void initiate(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                fadeTransition.setDuration(Duration.millis(200));
                fadeTransition.setCycleCount(Animation.INDEFINITE);
                fadeTransition.setAutoReverse(true);
                fadeTransition.setToValue(0.5);
                fadeTransition.setNode(imageView);
                fadeTransition.play();
                blast();
            }
        };
        timer.schedule(task, 1500);
    }

    public void blast(){
        fadeTransition.pause();
        FadeTransition fadeTransition2 = new FadeTransition();
        CommonAnimations.replaceImageView("tntFire", imageView);
        CommonAnimations.setCoordinates(imageView, x, y, createEntity.getHeightOfEntity("tntFire"), createEntity.getWidthOfEntity("tntFire"));
        fadeTransition2.setNode(imageView);
        fadeTransition2.setDuration(Duration.millis(1500));
        fadeTransition2.setToValue(0);
        fadeTransition2.play();
    }
}
