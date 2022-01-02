package com.example.willherojavafxproject;

import javafx.scene.input.MouseEvent;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Game implements Serializable {
    private Player player;
    private boolean loadedGame;
    private  FxmlLoader fxmlLoader;
    private Date dNow;
    private SimpleDateFormat fmt;
    private String playedOn;
    private Position position;
    private Homepage homepage;
    private boolean resumedGame;
    private boolean pausedGame;

    public Game(Player player, Homepage homepage){
        resumedGame = false;
        pausedGame = false;
        loadedGame = false;
        this.homepage = homepage;
        this.player = player;
        position = new Position(player, homepage);
        fmt = new SimpleDateFormat("E d MMM y, H:mm:ss z");
        fxmlLoader = new FxmlLoader();
    }

    public void playGame(){
        if(!resumedGame) {
            dNow = new Date();
            playedOn = fmt.format(dNow);
        }
        HelloApplication.setDifferentScene(fxmlLoader.getScene("blank", position, "Position"));
    }

    public void askPositionToStoreCoordinates(){
        position.storeCoordinates();
    }

    public void askPositionToReviveEverything(){
        //position.reviveEverything();
    }

    public void loadGame(){

    }

    public String getDateOfGamePlayed(){
        return playedOn;
    }

    public Player getPlayer(){
        return player;
    }

    public void setLoadedGame(boolean value){
        loadedGame = value;
        this.setPausedGame(false);
        this.setResumedGame(false);
    }

    public boolean getLoadedGame(){
        return loadedGame;
    }

    public void pauseGame(MouseEvent e) throws InterruptedException {
        pausedGame = true;
        askPositionToStoreCoordinates();
        position.makeAllTimerCancel();
        homepage.goToSettings(e);
    }

    public void resumeGame(){
        resumedGame = true;
        playGame();
//        position.startAllTimers();
//        HelloApplication.setDifferentScene(fxmlLoader.getScene("blank", position, "Position"));
    }

    public boolean getResumedGame(){
        return resumedGame;
    }

    public void setResumedGame(boolean value){
        resumedGame = value;
    }

    public void setPausedGame(boolean value){
        pausedGame = value;
    }

    public boolean getPausedGame(){
        return pausedGame;
    }

}
