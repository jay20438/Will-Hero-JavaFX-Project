package com.example.willherojavafxproject;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Enemy {

//    private Image image;
    private ImageView imageView;
    private double x;
    private double y;
    private double height;
    private double width;

    public Enemy(String imageName, Group gp, double x, double y, double height, double width){
        imageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        gp.getChildren().add(imageView);
        imageView.setPreserveRatio(true);
        this.jump();
    }


    public void killPlayer(Player player){
        //player.die();
    }

    public void jump(){
        CommonAnimations.makeYTranslationalObj(imageView, (int)imageView.getBoundsInLocal().getMinY(), (int)imageView.getBoundsInLocal().getMinY()-70, true, Duration.millis(1000)).play();
    }

    public void die(){
        CommonAnimations.replaceImageView("enemyBlood", imageView);
    }

    public void slide(double change){

    }



}