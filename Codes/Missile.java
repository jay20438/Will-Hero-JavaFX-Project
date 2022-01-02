package com.example.javafx2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Missile extends Weapon{

//    private ImageView weaponImageView;
    private double x;
    private double y;
    private double height;
    private double width;
    private CreateEntity createEntity;
    private AnchorPane anchorPane;
    public Missile(AnchorPane anchorPane) {
        super(anchorPane);
        this.anchorPane = anchorPane;
    }

    public ImageView formImageView(double from, double to,double yPosition, double duration)
    {
        ImageView weaponImageView = CommonAnimations.makeImageAndSetCoord("missileFlying",from, yPosition, 50, 150);
        anchorPane.getChildren().add(weaponImageView);

        return weaponImageView;
    }

    @Override
    public void moveWeapon(double from,ImageView weaponImageView,double yPosition, double duration) {

//        TranslateTransition translateTransition = new TranslateTransition();
//        translateTransition.setNode(weaponImageView);
//        translateTransition.setDuration(Duration.millis(duration));
//        translateTransition.setCycleCount(1);
//        translateTransition.setToX(to);
//        translateTransition.setFromX(from);
//        return translateTransition;


        super.setDistance((int)weaponImageView.getLayoutX() + 700);
        Timer timer3 = new Timer();
        TimerTask timerTask3 = new TimerTask() {
            @Override
            public void run() {
                if(weaponImageView.getLayoutX() < from + 700) {
                    weaponImageView.setLayoutX(weaponImageView.getLayoutX() + 50);
                }
                else
                {
                    weaponImageView.setOpacity(0);
                    terminateWeaponTimer(timer3);

                }
            }

        };
        timer3.scheduleAtFixedRate(timerTask3, 100, 100);
    }

    public void terminateWeaponTimer(Timer timer){
        timer.cancel();
        timer.purge();
    }

//    public ImageView getImageView() {
//        return weaponImageView;
//    }

    public void fade() {
        FadeTransition fadeTransition3 = new FadeTransition();
        //fadeTransition3.setNode(weaponImageView);
        fadeTransition3.setDuration(Duration.millis(5000));
        fadeTransition3.setToValue(0);
        fadeTransition3.play();
    }
}