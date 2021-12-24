package com.example.willherojavafxproject;

import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

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

    public TNT(String imageName, double x, double y, double height, double width, AnchorPane anchorPane){
        fadeTransition = new FadeTransition();
        createEntity = new CreateEntity(null, null, null);
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

//    public void initiate(){
//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                fadeTransition.setDuration(Duration.millis(200));
//                fadeTransition.setCycleCount(Animation.INDEFINITE);
//                fadeTransition.setAutoReverse(true);
//                fadeTransition.setToValue(0.5);
//                fadeTransition.setNode(imageView);
//                fadeTransition.play();
//                blast();
//            }
//        };
//        timer.schedule(task, 1500);
//    }
//
        public void initiate(){
            blast();
    }


    public void blast(){
        //fadeTransition.pause();
        FadeTransition fadeTransition2 = new FadeTransition();
        CommonAnimations.replaceImageView("tntFire", imageView);
        CommonAnimations.setCoordinates(imageView, imageView.getBoundsInParent().getMinX(), imageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("tntFire"), createEntity.getWidthOfEntity("tntFire"));
        fadeTransition2.setNode(imageView);
        fadeTransition2.setDuration(Duration.millis(1500));
        fadeTransition2.setToValue(0);
        fadeTransition2.play();
    }
}
