package com.example.willherojavafxproject;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChestType {
    private Object typeOfReward;
    private Image image;
    private ImageView imageView;
    private double x;
    private double y;
    private double height;
    private double width;
    private int open;
    private Group gpContainedIn;
    private CreateEntity createEntity;

    public ChestType(String imageName, Group gp, double x, double y, double height, double width){
        createEntity = new CreateEntity(null, null);
        this.gpContainedIn = gp;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width  = width;
        imageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        gp.getChildren().add(imageView);
        imageView.setPreserveRatio(true);
    }


    public void open(){
        open = 1;
        CommonAnimations.replaceImageView("openChest", imageView);
        CommonAnimations.setCoordinates(imageView, x, y, createEntity.getHeightOfEntity("openChest"), createEntity.getWidthOfEntity("openChest"));
    }

    public ImageView getImageView(){
        return imageView;
    }

    public Group getGroupContainedIn(){
        return gpContainedIn;
    }

}
