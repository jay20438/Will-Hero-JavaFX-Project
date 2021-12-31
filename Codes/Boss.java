package com.example.willherojavafxproject;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Boss extends Enemy{
    private Timer timer;
    private blankController bk;
    private ImageView mineImageView;
    public Boss(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, blankController bk) throws InterruptedException {
        super(imageName, x, y, height, width, anchorPane, bk, 50, 10);
        this.bk = bk;
        mineImageView = super.getImageView();
        this.moveLeft();

    }

    public void terminateTimer(){
        timer.cancel();
        timer.purge();
    }

    public void bringDownBoss(double islandY){
        mineImageView.setLayoutY(bk.getDepthOfBaseOfIsland("platform4Boss")+islandY-mineImageView.getFitHeight()+20);
        callJumpAfterDelay();
    }

    public void callJumpAfterDelay(){
        Timer timer2 = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(mineImageView.getLayoutX());
                try {
                    Boss.super.jump();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        timer2.schedule(timerTask, 100);
    }


    public void moveLeft(){
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("from run"+mineImageView.getLayoutX());
                if(mineImageView.getLayoutX()>20)
                    mineImageView.setLayoutX(mineImageView.getLayoutX()-50);
            }
        };
        timer.scheduleAtFixedRate(timerTask, 300, 900);
    }

}
