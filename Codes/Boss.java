package com.example.willherojavafxproject;


import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.util.Timer;
import java.util.TimerTask;

public class Boss extends Enemy{

    private transient Timer timer;
    private Position bk;
    private transient ImageView mineImageView;
    private double boundLeft;
    private double boundRight;

    public Boss(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, Position bk, double boundLeft, double boundRight) throws InterruptedException {
        super(imageName, x, y, height, width, anchorPane, bk, 80, 10);
        this.boundLeft = boundLeft;
        this.boundRight = boundRight;
        this.bk = bk;
        mineImageView = super.getImageView();

    }

    public void terminateTimer(){
        timer.cancel();
        timer.purge();
    }

    public void bringDownBoss(double islandY){
        mineImageView.setLayoutY(bk.getDepthOfBaseOfIsland("platform4Boss")+islandY-mineImageView.getFitHeight());
        callJumpAfterDelay();
        this.moveLeft();
        bk.checkCollisionOfPlayerAndBoss();
    }

    public void callJumpAfterDelay(){
        Timer timer2 = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Boss.super.jump();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        timer2.schedule(timerTask, 90);
    }


    public void moveLeft(){
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(mineImageView.getLayoutX()>=boundLeft && mineImageView.getBoundsInParent().getMaxX()<=boundRight)
                    mineImageView.setLayoutX(mineImageView.getLayoutX()-50);
            }
        };
        timer.scheduleAtFixedRate(timerTask, 400, 900);
    }

    public void moveWait()  {
        try{
            timer.wait();
        }catch (Exception e){}

    }


    public void terminateMoveLeft(){
        timer.cancel();
    }



    public void reviveMoveLeft(){
        mineImageView = super.getImageView();
        this.moveLeft();
        bk.checkCollisionOfPlayerAndBoss();
    }

}
