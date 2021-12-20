package com.example.willherojavafxproject;
import java.net.URL;
import java.util.*;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class blankController implements Initializable {
    private Random random;
    private HashMap<String, Integer> widthOfIslands;
    private HashMap<String, Integer> heightOfIslands;
    private HashMap<String, Integer> depthOfIslands;
    static TranslateTransition translateTransition;
    private String[] namesOfIslands;
    //private int[] widthOfIslands;
    //private int[] heightOfIslands;
    //private int[] depthOfBaseOfIslands;
    private int nOfClick;


    public blankController(){
        random = new Random();
        widthOfIslands = new HashMap<>();
        heightOfIslands = new HashMap<>();
//        depthOfIslands = new HashMap<>();
//        depthOfBaseIslands
        translateTransition = new TranslateTransition();
        namesOfIslands = new String[]{"4treesIsland", "4treesIsland2", "4treesIsland3", "SideIsland", "LongIsland", "doubleIsland"};
        widthOfIslands.put("4treesIsland", 343);
        widthOfIslands.put("4treesIsland2", 381);
        widthOfIslands.put("4treesIsland3", 316);
        widthOfIslands.put("SideIsland", 426);
        widthOfIslands.put("LongIsland", 403);
        widthOfIslands.put("doubleIsland", 563);
        heightOfIslands.put("4treesIsland", 297);
        heightOfIslands.put("4treesIsland2", 270);
        heightOfIslands.put("4treesIsland3", 288);
        heightOfIslands.put("SideIsland", 260);
        heightOfIslands.put("LongIsland", 168);
        heightOfIslands.put("doubleIsland", 260);
        depthOfIslands.put("4treesIsland", 144);
        depthOfIslands.put("4treesIsland2", 108);
        depthOfIslands.put("4treesIsland3", 108);
        depthOfIslands.put("SideIsland", 122);
        depthOfIslands.put("LongIsland", 57);
        depthOfIslands.put("doubleIsland", 87);
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
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @FXML
    private TextField tf4;

    @FXML
    private TextField tf5;

    @FXML
    private TextField tf6;

    @FXML
    private ImageView tnt;

    private int randNo1;
    private int randNo2;
    private int randNo3;

    @FXML
    void moveContent(MouseEvent event) throws FileNotFoundException {
        nOfClick += 1;
        if(nOfClick>122){
            player.setLayoutX(player.getLayoutX() + 100);
        }else {
            contIsland1.setLayoutX(contIsland1.getLayoutX() - 100);
            contIsland2.setLayoutX(contIsland2.getLayoutX() - 100);
            contIsland3.setLayoutX(contIsland3.getLayoutX() - 100);
            contIsland4.setLayoutX(contIsland4.getLayoutX() - 100);
            contIsland5.setLayoutX(contIsland5.getLayoutX() - 100);
            contIsland6.setLayoutX(contIsland6.getLayoutX() - 100);

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {

                @Override
                public void run() {
                    double playerPos = player.getBoundsInParent().getMinX();
                    if(playerPos>=contIsland1.getBoundsInParent().getMinX() && playerPos<=contIsland1.getBoundsInParent().getMaxX()){
                        System.out.println("1");
                        System.out.println(tf1.getText());
                        System.out.println(depthOfIslands.get(tf1.getText()));
                        makeChangesToTranslate(contIsland1.getBoundsInParent().getMinY(), depthOfIslands.get(tf1.getText()));
                    }else if(playerPos>=contIsland2.getBoundsInParent().getMinX() && playerPos<=contIsland2.getBoundsInParent().getMaxX()){
                        System.out.println("2");
                        makeChangesToTranslate(contIsland2.getBoundsInParent().getMinY(), depthOfIslands.get(tf2.getText()));
                    }else if(playerPos>=contIsland3.getBoundsInParent().getMinX() && playerPos<=contIsland3.getBoundsInParent().getMaxX()){
                        System.out.println("3");
                        makeChangesToTranslate(contIsland3.getBoundsInParent().getMinY(), depthOfIslands.get(tf3.getText()));
                    }else if(playerPos>=contIsland4.getBoundsInParent().getMinX() && playerPos<=contIsland4.getBoundsInParent().getMaxX()){
                        System.out.println("4");
                        makeChangesToTranslate(contIsland4.getBoundsInParent().getMinY(), depthOfIslands.get(tf4.getText()));
                    }else if(playerPos>=contIsland5.getBoundsInParent().getMinX() && playerPos<=contIsland5.getBoundsInParent().getMaxX()){
                        System.out.println("5");
                        makeChangesToTranslate(contIsland5.getBoundsInParent().getMinY(), depthOfIslands.get(tf5.getText()));
                    }else if(playerPos>=contIsland6.getBoundsInParent().getMinX() && playerPos<=contIsland6.getBoundsInParent().getMaxX()){
                        System.out.println("6");
                        makeChangesToTranslate(contIsland6.getBoundsInParent().getMinY(), depthOfIslands.get(tf6.getText()));
                    }
                }
            };
            timer.scheduleAtFixedRate(task, 12, 10);

            if ((int) (contIsland3.getLayoutX() + island3.getFitWidth()) < 20) {
                createIsland(1, island1, island2, island3);
            }
            if ((int) (contIsland6.getLayoutX() + island6.getFitWidth()) < 20) {
                createIsland(4, island4, island5, island6);
            }
        }
    }

    public void createIsland(int identifier, ImageView imageView1, ImageView imageView2, ImageView imageView3) throws FileNotFoundException {
        randNo1 = random.nextInt(0, 6);
        randNo2 = random.nextInt(0, 6);
        randNo3 = random.nextInt(0, 6);
        Image image1 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[randNo1] +".png"));
        Image image2 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[randNo2] +".png"));
        Image image3 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[randNo3] +".png"));
//        System.out.println(image1.toString());
        imageView1.setImage(image1);
        imageView2.setImage(image2);
        imageView3.setImage(image3);
        imageView1.setFitWidth(widthOfIslands.get(namesOfIslands[randNo1]));
        imageView2.setFitWidth(widthOfIslands.get(namesOfIslands[randNo2]));
        imageView3.setFitWidth(widthOfIslands.get(namesOfIslands[randNo3]));
        imageView1.setFitHeight(heightOfIslands.get(namesOfIslands[randNo1]));
        imageView2.setFitHeight(heightOfIslands.get(namesOfIslands[randNo2]));
        imageView3.setFitHeight(heightOfIslands.get(namesOfIslands[randNo3]));
        if(identifier==1){
            tf1.setText(namesOfIslands[randNo1]);
            contIsland1.setLayoutX(contIsland6.getBoundsInParent().getMaxX() + 250);
            tf2.setText(namesOfIslands[randNo2]);
            contIsland2.setLayoutX(contIsland1.getBoundsInParent().getMaxX() + 300);
            tf3.setText(namesOfIslands[randNo3]);
            contIsland3.setLayoutX(contIsland2.getBoundsInParent().getMaxX() + 250);
        }else{
            tf4.setText(namesOfIslands[randNo1]);
            contIsland4.setLayoutX(contIsland3.getBoundsInParent().getMaxX()  + 250);
            tf5.setText(namesOfIslands[randNo2]);
            contIsland5.setLayoutX(contIsland4.getBoundsInParent().getMaxX() + 200);
            tf6.setText(namesOfIslands[randNo3]);
            contIsland6.setLayoutX(contIsland5.getBoundsInParent().getMaxX() + 250);
        }
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

    public void makeChangesToTranslate(double start, int depth){
        translateTransition.setFromY(start + depth);
        translateTransition.setToY(start + depth - 90);
    }

}


