package com.example.willherojavafxproject;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class Coin {
    private ImageView imageView;
    private double x;
    private double y;
    private double height;
    private double width;

    public Coin(String imageName, Group gp, double x, double y, double height, double width) {
        imageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        gp.getChildren().add(imageView);
        imageView.setPreserveRatio(true);
    }
}
