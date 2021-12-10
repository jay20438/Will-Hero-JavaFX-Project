package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class UserLogin {

    private FxmlLoader fxmlLoader;

    public  UserLogin(AnchorPane myPane) {
        this.myPane = myPane;
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
        lock.getX();
        myPane.getScene();
        String userName = textFieldForUsername.getText();
        System.out.println(userName);
        if(userName.equals("Enter Username")){
            prompt.setVisible(true);
//            myPane.setLayoutX(-20);
            myPane.setVisible(false);
            prompt.setText("No UserName Entered!");
        }else {
            HelloApplication.setDifferentScene(fxmlLoader.getScene("homepage"));
        }
    }

}
