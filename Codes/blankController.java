package com.example.willherojavafxproject;
import java.net.URL;
import java.util.Random;
import java.util.Timer;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ResourceBundle;

public class blankController implements Initializable {
    private Random random;
    static TranslateTransition translateTransition;
    private String[] namesOfIslands;


    public blankController(){
        random = new Random();
        translateTransition = new TranslateTransition();
        namesOfIslands = new String[]{"4treesIsland", "4treesIsland2", "4treesIsland3", "SideIsland"};
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
    void moveContent(MouseEvent event) throws FileNotFoundException {
        island1.setLayoutX(island1.getLayoutX()-70);
        island2.setLayoutX(island2.getLayoutX()-70);
        island3.setLayoutX(island3.getLayoutX()-70);
        island4.setLayoutX(island4.getLayoutX()-70);
        island5.setLayoutX(island5.getLayoutX()-70);
        island6.setLayoutX(island6.getLayoutX()-70);
        double temp =  player.getLayoutY() + player.getFitHeight();
        double temp2 = -1.0;
        if (temp==island1.getLayoutY()){
            temp2 = island1.getLayoutY();
        }
        if (temp==island2.getLayoutY()){
            temp2 = island2.getLayoutY();
        }
        if (temp==island3.getLayoutY()){
            temp2 = island3.getLayoutY();
        }
        if (temp==island4.getLayoutY()){
            temp2 = island4.getLayoutY();
        }
        if (temp==island5.getLayoutY()){
            temp2 = island5.getLayoutY();
        }
        if (temp==island6.getLayoutY()){
            temp2 = island6.getLayoutY();
        }
        if(temp2!=-1.0){
            translateTransition.setFromY(temp2);
            translateTransition.setToY(temp2-90.0);
        }
        if((int)(island3.getLayoutX() + island3.getFitWidth()) < 20){
            createIsland(island1, island2, island3);
        }
        if((int)(island6.getLayoutX() + island6.getFitWidth()) < 20){
            createIsland(island4, island5, island6);
        }
    }

    public void createIsland(ImageView imageView1, ImageView imageView2, ImageView imageView3) throws FileNotFoundException {
        Image image1 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[random.nextInt(0, 4)] +".png"));
        Image image2 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[random.nextInt(0, 4)] +".png"));
        Image image3 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[random.nextInt(0, 4)] +".png"));
        imageView1.setImage(image1);
        imageView2.setImage(image2);
        imageView3.setImage(image3);
        imageView1.setLayoutX(imageView1.getLayoutX()+2134);
        imageView2.setLayoutX(imageView2.getLayoutX()+2134);
        imageView3.setLayoutX(imageView3.getLayoutX()+2134);
        image1 = null;
        image2 = null;
        image3 = null;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        translateTransition.setNode(player);
        translateTransition.setDuration(Duration.millis(700));
        translateTransition.setCycleCount(Animation.INDEFINITE);
        translateTransition.setByY(-90);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }

    public ImageView getPlayerM(){
        return player;
    }

    public ImageView getIsland1(){
        return island1;
    }
    public ImageView getIsland2(){
        return island2;
    }
    public ImageView getIsland3(){
        return island3;
    }
    public ImageView getIsland4(){
        return island4;

    }
    public ImageView getIsland5(){
        return island5;
    }
    public ImageView getIsland6(){
        return island6;
    }


}


