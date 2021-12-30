package com.example.javafx2;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Knife extends Weapon{
    private ImageView weaponImageView;
    private double x;
    private double y;
    private double height;
    private double width;
    private CreateEntity createEntity;
    private AnchorPane anchorPane;
    public Knife(AnchorPane anchorPane) {
        super(anchorPane);
        this.anchorPane = anchorPane;
    }

    @Override
    public TranslateTransition moveWeapon(double from, double to,double yPosition, double duration) {
        weaponImageView = CommonAnimations.makeImageAndSetCoord("knifeInAir",from, yPosition, 200, 300);
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
}