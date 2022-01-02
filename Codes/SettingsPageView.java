package com.example.willherojavafxproject;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.io.Serializable;


public class SettingsPageView implements Serializable
{

    private Homepage homepage;

    public SettingsPageView(Homepage homepage){
        this.homepage = homepage;
    }

    @FXML
    private transient AnchorPane myAnchorPane;


    @FXML
    private transient ImageView save;

    @FXML
    private transient ImageView resumeButton;

    @FXML
    private transient ImageView restartButton;


    @FXML
    void resumeGame(MouseEvent event) {
        if (homepage.getGame().getPausedGame()){
            homepage.getGame().resumeGame();
        }

    }

    @FXML
    void restartGame(MouseEvent event) {
        if(homepage.getGame().getPausedGame()){
            homepage.playTheGame(event);
        }

    }


    @FXML
    void saveGame(MouseEvent event) throws IOException, ClassNotFoundException {
        if(homepage.getGame().getPausedGame()){
            homepage.save();
        }

    }


    FxmlLoader fxmlLoader = new FxmlLoader();

    public void goToHomePage(MouseEvent mouseEvent) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("homepage", homepage, "Homepage"));
    }


}