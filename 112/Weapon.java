package com.example.willherojavafxproject;


import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


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
                if(weaponImageView.getLayoutX() < from + 500) {
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