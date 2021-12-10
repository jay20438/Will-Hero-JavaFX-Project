package com.example.javafx2;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerWithOpenChest implements Initializable {
    private final TranslateTransition translate4;
    private final TranslateTransition translate5;
    private final TranslateTransition translate6;
    private final TranslateTransition translate7;
    private double x;
    private double y;
    private String[] namesOfScenes = {"homepage", "playerInitiatedTnt", "playerKilledInTntBlast"};
    private Scene[] scenes;
    private Scene scene;
    private Scene scene3;
    private Parent root;
    FxmlLoader obj = new FxmlLoader();

    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private ImageView player;
    @FXML
    private ImageView orc1;
    @FXML
    private ImageView orc2;

    @FXML
    private ImageView orc3;

    private Stage stage;
    // = new Stage();
    public PlayerWithOpenChest() {
        translate4 = new TranslateTransition();
        translate5 = new TranslateTransition();
        translate6 = new TranslateTransition();
        translate7 = new TranslateTransition();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        translate4.setNode(player);
        translate4.setDuration(Duration.millis(1010));
        translate4.setCycleCount(TranslateTransition.INDEFINITE);
        translate4.setByY(-50);
        translate4.play();


        translate5.setNode(orc1);
        translate5.setDuration(Duration.millis(1050));
        translate5.setCycleCount(TranslateTransition.INDEFINITE);
        translate5.setByY(-50);
        translate5.setAutoReverse(true);
        translate5.play();

        translate6.setNode(orc2);
        translate6.setDuration(Duration.millis(1000));
        translate6.setCycleCount(TranslateTransition.INDEFINITE);
        translate6.setByY(-50);
        translate6.setAutoReverse(true);
        translate6.play();

        translate7.setNode(orc3);
        translate7.setDuration(Duration.millis(1000));
        translate7.setCycleCount(TranslateTransition.INDEFINITE);
        translate7.setByY(-50);
        translate7.setAutoReverse(true);
        translate7.play();
    }

    @FXML
    void move(ActionEvent event) throws IOException {
        //System.out.println("move");
//        System.out.println("hi3");
        //myImage.setX(x+=100);
        scene = obj.getPage("PlayerWithTNT");
        if(scene==null){
            System.out.println("it is null");
        }
        HelloApplication.setDifferentScene(scene);
    }

    FxmlLoader obj5 = new FxmlLoader();

    public void goToSettings(MouseEvent mouseEvent) {
        scene3 = obj5.getPage("SettingsPageView.fxml");
        if(scene3==null){
            System.out.println("it is null");
        }
        HelloApplication.setDifferentScene(scene3);
    }
}