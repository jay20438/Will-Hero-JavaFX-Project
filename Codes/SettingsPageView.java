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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SettingsPageView
{
    private Scene scene2;
    private static Scene scene4;

    @FXML
    private AnchorPane myAnchorPane;

//    @FXML
//    private ImageView player;
    FxmlLoader fxmlLoader = new FxmlLoader();

    public void goToHomePage(MouseEvent mouseEvent) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("homepage"));
    }


}