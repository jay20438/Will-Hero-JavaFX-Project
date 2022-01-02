package com.example.willherojavafxproject;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class Knife extends Weapon{

    public Knife(AnchorPane anchorPane) {
        super(anchorPane);
    }

    public ImageView formImageView(double from, double to, double yPosition, double duration)
    {
        ImageView weaponImageView = CommonAnimations.makeImageAndSetCoord("knife",from, yPosition, 200, 300);
        super.getAnchorPane().getChildren().add(weaponImageView);
        return weaponImageView;
    }

}