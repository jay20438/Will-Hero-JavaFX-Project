package com.example.javafx2;

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

public class SettingsPageView implements Initializable
{
    private TranslateTransition translate;
    private double x;
    private double y;
    private String[] namesOfScenes = {"homepage", "playerInitiatedTnt", "playerKilledInTntBlast"};
    private Scene[] scenes;
    private Scene scene;
    private Parent root;
    private Scene scene2;
    private Scene scene3;


    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private ImageView player;
    FxmlLoader obj1 = new FxmlLoader();

    public void goToHomePage(MouseEvent mouseEvent) {
        scene2 = obj1.getPage("hello-view");
        if(scene2==null){
            System.out.println("it is null");
        }
        HelloApplication.setDifferentScene(scene2);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        translate.setNode(player);
        translate.setDuration(Duration.millis(10000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(-50);
        translate.setAutoReverse(true);
        translate.play();
    }

    FxmlLoader obj2 = new FxmlLoader();
    public void goToSettings(MouseEvent mouseEvent) {
        scene3 = obj2.getPage("SettingsPageView");
        if(scene3==null){
            System.out.println("it is null");
        }
        HelloApplication.setDifferentScene(scene3);
    }
}
