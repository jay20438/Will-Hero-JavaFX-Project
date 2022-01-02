package com.example.javafx2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Knife extends Weapon{
    private double x;
    private double y;
    private double height;
    private double width;
    private CreateEntity createEntity;
    private AnchorPane anchorPane;
    public Knife(AnchorPane anchorPane) {
        super(anchorPane);
        this.anchorPane = anchorPane;
    }

    @Override
    public void moveWeapon(double from, ImageView weaponImageView,double yPosition, double duration) {

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+weaponImageView.getLayoutX());

        int[] count = {0};
        super.setDistance((int)weaponImageView.getLayoutX() + 700);
        Timer timer4 = new Timer();
        TimerTask timerTask4 = new TimerTask() {
            @Override
            public void run() {
                if(weaponImageView.getLayoutX() < from + 700) {
                    weaponImageView.setLayoutX(weaponImageView.getLayoutX() + 50);
                }
                else
                {
                    weaponImageView.setOpacity(0);
                    terminateWeaponTimer(timer4);

                }
            }

        };
        timer4.scheduleAtFixedRate(timerTask4, 100, 100);
    }

    public void terminateWeaponTimer(Timer timer){
        timer.cancel();
        timer.purge();
    }

    public ImageView formImageView(double from, double to,double yPosition, double duration)
    {
        ImageView weaponImageView = CommonAnimations.makeImageAndSetCoord("knifeInAir",from, yPosition, 200, 300);
        anchorPane.getChildren().add(weaponImageView);
        return weaponImageView;
    }
    public void fade() {
        FadeTransition fadeTransition3 = new FadeTransition();
        //fadeTransition3.setNode(weaponImageView);
        fadeTransition3.setDuration(Duration.millis(5000));
        fadeTransition3.setToValue(0);
        fadeTransition3.play();
    }

//    public ImageView getImageView() {
//        return weaponImageView;
//    }
}