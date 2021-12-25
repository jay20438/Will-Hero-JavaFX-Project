package com.example.willherojavafxproject;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public abstract class Enemy {

//    private Image image;
    private ImageView imageView;
    private double x;
    private double y;
    private double height;
    private double width;
    private AnchorPane anchorPane;
    private boolean collided;
    private CreateEntity createEntity;

    public Enemy(String imageName, double x, double y, double height, double width, AnchorPane anchorPane){
        this.anchorPane = anchorPane;
        imageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        imageView.setPreserveRatio(true);
        anchorPane.getChildren().add(imageView);
        createEntity = new CreateEntity(null, null, null);
        this.jump();
    }


    public void killPlayer(Player player){
        player.die();
    }

    public void jump(){
        CommonAnimations.makeYTranslationalObj(imageView, (int)imageView.getLayoutY(), (int)imageView.getLayoutY()-70, true, Duration.millis(1000)).play();
    }

    public void die(){
       // CommonAnimations.replaceImageView("enemyBlood", imageView);
    }

    public void slide(double change){

    }

    public ImageView getImageView(){
        return imageView;
    }
    private boolean isCollided(){
        return collided;
    }

    private void setCollided(boolean flag){
        collided = flag;
    }


    public void slide(){
        CommonAnimations.setCoordinates(imageView, imageView.getBoundsInParent().getMinX()+90, imageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("greenOrc"), createEntity.getWidthOfEntity("greenOrc"));
    }



}