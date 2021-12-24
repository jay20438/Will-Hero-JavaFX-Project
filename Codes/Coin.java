package com.example.willherojavafxproject;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Coin {
    private ImageView imageView;
    private double height;
    private double width;
    private AnchorPane anchorPane;

    public Coin(String imageName, double x, double y, double height, double width, AnchorPane anchorPane) {
        imageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        anchorPane.getChildren().add(imageView);
        imageView.setPreserveRatio(true);
    }

    public ImageView getImageView(){
        return imageView;
    }
}
