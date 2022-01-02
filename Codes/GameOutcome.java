package com.example.willherojavafxproject;

//import javafx.fxml.FXML;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//
//public class GameOutcome {
//    private Scene scene2;
//
//
//    @FXML
//    private transient AnchorPane myAnchorPane;
//
////    @FXML
//    private transient Label gameOutcomeLabel;
//
////    @FXML
//    private transient TextField myCoins;
//
////    @FXML
//    private transient TextField mySteps;
//
//    private Homepage homepage;
//
//    private FxmlLoader fxmlLoader;
//
//    private String status;
//
//    private String nOfCoinsAmount;
//
//    private String nOfSteps;
//
//
//
//    GameOutcome(String status,String nOfSteps,String nOfCoinsAmount, Homepage homepage)
//    {
//        gameOutcomeLabel = new Label();
//        myCoins = new TextField();
//        mySteps = new TextField();
//        gameOutcomeLabel.setLayoutX(279);
//        gameOutcomeLabel.setLayoutY(73);
//        gameOutcomeLabel.setPrefHeight(98);
//        gameOutcomeLabel.setPrefWidth(577);
//        myCoins.setLayoutX(541);
//        myCoins.setLayoutY(260);
//        myCoins.setPrefHeight(57);
//        myCoins.setPrefWidth(78);
//        mySteps.setPrefWidth(78);
//        mySteps.setPrefHeight(57);
//        myAnchorPane.getChildren().add(gameOutcomeLabel);
//        myAnchorPane.getChildren().add(myCoins);
//        myAnchorPane.getChildren().add(mySteps);
//        this.homepage = homepage;
//        fxmlLoader = new FxmlLoader();
//        this.status = status;
//        this.nOfSteps = nOfSteps;
//        this.nOfCoinsAmount = nOfCoinsAmount;
//        this.displayItems();
//    }
//
//    public void goToHomePage(MouseEvent mouseEvent) {
//        HelloApplication.setDifferentScene(fxmlLoader.getScene("homepage", homepage, "Homepage"));
//    }
//    public void displayItems(){
//        gameOutcomeLabel.setText(status);
//        mySteps.setText(nOfSteps);
//        myCoins.setText(nOfCoinsAmount);
//    }
//
//
//}


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

