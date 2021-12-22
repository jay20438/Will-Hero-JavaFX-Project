package com.example.willherojavafxproject;
import java.net.URL;
import java.util.*;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;

public class blankController implements Initializable {
    private Random random;
    private HashMap<String, Integer> widthOfIslands;
    private HashMap<String, Integer> heightOfIslands;
    private HashMap<String, Integer> depthOfBaseOfIslands;
    static TranslateTransition translateTransition;
    private String[] namesOfIslands;
    //private int[] widthOfIslands;
    //private int[] heightOfIslands;
    //private int[] depthOfBaseOfIslands;
    boolean playerFalls = false;
    private int nOfClick;
    CreateEntity createEntity;


    public blankController(){
        random = new Random();
        widthOfIslands = new HashMap<>();
        heightOfIslands = new HashMap<>();
        depthOfBaseOfIslands = new HashMap<>();
        translateTransition = new TranslateTransition();
        namesOfIslands = new String[]{"4treesIsland", "4treesIsland2", "4treesIsland3", "SideIsland", "LongIsland", "doubleIsland"};
        widthOfIslands.put("4treesIsland", 343);
        widthOfIslands.put("4treesIsland2", 343);
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
        depthOfBaseOfIslands.put("4treesIsland", 144);
        depthOfBaseOfIslands.put("4treesIsland2", 108);
        depthOfBaseOfIslands.put("4treesIsland3", 108);
        depthOfBaseOfIslands.put("SideIsland", 122);
        depthOfBaseOfIslands.put("LongIsland", 57);
        depthOfBaseOfIslands.put("doubleIsland", 87);
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
//        System.out.println(contIsland1.getChildren().get(1).getId());
        if(nOfClick>122){
            player.setLayoutX(player.getLayoutX() + 100);
        }else if(!playerFalls) {
            contIsland1.setLayoutX(contIsland1.getLayoutX() - 150);
            contIsland2.setLayoutX(contIsland2.getLayoutX() - 150);
            contIsland3.setLayoutX(contIsland3.getLayoutX() - 150);
            contIsland4.setLayoutX(contIsland4.getLayoutX() - 150);
            contIsland5.setLayoutX(contIsland5.getLayoutX() - 150);
            contIsland6.setLayoutX(contIsland6.getLayoutX() - 150);

            if ((int) (contIsland3.getLayoutX() + island3.getFitWidth()) < 20) {
                createIsland(1, island1, island2, island3);
                CreateEntity createEntity1 = new CreateEntity(contIsland1, this);
                CreateEntity createEntity2 = new CreateEntity(contIsland2, this);
                CreateEntity createEntity3 = new CreateEntity(contIsland3, this);
                createEntity = new CreateEntity(contIsland1, this);
                createEntity.create();
                createEntity = new CreateEntity(contIsland2, this);
                createEntity.create();
                createEntity = new CreateEntity(contIsland3, this);
                createEntity.create();
//                Thread t1 = new Thread(createEntity1);
//                Thread t2 = new Thread(createEntity2);
//                Thread t3 = new Thread(createEntity3);
//                t1.setDaemon(true);
//                t2.setDaemon(true);
//                t3.setDaemon(true);
//                t1.start();
//                t2.start();
//                t3.start();
            }

            if ((int) (contIsland6.getLayoutX() + island6.getFitWidth()) < 20) {
                 createIsland(4, island4, island5, island6);
                createEntity = new CreateEntity(contIsland4, this);
                createEntity.create();
                createEntity = new CreateEntity(contIsland5, this);
                createEntity.create();
                createEntity = new CreateEntity(contIsland6, this);
                createEntity.create();
//                CreateEntity createEntity1 = new CreateEntity(contIsland4, this);
//                CreateEntity createEntity2 = new CreateEntity(contIsland5, this);
//                CreateEntity createEntity3 = new CreateEntity(contIsland6, this);
//                Thread t4 = new Thread(createEntity1);
//                Thread t5 = new Thread(createEntity2);
//                Thread t6 = new Thread(createEntity3);
//                t4.setDaemon(true);
//                t5.setDaemon(true);
//                t6.setDaemon(true);
//                t4.start();
//                t5.start();
//                t6.start();
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
            int count = 0;
            tf1.setText(namesOfIslands[randNo1]);
            contIsland1.setLayoutX(contIsland6.getBoundsInParent().getMaxX() + 250);
            //contIsland1.getChildren().remove(2, contIsland1.getChildren().size()-1);
            tf2.setText(namesOfIslands[randNo2]);
            contIsland2.setLayoutX(contIsland1.getBoundsInParent().getMaxX() + 300);
//            contIsland2.getChildren().remove(2, contIsland2.getChildren().size()-1);
            tf3.setText(namesOfIslands[randNo3]);
            contIsland3.setLayoutX(contIsland2.getBoundsInParent().getMaxX() + 250);
            //contIsland3.getChildren().remove(2, contIsland3.getChildren().size()-1);
        }else{
            tf4.setText(namesOfIslands[randNo1]);
            contIsland4.setLayoutX(contIsland3.getBoundsInParent().getMaxX()  + 250);
            //contIsland4.getChildren().remove(2, contIsland4.getChildren().size()-1);
            tf5.setText(namesOfIslands[randNo2]);
            contIsland5.setLayoutX(contIsland4.getBoundsInParent().getMaxX() + 200);
            //contIsland5.getChildren().remove(2, contIsland5.getChildren().size()-1);
            tf6.setText(namesOfIslands[randNo3]);
            contIsland6.setLayoutX(contIsland5.getBoundsInParent().getMaxX() + 250);
            //contIsland6.getChildren().remove(2, contIsland6.getChildren().size()-1);
        }
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
            boolean flag = false;
            @Override
            public void run() {
                double playerPosFront = contPlayer.getBoundsInParent().getMinX();
                double playerPosLast = contPlayer.getBoundsInParent().getMaxX();
                if(contPlayer.getBoundsInParent().getMaxY()>600){
                    playerFalls = true;
                }else {
                    if (playerPosFront >= contIsland1.getBoundsInParent().getMinX() && playerPosLast <= contIsland1.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland1.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf1.getText()))) {
//                        if (contPlayer.getBoundsInParent().getMaxY() > (10 + contIsland1.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf1.getText()))) {
//                            flag = true;
//                        } else {
//                            playerFalls = true;
//                        }
                        flag = true;
                    } else if (playerPosFront >= contIsland2.getBoundsInParent().getMinX() && playerPosFront <= contIsland2.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland2.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf2.getText()))) {
//                        if (contPlayer.getBoundsInParent().getMaxY() > (10 + contIsland2.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf2.getText()))) {
//                            flag = true;
//                        } else {
//                            playerFalls = true;
//                        }
                        flag = true;
                    } else if (playerPosFront >= contIsland3.getBoundsInParent().getMinX() && playerPosFront <= contIsland3.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland3.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf3.getText()))) {
//                        if (contPlayer.getBoundsInParent().getMaxY() > (10 + contIsland3.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf3.getText()))) {
//                            flag = true;
//                        } else {
//                            playerFalls = true;
//                        }
                        flag = true;
                    } else if (playerPosFront >= contIsland4.getBoundsInParent().getMinX() && playerPosFront <= contIsland4.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland4.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf4.getText()))) {
//                        if (contPlayer.getBoundsInParent().getMaxY() > (50 + contIsland4.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf4.getText()))) {
//                            flag = true;
//                        } else {
//                            playerFalls = true;
//                        }
                        flag = true;
//                        makeChangesToTranslate(contIsland4.getBoundsInParent().getMinY(), depthOfBaseOfIslands.get(tf4.getText()));
                    } else if (playerPosFront >= contIsland5.getBoundsInParent().getMinX() && playerPosFront <= contIsland5.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland5.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf5.getText()))) {

//                        if (contPlayer.getBoundsInParent().getMaxY() > (10 + contIsland5.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf5.getText()))) {
//                            flag = true;
//                        } else {
//                            playerFalls = true;
//                        }
                        flag = true;
                    } else if (playerPosFront >= contIsland6.getBoundsInParent().getMinX() && playerPosFront <= contIsland6.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText())) && contPlayer.getBoundsInParent().getMaxY() < (50 + contIsland6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText()))) {
//                        if (contPlayer.getBoundsInParent().getMaxY() > (10 + contIsland6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText()))) {
//                            flag = true;
//                        } else {
//                            playerFalls = true;
//                        }
                        flag = true;
                    }
                    if (flag) {
                        for (int i = 0; i < 10; i++) {
                            contPlayer.setLayoutY(contPlayer.getBoundsInParent().getMinY() - 10);
                        }
                    }
                }
                contPlayer.setLayoutY(contPlayer.getBoundsInParent().getMinY() + 10);
                flag = false;
            }
        };
        timer1.scheduleAtFixedRate(task1, 0, 100);
    }

    public double getDepthOfBaseOfIsland(Group gp){
        System.out.println("tf in the group:" + gp.getChildren().get(1).getId());
        TextField tf = (TextField) gp.getChildren().get(0);
        System.out.println("name of tf:"+tf.getText());
        return depthOfBaseOfIslands.get(tf.getText());
    }
}


