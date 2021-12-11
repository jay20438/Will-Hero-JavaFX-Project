package com.example.willherojavafxproject;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerInitiatedTnt implements Initializable {
    private final TranslateTransition translate = new TranslateTransition();
    double x;
    @FXML
    private ImageView background;

    @FXML
    private ImageView myImage;

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
    void move(MouseEvent event) {
//        myImage.setX(x+=100);
        FxmlLoader obj = new FxmlLoader();
        Scene scene = obj.getScene("playerKilledInTntBlast");
        if(scene==null){
            System.out.println("it is null");
        }
        HelloApplication.setDifferentScene(scene);
    }


}
