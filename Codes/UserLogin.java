package com.example.javafxproject;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class UserLogin implements Initializable {

    private FxmlLoader fxmlLoader;
    private TranslateTransition t1;
    private TranslateTransition t2;

    public  UserLogin() {
        t1 = new TranslateTransition();
        t2 = new TranslateTransition();
        fxmlLoader = new FxmlLoader();
    }

    @FXML
    private ImageView lock;


    @FXML
    private AnchorPane myPane;


    @FXML
    private TextField prompt;

    @FXML
    private TextField textFieldForUsername;

    @FXML
    void verifyAndAllow(MouseEvent event) {
        String userName = textFieldForUsername.getText();
        System.out.println(userName);
        if(userName.equals("Enter Username")){
            prompt.setVisible(true);
            prompt.setText("No UserName Entered!");
        }else {
            HelloApplication.setDifferentScene(fxmlLoader.getScene("homepage"));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        t1.setNode(lock);
        t1.setDuration(Duration.millis(1000));
        t1.setCycleCount(1);
        t1.setByX(-400);
        t1.play();
        t2.setNode(textFieldForUsername);
        t2.setDuration(Duration.millis(1000));
        t2.setCycleCount(1);
        t2.setByX(670);
        t2.play();
    }
}
