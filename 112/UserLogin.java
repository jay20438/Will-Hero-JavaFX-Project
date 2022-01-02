package com.example.willherojavafxproject;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserLogin implements Initializable {

    private FxmlLoader fxmlLoader;
    private transient TranslateTransition t1;
    private transient TranslateTransition t2;

    public  UserLogin() {
        t1 = new TranslateTransition();
        t2 = new TranslateTransition();
        fxmlLoader = new FxmlLoader();
    }

    @FXML
    private  transient ImageView lock;


    @FXML
    private  transient AnchorPane myPane;


    @FXML
    private transient TextField prompt;

    @FXML
    private transient TextField textFieldForUsername;

    @FXML
    void verifyAndAllow(MouseEvent event) throws IOException {
        String userName = textFieldForUsername.getText();
        if(userName.equals("Enter Username")){
            prompt.setVisible(true);
            prompt.setText("No UserName Entered!");
        }else {
//            System.out.println(prompt.getText());
            Player player = new Player(userName);
            Homepage homepage = new Homepage(player);
            HelloApplication.setDifferentScene(fxmlLoader.getScene("homepage", homepage, "Homepage"));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        t1.setNode(lock);
        t1.setDuration(Duration.millis(2000));
        t1.setCycleCount(1);
        t1.setByX(-400);
        t1.play();
        t2.setNode(textFieldForUsername);
        t2.setDuration(Duration.millis(2000));
        t2.setCycleCount(1);
        t2.setByX(670);
        t2.play();
    }
}
