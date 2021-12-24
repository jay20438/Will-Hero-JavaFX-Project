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
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class blankController implements Initializable {
    private Random random;
    private HashMap<String, Integer> widthOfIslands;
    private HashMap<String, Integer> heightOfIslands;
    private HashMap<String, Integer> depthOfBaseOfIslands;
    static TranslateTransition translateTransition;
    private String[] namesOfIslands;
    boolean playerFalls = false;
    private int nOfClick;
    CreateEntity createEntity;
    private FxmlLoader fxmlLoader;
    private ArrayList<ChestType> chestTypeObjects;
    private ArrayList<TNT> tntObjects;
    private CreateEntity createEntityStandard;

    private final TranslateTransition translate2;
    private final TranslateTransition translate3;
    private final TranslateTransition translate4;
    private final TranslateTransition translate5;

    public blankController(){
        tntObjects = new ArrayList<>();
        fxmlLoader = new FxmlLoader();
        translate2 = new TranslateTransition();
        translate3 = new TranslateTransition();
        translate4 = new TranslateTransition();
        translate5 = new TranslateTransition();
        random = new Random();
        widthOfIslands = new HashMap<>();
        heightOfIslands = new HashMap<>();
        depthOfBaseOfIslands = new HashMap<>();
        translateTransition = new TranslateTransition();
        namesOfIslands = new String[]{"4treesIsland", "4treesIsland2", "4treesIsland3", "SideIsland", "LongIsland", "doubleIsland"};
        widthOfIslands.put("4treesIsland", 343);
        widthOfIslands.put("4treesIsland2", 381);
        widthOfIslands.put("4treesIsland3", 316);
        widthOfIslands.put("SideIsland", 426);
        widthOfIslands.put("LongIsland", 480);
        widthOfIslands.put("doubleIsland", 563);
        heightOfIslands.put("4treesIsland", 297);
        heightOfIslands.put("4treesIsland2", 270);
        heightOfIslands.put("4treesIsland3", 288);
        heightOfIslands.put("SideIsland", 283);
        heightOfIslands.put("LongIsland", 283);
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

    @FXML
    private ImageView greenOrc1;

    @FXML
    private ImageView greenOrc2;

    @FXML
    private ImageView redOrc1;

    @FXML
    private ImageView redOrc2;

    private int randNo1;
    private int randNo2;
    private int randNo3;

    @FXML
    void moveContent(MouseEvent event) throws FileNotFoundException {
        nOfClick += 1;
        if(nOfClick>122){
            if(!playerFalls)
                player.setLayoutX(player.getLayoutX() + 150);
        }else if(!playerFalls) {
            contIsland1.setLayoutX(contIsland1.getLayoutX() - 150);
            contIsland2.setLayoutX(contIsland2.getLayoutX() - 150);
            contIsland3.setLayoutX(contIsland3.getLayoutX() - 150);
            contIsland4.setLayoutX(contIsland4.getLayoutX() - 150);
            contIsland5.setLayoutX(contIsland5.getLayoutX() - 150);
            contIsland6.setLayoutX(contIsland6.getLayoutX() - 150);


            if ((int) (contIsland3.getLayoutX() + island3.getFitWidth()) < 20) {
                createIsland(1, island1, island2, island3);
                createEntity = new CreateEntity(contIsland1, this);
                createEntity.create();
                createEntity = new CreateEntity(contIsland2, this);
                createEntity.create();
                createEntity = new CreateEntity(contIsland3, this);
                createEntity.create();
            }

            if ((int) (contIsland6.getLayoutX() + island6.getFitWidth()) < 20) {
                 createIsland(4, island4, island5, island6);
                createEntity = new CreateEntity(contIsland4, this);
                createEntity.create();
                createEntity = new CreateEntity(contIsland5, this);
                createEntity.create();
                createEntity = new CreateEntity(contIsland6, this);
                createEntity.create();
            }
        }
    }

    public void createIsland(int identifier, ImageView imageView1, ImageView imageView2, ImageView imageView3) throws FileNotFoundException {
        randNo1 = random.nextInt(6);
        randNo2 = random.nextInt( 6);
        randNo3 = random.nextInt( 6);
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
            tf2.setText(namesOfIslands[randNo2]);
            contIsland2.setLayoutX(contIsland1.getBoundsInParent().getMaxX() + 300);
            tf3.setText(namesOfIslands[randNo3]);
            contIsland3.setLayoutX(contIsland2.getBoundsInParent().getMaxX() + 250);
            this.deleteEntities(contIsland1, contIsland2, contIsland3);
            //this.displayEntitiesInsideGroup(contIsland1, contIsland2, contIsland3);
//            if(contIsland1.getChildren().size()!=2){
//                contIsland1.getChildren().remove(2, contIsland1.getChildren().size()-1);
//            }
//            if(contIsland2.getChildren().size()!=2){
//                contIsland2.getChildren().remove(2, contIsland2.getChildren().size()-1);
//            }
//            if(contIsland3.getChildren().size()!=2){
//                contIsland3.getChildren().remove(2, contIsland3.getChildren().size()-1);
//            }

        }else{
            tf4.setText(namesOfIslands[randNo1]);
            contIsland4.setLayoutX(contIsland3.getBoundsInParent().getMaxX()  + 250);
            tf5.setText(namesOfIslands[randNo2]);
            contIsland5.setLayoutX(contIsland4.getBoundsInParent().getMaxX() + 200);
            tf6.setText(namesOfIslands[randNo3]);
            contIsland6.setLayoutX(contIsland5.getBoundsInParent().getMaxX() + 250);
//              if(contIsland4.getChildren().size()!=2){
//                  contIsland4.getChildren().remove(2, contIsland4.getChildren().size()-1);
//              }
//              if (contIsland5.getChildren().size()!=2){
//                  contIsland5.getChildren().remove(2, contIsland5.getChildren().size()-1);
//              }
//
//            if(contIsland6.getChildren().size()!=2){
//                contIsland6.getChildren().remove(2, contIsland6.getChildren().size()-1);
//            }
            this.deleteEntities(contIsland4, contIsland5, contIsland6);
            //this.displayEntitiesInsideGroup(contIsland4, contIsland5, contIsland6);

        }
    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            detect();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chestTypeObjects = new ArrayList<>();
        createEntity = new CreateEntity(contIsland2, this);
        createEntity.create();
        createEntity = new CreateEntity(contIsland3, this);
        createEntity.create();
        createEntity = new CreateEntity(contIsland4, this);
        createEntity.create();
        createEntity = new CreateEntity(contIsland5, this);
        createEntity.create();
        createEntity = new CreateEntity(contIsland6, this);
        createEntity.create();
        checkCollisionWithChestAndPlayer();
        checkCollisionOfPlayerWithTnt();
    }

    public void detect() throws InterruptedException {
        Timer timer1 = new Timer();
        TimerTask task1 = new TimerTask() {
            boolean flag = false;
            @Override
            public void run() {
                double playerPosFront = contPlayer.getBoundsInParent().getMinX();
                double playerPosLast = contPlayer.getBoundsInParent().getMaxX();
                if(contPlayer.getBoundsInParent().getMaxY()>520){
                    playerFalls = true;
                }else {
                    try {
                        if (playerPosFront >= contIsland1.getBoundsInParent().getMinX() && playerPosFront <= contIsland1.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland1.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf1.getText()))) {
                            flag = true;
                        } else if (playerPosFront >= contIsland2.getBoundsInParent().getMinX() && playerPosFront <= contIsland2.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland2.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf2.getText()))) {
                            flag = true;
                        } else if (playerPosFront >= contIsland3.getBoundsInParent().getMinX() && playerPosFront <= contIsland3.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland3.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf3.getText()))) {
                            flag = true;
                        } else if (playerPosFront >= contIsland4.getBoundsInParent().getMinX() && playerPosFront <= contIsland4.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland4.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf4.getText()))) {
                            flag = true;
                        } else if (playerPosFront >= contIsland5.getBoundsInParent().getMinX() && playerPosFront <= contIsland5.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland5.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf5.getText()))) {
                            flag = true;
                        } else if (playerPosFront >= contIsland6.getBoundsInParent().getMinX() && playerPosFront <= contIsland6.getBoundsInParent().getMaxX() && contPlayer.getBoundsInParent().getMaxY() > (contIsland6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText())) && contPlayer.getBoundsInParent().getMaxY() < (50 + contIsland6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText()))) {
                            flag = true;
                        }
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("c");
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

    @FXML
    void goToSettings(MouseEvent event) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("SettingsPageView"));
    }

    public void deleteEntities(Group gp1, Group gp2, Group gp3){
        int a = gp1.getChildren().size();
        int b = gp2.getChildren().size();
        int c = gp3.getChildren().size();
        if(a>2){
            gp1.getChildren().remove(2, a);
        }
        if(b>2){
            gp2.getChildren().remove(2, b);
        }
        if(c>2){
            gp3.getChildren().remove(2, c);
        }
//        ListIterator<ChestType> listIterator = chestTypeObjects.listIterator();
//        while (listIterator.hasNext()){
//            ChestType chestType = listIterator.next();
//            ImageView chestTypeImageView = chestType.getImageView();
//            Group gp = (Group) chestTypeImageView.getParent();
//            //double chestTypeImageViewXFront = chestTypeImageView.getParent().getBoundsInParent().getMinX() + chestTypeImageView.getBoundsInParent().getMinX();
//            double chestTypeImageViewXLast = chestTypeImageView.getParent().getBoundsInParent().getMinX() + chestTypeImageView.getBoundsInParent().getMinX() + chestTypeImageView.getFitWidth();
//            if(chestTypeImageViewXLast<0){
//                chestTypeObjects.remove(chestType);
//            }
//        }

    }

    public void deleteEntity(Group gp){
        int a = gp.getChildren().size();
//        int b = gp1.getChildren().size();
//        int c = gp1.getChildren().size();
        int i = 2;
        ImageView imageView;
        System.out.println("size:" + a);
        if(a>2){
            gp.getChildren().remove(2, a);
        }
    }

//    public void displayEntitiesInsideGroup(Group gp){
//        int a = gp.getChildren().size();
////        int b = gp1.getChildren().size();
////        int c = gp1.getChildren().size();
//        int i = 0;
//        Node n;
//        while(i<a ){
//            if(gp.getChildren().size()>i){
//                n =  gp.getChildren().get(i);
//                System.out.println(n);
//            }
////            if(gp2.getChildren().size()>i){
////                n = (ImageView) gp2.getChildren().get(i);
////                System.out.println(n);
////            }
////            if(gp3.getChildren().size()>i){
////                n = (ImageView) gp3.getChildren().get(i);
////                System.out.println(n);
////            }
//            i += 1;
//        }
//    }

    public double getDepthOfBaseOfIsland(Group gp){
        //System.out.println("tf in the group:" + gp.getChildren().get(0).getId());
        TextField tf = (TextField) gp.getChildren().get(0);
        //System.out.println("name of tf:"+tf.getText());
        return depthOfBaseOfIslands.get(tf.getText());
    }

    public void setChestObjects(ChestType chest){
        chestTypeObjects.add(chest);
    }

    public void setTntObjects(TNT tnt){
        tntObjects.add(tnt);
    }

    public void checkCollisionWithChestAndPlayer(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ArrayList<Integer> toDel = new ArrayList<>();
                int index = 0;
                double playerXFront = contPlayer.getBoundsInParent().getMinX();
                double playerXLast = contPlayer.getBoundsInParent().getMaxX();
                if(chestTypeObjects.size()>0) {
                    ListIterator<ChestType> listIterator = chestTypeObjects.listIterator();
                    while (listIterator.hasNext()) {
                        ChestType chestType = listIterator.next();
                        ImageView chestTypeImageView = chestType.getImageView();
                        Group gp = chestType.getGroupContainedIn();
                        double chestTypeImageViewXFront = chestTypeImageView.getParent().getBoundsInParent().getMinX() + chestTypeImageView.getBoundsInParent().getMinX();
                        double chestTypeImageViewXLast = chestTypeImageView.getParent().getBoundsInParent().getMinX() + chestTypeImageView.getBoundsInParent().getMinX() + chestTypeImageView.getFitWidth();
                        if (playerXFront < chestTypeImageViewXLast) {
                            if (playerXLast > chestTypeImageViewXFront) {
                                if (contPlayer.getBoundsInParent().getMaxY() > gp.getBoundsInParent().getMinY() + (-gp.getBoundsInLocal().getMinY() + chestTypeImageView.getLayoutY())) {
                                    chestType.open();
                                    toDel.add(index);
                                }
                            }
                        }else{
                            toDel.add(index);
                        }
                        index += 1;
                    }
                }
//                System.out.println("---in thread and index:"+index);
//                System.out.println("@@in thread and toDel size:"+toDel.size());
//                System.out.println("###in thread and chestTypeObjects size:"+chestTypeObjects.size());
                for (int i = 0; i < toDel.size(); i++) {
                    chestTypeObjects.remove(toDel.get(i));
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 10);
    }

    public void checkCollisionOfPlayerWithTnt(){
        Timer timer = new Timer();
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                ArrayList<Integer> toDel = new ArrayList<>();
                int index = 0;
                double playerXFront = contPlayer.getBoundsInParent().getMinX();
                double playerXLast = contPlayer.getBoundsInParent().getMaxX();
                if(tntObjects.size()>0){
                    ListIterator<TNT> listIterator = tntObjects.listIterator();
                    while (listIterator.hasNext()) {
                        TNT tnt = listIterator.next();
                        ImageView tntImageView = tnt.getImageView();
                        Group gp = tnt.getGroupContainedIn();
                        double tntImageViewXFront = tntImageView.getParent().getBoundsInParent().getMinX() + tntImageView.getBoundsInParent().getMinX();
                        double tntImageViewXLast = tntImageView.getParent().getBoundsInParent().getMinX() + tntImageView.getBoundsInParent().getMinX() + tntImageView.getFitWidth();
                        if (playerXFront < tntImageViewXLast) {
                            if (playerXLast > tntImageViewXFront) {
                                if (contPlayer.getBoundsInParent().getMaxY() > gp.getBoundsInParent().getMinY() + (-gp.getBoundsInLocal().getMinY() + tntImageView.getLayoutY())) {
                                    tnt.initiate();
//                                    try {
//                                        wait(1000);
//                                    } catch (InterruptedException e) {
//                                        e.printStackTrace();
//                                    }
                                    toDel.add(index);
                                }
                            }
                        }else{
                            toDel.add(index);
                        }
                        index += 1;
                    }
                }
                for (int i = 0; i < toDel.size(); i++) {
                    System.out.println("pesent to del tnt");
                    tntObjects.remove(toDel.get(i));
                }
            }
        };
        timer.scheduleAtFixedRate(task2, 0, 12);
    }


}