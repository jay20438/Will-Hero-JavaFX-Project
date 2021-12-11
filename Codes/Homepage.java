package com.example.javafxproject;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Homepage implements Initializable {
    private FxmlLoader fxmlLoader;
    private FadeTransition fadeTransition1;
    private FadeTransition fadeTransition2;
    private FadeTransition fadeTransition3;

    public  Homepage() {
        fadeTransition1 = new FadeTransition();
        fadeTransition2 = new FadeTransition();
        fadeTransition3 = new FadeTransition();
        fxmlLoader = new FxmlLoader();
    }

    @FXML
    private ImageView playButton;

    @FXML
    private ImageView settingsButton;

    @FXML
    private ImageView viewRank;

    @FXML
    void playTheGame(MouseEvent event) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("arena"));
    }

    @FXML
    void showSettings(MouseEvent event) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("settings"));
    }

    @FXML
    void showTheRank(MouseEvent event) {   /// here i am thinking to show the pop up menu rather then the
        HelloApplication.setDifferentScene(fxmlLoader.getScene("ranks"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fadeTransition1.setDuration(Duration.millis(1000));
        fadeTransition1.setToValue(1);
        fadeTransition1.setNode(playButton);
        fadeTransition2.setDuration(Duration.millis(1000));
        fadeTransition2.setToValue(1);
        fadeTransition2.setNode(settingsButton);
        fadeTransition3.setDuration(Duration.millis(1000));
        fadeTransition3.setToValue(1);
        fadeTransition3.setNode(viewRank);
        fadeTransition1.play();
        fadeTransition2.play();
        fadeTransition3.play();
    }
}
