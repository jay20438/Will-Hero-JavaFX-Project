package com.example.willherojavafxproject;
import java.net.URL;
import java.util.*;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class earlierController2 implements Initializable {
    private Random random;
    static TranslateTransition translateTransition;
    private String[] namesOfIslands;
    private int[] widthOfIslands;
    private int[] heightOfIslands;
    private int[] depthOfBaseOfIslands;
    private int nOfClick;


    public earlierController2(){
        translateTransition = new TranslateTransition();
        widthOfIslands = new int[]{316, 381, 426, 563, 343, 403};
        heightOfIslands = new int[]{288, 270, 260, 260, 297, 168};
        depthOfBaseOfIslands = new int[]{108, 108, 122, 87, 144, 57};
        nOfClick = 0;
    }


    @FXML
    private ImageView background;

    @FXML
    private ImageView island1;

    @FXML
    private ImageView island2;

    @FXML
    private ImageView island3;

    @FXML
    private ImageView island4;

    @FXML
    private ImageView island5;

    @FXML
    private ImageView island6;

    @FXML
    private ImageView player;

    @FXML
    private Group contIsland2;

    @FXML
    private Group contIsland1;

    @FXML
    private Group contIsland3;

    @FXML
    private Group contIsland4;

    @FXML
    private Group contIsland5;

    @FXML
    private Group contIsland6;

    @FXML
    private Group contPlayer;

    @FXML
    private ImageView tnt;


    @FXML
    void moveContent(MouseEvent event) throws FileNotFoundException {
        nOfClick += 1;
//        System.out.println("s-------------");
//        System.out.println("xcoordinate1:" + contIsland1.getLayoutX() + " width:" + contIsland1.getBoundsInParent().getWidth());
//        System.out.println("xcoordinate2:" + contIsland2.getLayoutX() + " width:" + contIsland2.getBoundsInParent().getWidth());
//        System.out.println("xcoordinate3:" + contIsland3.getLayoutX() + " width:" + contIsland3.getBoundsInParent().getWidth());
//        System.out.println("xcoordinate4:" + contIsland4.getLayoutX());
//        System.out.println("xcoordinate5:" + contIsland5.getLayoutX());
//        System.out.println("xcoordinate6:" + contIsland6.getLayoutX());
//        System.out.println("e------------");
        if(nOfClick >= 122){
            contPlayer.setLayoutX(contPlayer.getLayoutX() + 100);
        }else {
            contIsland1.setLayoutX(contIsland1.getLayoutX() - 100);
            contIsland2.setLayoutX(contIsland2.getLayoutX() - 100);
            contIsland3.setLayoutX(contIsland3.getLayoutX() - 100);
            contIsland4.setLayoutX(contIsland4.getLayoutX() - 100);
            contIsland5.setLayoutX(contIsland5.getLayoutX() - 100);
            contIsland6.setLayoutX(contIsland6.getLayoutX() - 100);
            if ((int) (contIsland3.getLayoutX() + contIsland3.getBoundsInParent().getWidth()) < 20) {
                createIsland(1);
            }
            if ((int) (contIsland6.getLayoutX() + contIsland6.getBoundsInParent().getWidth()) < 20) {
                createIsland(4);
            }
            checkCollision();
        }
    }

    public void createIsland(int identifier) throws FileNotFoundException {
        if(identifier==1){
            contIsland1.setLayoutX(contIsland6.getLayoutX()+ contIsland6.getBoundsInParent().getWidth() + 250);
            contIsland2.setLayoutX(contIsland1.getLayoutX()+ contIsland1.getBoundsInParent().getWidth() + 250);
            contIsland3.setLayoutX(contIsland2.getLayoutX()+ contIsland2.getBoundsInParent().getWidth() + 250);
        }else{
            contIsland4.setLayoutX(contIsland3.getLayoutX()+ contIsland3.getBoundsInParent().getWidth()  + 250);
            contIsland5.setLayoutX(contIsland4.getLayoutX()+ contIsland4.getBoundsInParent().getWidth() + 250);
            contIsland6.setLayoutX(contIsland5.getLayoutX() + contIsland5.getBoundsInParent().getWidth() + 250);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        translateTransition.setNode(contPlayer);
        translateTransition.setDuration(Duration.millis(700));
        translateTransition.setCycleCount(Animation.INDEFINITE);
        translateTransition.setByY(-90);
        translateTransition.setAutoReverse(true);
        translateTransition.play();

    }



    public void checkCollision(){
//        if(player.getLayoutX()>= tnt.getLayoutX() && player.getLayoutY()<= tnt.getLayoutY()){
//            Image image1 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ "tntInitiated.png"));
//            tnt.setImage(image1);
//            startTimer();
//        }
    }

    public void startTimer(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Image image1 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ "tntFire.png"));
                tnt.setImage(image1);
                tnt.setFitWidth(300);
                tnt.setFitHeight(100);

                if(player.getLayoutX()>= tnt.getLayoutX() && (player.getLayoutX()+ player.getFitWidth())<tnt.getLayoutX() && (player.getLayoutY()+ player.getFitHeight())< tnt.getLayoutY()){
                    image1 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ "playerBurnt.png"));
                    player.setImage(image1);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 2000, 10);
    }
}


