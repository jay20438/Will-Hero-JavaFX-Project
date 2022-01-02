package com.example.willherojavafxproject;

import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Enemy implements Serializable {
    private Position bk;
    private transient ImageView mineImageView;
    private transient AnchorPane anchorPane;
    private boolean collided;
    private CreateEntity createEntity;
    private transient Timer timer1;
    private int gainedUpHeight;
    private boolean flag4Up;
    private Enemy e;
    private boolean living;
    private int maxHeight;
    private int yChange;
    private String imageName;
    private double x;
    private double y;
    private double height;
    private double width;

    public Enemy(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, Position bk, int maxHeight, int yChange) throws InterruptedException {
        this.maxHeight = maxHeight;
        this.yChange = yChange;
        this.bk = bk;
        e = this;
        this.imageName = imageName;
        collided = false;
        flag4Up = false;
        living = true;
        gainedUpHeight = 0;
        this.anchorPane = anchorPane;
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        anchorPane.getChildren().add(mineImageView);
        createEntity = new CreateEntity(null, null);
        if(!imageName.equals("boss")){
            this.jump();
        }

    }


    public void killPlayer(Player player){
        player.die();
    }

    public void jump() throws InterruptedException {
        timer1 = new Timer();
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                if(!living){
                    e.setFlag4Up(false);
                }else {
                    if (e.getGainedUpHeight() > 0 && e.getGainedUpHeight() <= e.getMaxHeight()) {
                        e.setFlag4Up(true);
                    } else {
                        e.setFlag4Up(false);
                        e.setGainedUpHeight(0);
                    }
                }
                try {
                    bk.jump(mineImageView, e, e.getyChange(), e.getFlag4Up(), e.isLiving());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        timer1.scheduleAtFixedRate(timerTask1, 300, 150);
    }


    public void jumpWait()  {
        try{
            timer1.wait();
        }catch (Exception e){}

    }

    public void notifyJump(){
        timer1.notify();
    }


    public void terminateJump(){
        timer1.cancel();
        timer1.purge();
    }


    public void setyChange(int value){
        yChange = value;
    }

    public void setMaxHeight(int value){
        maxHeight = value;
    }

    public ImageView getImageView(){
        return mineImageView;
    }

    public boolean isCollided(){
        return collided;
    }

    public void setCollided(boolean flag){
        collided = flag;
    }


    public void slide(int amount){
        //CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX()+90, mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("greenOrc"), createEntity.getWidthOfEntity("greenOrc"));
        mineImageView.setLayoutX(mineImageView.getLayoutX()+amount);
    }


    public void  endTimer(){
        timer1.cancel();
    }

    public void setGainedUpHeight(int value){
        gainedUpHeight = value;
    }

    public int getGainedUpHeight(){
        return gainedUpHeight;
    }

    public void setFlag4Up(boolean val){;
        flag4Up = val;
    }

    public boolean getFlag4Up(){
        return flag4Up;
    }

    public int getMaxHeight(){
        return maxHeight;
    }

    public int getyChange(){
        return yChange;
    }

    public void burnt(){

    }

    public void changeStatusOfLiving(boolean val){
        living = val;
    }
    public boolean isLiving(){
        return living;
    }

    public void store(){
         x = mineImageView.getLayoutX();
         y = mineImageView.getLayoutY();
         height = mineImageView.getFitHeight();
         width = mineImageView.getFitWidth();
    }


    public void revive(AnchorPane anchorPane) throws InterruptedException {
        if(living){
            mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
            anchorPane.getChildren().add(mineImageView);
            this.jump();
        }
    }

    public void die(){
        living = false;
        double yCoordinate  = mineImageView.getBoundsInParent().getMinY();
        double xCoordinate = mineImageView.getBoundsInParent().getMinX();
        imageName = "enemyBlood";
        CommonAnimations.replaceImageView("enemyBlood", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, xCoordinate, yCoordinate-60, createEntity.getHeightOfEntity("enemyBlood"), createEntity.getWidthOfEntity("enemyBlood"));
        this.fade();
        this.terminateJump();
    }

    public void fade() {
        FadeTransition fadeTransition4 = new FadeTransition();
        fadeTransition4.setNode(mineImageView);
        if(imageName.equals("boss")){
            fadeTransition4.setDuration(Duration.millis(800));
        }else{
            fadeTransition4.setDuration(Duration.millis(500));
        }
        fadeTransition4.setToValue(0);
        fadeTransition4.play();
    }
}