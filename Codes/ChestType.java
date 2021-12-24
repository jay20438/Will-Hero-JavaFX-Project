package com.example.willherojavafxproject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ChestType {
    private Object typeOfReward;
    private Image image;
    private ImageView mineImageView;
    private double x;
    private double y;
    private double height;
    private double width;
    private int open;
    private CreateEntity createEntity;
    private AnchorPane anchorPane;

    public ChestType(String imageName, double x, double y, double height, double width, AnchorPane anchorPane){
        this.anchorPane = anchorPane;
        createEntity = new CreateEntity(null, null, null);
        this.height = height;
        this.width  = width;
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);;
        mineImageView.setPreserveRatio(true);
        anchorPane.getChildren().add(mineImageView);
    }


    public void open(){
        open = 1;
        CommonAnimations.replaceImageView("openChest", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("openChest"), createEntity.getWidthOfEntity("openChest"));
    }

    public ImageView getImageView(){
        return mineImageView;
    }


}
