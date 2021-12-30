package com.example.javafx2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Missile extends Weapon{

    private ImageView weaponImageView;
    private double x;
    private double y;
    private double height;
    private double width;
    private CreateEntity createEntity;
    private AnchorPane anchorPane;
    public Missile(AnchorPane anchorPane) {
        super(anchorPane);
        this.anchorPane = anchorPane;
    }

    @Override
    public TranslateTransition moveWeapon(double from, double to,double yPosition, double duration) {
        weaponImageView = CommonAnimations.makeImageAndSetCoord("missileFlying",from, yPosition, 50, 150);
        anchorPane.getChildren().add(weaponImageView);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(weaponImageView);
        translateTransition.setDuration(Duration.millis(duration));
        translateTransition.setCycleCount(1);
        translateTransition.setToX(to);
        translateTransition.setFromX(from);
        return translateTransition;
    }

    public ImageView getImageView() {
        return weaponImageView;
    }

    public void fade() {
        FadeTransition fadeTransition3 = new FadeTransition();
        CommonAnimations.replaceImageView(null, weaponImageView);
        fadeTransition3.setNode(weaponImageView);
        fadeTransition3.setDuration(Duration.millis(1500));
        fadeTransition3.setToValue(0);
        fadeTransition3.play();
    }
}