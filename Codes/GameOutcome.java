package com.example.willherojavafxproject;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GameOutcome {
    private Scene scene2;

    @FXML
    private transient AnchorPane myAnchorPane;

    @FXML
    private transient Label gameOutcomeLabel;

    @FXML
    private transient TextField myCoins;

    @FXML
    private transient TextField mySteps;

    private Homepage homepage;

    private FxmlLoader fxmlLoader;

    private String status;

    private String nOfCoinsAmount;

    private String nOfSteps;



    GameOutcome(String status,String nOfSteps,String nOfCoinsAmount, Homepage homepage)
    {;
        this.homepage = homepage;
        fxmlLoader = new FxmlLoader();
        this.status = status;
        this.nOfSteps = nOfSteps;
        this.nOfCoinsAmount = nOfCoinsAmount;
        this.displayItems();

    }

    public void goToHomePage(MouseEvent mouseEvent) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("homepage", homepage, "Homepage"));
    }
    public void displayItems(){
        gameOutcomeLabel.setText(status);
        mySteps.setText(nOfSteps);
        myCoins.setText(nOfCoinsAmount);
    }

}
