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
    private ImageView resumeButton;




    @FXML
    void resumeGame(MouseEvent event) {
        homepage.getGame().resumeGame();
    }


    @FXML
    void saveGame(MouseEvent event) throws IOException, ClassNotFoundException {
        homepage.save();
    }


    FxmlLoader fxmlLoader = new FxmlLoader();

    public void goToHomePage(MouseEvent mouseEvent) {
        System.out.println("present in goToHomePage in SettingsPageView");
        HelloApplication.setDifferentScene(fxmlLoader.getScene("homepage", homepage, "Homepage"));
    }


}