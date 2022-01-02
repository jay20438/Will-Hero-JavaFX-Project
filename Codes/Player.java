package com.example.willherojavafxproject;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Player implements Serializable {
    private transient ImageView mineImageView;
    private int nOfCoins;
    private Knife knife;
    private Missile missile;
    private CreateEntity createEntity;
    private Position bk;
    private transient Timer timer;
    private int gainedUpHeight;
    private boolean flag4Up;
    private Player p;
    private boolean living;
    private String userName;
    private String imageName;
    private double x;
    private double y;
    private double height;
    private double width;
    private transient AnchorPane anchorPane;

    public Player(String name){
        System.out.println("my name:" + name);
        this.userName = name;
    }

//    public Player(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, CreateEntity createEntity, Position bk) throws InterruptedException {
//        living = true;
//        this.createEntity = createEntity;
//        this.bk = bk;
//        gainedUpHeight = 0;
//        knife = null;
//        p = this;
//        flag4Up = false;
//        missile = null;
//        nOfCoins = 0;
//        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
//        anchorPane.getChildren().add(mineImageView);
//        mineImageView.setPreserveRatio(true);
//        this.jump();
//    }



    public void formMyImage(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, CreateEntity createEntity, Position bk) throws InterruptedException {
        living = true;
        this.createEntity = createEntity;
        this.bk = bk;
        gainedUpHeight = 0;
        knife = null;
        p = this;
        flag4Up = false;
        missile = null;
        nOfCoins = 0;
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        anchorPane.getChildren().add(mineImageView);
        mineImageView.setPreserveRatio(true);
        this.anchorPane = anchorPane;
        this.imageName = imageName;
        this.jump();
    }

    public ImageView getMineImageView(){
        return mineImageView;
    }

    public void getCoins(int change){
        nOfCoins += change;
    }

    public void getKnife(Knife knife){
        this.knife = knife;
        CommonAnimations.replaceImageView("playerWithKnife", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("playerWithKnife"), createEntity.getWidthOfEntity("playerWithKnife"));
    }

    public void getMissile(Missile missile){
        this.missile = missile;
        CommonAnimations.replaceImageView("playerWithMissile", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("playerWithMissile"), createEntity.getWidthOfEntity("playerWithMissile"));
    }

    public void die()
    {
        living = false;
        CommonAnimations.replaceImageView("crushedPlayer", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("crushedPlayer"), createEntity.getWidthOfEntity("crushedPlayer"));
    }

    public void terminateJump(){
        timer.cancel();
        timer.purge();
    }

    public void jump() throws InterruptedException {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(!living){
                    p.setFlag4Up(false);
                }else {
                    if (p.getGainedUpHeight() > 0 && p.getGainedUpHeight() < 100) {
                        p.setFlag4Up(true);
                    } else {
                        p.setFlag4Up(false);
                        p.setGainedUpHeight(0);
                    }
                }
                try {
                    bk.jump(mineImageView, p, 10, p.getFlag4Up(), p.isLiving());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 280, 110);
    }

    public boolean  isLiving(){
        return living;
    }

    public void changeStatusOfLiving(boolean val){
        living = val;
    }

    public void setGainedUpHeight(int value){
        gainedUpHeight = value;
    }

    public int getGainedUpHeight(){
        return gainedUpHeight;
    }

    public void setFlag4Up(boolean val){
        flag4Up = val;
    }

    public boolean getFlag4Up(){
        return flag4Up;
    }

    public void burnt(){
        die();
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(mineImageView);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setDuration(Duration.millis(200));
        rotateTransition.setByAngle(180);
        rotateTransition.setCycleCount(1);
        rotateTransition.play();
    }

    public void throwWeapon(){
        if(knife!=null){
            this.throwKnife();
        }else if(missile!=null){
            this.launchMissile();
        }
    }

    public void launchMissile()
    {
        missile.moveWeapon( 30, 120,  Duration.millis(1000)).play();
    }

    public void throwKnife()
    {
        ImageView imv2 = knife.getImageView();
        knife.moveWeapon(30, 120,  Duration.millis(1000)).play();
    }

    public void setCoordinatesAfterCollision(int value){
        mineImageView.setLayoutX(value);
    }

//    public void displaySavedGames(List){
//
//    }

    public String getMyName(){

        return userName;
    }

    public void store(){
        System.out.println("player x while storing:" + mineImageView.getLayoutX()+" y:"+mineImageView.getLayoutY());
         x = mineImageView.getLayoutX();
         y = mineImageView.getLayoutY();
         height = mineImageView.getFitHeight();
         width = mineImageView.getFitWidth();
    }


    public void revive(AnchorPane anchorPane)  {
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        System.out.println("player x after reviving:" + mineImageView.getLayoutX() + " y:"+mineImageView.getLayoutY());
        anchorPane.getChildren().add(mineImageView);
        try {
            this.jump();
        }catch (Exception e){}
    }

}
