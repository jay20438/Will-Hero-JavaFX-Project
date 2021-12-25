package com.example.willherojavafxproject;

import javafx.scene.Group;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Player {
    private ImageView mineImageView;
    private int nOfCoins;
    private Knife knife;
    private Missile missile;
    private CreateEntity createEntity;

    public Player(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, CreateEntity createEntity) {
        this.createEntity = createEntity;
        knife = null;
        missile = null;
        nOfCoins = 0;
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        anchorPane.getChildren().add(mineImageView);
        mineImageView.setPreserveRatio(true);
    }

    public ImageView getMineImageView(){
        return mineImageView;
    }

    public void getCoins(int change){
        nOfCoins += change;
    }

    public void getKnife(Knife knife){
        this.knife = knife;
        CommonAnimations.replaceImageView("playerWithKnife", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("playerWithKnife"), createEntity.getWidthOfEntity("playerWithKnife"));
    }

    public void getMissile(Missile missile){
        this.missile = missile;
        CommonAnimations.replaceImageView("playerWithMissile", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("playerWithMissile"), createEntity.getWidthOfEntity("playerWithMissile"));
    }


}
