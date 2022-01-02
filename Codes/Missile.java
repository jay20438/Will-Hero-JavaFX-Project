package com.example.willherojavafxproject;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Timer;
import java.util.TimerTask;

//public class Missile extends Weapon{
//    public Missile(AnchorPane anchorPane) {
//        super(anchorPane);
//    }
//}


public class Missile extends Weapon{

    public Missile(AnchorPane anchorPane) {
        super(anchorPane);
    }

    public ImageView formImageView(double from, double to,double yPosition, double duration)
    {
        //System.out.println("formed the imageView of missile");
        ImageView weaponImageView = CommonAnimations.makeImageAndSetCoord("missileFlying",from, yPosition, 50, 150);
        super.getAnchorPane().getChildren().add(weaponImageView);
        return weaponImageView;
    }

}
