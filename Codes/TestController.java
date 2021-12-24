package com.example.willherojavafxproject;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class TestController implements Initializable {
    private String[] namesOfIslands = new String[]{"4treesIsland", "4treesIsland2", "4treesIsland3", "SideIsland", "LongIsland", "doubleIsland"};


    @FXML
    private ImageView bg;

    @FXML
    private Group contPlayer;

    @FXML
    private Group gp;

    @FXML
    private Group gp2;

    @FXML
    private ImageView island;

    @FXML
    private ImageView island2;

    @FXML
    private ImageView player;

    Random random = new Random();
    int randNo3;

    @FXML
    void move(MouseEvent event) {
        contPlayer.setLayoutX(contPlayer.getBoundsInParent().getMinX()+50);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            detect();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void detect() throws InterruptedException {
        Timer timer1 = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                double currY = contPlayer.getBoundsInParent().getMinY();
                currY += 10;
                if(contPlayer.getBoundsInParent().getMaxY()>gp2.getBoundsInParent().getMaxY()){
                    for (int i = 0; i < 10; i++) {
                        contPlayer.setLayoutY(contPlayer.getBoundsInParent().getMinY()-10);
                    }

                }else{
                    contPlayer.setLayoutY(currY);
                }
            }
        };
        timer1.scheduleAtFixedRate(task1, 0, 100);

    }
}