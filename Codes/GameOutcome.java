package com.example.javafx2;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GameOutcome {
    private Scene scene2;
    private blankController bk;

    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private transient Label gameOutcomeLabel;

    @FXML
    private transient TextField myCoins;

    @FXML
    private transient TextField mySteps;


    FxmlLoader obj1 = new FxmlLoader();

    GameOutcome(String status,String nOfSteps,String nOfCoinsAmount)
    {
        gameOutcomeLabel.setText(status);
        mySteps.setText(nOfSteps);
        myCoins.setText(nOfCoinsAmount);
    }

    public void goToHomePage(MouseEvent mouseEvent) {
        scene2 = obj1.getScene("homepage");
        if(scene2==null){
            System.out.println("it is null");
        }
        HelloApplication.setDifferentScene(scene2);
    }
}
