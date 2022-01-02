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
    private Knife knifeStandard;
    private Missile missileStandard;
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
    private boolean gameStatusWin;

    public Player(String name){
        this.userName = name;
        gameStatusWin = false;
    }




    public void formMyImage(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, CreateEntity createEntity, Position bk) throws InterruptedException {
        living = true;
        this.createEntity = createEntity;
        this.bk = bk;
        gainedUpHeight = 0;
        knifeStandard = null;
        p = this;
        flag4Up = false;
        missileStandard = null;
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

    public void getKnife(Knife knifeStandard){
        this.knifeStandard = knifeStandard;
        imageName = "playerWithKnife";
        CommonAnimations.replaceImageView("playerWithKnife", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("playerWithKnife"), createEntity.getWidthOfEntity("playerWithKnife"));
    }

    public void getMissile(Missile missileStandard){
        this.missileStandard = missileStandard;
        imageName = "playerWithMissile";
        CommonAnimations.replaceImageView("playerWithMissile", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("playerWithMissile"), createEntity.getWidthOfEntity("playerWithMissile"));
    }

    public void die()
    {
        living = false;
        imageName = "crushedPlayer";
        CommonAnimations.replaceImageView("crushedPlayer", mineImageView);
        CommonAnimations.setCoordinates(mineImageView, mineImageView.getBoundsInParent().getMinX(), mineImageView.getBoundsInParent().getMinY(), createEntity.getHeightOfEntity("crushedPlayer"), createEntity.getWidthOfEntity("crushedPlayer"));
    }

    public void jumpWait()  {
        try{
            timer.wait();
        }catch (Exception e){}

    }

    public void notifyJump(){
        timer.notify();
    }

    public void terminateJump(){
        timer.cancel();
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

    public void changeGameStatusWin(boolean value){
        gameStatusWin = value;
    }

    public boolean getGameStatusWin(){return gameStatusWin;}

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

    public void setCoordinatesAfterCollision(int value){
        mineImageView.setLayoutX(value);
    }

    public String getMyName(){

        return userName;
    }

    public void store(){
         x = mineImageView.getLayoutX();
         y = mineImageView.getLayoutY();
         height = mineImageView.getFitHeight();
         width = mineImageView.getFitWidth();
    }


    public void revive(AnchorPane anchorPane)  {
        mineImageView = CommonAnimations.makeImageAndSetCoord(imageName, x, y, height, width);
        this.anchorPane = anchorPane;
        anchorPane.getChildren().add(mineImageView);
        try {
            this.jump();
        }catch (Exception e){}
    }


    public void throwWeapon(){
        if(knifeStandard!=null){
            this.throwKnife();
        }
        else if(missileStandard!=null){
            this.launchMissile();
        }
    }

    public void launchMissile()
    {
        Missile missile = new Missile(anchorPane);
        ImageView imageView = missile.formImageView(mineImageView.getBoundsInParent().getMaxX()-80, mineImageView.getBoundsInParent().getMaxX()+200,mineImageView.getBoundsInParent().getMaxY()-mineImageView.getFitHeight(),  1000);
        missile.moveWeapon(mineImageView.getBoundsInParent().getMaxX()-80, imageView,mineImageView.getBoundsInParent().getMaxY()-mineImageView.getFitHeight(),  1000);
        startCheckingCollision(imageView);
    }

    public void throwKnife()
    {
        Knife knife = new Knife(anchorPane);
        ImageView imageView = knife.formImageView(mineImageView.getBoundsInParent().getMaxX()-80, mineImageView.getBoundsInParent().getMaxX()+200,mineImageView.getBoundsInParent().getMaxY()-mineImageView.getFitHeight(),  1000);
        knife.moveWeapon( mineImageView.getBoundsInParent().getMaxX()-80, imageView,mineImageView.getBoundsInParent().getMaxY()-mineImageView.getFitHeight(),  1000);
        startCheckingCollision(imageView);
    }

    public void startCheckingCollision(ImageView imageView)
    {

        Timer timer2 = new Timer();
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                try {
                    bk.checkCollisionOfOrcAndWeapon(imageView);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer2.scheduleAtFixedRate(timerTask2, 100, 100);
    }

}
