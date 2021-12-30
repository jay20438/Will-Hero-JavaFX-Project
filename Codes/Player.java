package com.example.javafx2;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Player {
    private ImageView mineImageView;
    private int nOfCoins;
    private Knife knife;
    private Missile missile;
    private CreateEntity createEntity;
    private blankController bk;
    private Timer timer;
    private int gainedUpHeight;
    private boolean flag4Up;
    private Player p;
    private boolean living;

    public Player(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, CreateEntity createEntity, blankController bk) throws InterruptedException {
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
                //ystem.out.println("gained heoght:" + p.getGainedUpHeight());
                try {
                    bk.jump(mineImageView, p, 10, p.getFlag4Up(), p.isLiving());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 280, 100);
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
        double xPosition = mineImageView.getBoundsInParent().getMaxX();
        double temp = xPosition+40;
        double yPosition = mineImageView.getBoundsInParent().getMaxY();
        missile.moveWeapon( xPosition, xPosition + 40,yPosition,  1000).play();
        if(temp == xPosition)
        {
            missile.fade();
        }
    }

    public void throwKnife()
    {
        double xPosition = mineImageView.getBoundsInParent().getMaxX();
        double temp = xPosition+40;
        double yPosition = mineImageView.getBoundsInParent().getMaxY();
        knife.moveWeapon(xPosition, temp,yPosition,  1000).play();

        if(temp == xPosition)
        {
            knife.fade();
        }
    }

}