package com.example.willherojavafxproject;

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

    public Enemy(String imageName, double x, double y, double height, double width){
//        image = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ "GreenOrcNew.png"));
//        imageView = new ImageView();
//        imageView.setImage(image);
//        imageView.setFitHeight(height);
//        imageView.setFitWidth(width);
//        imageView.setLayoutX(x);
//        imageView.setLayoutY(y);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        imageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        imageView.setPreserveRatio(true);
    }


    public void killPlayer(Player player){
        //player.die();
    }

    public void jump(){
        CommonAnimations.makeYTranslationalObj(imageView, 1, 3, true, Duration.INDEFINITE).play();
    }

    public void die(){
        CommonAnimations.replaceImageView("enemyBlood", imageView);
    }

    public void slide(double change){

    }



}