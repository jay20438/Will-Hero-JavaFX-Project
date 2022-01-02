package com.example.willherojavafxproject;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class GameOutcome implements Initializable, Serializable {

    @FXML
    private transient Label gameOutcomeLabel;

    @FXML
    private transient ImageView homeButton;

    @FXML
    private transient TextField myCoins;

    @FXML
    private transient TextField mySteps;

    private Homepage homepage;

    private String status;

    private String nOfCoinsAmount;

    private String nOfSteps;
    private FxmlLoader fxmlLoader;

    @FXML
    void goToHomePage(MouseEvent event) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("homepage", homepage, "Homepage"));
    }


    public GameOutcome(String status,String nOfSteps,String nOfCoinsAmount, Homepage homepage){
        this.homepage = homepage;
                fxmlLoader = new FxmlLoader();
        this.status = status;
        this.nOfSteps = nOfSteps;
        this.nOfCoinsAmount = nOfCoinsAmount;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameOutcomeLabel.setText(status);
        mySteps.setText(nOfSteps);
        myCoins.setText(nOfCoinsAmount);
    }
}

