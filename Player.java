package com.example.javafx2;

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

    public void die()
    {
        CommonAnimations.replaceImageView("crushedPlayer", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("crushedPlayer"), createEntity.getWidthOfEntity("crushedPlayer"));
    }

//    String weapon = ChestType.chestTypeObject.size(chestTypeObject.size() - 1);
//    if(weapon == "missile")
//    {
//        launchMissile();
//    }
//    else if (weapon == "knife")
//    {
//        throwKnife();
//    }
    //Still working
    public void launchMissile(Missile missile)
    {

    }

//    public void throwKnife(Knife knife)
//    {
//
//    }


}