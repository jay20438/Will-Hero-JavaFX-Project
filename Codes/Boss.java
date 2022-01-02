package com.example.willherojavafxproject;


import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.util.Timer;
import java.util.TimerTask;

public class Boss extends Enemy{
    private Timer timer;
    private blankController bk;
    private ImageView mineImageView;
    private double boundLeft;
    private double boundRight;

    public Boss(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, blankController bk, double boundLeft, double boundRight) throws InterruptedException {
        super(imageName, x, y, height, width, anchorPane, bk, 80, 20);
        this.boundLeft = boundLeft;
        this.boundRight = boundRight;
        this.bk = bk;
        mineImageView = super.getImageView();
        this.moveLeft();

    }

    public void terminateTimer(){
        timer.cancel();
        timer.purge();
    }

    public void bringDownBoss(double islandY){
        mineImageView.setLayoutY(bk.getDepthOfBaseOfIsland("platform4Boss")+islandY-mineImageView.getFitHeight());
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
                if(mineImageView.getLayoutX()>=boundLeft && mineImageView.getBoundsInParent().getMaxX()<=boundRight)
                    mineImageView.setLayoutX(mineImageView.getLayoutX()-50);
            }
        };
        timer.scheduleAtFixedRate(timerTask, 400, 900);
    }

    public void terminateMoveLeft(){
        timer.cancel();
    }

}