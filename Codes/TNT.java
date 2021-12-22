package com.example.willherojavafxproject;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TNT extends Obstacle
{
    private Image image;
    private ImageView imageView;
    private double x;
    private double y;
    private double height;
    private double width;
    private int open;

    public TNT(String imageName, Group gp, double x, double y, double height, double width){
//        imageView = CommonAnimations.makeImageAndSetCoord("treasureBox", x, y, height, width);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        imageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);

        gp.getChildren().add(imageView);

        imageView.setPreserveRatio(true);
    }
}
