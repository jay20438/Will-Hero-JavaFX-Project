package com.example.javafxproject;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private final TranslateTransition translate;
    private double x;
    private double y;
    private String[] namesOfScenes = {"homepage", "playerInitiatedTnt", "playerKilledInTntBlast"};
    private Scene[] scenes;
    private Scene scene;
    private Parent root;
    FxmlLoader obj = new FxmlLoader();

    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private ImageView myImage;
    private Stage stage;
// = new Stage();
    public HelloController() {
        translate = new TranslateTransition();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        translate.setNode(myImage);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(-50);
        translate.setAutoReverse(true);
        translate.play();
    }

    @FXML
    void move(ActionEvent event) throws IOException {
        //System.out.println("move");
//        System.out.println("hi3");
        //myImage.setX(x+=100);
        scene = obj.getPage("playerKilledInTntBlast");
        if(scene==null){
            System.out.println("it is null");
        }
        HelloApplication.setDifferentScene(scene);
    }
}
