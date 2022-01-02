package com.example.willherojavafxproject;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;




public class Missile extends Weapon{

    public Missile(AnchorPane anchorPane) {
        super(anchorPane);
    }

    public ImageView formImageView(double from, double to,double yPosition, double duration)
    {
        ImageView weaponImageView = CommonAnimations.makeImageAndSetCoord("missileFlying",from, yPosition, 50, 150);
        super.getAnchorPane().getChildren().add(weaponImageView);
        return weaponImageView;
    }

}