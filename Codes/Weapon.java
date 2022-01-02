package com.example.willherojavafxproject;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Weapon implements Serializable {
    private transient ImageView weaponImageView;
    private  double x;
    private  double y;
    private  double height;
    private  double width;
    private String imageName;
    private CreateEntity createEntity;
    private transient AnchorPane anchorPane;
    private Timer timer;

    public Weapon(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
        createEntity = new CreateEntity(null, null);
    }

//
//    public TranslateTransition moveWeapon(int from, int to, Duration duration) {
//        weaponImageView = CommonAnimations.makeImageAndSetCoord("missileFlying", 30, 120, 50, 150);
//        anchorPane.getChildren().add(weaponImageView);
//        TranslateTransition translateTransition = new TranslateTransition();
//        translateTransition.setNode(weaponImageView);
//        translateTransition.setDuration(duration);
//        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
//        translateTransition.setToX(to);
//        translateTransition.setFromX(from);
//        return translateTransition;
//    }



    /*public void killEnemy(Enemy enemy){
        //player.die();
        FadeTransition fadeTransition3 = new FadeTransition();
        CommonAnimations.replaceImageView("crushedPlayer", imageView);
        CommonAnimations.setCoordinates(imageView, imageView.getBoundsInParent().getMinX(), imageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("crushedPlayer"), createEntity.getWidthOfEntity("crushedPlayer"));
        fadeTransition3.setNode(imageView);
        fadeTransition3.setDuration(Duration.millis(1500));
        fadeTransition3.setToValue(0);
        fadeTransition3.play();
    }*/


    public ImageView getImageView() {
        return weaponImageView;
    }

    public AnchorPane getAnchorPane(){
        return anchorPane;
    }

//    abstract void moveWeapon(double from,ImageView weaponImageView,double yPosition, double duration);

    public void moveWeapon(double from,ImageView weaponImageView,double yPosition, double duration) {
        timer = new Timer();
        TimerTask timerTask3 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("moving the weapon");
                if(weaponImageView.getLayoutX() < from + 700) {
                    weaponImageView.setLayoutX(weaponImageView.getLayoutX() + 50);
                }
                else
                {
                    weaponImageView.setOpacity(0);
                    terminateWeaponTimer(timer);

                }
            }

        };
        timer.scheduleAtFixedRate(timerTask3, 100, 100);
    }

    public void terminateWeaponTimer(Timer timer){
        timer.cancel();
        timer.purge();
    }

}