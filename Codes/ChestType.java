package com.example.willherojavafxproject;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChestType {
    private Object typeOfReward;
    private Image image;
    private ImageView imageView;
    private int open;

    public ChestType(Group gp, double x, double y, double height, double width){
        imageView = CommonAnimations.makeImageAndSetCoord("treasureBox", x, y, height, width);
        gp.getChildren().add(imageView);
    }


    public void open(){
        open = 1;
        CommonAnimations.replaceImageView("openChest", imageView);
    }


}
