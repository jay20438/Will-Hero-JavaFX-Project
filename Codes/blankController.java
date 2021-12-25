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
    private Player playerObj;
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
    private int nOfCoinsAmount;
    private final TranslateTransition translate2;
    private final TranslateTransition translate3;
    private final TranslateTransition translate4;
    private final TranslateTransition translate5;
    private Timer timer1;
    private Timer timer2;
    private Timer timer3;
    private Timer timer0;

    public blankController(){
        //nOfCoins = new TextField();
        nOfCoinsAmount = 0;
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
    private ImageView coinSymbol;

    @FXML
    private TextField nOfCoins;

    @FXML
    private TextField nOfSteps;
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
        nOfSteps.setText(String.valueOf(nOfClick));
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
        }else{
            tf4.setText(namesOfIslands[randNo1]);
            island4.setLayoutX(island3.getBoundsInParent().getMaxX()  + 250);
            tf5.setText(namesOfIslands[randNo2]);
            island5.setLayoutX(island4.getBoundsInParent().getMaxX() + 200);
            tf6.setText(namesOfIslands[randNo3]);
            island6.setLayoutX(island5.getBoundsInParent().getMaxX() + 250);

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createEntity = new CreateEntity(this, island1, mainAnchorPane);
        playerObj = createEntity.createPlayer();
        player = playerObj.getMineImageView();
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
        checkCollisionOfPlayerWithCoin();
        checkCollisionOfPlayerWithGreenOrc();
        checkCollisionOfPlayerWithRedOrc();
    }

    public void detect() throws InterruptedException {
        timer0 = new Timer();
        TimerTask task1 = new TimerTask() {
            boolean flag = false;
            @Override
            public void run() {
                double playerPosFront = player.getBoundsInParent().getMinX();
                double playerPosLast =player.getBoundsInParent().getMaxX();
                if(player.getBoundsInParent().getMinX()>1500){
                    gameOver();
                }
                if(player.getBoundsInParent().getMaxY()>520){
                    if(player.getLayoutY()>739){
                        gameOver();
                    }else{
                        playerFalls = true;
                    }
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
                System.out.println("before incrementing the miny:"+player.getBoundsInParent().getMinY());
                player.setLayoutY(player.getBoundsInParent().getMinY() + 10);
                System.out.println("bafter incrementing the miny:"+player.getBoundsInParent().getMinY());
                flag = false;
            }
        };
        timer0.scheduleAtFixedRate(task1, 500, 100);

    }

    private void gameOver() {
        timer0.purge();
        timer1.purge();
        timer2.purge();
        //timer3.cancel();
        System.out.println("game over");
        //goToSettings(null);
    }

    @FXML
    void goToSettings(MouseEvent event) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("SettingsPageView"));
    }

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
        int index1 = -1;
        int index2 = -1;
        int index3 = -1;
        int index4 = -1;
        int index5 = -1;
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
            TNT tnt = listIterator1.next();
            ImageView tntImageView = tnt.getImageView();
            if(tntImageView.getLayoutX()<0){
                index1 += 1;
            }
            tntImageView.setLayoutX(tntImageView.getLayoutX()-150);
        }
        while (listIterator2.hasNext()){
            RedOrc redOrc = listIterator2.next();
            ImageView redOrcImageView = redOrc.getImageView();
            if (redOrcImageView.getLayoutX()<0){
                index2 += 1;
            }
            redOrcImageView.setLayoutX(redOrcImageView.getLayoutX()-150);
        }
        while (listIterator3.hasNext()){
            GreenOrc  greenOrc = listIterator3.next();
            ImageView greenOrcImageView = greenOrc.getImageView();
            if(greenOrcImageView.getLayoutX()<0){
                index3 += 1;
            }
            greenOrcImageView.setLayoutX(greenOrcImageView.getLayoutX()-150);
        }

        while (listIterator4.hasNext()){
            Coin coin = listIterator4.next();
            ImageView coinImageView = coin.getImageView();
            if(coinImageView.getLayoutX()<0){
                index4 += 1;
            }
            coinImageView.setLayoutX(coinImageView.getLayoutX()-150);
        }

        while (listIterator5.hasNext()){
            ChestType chest = listIterator5.next();
            ImageView chestImageView = chest.getImageView();
            if(chestImageView.getLayoutX()<0){
                index5 += 1;
            }
            chestImageView.setLayoutX(chestImageView.getLayoutX()-150);
        }
        for (int i = 0; i < index1; i++) {
            tntObjects.remove(0);
        }
        for (int i = 0; i < index2; i++) {
            redOrcs.remove(0);
        }
        for (int i = 0; i < index3; i++) {
            greenOrcs.remove(0);
        }
        for (int i = 0; i < index4; i++) {
            coins.remove(0);
        }
        for (int i = 0; i < index5; i++) {
            chestTypeObjects.remove(0);
        }
    }

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

    public void updateCoin(int change){
        System.out.println("updating the coin");
        nOfCoinsAmount += change;
        nOfCoins.setText(String.valueOf(nOfCoinsAmount));
    }

    public void loadImage( ChestType chestType){
        chestType.generateTransition();
    }

    public ImageView getCoinSymbol(){
        return coinSymbol;
    }

    public void checkCollisionWithChestAndPlayer(){
        timer1 = new Timer();
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
                        if(!chestType.isCollided()) {
                            ImageView chestTypeImageView = chestType.getImageView();
                            double chestTypeImageViewXLast = chestTypeImageView.getBoundsInParent().getMaxX();
                            double chestTypeImageViewXFront = chestTypeImageView.getBoundsInParent().getMinX();
                            if (playerXLast >= chestTypeImageViewXFront) {
                                if (playerXFront <= chestTypeImageViewXLast) {
                                    if (player.getBoundsInParent().getMaxY() >= chestTypeImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() <= chestTypeImageView.getBoundsInParent().getMaxY()) {
                                        chestType.setCollided(true);
                                        chestType.open(playerObj);
                                        //loadImage(chestType);
                                        toDel.add(index);
                                        index += 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        timer1.scheduleAtFixedRate(task, 1500, 50);
    }

    public void checkCollisionOfPlayerWithTnt(){
        timer2 = new Timer();
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
                        if(!tnt.isCollided()) {
                            ImageView tntImageView = tnt.getImageView();
                            double tntImageViewXFront = tntImageView.getBoundsInParent().getMinX();
                            double tntImageViewXLast = tntImageView.getBoundsInParent().getMaxX();
                            if (playerXLast >= tntImageViewXFront) {
                                if (playerXFront <= tntImageViewXLast) {
                                    if (player.getBoundsInParent().getMaxY() >= tntImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() <= tntImageView.getBoundsInParent().getMaxY()) {
                                        tnt.setCollided(true);
                                        tnt.initiate();
                                    }
                                }
                            }
                        }
                    }
                }

            }
        };
        timer2.scheduleAtFixedRate(task2, 2000, 50);
    }

    public void checkCollisionOfPlayerWithCoin(){
        timer3 = new Timer();
        TimerTask task3 = new TimerTask() {
            @Override
            public void run() {
                ArrayList<Integer> toDel3 = new ArrayList<>();
                int index2 = 0;
                double playerXFront = player.getBoundsInParent().getMinX();
                double playerXLast = player.getBoundsInParent().getMaxX();
                if(tntObjects.size()>0){
                    ListIterator<Coin> listIterator = coins.listIterator();
                    while (listIterator.hasNext()) {
                        Coin coin = listIterator.next();
                        ImageView coinImageView = coin.getImageView();
                        double coinImageViewXFront = coinImageView.getBoundsInParent().getMinX();
                        double coinImageViewXLast = coinImageView.getBoundsInParent().getMaxX();
                        if(!coin.isCollided()) {
                            if (playerXLast >= coinImageViewXFront) {
                                if (playerXFront <= coinImageViewXLast) {
                                    if (player.getBoundsInParent().getMaxY() >= coinImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() <= coinImageView.getBoundsInParent().getMaxY()) {
                                        coin.setCollided(true);
                                        updateCoin(1);
                                        playerObj.getCoins(1);
                                        coin.fade();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        timer3.scheduleAtFixedRate(task3, 500, 60);
    }

    public void checkCollisionOfPlayerWithGreenOrc(){
        Timer timer4 = new Timer();
        TimerTask task4 = new TimerTask() {
            @Override
            public void run() {
                ArrayList<Integer> toDel4 = new ArrayList<>();
                int index = 0;
                double playerXFront = player.getBoundsInParent().getMinX();
                double playerXLast = player.getBoundsInParent().getMaxX();
                double playerYTop = player.getBoundsInParent().getMinY();
                double playerYBottom = player.getBoundsInParent().getMaxY();
                if(greenOrcs.size()>0) {
                    ListIterator<GreenOrc> listIterator4 = greenOrcs.listIterator();
                    while (listIterator4.hasNext()) {
                        GreenOrc gOrc = listIterator4.next();
                        ImageView greenOrcImageView = gOrc.getImageView();
                        double greenOrcImageViewXLast = greenOrcImageView.getBoundsInParent().getMaxX();
                        double greenOrcImageViewXFront = greenOrcImageView.getBoundsInParent().getMinX();
                        double greenOrcImageViewYBottom = greenOrcImageView.getBoundsInParent().getMaxY();
                        if (playerXFront <= greenOrcImageViewXLast) {
                            if (playerXLast >= greenOrcImageViewXFront) {
                                if (player.getBoundsInParent().getMaxY() >= greenOrcImageView.getBoundsInParent().getMinY()) {
                                    gOrc.slide();
                                    toDel4.add(index);
                                }
                            }
                        }
                        else if(playerYTop <= greenOrcImageViewYBottom)
                        {
                            gOrc.killPlayer(playerObj);
                        }
                        else{
                            toDel4.add(index);
                        }
                        index += 1;
                    }
                }
                for (int i = 0; i < toDel4.size(); i++) {
                    greenOrcs.remove(toDel4.get(i));
                }
            }
        };
        timer4.scheduleAtFixedRate(task4, 1000, 100);
    }

    public void checkCollisionOfPlayerWithRedOrc(){
        Timer timer5 = new Timer();
        TimerTask task5 = new TimerTask() {
            @Override
            public void run() {
                ArrayList<Integer> toDel5 = new ArrayList<>();
                int index = 0;
                double playerXFront = player.getBoundsInParent().getMinX();
                double playerXLast = player.getBoundsInParent().getMaxX();
                double playerYTop = player.getBoundsInParent().getMinY();
                if (redOrcs.size() > 0) {
                    ListIterator<RedOrc> listIterator4 = redOrcs.listIterator();
                    while (listIterator4.hasNext()) {
                        RedOrc rOrc = listIterator4.next();
                        ImageView redOrcImageView = rOrc.getImageView();
                        double redOrcImageViewXLast = redOrcImageView.getBoundsInParent().getMaxX();
                        double redOrcImageViewXFront = redOrcImageView.getBoundsInParent().getMinX();

                        double redOrcImageViewYBottom = redOrcImageView.getBoundsInParent().getMaxY();
                        if (playerXFront <= redOrcImageViewXLast) {
                            if (playerXLast >= redOrcImageViewXFront) {
                                if (player.getBoundsInParent().getMaxY() >= redOrcImageView.getBoundsInParent().getMinY()) {
                                    rOrc.slide();
                                    toDel5.add(index);
                                }
                            }
                        } else if (playerYTop <= redOrcImageViewYBottom) {
                            rOrc.killPlayer(playerObj);
                        } else {
                            toDel5.add(index);
                        }
                        index += 1;
                    }
                    for (int i = 0; i < toDel5.size(); i++) {
                        redOrcs.remove(toDel5.get(i));
                    }
                }
            }
        };
        timer5.scheduleAtFixedRate(task5, 1000, 100);

    }

    public void maKeArrangementForBoss(){

    }

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