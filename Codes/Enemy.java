package com.example.javafx2;


import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Enemy {
    private blankController bk;
    private ImageView imageView;
    private AnchorPane anchorPane;
    private boolean collided;
    private CreateEntity createEntity;
    private Timer timer1;
    private int gainedUpHeight;
    private boolean flag4Up;
    private Enemy e;
    private boolean living;
    private int maxHeight;
    private int yChange;



    public Enemy(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, blankController bk, int maxHeight, int yChange) throws InterruptedException {
        this.maxHeight = maxHeight;
        this.yChange = yChange;
        this.bk = bk;
        e = this;
        collided = false;
        flag4Up = false;
        living = true;
        gainedUpHeight = 0;
        this.anchorPane = anchorPane;
        imageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        imageView.setPreserveRatio(true);
        anchorPane.getChildren().add(imageView);
        createEntity = new CreateEntity(null, null);
        System.out.println(imageView.getLayoutY());
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
                    bk.jump(imageView, e, e.getyChange(), e.getFlag4Up(), e.isLiving());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        timer1.scheduleAtFixedRate(timerTask1, 300, 150);
    }





    public void terminateJump(){
        timer1.cancel();
        timer1.purge();
    }

    public void die(){
        double yCoordinate  = imageView.getBoundsInParent().getMinY();
        double xCoordinate = imageView.getBoundsInParent().getMinX();
        CommonAnimations.replaceImageView("enemyBlood", imageView);
        CommonAnimations.setCoordinates(imageView, xCoordinate, yCoordinate-60, createEntity.getHeightOfEntity("enemyBlood"), createEntity.getWidthOfEntity("enemyBlood"));
        e.fade();

    }

    public void fade() {
        FadeTransition fadeTransition4 = new FadeTransition();
        fadeTransition4.setNode(imageView);
        fadeTransition4.setDuration(Duration.millis(5000));
        fadeTransition4.setToValue(0);
        fadeTransition4.play();
    }

    public void setyChange(int value){
        yChange = value;
    }

    public void setMaxHeight(int value){
        maxHeight = value;
    }

    public ImageView getImageView(){
        return imageView;
    }

    public boolean isCollided(){
        return collided;
    }

    public void setCollided(boolean flag){
        collided = flag;
    }


    public void slide(int amount){
        //CommonAnimations.setCoordinates(imageView, imageView.getBoundsInParent().getMinX()+90, imageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("greenOrc"), createEntity.getWidthOfEntity("greenOrc"));
        imageView.setLayoutX(imageView.getLayoutX()+amount);
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
}