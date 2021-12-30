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
    }

    @Override
    public TranslateTransition moveWeapon(int from, int to, Duration duration) {
        weaponImageView = CommonAnimations.makeImageAndSetCoord("knife", 30, 40, 50, 300);
        anchorPane.getChildren().add(weaponImageView);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(weaponImageView);
        translateTransition.setDuration(duration);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setToX(to);
        translateTransition.setFromX(from);
        return translateTransition;
    }

    public ImageView getImageView() {
        return weaponImageView;
    }
}