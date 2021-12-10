package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Homepage {
    private FxmlLoader fxmlLoader;

    public  Homepage() {
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

}
