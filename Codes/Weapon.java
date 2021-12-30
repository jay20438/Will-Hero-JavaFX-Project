package com.example.javafx2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public abstract class Weapon {

    //    private Image image;
    //private final TranslateTransition translate4;
    private double x;
    private double y;
    private double height;
    private double width;
    private CreateEntity createEntity;
    private AnchorPane anchorPane;

    public Weapon(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
        createEntity = new CreateEntity(null, null);
    }

    abstract TranslateTransition moveWeapon(double from, double to,double yPosition, double duration);


    /*public void killEnemy(Enemy enemy){
        //player.die();
        FadeTransition fadeTransition3 = new FadeTransition();
        CommonAnimations.replaceImageView("crushedPlayer", imageView);
        CommonAnimations.setCoordinates(imageView, imageView.getBoundsInParent().getMinX(), imageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("crushedPlayer"), createEntity.getWidthOfEntity("crushedPlayer"));
        fadeTransition3.setNode(imageView);
        fadeTransition3.setDuration(Duration.millis(1500));
        fadeTransition3.setToValue(0);
        fadeTransition3.play();
    }*/

}