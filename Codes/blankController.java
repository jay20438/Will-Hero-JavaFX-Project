package com.example.javafx2;

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
    private ArrayList<Knife>knives;
    private ArrayList<Missile>missiles;
    private int nOfCoinsAmount;
    private final TranslateTransition translate2;
    private final TranslateTransition translate3;
    private final TranslateTransition translate4;
    private final TranslateTransition translate5;
    private Timer timer1;
    private Timer timer2;
    private Timer timer3;
    private Timer timer4;
    private Timer timer5;
    private Timer timer6;
    private Timer timer0;
    boolean flagToStopCreating = true;
    private boolean flagForBossLoaded;

    public blankController(){
        //nOfCoins = new TextField();
        flagForBossLoaded = false;
        nOfCoinsAmount = 0;
        tntObjects = new ArrayList<>();
        redOrcs = new ArrayList<>();
        greenOrcs = new ArrayList<>();
        coins = new ArrayList<>();
        chestTypeObjects = new ArrayList<>();
        knives = new ArrayList<>();
        missiles = new ArrayList<>();
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
        namesOfIslands = new String[]{"4treesIsland", "4treesIsland2", "4treesIsland3", "SideIsland", "LongIsland", "doubleIsland", "smallestFloatingIsland", "mediumFloatingIsland", "platform4Boss"};
        widthOfIslands.put("4treesIsland", 343);
        widthOfIslands.put("4treesIsland2", 381);
        widthOfIslands.put("4treesIsland3", 316);
        widthOfIslands.put("SideIsland", 426);
        widthOfIslands.put("LongIsland", 480);
        widthOfIslands.put("doubleIsland", 563);
        widthOfIslands.put("smallestFloatingIsland", 150);
        widthOfIslands.put("mediumFloatingIsland", 334);
        widthOfIslands.put("platform4Boss", 771);
        heightOfIslands.put("4treesIsland", 297);
        heightOfIslands.put("4treesIsland2", 270);
        heightOfIslands.put("4treesIsland3", 288);
        heightOfIslands.put("SideIsland", 283);
        heightOfIslands.put("LongIsland", 283);
        heightOfIslands.put("doubleIsland", 260);
        heightOfIslands.put("smallestFloatingIsland", 197);
        heightOfIslands.put("mediumFloatingIsland", 282);
        heightOfIslands.put("platform4Boss", 327);
        depthOfBaseOfIslands.put("4treesIsland", 144);
        depthOfBaseOfIslands.put("4treesIsland2", 108);
        depthOfBaseOfIslands.put("4treesIsland3", 108);
        depthOfBaseOfIslands.put("SideIsland", 122);
        depthOfBaseOfIslands.put("LongIsland", 57);
        depthOfBaseOfIslands.put("doubleIsland", 87);
        depthOfBaseOfIslands.put("smallestFloatingIsland", 0);
        depthOfBaseOfIslands.put("mediumFloatingIsland", 135);
        depthOfBaseOfIslands.put("platform4Boss", 87);
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
    void moveContent(MouseEvent event) throws FileNotFoundException, InterruptedException {

        nOfClick += 1;
        nOfSteps.setText(String.valueOf(nOfClick));
        playerObj.throwWeapon();
        //createEntity.createBoss(500);
        if(nOfClick>120 && island6.getBoundsInParent().getMaxX()<1408){
            if(!playerFalls)
                createEntity = new CreateEntity(this, mainAnchorPane);
//                if (player.getBoundsInParent().getMaxX()>island4.getBoundsInParent().getMinX()+20);
//                //createEntity.loadBoss();
            player.setLayoutX(player.getLayoutX() + 150);
            if(player.getBoundsInParent().getMaxX()>island5.getLayoutX() && !flagForBossLoaded){
                flagForBossLoaded = true;
                //createEntity.createBoss((int) (island5.getLayoutX()+200 + random.nextInt((int)island5.getFitWidth()-200-171)));
            }
        }else if(!playerFalls && playerObj.isLiving()) {
            moveEntities();
            if(flagToStopCreating) {
                if (nOfClick > 112) {
                    createEntity = new CreateEntity(this, mainAnchorPane);
                    createEntity.createScene4Boss(island4, island5, island6, island3);
                    tf4.setText("smallestFloatingIsland");
                    tf5.setText("platform4Boss");
                    tf6.setText("mediumFloatingIsland");
                    flagToStopCreating = false;
                } else {
                    if ((int) (island3.getBoundsInParent().getMaxX()) < 0) {
                        createIsland(1, island1, island2, island3);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island1);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island2);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island3);
                    }

                    if ((int) (island6.getBoundsInParent().getMaxX()) < 0) {
                        createIsland(4, island4, island5, island6);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island4);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island5);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island6);
                    }
                }
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
        createEntity = new CreateEntity(this, mainAnchorPane);
        try {
            playerObj = createEntity.createPlayer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        player = playerObj.getMineImageView();
        //chestTypeObjects = new ArrayList<>();

        try {
            createEntity = new CreateEntity(this, mainAnchorPane);
            createEntity.create(island2);
            createEntity = new CreateEntity(this, mainAnchorPane);
            createEntity.create(island3);
            createEntity = new CreateEntity(this,  mainAnchorPane);
            createEntity.create(island4);
            createEntity = new CreateEntity(this,  mainAnchorPane);
            createEntity.create(island5);
            createEntity = new CreateEntity(this,  mainAnchorPane);
            createEntity.create(island6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in intiialize");

        checkCollisionWithChestAndPlayer();
        checkCollisionOfPlayerWithTnt();
        checkCollisionOfPlayerWithCoin();
        //checkCollisionOfPlayerWithGreenOrc();
       //checkCollisionOfPlayerWithRedOrc();

    }


    synchronized public void  jump(ImageView imageView, Object obj, int sub, boolean flag4Up, boolean living) throws InterruptedException {
        boolean flag = false;
        try {
            double imageViewPosFront = imageView.getBoundsInParent().getMinX();
            double imageViewPosLast = imageView.getBoundsInParent().getMaxX();
            System.out.println(obj.getClass().getName());
            if(!(obj.getClass().getName().equals("com.example.javafx2.RedOrc") || obj.getClass().getName().equals("com.example.javafx2.GreenOrc")) && imageView.getBoundsInParent().getMinX()>1500){
                //gameOver();
            }
            if(imageView.getBoundsInParent().getMaxY()>520){
                if(obj.getClass().getName().equals("Player")){
                    if(player.getLayoutY()>739){
                        gameOver();
                    }else{
                        playerFalls = true;
                    }
                }
            }else if(!flag4Up) {
                if (imageViewPosLast >= island1.getBoundsInParent().getMinX() && imageViewPosFront <= island1.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island1.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf1.getText()))) {
                    flag = true;
                } else if (imageViewPosLast >= island2.getBoundsInParent().getMinX() && imageViewPosFront <= island2.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island2.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf2.getText()))) {
                    flag = true;
                } else if (imageViewPosLast >= island3.getBoundsInParent().getMinX() && imageViewPosFront <= island3.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island3.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf3.getText()))) {
                    flag = true;
                } else if (imageViewPosLast >= island4.getBoundsInParent().getMinX() && imageViewPosFront <= island4.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island4.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf4.getText()))) {
                    flag = true;
                } else if (imageViewPosLast >= island5.getBoundsInParent().getMinX() && imageViewPosFront <= island5.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island5.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf5.getText()))) {
                    flag = true;
                } else if (imageViewPosLast >= island6.getBoundsInParent().getMinX() && imageViewPosFront <= island6.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText()))) {
                    flag = true;
                }
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("catched");
        }
        if(flag || flag4Up){
            flag4Up = true;
            if(obj.getClass().getName().equals("com.example.javafx2.Player")){
                Player p = (Player) obj;
                if(living){
                    p.setGainedUpHeight(p.getGainedUpHeight()+sub);
                }
                if(flag && !living){
                    p.terminateJump();
                }
            }else if(obj.getClass().getName().equals("com.example.javafx2.RedOrc") || obj.getClass().getName().equals("com.example.javafx2.GreenOrc") || obj.getClass().getName().equals("com.example.javafx2.Boss")){
                Enemy e = (Enemy) obj;
                if(living){
                    e.setGainedUpHeight(e.getGainedUpHeight()+sub);
                }
                if(flag && !living){
                    e.terminateJump();
                }
            }
            if(living) {
                imageView.setLayoutY(imageView.getBoundsInParent().getMinY() - sub);
            }
        }
        if(!flag4Up){
            imageView.setLayoutY(imageView.getBoundsInParent().getMinY() + sub);
        }
    }





    private void gameOver() throws InterruptedException {
        timer0 = null;
        timer1 = null;
        timer2 = null;
        //System.exit(0);
        //timer3.cancel();
        System.out.println("game over");
        //goToSettings(null);
    }

    public void terminateJump(){

    }

    @FXML
    void goToSettings(MouseEvent event) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("SettingsPageView"));
    }

    public double getDepthOfBaseOfIsland(ImageView imageView){
        System.out.println("in getDepthOf island");
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

    public int getDepthOfBaseOfIsland(String name){
        return (int)depthOfBaseOfIslands.get(name);
    }

    public void moveEntities(){
        int index1 = -1;
        int index2 = -1;
        int index3 = -1;
        int index4 = -1;
        int index5 = -1;
        island1.setLayoutX(island1.getLayoutX() - 170);
        tf1.setLayoutX(tf1.getLayoutX() - 170);
        island2.setLayoutX(island2.getLayoutX() - 170);
        tf2.setLayoutX(tf2.getLayoutX() - 170);
        island3.setLayoutX(island3.getLayoutX() - 170);
        tf3.setLayoutX(tf3.getLayoutX() - 170);
        island4.setLayoutX(island4.getLayoutX() - 170);
        tf4.setLayoutX(tf4.getLayoutX() - 170);
        island5.setLayoutX(island5.getLayoutX() - 170);
        tf5.setLayoutX(tf5.getLayoutX() - 170);
        island6.setLayoutX(island6.getLayoutX() - 170);
        tf6.setLayoutX(tf6.getLayoutX() - 170);
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
            tntImageView.setLayoutX(tntImageView.getLayoutX()-170);
        }
        while (listIterator2.hasNext()){
            RedOrc redOrc = listIterator2.next();
            ImageView redOrcImageView = redOrc.getImageView();
            if (redOrcImageView.getLayoutX()<0){
                index2 += 1;
            }
            redOrcImageView.setLayoutX(redOrcImageView.getLayoutX()-170);
        }
        while (listIterator3.hasNext()){
            GreenOrc  greenOrc = listIterator3.next();
            ImageView greenOrcImageView = greenOrc.getImageView();
            if(greenOrcImageView.getLayoutX()<0){
                index3 += 1;
            }
            greenOrcImageView.setLayoutX(greenOrcImageView.getLayoutX()-170);
        }

        while (listIterator4.hasNext()){
            Coin coin = listIterator4.next();
            ImageView coinImageView = coin.getImageView();
            if(coinImageView.getLayoutX()<0){
                index4 += 1;
            }
            coinImageView.setLayoutX(coinImageView.getLayoutX()-170);
        }

        while (listIterator5.hasNext()){
            ChestType chest = listIterator5.next();
            ImageView chestImageView = chest.getImageView();
            if(chestImageView.getLayoutX()<0){
                index5 += 1;
            }
            chestImageView.setLayoutX(chestImageView.getLayoutX()-170);
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

    public void setKnife(Knife knife)
    {
        knives.add(knife);
    }

    public void setMissile(Missile missile)
    {
        missiles.add(missile);
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

    public int getHeightOfIslands(String imageName){
        return heightOfIslands.get(imageName);
    }

    public int getWidthOfIslands(String imageName){
        return widthOfIslands.get(imageName);
    }

    public int getXOfPlatformForBoss(){
        return (int)island5.getLayoutX();
    }

    public void checkCollisionWithChestAndPlayer(){

        timer1 = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int index = 0;
                //double player.getBoundsInParent().getMinX() = player.getBoundsInParent().getMinX();
                //double player.getBoundsInParent().getMaxX() = player.getBoundsInParent().getMaxX();
                if(chestTypeObjects.size()>0) {
                    System.out.println("size of chestType:"+chestTypeObjects.size());
                    ListIterator<ChestType> listIterator = chestTypeObjects.listIterator();
                    while (listIterator.hasNext()) {
                        ChestType chestType = listIterator.next();
                        if(!chestType.isCollided()) {
                            ImageView chestTypeImageView = chestType.getImageView();
                            if (player.getBoundsInParent().getMaxX() >= chestTypeImageView.getLayoutX() && player.getLayoutX() <= chestTypeImageView.getBoundsInParent().getMaxX()) {
                                if (player.getBoundsInParent().getMaxY() >= chestTypeImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() <= chestTypeImageView.getBoundsInParent().getMaxY()) {
                                    chestType.setCollided(true);
                                    chestType.open(playerObj);
                                }
                            }
                        }
                    }
                }
            }
        };
        timer1.scheduleAtFixedRate(task, 1500, 100);
    }


    public void checkCollisionOfPlayerWithTnt(){
        timer2 = new Timer();
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                if(tntObjects.size()>0){
                    System.out.println("size of tnt:"+tntObjects.size());
                    ListIterator<TNT> listIterator = tntObjects.listIterator();
                    while (listIterator.hasNext()) {
                        TNT tnt = listIterator.next();
                        if(!tnt.isCollided()) {
                            ImageView tntImageView = tnt.getImageView();
                            if (player.getBoundsInParent().getMaxX() >= tntImageView.getLayoutX() && player.getLayoutX() <= tntImageView.getBoundsInParent().getMaxX()) {
                                if (player.getBoundsInParent().getMaxY() >= tntImageView.getLayoutY() && player.getLayoutY() <= tntImageView.getBoundsInParent().getMaxY()) {
                                    tnt.setCollided(true);
                                    tnt.initiate();
                                }
                            }
                        }
                    }
                }

            }
        };
        timer2.scheduleAtFixedRate(task2, 2000, 100);
    }





    public void checkCollisionOfPlayerWithCoin(){
        timer3 = new Timer();
        TimerTask task3 = new TimerTask() {
            @Override
            public void run() {
                int index2 = 0;
                if(tntObjects.size()>0){
                    System.out.println("size of coins:"+coins.size());
                    ListIterator<Coin> listIterator = coins.listIterator();
                    while (listIterator.hasNext()) {
                        Coin coin = listIterator.next();
                        ImageView coinImageView = coin.getImageView();
                        if(!coin.isCollided()) {
                            if (player.getBoundsInParent().getMaxX() >= coinImageView.getBoundsInParent().getMinX() && player.getBoundsInParent().getMinX() <= coinImageView.getBoundsInParent().getMaxX()) {
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
        };
        timer3.scheduleAtFixedRate(task3, 500, 100);
    }


    public void checkCollisionOfPlayerWithGreenOrc(){
        System.out.println("in green p");
        timer4 = new Timer();
        TimerTask task4 = new TimerTask() {
            @Override
            public void run() {
                int index = 0;

                if(greenOrcs.size()>0) {
                    ListIterator<GreenOrc> listIterator4 = greenOrcs.listIterator();
                    System.out.println("size of gOrc:"+greenOrcs.size());
                    while (listIterator4.hasNext()) {
                        GreenOrc gOrc = listIterator4.next();
                        if (!gOrc.isCollided()) {
                            ImageView greenOrcImageView = gOrc.getImageView();
                            if(player.getBoundsInParent().getMaxX()>=greenOrcImageView.getLayoutX() && player.getLayoutX()<greenOrcImageView.getBoundsInParent().getMaxX()){
                                if(player.getBoundsInParent().getMinY()>=greenOrcImageView.getBoundsInParent().getMaxY()-5){
                                    gOrc.killPlayer(playerObj);
                                }else if(player.getBoundsInParent().getMaxY()>greenOrcImageView.getLayoutY()){
                                    int x = (int)greenOrcImageView.getLayoutX();
                                    //playerObj.setCoordinatesAfterCollision(x-25);
                                    gOrc.slide(300);
                                }
                                gOrc.setCollided(true);
                            }
                        }
                    }
                }
            }
        };
        timer4.scheduleAtFixedRate(task4, 1000, 100);
    }

    public void checkCollisionOfPlayerWithRedOrc(){
        timer5 = new Timer();
        TimerTask task5 = new TimerTask() {
            @Override
            public void run() {
                int index = 0;
                if(redOrcs.size()>0) {
                    ListIterator<RedOrc> listIterator4 = redOrcs.listIterator();
                    while (listIterator4.hasNext()) {
                        RedOrc rOrc = listIterator4.next();
                        if (!rOrc.isCollided()) {
                            ImageView redOrcImageView = rOrc.getImageView();
                            if(player.getBoundsInParent().getMaxX()>=redOrcImageView.getLayoutX() && player.getLayoutX()<redOrcImageView.getBoundsInParent().getMaxX()){
                                // not setting the is collided flag because it is not needed as we don't have any array list
                                if(player.getBoundsInParent().getMinY()>=redOrcImageView.getBoundsInParent().getMaxY()-5){
                                    rOrc.killPlayer(playerObj);
                                }else if(player.getBoundsInParent().getMaxY()>redOrcImageView.getLayoutY()){
                                    int x = (int)redOrcImageView.getLayoutX();
                                    //playerObj.setCoordinatesAfterCollision(x-30);
                                    rOrc.slide(200);
                                }
                                rOrc.setCollided(true);
                            }
                        }
                    }
                }
            }
        };
        timer5.scheduleAtFixedRate(task5, 1000, 100);
    }


    public void checkCollisionOfEntitiesAndFire(ImageView imageView) {
        //imageView = Weapon.getImageView();
        System.out.println("ion e and F");
//        while (imageView.getOpacity()!=0){
        if (player.getBoundsInParent().getMaxX() > imageView.getBoundsInParent().getMinX() && player.getBoundsInParent().getMinX() < imageView.getBoundsInParent().getMaxX()
                && player.getBoundsInParent().getMaxY() > imageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() < imageView.getBoundsInParent().getMaxY()) {
            playerObj.burnt();
        } else {
            ListIterator<GreenOrc> listIterator1 = greenOrcs.listIterator();
            ListIterator<RedOrc> listIterator2 = redOrcs.listIterator();
            while (listIterator1.hasNext()) {
                GreenOrc greenOrc = listIterator1.next();
                ImageView temp = greenOrc.getImageView();
                if (temp.getBoundsInParent().getMaxX() > imageView.getBoundsInParent().getMinX() && temp.getBoundsInParent().getMinX() < imageView.getBoundsInParent().getMaxX()
                        && temp.getBoundsInParent().getMaxY() > imageView.getBoundsInParent().getMinY() && temp.getBoundsInParent().getMinY() < imageView.getBoundsInParent().getMaxY()) {
                    greenOrc.burnt();
                }
            }
            while (listIterator2.hasNext()) {
                RedOrc redOrc = listIterator2.next();
                ImageView temp = redOrc.getImageView();
                if (temp.getBoundsInParent().getMaxX() > imageView.getBoundsInParent().getMinX() && temp.getBoundsInParent().getMinX() < imageView.getBoundsInParent().getMaxX()
                        && temp.getBoundsInParent().getMaxY() > imageView.getBoundsInParent().getMinY() && temp.getBoundsInParent().getMinY() < imageView.getBoundsInParent().getMaxY()) {
                    redOrc.burnt();
                }
            }
        }
//     }
    }

    public void checkCollisionOfOrcAndWeapon()
    {
        ListIterator<GreenOrc> listIterator8 = greenOrcs.listIterator();
        ListIterator<RedOrc> listIterator9 = redOrcs.listIterator();
        ListIterator<Knife> listIterator10 = knives.listIterator();
        ListIterator<Missile> listIterator11 = missiles.listIterator();
        Knife kn = listIterator10.next();
        ImageView kni = kn.getImageView();
        Missile m = listIterator11.next();
        ImageView rocket = m.getImageView();
        while (listIterator8.hasNext()) {
                GreenOrc greenOrc = listIterator8.next();
                ImageView temp = greenOrc.getImageView();

                if ((temp.getBoundsInParent().getMaxX() > kni.getBoundsInParent().getMinX() && temp.getBoundsInParent().getMinX() < kni.getBoundsInParent().getMaxX()
                        && temp.getBoundsInParent().getMaxY() > kni.getBoundsInParent().getMinY() && temp.getBoundsInParent().getMinY() < kni.getBoundsInParent().getMaxY()) ||
                        temp.getBoundsInParent().getMaxX() > rocket.getBoundsInParent().getMinX() && temp.getBoundsInParent().getMinX() < rocket.getBoundsInParent().getMaxX()
                                && temp.getBoundsInParent().getMaxY() > rocket.getBoundsInParent().getMinY() && temp.getBoundsInParent().getMinY() < rocket.getBoundsInParent().getMaxY()) {
                    greenOrc.die();
                }
            }
            while (listIterator9.hasNext()) {
                RedOrc redOrc = listIterator9.next();
                ImageView temp = redOrc.getImageView();

                if ((temp.getBoundsInParent().getMaxX() > kni.getBoundsInParent().getMinX() && temp.getBoundsInParent().getMinX() < kni.getBoundsInParent().getMaxX()
                        && temp.getBoundsInParent().getMaxY() > kni.getBoundsInParent().getMinY() && temp.getBoundsInParent().getMinY() < kni.getBoundsInParent().getMaxY()) ||
                        temp.getBoundsInParent().getMaxX() > rocket.getBoundsInParent().getMinX() && temp.getBoundsInParent().getMinX() < rocket.getBoundsInParent().getMaxX()
                                && temp.getBoundsInParent().getMaxY() > rocket.getBoundsInParent().getMinY() && temp.getBoundsInParent().getMinY() < rocket.getBoundsInParent().getMaxY()) {
                    redOrc.die();
                }
            }

        Timer timer1 = new Timer();
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                if(kni.getOpacity()==0){
                    terminateTimer(timer1);
                }

            }
        };
        timer1.scheduleAtFixedRate(timerTask1, 100, 100);
    }

    public void terminateTimer(Timer timer){
        timer.cancel();
        timer.purge();
    }
   /* public void checkCollisionOfPlayerAndBoss(){
        timer6 = new Timer();
        TimerTask timerTask  = new TimerTask() {
            @Override
            public void run() {
                ImageView bossImageView = boss.getImageView();
                if(player.getBoundsInParent().getMaxX()>=bossImageView.getLayoutX() && player.getLayoutX()<bossImageView.getBoundsInParent().getMaxX()){
                    // not setting the is collided flag because it is not needed as we don't have any array list
                    if(player.getBoundsInParent().getMinY()>=bossImageView.getBoundsInParent().getMaxY()-10){
                        boss.killPlayer(playerObj);
                    }else if(player.getBoundsInParent().getMaxY()>bossImageView.getLayoutY()){
                        int x = (int)bossImageView.getLayoutX();
                        playerObj.setCoordinatesAfterCollision(x-100);
                        boss.slide(50);
                    }
                }
            }
        };
        timer6.scheduleAtFixedRate(timerTask, 100, 100);
    }*/


}
