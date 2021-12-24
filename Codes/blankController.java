package com.example.willherojavafxproject;
import java.net.URL;
import java.util.*;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    private ArrayList<RedOrc> redOrcs;
    private ArrayList<GreenOrc> greenOrcs;
    private ArrayList<Coin> coins;
    //private CreateEntityNg createEntityStandard;

    private final TranslateTransition translate2;
    private final TranslateTransition translate3;
    private final TranslateTransition translate4;
    private final TranslateTransition translate5;

    public blankController(){
        tntObjects = new ArrayList<>();
        redOrcs = new ArrayList<>();
        greenOrcs = new ArrayList<>();
        coins = new ArrayList<>();
        chestTypeObjects = new ArrayList<>();
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
    private AnchorPane mainAnchorPane;

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
            if(!playerFalls)
                player.setLayoutX(player.getLayoutX() + 150);
        }else if(!playerFalls) {
            moveEntities();
            if ((int) (island3.getBoundsInParent().getMaxX()) < 0) {
                createIsland(1, island1, island2, island3);
                createEntity = new CreateEntity( this, island1, mainAnchorPane);
                createEntity.create();
                createEntity = new CreateEntity(this, island2, mainAnchorPane);
                createEntity.create();
                createEntity = new CreateEntity(this, island3, mainAnchorPane);
                createEntity.create();
            }

            if ((int) (island6.getBoundsInParent().getMaxX()) < 0) {
                createIsland(4, island4, island5, island6);
                createEntity = new CreateEntity(this, island4, mainAnchorPane);
                createEntity.create();
                createEntity = new CreateEntity(this, island5, mainAnchorPane);
                createEntity.create();
                createEntity = new CreateEntity(this, island6, mainAnchorPane);
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
        if(identifier==1) {
            int count = 0;
            tf1.setText(namesOfIslands[randNo1]);
            island1.setLayoutX(island6.getBoundsInParent().getMaxX() + 250);
            tf2.setText(namesOfIslands[randNo2]);
            island2.setLayoutX(island1.getBoundsInParent().getMaxX() + 300);
            tf3.setText(namesOfIslands[randNo3]);
            island3.setLayoutX(island2.getBoundsInParent().getMaxX() + 250);
//            this.deleteEntities(contIsland1, contIsland2, contIsland3);
//            //this.displayEntitiesInsideGroup(contIsland1, contIsland2, contIsland3);
////            if(contIsland1.getChildren().size()!=2){
////                contIsland1.getChildren().remove(2, contIsland1.getChildren().size()-1);
////            }
////            if(contIsland2.getChildren().size()!=2){
////                contIsland2.getChildren().remove(2, contIsland2.getChildren().size()-1);
////            }
////            if(contIsland3.getChildren().size()!=2){
////                contIsland3.getChildren().remove(2, contIsland3.getChildren().size()-1);
////            }
//
        }else{
            tf4.setText(namesOfIslands[randNo1]);
            island4.setLayoutX(island3.getBoundsInParent().getMaxX()  + 250);
            tf5.setText(namesOfIslands[randNo2]);
            island5.setLayoutX(island4.getBoundsInParent().getMaxX() + 200);
            tf6.setText(namesOfIslands[randNo3]);
            island6.setLayoutX(island5.getBoundsInParent().getMaxX() + 250);
////              if(contIsland4.getChildren().size()!=2){
////                  contIsland4.getChildren().remove(2, contIsland4.getChildren().size()-1);
////              }
////              if (contIsland5.getChildren().size()!=2){
////                  contIsland5.getChildren().remove(2, contIsland5.getChildren().size()-1);
////              }
////
////            if(contIsland6.getChildren().size()!=2){
////                contIsland6.getChildren().remove(2, contIsland6.getChildren().size()-1);
////            }
//            this.deleteEntities(contIsland4, contIsland5, contIsland6);
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
        //chestTypeObjects = new ArrayList<>();
        createEntity = new CreateEntity(this, island2, mainAnchorPane);
        createEntity.create();
        createEntity = new CreateEntity(this, island3, mainAnchorPane);
        createEntity.create();
        createEntity = new CreateEntity(this, island4, mainAnchorPane);
        createEntity.create();
        createEntity = new CreateEntity(this, island5, mainAnchorPane);
        createEntity.create();
        createEntity = new CreateEntity(this, island6, mainAnchorPane);
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
                double playerPosFront = player.getBoundsInParent().getMinX();
                double playerPosLast =player.getBoundsInParent().getMaxX();
                if(player.getBoundsInParent().getMaxY()>520){
                    playerFalls = true;
                }else {
                    try {
                        if (playerPosFront >= island1.getBoundsInParent().getMinX() && playerPosFront <= island1.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island1.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf1.getText()))) {
                            flag = true;
                        } else if (playerPosFront >= island2.getBoundsInParent().getMinX() && playerPosFront <= island2.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island2.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf2.getText()))) {
                            flag = true;
                        } else if (playerPosFront >= island3.getBoundsInParent().getMinX() && playerPosFront <= island3.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island3.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf3.getText()))) {
                            flag = true;
                        } else if (playerPosFront >= island4.getBoundsInParent().getMinX() && playerPosFront <= island4.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island4.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf4.getText()))) {
                            flag = true;
                        } else if (playerPosFront >= island5.getBoundsInParent().getMinX() && playerPosFront <= island5.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island5.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf5.getText()))) {
                            flag = true;
                        } else if (playerPosFront >= island6.getBoundsInParent().getMinX() && playerPosFront <= island6.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText()))) {
                            flag = true;
                        }
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("c");
                    }
                    if (flag) {
                        for (int i = 0; i < 10; i++) {
                            player.setLayoutY(player.getBoundsInParent().getMinY() - 10);
                        }
                    }
                }
                player.setLayoutY(player.getBoundsInParent().getMinY() + 10);
                flag = false;
            }
        };
        timer1.scheduleAtFixedRate(task1, 0, 100);

    }

    @FXML
    void goToSettings(MouseEvent event) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("SettingsPageView"));
    }
    //
//    public void deleteEntities(Group gp1, Group gp2, Group gp3){
//        int a = gp1.getChildren().size();
//        int b = gp2.getChildren().size();
//        int c = gp3.getChildren().size();
//        if(a>2){
//            gp1.getChildren().remove(2, a);
//        }
//        if(b>2){
//            gp2.getChildren().remove(2, b);
//        }
//        if(c>2){
//            gp3.getChildren().remove(2, c);
//        }
////        ListIterator<ChestType> listIterator = chestTypeObjects.listIterator();
////        while (listIterator.hasNext()){
////            ChestType chestType = listIterator.next();
////            ImageView chestTypeImageView = chestType.getImageView();
////            Group gp = (Group) chestTypeImageView.getParent();
////            //double chestTypeImageViewXFront = chestTypeImageView.getParent().getBoundsInParent().getMinX() + chestTypeImageView.getBoundsInParent().getMinX();
////            double chestTypeImageViewXLast = chestTypeImageView.getParent().getBoundsInParent().getMinX() + chestTypeImageView.getBoundsInParent().getMinX() + chestTypeImageView.getFitWidth();
////            if(chestTypeImageViewXLast<0){
////                chestTypeObjects.remove(chestType);
////            }
////        }
//
//    }
//
//    public void deleteEntity(Group gp){
//        int a = gp.getChildren().size();
////        int b = gp1.getChildren().size();
////        int c = gp1.getChildren().size();
//        int i = 2;
//        ImageView imageView;
//        System.out.println("size:" + a);
//        if(a>2){
//            gp.getChildren().remove(2, a);
//        }
//    }
//
////    public void displayEntitiesInsideGroup(Group gp){
////        int a = gp.getChildren().size();
//////        int b = gp1.getChildren().size();
//////        int c = gp1.getChildren().size();
////        int i = 0;
////        Node n;
////        while(i<a ){
////            if(gp.getChildren().size()>i){
////                n =  gp.getChildren().get(i);
////                System.out.println(n);
////            }
//////            if(gp2.getChildren().size()>i){
//////                n = (ImageView) gp2.getChildren().get(i);
//////                System.out.println(n);
//////            }
//////            if(gp3.getChildren().size()>i){
//////                n = (ImageView) gp3.getChildren().get(i);
//////                System.out.println(n);
//////            }
////            i += 1;
////        }
////    }
//
    public double getDepthOfBaseOfIsland(ImageView imageView){
        String name  = imageView.getId();
        if(name.equals("island1")){
            return depthOfBaseOfIslands.get(tf1.getText());
        }else if(name.equals("island2")){
            return depthOfBaseOfIslands.get(tf2.getText());
        }else if(name.equals("island3")){
            return depthOfBaseOfIslands.get(tf3.getText());
        }else if(name.equals("island4")){
            return depthOfBaseOfIslands.get(tf4.getText());
        }else if(name.equals("island5")){
            return depthOfBaseOfIslands.get(tf5.getText());
        }else if(name.equals("island6")){
            return depthOfBaseOfIslands.get(tf6.getText());
        }
        System.out.println("no tf found");
        return 0;

    }

    public void moveEntities(){
        island1.setLayoutX(island1.getLayoutX() - 150);
        tf1.setLayoutX(tf1.getLayoutX() - 150);
        island2.setLayoutX(island2.getLayoutX() - 150);
        tf2.setLayoutX(tf2.getLayoutX() - 150);
        island3.setLayoutX(island3.getLayoutX() - 150);
        tf3.setLayoutX(tf3.getLayoutX() - 150);
        island4.setLayoutX(island4.getLayoutX() - 150);
        tf4.setLayoutX(tf4.getLayoutX() - 150);
        island5.setLayoutX(island5.getLayoutX() - 150);
        tf5.setLayoutX(tf5.getLayoutX() - 150);
        island6.setLayoutX(island6.getLayoutX() - 150);
        tf6.setLayoutX(tf6.getLayoutX() - 150);
        ListIterator<TNT> listIterator1 = tntObjects.listIterator();
        ListIterator<RedOrc> listIterator2 = redOrcs.listIterator();
        ListIterator<GreenOrc> listIterator3 = greenOrcs.listIterator();
        ListIterator<Coin> listIterator4 = coins.listIterator();
        ListIterator<ChestType> listIterator5 = chestTypeObjects.listIterator();
        while (listIterator1.hasNext()){
            ImageView tnt = listIterator1.next().getImageView();
            tnt.setLayoutX(tnt.getLayoutX()-150);
        }
        while (listIterator2.hasNext()){
            ImageView redOrc = listIterator2.next().getImageView();
            redOrc.setLayoutX(redOrc.getLayoutX()-150);
        }
        while (listIterator3.hasNext()){
            ImageView greenOrc = listIterator3.next().getImageView();
            greenOrc.setLayoutX(greenOrc.getLayoutX()-150);
        }
        while (listIterator4.hasNext()){
            ImageView coin = listIterator4.next().getImageView();
            coin.setLayoutX(coin.getLayoutX()-150);
        }
        while (listIterator5.hasNext()){
            ImageView chest = listIterator5.next().getImageView();
            chest.setLayoutX(chest.getLayoutX()-150);
        }

    }
    //
    public void setChestObjects(ChestType chest){
        chestTypeObjects.add(chest);
    }

    public void setTntObjects(TNT tnt){
        tntObjects.add(tnt);
    }

    public void setCoinObjects(Coin coin){
        coins.add(coin);
    }

    public void setRedOrcObjects(RedOrc redOrc){
        redOrcs.add(redOrc);
    }

    public void setGreenOrcObjects(GreenOrc greenOrc){
        greenOrcs.add(greenOrc);
    }
    //
    public void checkCollisionWithChestAndPlayer(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ArrayList<Integer> toDel = new ArrayList<>();
                int index = 0;
                double playerXFront = player.getBoundsInParent().getMinX();
                double playerXLast = player.getBoundsInParent().getMaxX();
                if(chestTypeObjects.size()>0) {
                    ListIterator<ChestType> listIterator = chestTypeObjects.listIterator();
                    while (listIterator.hasNext()) {
                        ChestType chestType = listIterator.next();
                        ImageView chestTypeImageView = chestType.getImageView();
                        double chestTypeImageViewXLast = chestTypeImageView.getBoundsInParent().getMaxX();
                        double chestTypeImageViewXFront = chestTypeImageView.getBoundsInParent().getMinX();
                        if (playerXFront < chestTypeImageViewXLast) {
                            if (playerXLast > chestTypeImageViewXFront) {
                                if (player.getBoundsInParent().getMaxY() > chestTypeImageView.getBoundsInParent().getMinY()) {
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
        timer.scheduleAtFixedRate(task, 0, 60);
    }
    //
    public void checkCollisionOfPlayerWithTnt(){
        Timer timer2 = new Timer();
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                ArrayList<Integer> toDel2 = new ArrayList<>();
                int index2 = 0;
                double playerXFront = player.getBoundsInParent().getMinX();
                double playerXLast = player.getBoundsInParent().getMaxX();
                if(tntObjects.size()>0){
                    ListIterator<TNT> listIterator = tntObjects.listIterator();
                    while (listIterator.hasNext()) {
                        TNT tnt = listIterator.next();
                        ImageView tntImageView = tnt.getImageView();
                        double tntImageViewXFront = tntImageView.getBoundsInParent().getMinX();
                        double tntImageViewXLast = tntImageView.getBoundsInParent().getMaxX();
                        if (playerXFront < tntImageViewXLast) {
                            if (playerXLast > tntImageViewXFront) {
                                if (player.getBoundsInParent().getMaxY() > tntImageView.getBoundsInParent().getMinY() ) {
                                    tnt.initiate();
                                    toDel2.add(index2);
                                }
                            }
                        }else{
                            toDel2.add(index2);
                        }
                        index2 += 1;
                    }
                }
                for (int i = 0; i < toDel2.size(); i++) {
                    System.out.println("size of to del for tnt:" + toDel2.size());
                    System.out.println("pesent to del tnt");
                    tntObjects.remove(toDel2.get(i));
                }
            }
        };
        timer2.scheduleAtFixedRate(task2, 0, 100);
    }


}