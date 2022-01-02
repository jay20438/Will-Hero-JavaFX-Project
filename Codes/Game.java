package com.example.willherojavafxproject;

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

    public Game(Player player, Homepage homepage){
        loadedGame = false;
        this.homepage = homepage;
        System.out.println("in game constructor");
        this.player = player;
        System.out.println(player.getMyName());
        position = new Position(player, homepage);
        fmt = new SimpleDateFormat("E d MMM y, H:mm:ss z");
        fxmlLoader = new FxmlLoader();
    }

    public void playGame(){
        dNow = new Date();
        playedOn = fmt.format(dNow);
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
    }

    public boolean getLoadedGame(){
        return loadedGame;
    }

}
