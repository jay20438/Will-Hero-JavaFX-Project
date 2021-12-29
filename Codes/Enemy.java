package com.example.willherojavafxproject;

import javafx.scene.Group;
import javafx.scene.image.Image;
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

    public Enemy(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, blankController bk) throws InterruptedException {
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
        this.jump();
    }


    public void killPlayer(Player player){
        player.die();
    }

    public void jump() throws InterruptedException {
        //CommonAnimations.makeYTranslationalObj(imageView, (int)imageView.getLayoutY(), (int)imageView.getLayoutY()-70, true, Duration.millis(1000)).play();
        timer1 = new Timer();
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                if(!living){
                    e.setFlag4Up(false);
                }else {
                    if (e.getGainedUpHeight() > 0 && e.getGainedUpHeight() < 100) {
                        e.setFlag4Up(true);
                    } else {
                        e.setFlag4Up(false);
                        e.setGainedUpHeight(0);
                    }
                }
                try {
                    bk.jump(imageView, e, 10, e.getFlag4Up(), e.isLiving());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        timer1.scheduleAtFixedRate(timerTask1, 500, 150);
    }

    public void terminateJump(){
        timer1.cancel();
        timer1.purge();
    }

    public void die(){
       // CommonAnimations.replaceImageView("enemyBlood", imageView);
    }

    public void slide(double change){

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


    public void slide(){
        //CommonAnimations.setCoordinates(imageView, imageView.getBoundsInParent().getMinX()+90, imageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("greenOrc"), createEntity.getWidthOfEntity("greenOrc"));
        imageView.setLayoutX(imageView.getLayoutX()+200);
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

    public void burnt(){

    }

    public void changeStatusOfLiving(boolean val){
        living = val;
    }
    public boolean isLiving(){
        return living;
    }
}