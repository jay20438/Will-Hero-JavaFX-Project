package com.example.willherojavafxproject;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CommonAnimations {

    static public TranslateTransition makeYTranslationalObj(int from, int to, boolean autoReverse, Duration duration){
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(duration);
        translateTransition.setAutoReverse(autoReverse);
        translateTransition.setToY(to);
        translateTransition.setFromY(from);
        return translateTransition;
    }

    static public ImageView makeImageAndSetCoord(String imageName, double x, double y, double height, double width){
        ImageView imageView = new ImageView();
        Image image = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ imageName + ".png"));
        imageView.setImage(image);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        return imageView;
    }

    static public void replaceImageView(String newImage, ImageView imageView){
        Image image = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ newImage + ".png"));
        imageView.setImage(image);
    }
}
