package com.example.javafx2;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private final TranslateTransition translate;
    private final TranslateTransition translate2;
    private final TranslateTransition translate3;
    private final RotateTransition rotate;
    private double x;
    private double y;
    private String[] namesOfScenes = {"homepage", "playerInitiatedTnt", "playerKilledInTntBlast"};
    private Scene[] scenes;
    private Scene scene;
    private Scene scene3;
    private Parent root;
    FxmlLoader obj = new FxmlLoader();

    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private ImageView player;
    @FXML
    private ImageView orc1;
    @FXML
    private ImageView orc2;

    private Stage stage;
    // = new Stage();
    public HelloController() {
        translate = new TranslateTransition();
        translate2 = new TranslateTransition();
        translate3 = new TranslateTransition();
        rotate = new RotateTransition();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        translate.setNode(player);
        translate.setDuration(Duration.millis(1010));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(150);
        translate.play();

        rotate.setNode(player);
        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.play();

        translate2.setNode(orc1);
        translate2.setDuration(Duration.millis(1050));
        translate2.setCycleCount(TranslateTransition.INDEFINITE);
        translate2.setByY(-50);
        translate2.setAutoReverse(true);
        translate2.play();

        translate3.setNode(orc2);
        translate3.setDuration(Duration.millis(1000));
        translate3.setCycleCount(TranslateTransition.INDEFINITE);
        translate3.setByY(-50);
        translate3.setAutoReverse(true);
        translate3.play();
    }

    @FXML
    void move(ActionEvent event) throws IOException {
        //System.out.println("move");
//        System.out.println("hi3");
        //myImage.setX(x+=100);
        scene = obj.getPage("PlayerWithTNT");
        if(scene==null){
            System.out.println("it is null");
        }
        HelloApplication.setDifferentScene(scene);
    }

    FxmlLoader obj2 = new FxmlLoader();

    public void goToSettings(MouseEvent mouseEvent) {
        scene3 = obj2.getPage("SettingsPageView.fxml");
        if(scene3==null){
            System.out.println("it is null");
        }
        HelloApplication.setDifferentScene(scene3);
    }
}