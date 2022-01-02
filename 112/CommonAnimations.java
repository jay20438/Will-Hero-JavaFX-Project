package com.example.willherojavafxproject;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class CommonAnimations implements Serializable {

    static public TranslateTransition makeYTranslationalObj(ImageView imageView, int from, int to, boolean autoReverse, Duration duration) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(imageView);
        translateTransition.setDuration(duration);
        translateTransition.setAutoReverse(autoReverse);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setByY(imageView.getBoundsInLocal().getMinY() - 70);
        return translateTransition;
    }

    static public ImageView makeImageAndSetCoord(String imageName, double x, double y, double height, double width) {
        ImageView imageView = new ImageView();
        Image image = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/" + imageName + ".png"));
        imageView.setImage(image);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        return imageView;
    }

    static public void replaceImageView(String newImage, ImageView imageView) {
        Image image = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/" + newImage + ".png"));
        imageView.setImage(image);

    }

    static public void replaceImageView(String newImage, ImageView imageView, double x, double y, double height, double width) {
        Image image = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/" + newImage + ".png"));
        imageView.setImage(image);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);

    }

    static public void setCoordinates(ImageView imageView, double x, double y, double height, double width) {
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
    }

}

