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

public class earlierController1 implements Initializable {
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


    public earlierController1(){
        random = new Random();
        widthOfIslands = new HashMap<>();
        heightOfIslands = new HashMap<>();
        depthOfIslands = new HashMap<>();
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

        //widthOfIslands = new int[]{343, 381, 316, 426, 403, 563};
        //heightOfIslands = new int[]{297, 270, 288, 260, 168, 260};
        //depthOfBaseOfIslands = new int[]{144, 108, 108, 122, 57, 87};
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

    private int randNo1;
    private int randNo2;
    private int randNo3;

    @FXML
    void moveContent(MouseEvent event) throws FileNotFoundException {
        nOfClick += 1;
        System.out.println("s-------------");
        System.out.println("xcoordinate1:" + contIsland1.getLayoutX() + " width:" + contIsland1.getBoundsInParent().getWidth());
        System.out.println("xcoordinate2:" + contIsland2.getLayoutX() + " width:" + contIsland2.getBoundsInParent().getWidth());
        System.out.println("xcoordinate3:" + contIsland3.getLayoutX() + " width:" + contIsland3.getBoundsInParent().getWidth());
        System.out.println("xcoordinate4:" + contIsland4.getLayoutX());
        System.out.println("xcoordinate5:" + contIsland5.getLayoutX());
        System.out.println("xcoordinate6:" + contIsland6.getLayoutX());
        System.out.println("e------------");
        contIsland1.setLayoutX(contIsland1.getLayoutX()-100);
        contIsland2.setLayoutX(contIsland2.getLayoutX()-100);
        contIsland3.setLayoutX(contIsland3.getLayoutX()-100);
        contIsland4.setLayoutX(contIsland4.getLayoutX()-100);
        contIsland5.setLayoutX(contIsland5.getLayoutX()-100);
        contIsland6.setLayoutX(contIsland6.getLayoutX()-100);
        tnt.setLayoutX(tnt.getLayoutX()-100);
        System.out.println(island1.getId());

        if(nOfClick == 1) {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {

                double temp2;
                @Override
                public void run() {
                    temp2 = -1.0;
                    double temp1 = contPlayer.getLayoutX() + player.getFitWidth();
                    if ((island1.getFitWidth()+contIsland1.getLayoutX())>0 && temp1 >= contIsland1.getLayoutX() ) {
                        System.out.println("i1");
                        if(temp1 < (island1.getFitWidth()+contIsland1.getLayoutX())){
                            System.out.println("ii1");
//                            makeChangesToTranslate(depthOfBaseOfIslands.get[0], island1.getLayoutY());
                        }
                    }else if ((island2.getFitWidth()+contIsland2.getLayoutX())>0 && temp1 >= contIsland2.getLayoutX()) {
                        System.out.println("i2");
                        if(temp1 < (island2.getFitWidth()+contIsland2.getLayoutX())){
                            System.out.println("ii2");
                            //makeChangesToTranslate(depthOfBaseOfIslands[1], island2.getLayoutY());
                        }
                    }else if((island3.getFitWidth()+contIsland3.getLayoutX())>0 && temp1 >= contIsland3.getLayoutX()) {
                        System.out.println("i3");
                        if(temp1 < (island3.getFitWidth()+contIsland3.getLayoutX())){
                            System.out.println("ii3");
                            //makeChangesToTranslate(depthOfBaseOfIslands[2], island3.getLayoutY());
                        }
                    }else if((island4.getFitWidth()+contIsland4.getLayoutX())>0 && temp1 >= contIsland4.getLayoutX()) {
                        System.out.println("i4");
                        if(temp1 < (island4.getFitWidth()+contIsland4.getLayoutX())){
                            System.out.println("ii4");
                            //makeChangesToTranslate(depthOfBaseOfIslands[3], island4.getLayoutY());
                        }
                    }else if((island5.getFitWidth()+contIsland5.getLayoutX())>0 && temp1 >= contIsland5.getLayoutX()) {
                        System.out.println("i5");
                        if(temp1 < (island5.getFitWidth()+contIsland5.getLayoutX())){
                            System.out.println("ii5");
                            //makeChangesToTranslate(depthOfBaseOfIslands[4], island5.getLayoutY());
                        }
                    }else if((island6.getFitWidth()+contIsland6.getLayoutX())>0 && temp1 >= contIsland6.getLayoutX()) {
                        System.out.println("i6");
                        if(temp1 < (island6.getFitWidth()+contIsland6.getLayoutX())){
                            System.out.println("ii6");
                            //makeChangesToTranslate(depthOfBaseOfIslands[5], island6.getLayoutY());
                        }
                    }

                }
            };
            timer.scheduleAtFixedRate(task, 12, 10);

        }
        if((int)(contIsland3.getLayoutX() + island3.getFitWidth()) < 0){
            createIsland(1);
        }
        if((int)(contIsland6.getLayoutX() + island6.getFitWidth()) < 0){
            createIsland(4);
        }
        checkCollision();
    }

    public void createIsland(int identifier) throws FileNotFoundException {
        randNo1 = random.nextInt(0, 6);
        randNo2 = random.nextInt(0, 6);
        randNo3 = random.nextInt(0, 6);
        Image image1 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[randNo1] +".png"));
        Image image2 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[randNo2] +".png"));
        Image image3 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[randNo3] +".png"));
        System.out.println(image1.toString());
        if(identifier==1){
            island1.setImage(image1);
            island2.setImage(image2);
            island3.setImage(image3);
            island1.setFitWidth(widthOfIslands.get(namesOfIslands[randNo1]));
            island2.setFitWidth(widthOfIslands.get(namesOfIslands[randNo2]));
            island3.setFitWidth(widthOfIslands.get(namesOfIslands[randNo3]));
            island1.setFitHeight(heightOfIslands.get(namesOfIslands[randNo1]));
            island2.setFitHeight(heightOfIslands.get(namesOfIslands[randNo2]));
            island3.setFitHeight(heightOfIslands.get(namesOfIslands[randNo3]));
            contIsland1.setLayoutX(contIsland6.getLayoutX()+ island6.getFitWidth() + 300);
            contIsland2.setLayoutX(contIsland1.getLayoutX()+ island1.getFitWidth() + 300);
            contIsland3.setLayoutX(contIsland2.getLayoutX()+ island2.getFitWidth() + 300);
            System.out.println("hto");
        }else{
            island4.setImage(image1);
            island5.setImage(image2);
            island6.setImage(image3);
            island4.setFitWidth(widthOfIslands.get(namesOfIslands[randNo1]));
            island5.setFitWidth(widthOfIslands.get(namesOfIslands[randNo2]));
            island6.setFitWidth(widthOfIslands.get(namesOfIslands[randNo3]));
            island4.setFitHeight(heightOfIslands.get(namesOfIslands[randNo1]));
            island5.setFitHeight(heightOfIslands.get(namesOfIslands[randNo2]));
            island6.setFitHeight(heightOfIslands.get(namesOfIslands[randNo3]));
            System.out.println("hello");
            contIsland4.setLayoutX(contIsland3.getLayoutX()+ island3.getFitWidth()  + 300);
            contIsland5.setLayoutX(contIsland4.getLayoutX()+ island4.getFitWidth() + 300);
            contIsland6.setLayoutX(contIsland5.getLayoutX() + island5.getFitWidth() + 300);
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



    public void checkCollision(){
        if(player.getLayoutX()>= tnt.getLayoutX() && player.getLayoutY()<= tnt.getLayoutY()){
            Image image1 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ "tntInitiated.png"));
            tnt.setImage(image1);
            startTimer();
        }
    }

    public void startTimer(){
//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                Image image1 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ "tntFire.png"));
//                tnt.setImage(image1);
//                tnt.setFitWidth(300);
//                tnt.setFitHeight(100);
//
//                if(player.getLayoutX()>= tnt.getLayoutX() && (player.getLayoutX()+ player.getFitWidth())<tnt.getLayoutX() && (player.getLayoutY()+ player.getFitHeight())< tnt.getLayoutY()){
//                    image1 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ "playerBurnt.png"));
//                    player.setImage(image1);
//               }
//            }
//        };
//        timer.scheduleAtFixedRate(task, 2000, 10);
    }

    public void makeChangesToTranslate(int depth, double start){
        translateTransition.setFromY(start + depth);
        translateTransition.setToY(start + depth - 90);
    }

}


