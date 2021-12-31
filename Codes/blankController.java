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
    boolean flagToStopCreating = true;
    private boolean flagForBossLoaded;
    private int noOfFramesCreated;
    private Boss boss;

    public blankController(){
        noOfFramesCreated = 0;
        //nOfCoins = new TextField();
        flagForBossLoaded = false;
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
        depthOfBaseOfIslands.put("platform4Boss", 121);
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
        //boss = createEntity.createBoss(500);
        //boss.jump();
        //boss.move();
        if(nOfClick>120 && island6.getBoundsInParent().getMaxX()<1408){
            if(!playerFalls)
                createEntity = new CreateEntity(this, mainAnchorPane);
                player.setLayoutX(player.getLayoutX() + 150);
                if(player.getBoundsInParent().getMaxX()>island5.getLayoutX() && !flagForBossLoaded){
                    flagForBossLoaded = true;
                    boss = createEntity.createBoss((int) (island5.getLayoutX()+200 + random.nextInt((int)island5.getFitWidth()-200-171)));
                    boss.bringDownBoss((double)island5.getLayoutY());
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
                } else if(noOfFramesCreated<9) {
                    if ((int) (island3.getBoundsInParent().getMaxX()) < 0) {
                        createIsland(1, island1, island2, island3);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island1);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island2);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island3);
                        noOfFramesCreated += 1;
                    }

                    if ((int) (island6.getBoundsInParent().getMaxX()) < 0) {
                        createIsland(4, island4, island5, island6);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island4);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island5);
                        createEntity = new CreateEntity(this, mainAnchorPane);
                        createEntity.create(island6);
                        noOfFramesCreated += 1;
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
       checkCollisionOfPlayerWithGreenOrc();
        checkCollisionOfPlayerWithRedOrc();
    }


      synchronized public void  jump(ImageView imageView, Object obj, int sub, boolean flag4Up, boolean living) throws InterruptedException {
        boolean flag = false;
        try {
            double imageViewPosFront = imageView.getBoundsInParent().getMinX();
            double imageViewPosLast = imageView.getBoundsInParent().getMaxX();
            if(!(obj.getClass().getName().equals("com.example.willherojavafxproject.RedOrc") || obj.getClass().getName().equals("com.example.willherojavafxproject.GreenOrc")) && imageView.getBoundsInParent().getMinX()>1500){
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
            if(obj.getClass().getName().equals("com.example.willherojavafxproject.Player")){
                Player p = (Player) obj;
                if(living){
                    p.setGainedUpHeight(p.getGainedUpHeight()+sub);
                }
                if(flag && !living){
                    p.terminateJump();
                }
            }else if(obj.getClass().getName().equals("com.example.willherojavafxproject.RedOrc") || obj.getClass().getName().equals("com.example.willherojavafxproject.GreenOrc") || obj.getClass().getName().equals("com.example.willherojavafxproject.Boss")){
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
        timer0.cancel();
        timer1.cancel();
        timer2.cancel();
        System.out.println("game over");
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
            redOrcs.get(0).terminateJump();
            redOrcs.remove(0);
        }
        for (int i = 0; i < index3; i++) {
            greenOrcs.get(0).terminateJump();
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
                            //double chestTypeImageView.getBoundsInParent().getMaxX() = chestTypeImageView.getBoundsInParent().getMaxX();
                            //double chestTypeImageView.getBoundsInParent().getMinX() = chestTypeImageView.getBoundsInParent().getMinX();
                            if (player.getBoundsInParent().getMaxX() >= chestTypeImageView.getBoundsInParent().getMinX()) {
                                if (player.getBoundsInParent().getMinX() <= chestTypeImageView.getBoundsInParent().getMaxX()) {
                                    if (player.getBoundsInParent().getMaxY() >= chestTypeImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() <= chestTypeImageView.getBoundsInParent().getMaxY()) {
                                        chestType.setCollided(true);
                                        chestType.open(playerObj);
                                        //loadImage(chestType);
                                    }
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
                int index2 = 0;
                //double player.getBoundsInParent().getMinX() = player.getBoundsInParent().getMinX();
                //double player.getBoundsInParent().getMaxX() = player.getBoundsInParent().getMaxX();
                if(tntObjects.size()>0){
                    System.out.println("size of tnt:"+tntObjects.size());
                    ListIterator<TNT> listIterator = tntObjects.listIterator();
                    while (listIterator.hasNext()) {
                        TNT tnt = listIterator.next();
                        if(!tnt.isCollided()) {
                            ImageView tntImageView = tnt.getImageView();
                            //double tntImageView.getBoundsInParent().getMinX() = tntImageView.getBoundsInParent().getMinX();
                            //double tntImageView.getBoundsInParent().getMaxX() = tntImageView.getBoundsInParent().getMaxX();
                            if (player.getBoundsInParent().getMaxX() >= tntImageView.getBoundsInParent().getMinX()) {
                                if (player.getBoundsInParent().getMinX() <= tntImageView.getBoundsInParent().getMaxX()) {
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
        timer2.scheduleAtFixedRate(task2, 2000, 100);
    }





    public void checkCollisionOfPlayerWithCoin(){
        System.out.println("in pc");
        timer3 = new Timer();
        TimerTask task3 = new TimerTask() {
            @Override
            public void run() {
                int index2 = 0;
                //double player.getBoundsInParent().getMinX() = player.getBoundsInParent().getMinX();
                //double player.getBoundsInParent().getMaxX() = player.getBoundsInParent().getMaxX();
                if(tntObjects.size()>0){
                    System.out.println("size of coins:"+coins.size());
                    ListIterator<Coin> listIterator = coins.listIterator();
                    while (listIterator.hasNext()) {
                        Coin coin = listIterator.next();
                        ImageView coinImageView = coin.getImageView();
                        //double coinImageView.getBoundsInParent().getMinX() = coinImageView.getBoundsInParent().getMinX();
                        //double coinImageView.getBoundsInParent().getMaxX() = coinImageView.getBoundsInParent().getMaxX();
                        if(!coin.isCollided()) {
                            if (player.getBoundsInParent().getMaxX() >= coinImageView.getBoundsInParent().getMinX()) {
                                if (player.getBoundsInParent().getMinX() <= coinImageView.getBoundsInParent().getMaxX()) {
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
        timer3.scheduleAtFixedRate(task3, 500, 100);
    }


     public void checkCollisionOfPlayerWithGreenOrc(){
        System.out.println("in green p");
        Timer timer4 = new Timer();
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

                            if (player.getBoundsInParent().getMinX() <= greenOrcImageView.getBoundsInParent().getMaxX()) {
                                if (player.getBoundsInParent().getMaxX() >= greenOrcImageView.getBoundsInParent().getMinX()) {
                                    if (player.getBoundsInParent().getMaxY() >= greenOrcImageView.getBoundsInParent().getMinY()) {
                                        gOrc.slide();
                                        gOrc.setCollided(true);
                                    }
                                }
                            } else if (player.getBoundsInParent().getMinY() <= greenOrcImageView.getBoundsInParent().getMaxY()) {
                                gOrc.killPlayer(playerObj);
                                gOrc.setCollided(true);
                            }
//                            if (playerXLast >= greenOrcImageViewXFront && playerXFront <= greenOrcImageViewXLast) {
//                                if (playerXLast < greenOrcImageViewXFront + 10) {
//                                    if ((playerYTop >= greenOrcImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMaxY() <= greenOrcImageViewYBottom) || (playerYTop <= greenOrcImageViewYTop && playerYBottom >= greenOrcImageViewYBottom)) {
//                                        gOrc.slide();
//                                    }
//                                } else if (playerYTop <= greenOrcImageViewYBottom && playerYBottom >= greenOrcImageViewYTop) {
//                                    gOrc.killPlayer(playerObj);
//                                }
//                                gOrc.setCollided(true);
//                            }
                        }
                    }
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
                int index = 0;
                if(redOrcs.size()>0) {
                    ListIterator<RedOrc> listIterator4 = redOrcs.listIterator();
                    System.out.println("size of gOrc:"+redOrcs.size());
                    while (listIterator4.hasNext()) {
                        RedOrc rOrc = listIterator4.next();
                        if (!rOrc.isCollided()) {
                            ImageView redOrcImageView = rOrc.getImageView();
                            if (player.getBoundsInParent().getMinX() <= redOrcImageView.getBoundsInParent().getMaxX()) {
                                if (player.getBoundsInParent().getMaxX() >= redOrcImageView.getBoundsInParent().getMinX()) {
                                    if (player.getBoundsInParent().getMaxY() >= redOrcImageView.getBoundsInParent().getMinY()) {
                                        rOrc.slide();
                                        rOrc.setCollided(true);
                                    }
                                }
                            } else if (player.getBoundsInParent().getMinY() <= redOrcImageView.getBoundsInParent().getMaxY()) {
                                rOrc.killPlayer(playerObj);
                                rOrc.setCollided(true);
                            }
//                            if (playerXLast >= greenOrcImageViewXFront && playerXFront <= greenOrcImageViewXLast) {
//                                if (playerXLast < greenOrcImageViewXFront + 10) {
//                                    if ((playerYTop >= greenOrcImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMaxY() <= greenOrcImageViewYBottom) || (playerYTop <= greenOrcImageViewYTop && playerYBottom >= greenOrcImageViewYBottom)) {
//                                        gOrc.slide();
//                                    }
//                                } else if (playerYTop <= greenOrcImageViewYBottom && playerYBottom >= greenOrcImageViewYTop) {
//                                    gOrc.killPlayer(playerObj);
//                                }
//                                gOrc.setCollided(true);
//                            }
                        }
                    }
                }
            }
        };
        timer5.scheduleAtFixedRate(task5, 1000, 100);
    }


      public void checkCollisionOfEntitiesAndFire(ImageView imageView) {
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


}









//friday 4:40pm
//package com.example.willherojavafxproject;
//        import java.net.URL;
//        import java.util.*;
//
//        import javafx.animation.TranslateTransition;
//        import javafx.fxml.FXML;
//        import javafx.fxml.Initializable;
//        import javafx.scene.control.TextField;
//        import javafx.scene.image.Image;
//        import javafx.scene.image.ImageView;
//        import javafx.scene.input.MouseEvent;
//        import javafx.scene.layout.AnchorPane;
//
//        import java.io.FileNotFoundException;
//
//public class blankController implements Initializable {
//    private Player playerObj;
//    private Random random;
//    private HashMap<String, Integer> widthOfIslands;
//    private HashMap<String, Integer> heightOfIslands;
//    private HashMap<String, Integer> depthOfBaseOfIslands;
//    static TranslateTransition translateTransition;
//    private String[] namesOfIslands;
//    boolean playerFalls = false;
//    private int nOfClick;
//    CreateEntity createEntity;
//    private FxmlLoader fxmlLoader;
//    private ArrayList<ChestType> chestTypeObjects;
//    private ArrayList<TNT> tntObjects;
//    private ArrayList<RedOrc> redOrcs;
//    private ArrayList<GreenOrc> greenOrcs;
//    private ArrayList<Coin> coins;
//    private int nOfCoinsAmount;
//    private final TranslateTransition translate2;
//    private final TranslateTransition translate3;
//    private final TranslateTransition translate4;
//    private final TranslateTransition translate5;
//    private Timer timer1;
//    private Timer timer2;
//    private Timer timer3;
//    private Timer timer0;
//    boolean flagToStopCreating = true;
//    private boolean flagForBossLoaded;
//    private int noOfFramesCreated;
//    private Boss boss;
//
//    public blankController(){
//        noOfFramesCreated = 0;
//        //nOfCoins = new TextField();
//        flagForBossLoaded = false;
//        nOfCoinsAmount = 0;
//        tntObjects = new ArrayList<>();
//        redOrcs = new ArrayList<>();
//        greenOrcs = new ArrayList<>();
//        coins = new ArrayList<>();
//        chestTypeObjects = new ArrayList<>();
//        fxmlLoader = new FxmlLoader();
//        translate2 = new TranslateTransition();
//        translate3 = new TranslateTransition();
//        translate4 = new TranslateTransition();
//        translate5 = new TranslateTransition();
//        random = new Random();
//        widthOfIslands = new HashMap<>();
//        heightOfIslands = new HashMap<>();
//        depthOfBaseOfIslands = new HashMap<>();
//        translateTransition = new TranslateTransition();
//        namesOfIslands = new String[]{"4treesIsland", "4treesIsland2", "4treesIsland3", "SideIsland", "LongIsland", "doubleIsland", "smallestFloatingIsland", "mediumFloatingIsland", "platform4Boss"};
//        widthOfIslands.put("4treesIsland", 343);
//        widthOfIslands.put("4treesIsland2", 381);
//        widthOfIslands.put("4treesIsland3", 316);
//        widthOfIslands.put("SideIsland", 426);
//        widthOfIslands.put("LongIsland", 480);
//        widthOfIslands.put("doubleIsland", 563);
//        widthOfIslands.put("smallestFloatingIsland", 150);
//        widthOfIslands.put("mediumFloatingIsland", 334);
//        widthOfIslands.put("platform4Boss", 771);
//        heightOfIslands.put("4treesIsland", 297);
//        heightOfIslands.put("4treesIsland2", 270);
//        heightOfIslands.put("4treesIsland3", 288);
//        heightOfIslands.put("SideIsland", 283);
//        heightOfIslands.put("LongIsland", 283);
//        heightOfIslands.put("doubleIsland", 260);
//        heightOfIslands.put("smallestFloatingIsland", 197);
//        heightOfIslands.put("mediumFloatingIsland", 282);
//        heightOfIslands.put("platform4Boss", 327);
//        depthOfBaseOfIslands.put("4treesIsland", 144);
//        depthOfBaseOfIslands.put("4treesIsland2", 108);
//        depthOfBaseOfIslands.put("4treesIsland3", 108);
//        depthOfBaseOfIslands.put("SideIsland", 122);
//        depthOfBaseOfIslands.put("LongIsland", 57);
//        depthOfBaseOfIslands.put("doubleIsland", 87);
//        depthOfBaseOfIslands.put("smallestFloatingIsland", 0);
//        depthOfBaseOfIslands.put("mediumFloatingIsland", 135);
//        depthOfBaseOfIslands.put("platform4Boss", 121);
//        nOfClick = 0;
//    }
//
//
//
//    @FXML
//    private ImageView coinSymbol;
//
//    @FXML
//    private TextField nOfCoins;
//
//    @FXML
//    private TextField nOfSteps;
//    @FXML
//    private ImageView background;
//
//    @FXML
//    private ImageView island1;
//
//    @FXML
//    private ImageView island2;
//
//    @FXML
//    private ImageView island3;
//
//    @FXML
//    private ImageView island4;
//
//    @FXML
//    private ImageView island5;
//
//    @FXML
//    private ImageView island6;
//
//    @FXML
//    private ImageView player;
//
//    @FXML
//    private AnchorPane mainAnchorPane;
//
//    @FXML
//    private TextField tf1;
//
//    @FXML
//    private TextField tf2;
//
//    @FXML
//    private TextField tf3;
//
//    @FXML
//    private TextField tf4;
//
//    @FXML
//    private TextField tf5;
//
//    @FXML
//    private TextField tf6;
//
//    @FXML
//    private ImageView tnt;
//
//
//    private int randNo1;
//    private int randNo2;
//    private int randNo3;
//
//    @FXML
//    void moveContent(MouseEvent event) throws FileNotFoundException, InterruptedException {
//        nOfClick += 1;
//        nOfSteps.setText(String.valueOf(nOfClick));
//        playerObj.throwWeapon();
//        //boss = createEntity.createBoss(500);
//        //boss.jump();
//        //boss.move();
//        if(nOfClick>120 && island6.getBoundsInParent().getMaxX()<1408){
//            if(!playerFalls)
//                createEntity = new CreateEntity(this, mainAnchorPane);
//            player.setLayoutX(player.getLayoutX() + 150);
//            if(player.getBoundsInParent().getMaxX()>island5.getLayoutX() && !flagForBossLoaded){
//                flagForBossLoaded = true;
//                boss = createEntity.createBoss((int) (island5.getLayoutX()+200 + random.nextInt((int)island5.getFitWidth()-200-171)));
//                boss.bringDownBoss((double)island5.getLayoutY());
//            }
//        }else if(!playerFalls && playerObj.isLiving()) {
//            moveEntities();
//            if(flagToStopCreating) {
//                if (nOfClick > 112) {
//                    createEntity = new CreateEntity(this, mainAnchorPane);
//                    createEntity.createScene4Boss(island4, island5, island6, island3);
//                    tf4.setText("smallestFloatingIsland");
//                    tf5.setText("platform4Boss");
//                    tf6.setText("mediumFloatingIsland");
//                    flagToStopCreating = false;
//                } else if(noOfFramesCreated<9) {
//                    if ((int) (island3.getBoundsInParent().getMaxX()) < 0) {
//                        createIsland(1, island1, island2, island3);
//                        createEntity = new CreateEntity(this, mainAnchorPane);
//                        createEntity.create(island1);
//                        createEntity = new CreateEntity(this, mainAnchorPane);
//                        createEntity.create(island2);
//                        createEntity = new CreateEntity(this, mainAnchorPane);
//                        createEntity.create(island3);
//                        noOfFramesCreated += 1;
//                    }
//
//                    if ((int) (island6.getBoundsInParent().getMaxX()) < 0) {
//                        createIsland(4, island4, island5, island6);
//                        createEntity = new CreateEntity(this, mainAnchorPane);
//                        createEntity.create(island4);
//                        createEntity = new CreateEntity(this, mainAnchorPane);
//                        createEntity.create(island5);
//                        createEntity = new CreateEntity(this, mainAnchorPane);
//                        createEntity.create(island6);
//                        noOfFramesCreated += 1;
//                    }
//                }
//            }
//        }
//    }
//
//    public void createIsland(int identifier, ImageView imageView1, ImageView imageView2, ImageView imageView3) throws FileNotFoundException {
//        randNo1 = random.nextInt(6);
//        randNo2 = random.nextInt( 6);
//        randNo3 = random.nextInt( 6);
//        Image image1 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[randNo1] +".png"));
//        Image image2 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[randNo2] +".png"));
//        Image image3 = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ namesOfIslands[randNo3] +".png"));
//        imageView1.setImage(image1);
//        imageView2.setImage(image2);
//        imageView3.setImage(image3);
//        imageView1.setFitWidth(widthOfIslands.get(namesOfIslands[randNo1]));
//        imageView2.setFitWidth(widthOfIslands.get(namesOfIslands[randNo2]));
//        imageView3.setFitWidth(widthOfIslands.get(namesOfIslands[randNo3]));
//        imageView1.setFitHeight(heightOfIslands.get(namesOfIslands[randNo1]));
//        imageView2.setFitHeight(heightOfIslands.get(namesOfIslands[randNo2]));
//        imageView3.setFitHeight(heightOfIslands.get(namesOfIslands[randNo3]));
//        if(identifier==1) {
//            tf1.setText(namesOfIslands[randNo1]);
//            island1.setLayoutX(island6.getBoundsInParent().getMaxX() + 250);
//            tf2.setText(namesOfIslands[randNo2]);
//            island2.setLayoutX(island1.getBoundsInParent().getMaxX() + 300);
//            tf3.setText(namesOfIslands[randNo3]);
//            island3.setLayoutX(island2.getBoundsInParent().getMaxX() + 250);
//        }else{
//            tf4.setText(namesOfIslands[randNo1]);
//            island4.setLayoutX(island3.getBoundsInParent().getMaxX()  + 250);
//            tf5.setText(namesOfIslands[randNo2]);
//            island5.setLayoutX(island4.getBoundsInParent().getMaxX() + 200);
//            tf6.setText(namesOfIslands[randNo3]);
//            island6.setLayoutX(island5.getBoundsInParent().getMaxX() + 250);
//        }
//    }
//
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        createEntity = new CreateEntity(this, mainAnchorPane);
//        try {
//            playerObj = createEntity.createPlayer();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        player = playerObj.getMineImageView();
//        //chestTypeObjects = new ArrayList<>();
//
//        try {
//            createEntity = new CreateEntity(this, mainAnchorPane);
//            createEntity.create(island2);
//            createEntity = new CreateEntity(this, mainAnchorPane);
//            createEntity.create(island3);
//            createEntity = new CreateEntity(this,  mainAnchorPane);
//            createEntity.create(island4);
//            createEntity = new CreateEntity(this,  mainAnchorPane);
//            createEntity.create(island5);
//            createEntity = new CreateEntity(this,  mainAnchorPane);
//            createEntity.create(island6);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("in intiialize");
//
//        checkCollisionWithChestAndPlayer();
//        checkCollisionOfPlayerWithTnt();
//        checkCollisionOfPlayerWithCoin();
//        checkCollisionOfPlayerWithGreenOrc();
//        checkCollisionOfPlayerWithRedOrc();
//    }
//
//
//    synchronized public void  jump(ImageView imageView, Object obj, int sub, boolean flag4Up, boolean living) throws InterruptedException {
//        boolean flag = false;
//        try {
//            double imageViewPosFront = imageView.getBoundsInParent().getMinX();
//            double imageViewPosLast = imageView.getBoundsInParent().getMaxX();
//            if(!(obj.getClass().getName().equals("com.example.willherojavafxproject.RedOrc") || obj.getClass().getName().equals("com.example.willherojavafxproject.GreenOrc")) && imageView.getBoundsInParent().getMinX()>1500){
//                //gameOver();
//            }
//            if(imageView.getBoundsInParent().getMaxY()>520){
//                if(obj.getClass().getName().equals("Player")){
//                    if(player.getLayoutY()>739){
//                        gameOver();
//                    }else{
//                        playerFalls = true;
//                    }
//                }
//            }else if(!flag4Up) {
//                if (imageViewPosLast >= island1.getBoundsInParent().getMinX() && imageViewPosFront <= island1.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island1.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf1.getText()))) {
//                    flag = true;
//                } else if (imageViewPosLast >= island2.getBoundsInParent().getMinX() && imageViewPosFront <= island2.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island2.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf2.getText()))) {
//                    flag = true;
//                } else if (imageViewPosLast >= island3.getBoundsInParent().getMinX() && imageViewPosFront <= island3.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island3.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf3.getText()))) {
//                    flag = true;
//                } else if (imageViewPosLast >= island4.getBoundsInParent().getMinX() && imageViewPosFront <= island4.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island4.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf4.getText()))) {
//                    flag = true;
//                } else if (imageViewPosLast >= island5.getBoundsInParent().getMinX() && imageViewPosFront <= island5.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island5.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf5.getText()))) {
//                    flag = true;
//                } else if (imageViewPosLast >= island6.getBoundsInParent().getMinX() && imageViewPosFront <= island6.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText()))) {
//                    flag = true;
//                }
//            }
//        }catch (IndexOutOfBoundsException e){
//            System.out.println("catched");
//        }
//        if(flag || flag4Up){
//            flag4Up = true;
//            if(obj.getClass().getName().equals("com.example.willherojavafxproject.Player")){
//                Player p = (Player) obj;
//                if(living){
//                    p.setGainedUpHeight(p.getGainedUpHeight()+sub);
//                }
//                if(flag && !living){
//                    p.terminateJump();
//                }
//            }else if(obj.getClass().getName().equals("com.example.willherojavafxproject.RedOrc") || obj.getClass().getName().equals("com.example.willherojavafxproject.GreenOrc") || obj.getClass().getName().equals("com.example.willherojavafxproject.Boss")){
//                Enemy e = (Enemy) obj;
//                if(living){
//                    e.setGainedUpHeight(e.getGainedUpHeight()+sub);
//                }
//                if(flag && !living){
//                    e.terminateJump();
//                }
//            }
//            if(living) {
//                imageView.setLayoutY(imageView.getBoundsInParent().getMinY() - sub);
//            }
//        }
//        if(!flag4Up){
//            imageView.setLayoutY(imageView.getBoundsInParent().getMinY() + sub);
//        }
//    }
//
//
//
//
//
//    private void gameOver() throws InterruptedException {
//        timer0.cancel();
//        timer1.cancel();
//        timer2.cancel();
//        System.out.println("game over");
//    }
//
//    public void terminateJump(){
//
//    }
//
//    @FXML
//    void goToSettings(MouseEvent event) {
//        HelloApplication.setDifferentScene(fxmlLoader.getScene("SettingsPageView"));
//    }
//
//    public double getDepthOfBaseOfIsland(ImageView imageView){
//        System.out.println("in getDepthOf island");
//        String name  = imageView.getId();
//        if(name.equals("island1")){
//            return depthOfBaseOfIslands.get(tf1.getText());
//        }else if(name.equals("island2")){
//            return depthOfBaseOfIslands.get(tf2.getText());
//        }else if(name.equals("island3")){
//            return depthOfBaseOfIslands.get(tf3.getText());
//        }else if(name.equals("island4")){
//            return depthOfBaseOfIslands.get(tf4.getText());
//        }else if(name.equals("island5")){
//            return depthOfBaseOfIslands.get(tf5.getText());
//        }else if(name.equals("island6")){
//            return depthOfBaseOfIslands.get(tf6.getText());
//        }
//        System.out.println("no tf found");
//        return 0;
//
//    }
//
//    public int getDepthOfBaseOfIsland(String name){
//        return (int)depthOfBaseOfIslands.get(name);
//    }
//
//    public void moveEntities(){
//        int index1 = -1;
//        int index2 = -1;
//        int index3 = -1;
//        int index4 = -1;
//        int index5 = -1;
//        island1.setLayoutX(island1.getLayoutX() - 170);
//        tf1.setLayoutX(tf1.getLayoutX() - 170);
//        island2.setLayoutX(island2.getLayoutX() - 170);
//        tf2.setLayoutX(tf2.getLayoutX() - 170);
//        island3.setLayoutX(island3.getLayoutX() - 170);
//        tf3.setLayoutX(tf3.getLayoutX() - 170);
//        island4.setLayoutX(island4.getLayoutX() - 170);
//        tf4.setLayoutX(tf4.getLayoutX() - 170);
//        island5.setLayoutX(island5.getLayoutX() - 170);
//        tf5.setLayoutX(tf5.getLayoutX() - 170);
//        island6.setLayoutX(island6.getLayoutX() - 170);
//        tf6.setLayoutX(tf6.getLayoutX() - 170);
//        ListIterator<TNT> listIterator1 = tntObjects.listIterator();
//        ListIterator<RedOrc> listIterator2 = redOrcs.listIterator();
//        ListIterator<GreenOrc> listIterator3 = greenOrcs.listIterator();
//        ListIterator<Coin> listIterator4 = coins.listIterator();
//        ListIterator<ChestType> listIterator5 = chestTypeObjects.listIterator();
//        while (listIterator1.hasNext()){
//            TNT tnt = listIterator1.next();
//            ImageView tntImageView = tnt.getImageView();
//            if(tntImageView.getLayoutX()<0){
//                index1 += 1;
//            }
//            tntImageView.setLayoutX(tntImageView.getLayoutX()-170);
//        }
//        while (listIterator2.hasNext()){
//            RedOrc redOrc = listIterator2.next();
//            ImageView redOrcImageView = redOrc.getImageView();
//            if (redOrcImageView.getLayoutX()<0){
//                index2 += 1;
//            }
//            redOrcImageView.setLayoutX(redOrcImageView.getLayoutX()-170);
//        }
//        while (listIterator3.hasNext()){
//            GreenOrc  greenOrc = listIterator3.next();
//            ImageView greenOrcImageView = greenOrc.getImageView();
//            if(greenOrcImageView.getLayoutX()<0){
//                index3 += 1;
//            }
//            greenOrcImageView.setLayoutX(greenOrcImageView.getLayoutX()-170);
//        }
//
//        while (listIterator4.hasNext()){
//            Coin coin = listIterator4.next();
//            ImageView coinImageView = coin.getImageView();
//            if(coinImageView.getLayoutX()<0){
//                index4 += 1;
//            }
//            coinImageView.setLayoutX(coinImageView.getLayoutX()-170);
//        }
//
//        while (listIterator5.hasNext()){
//            ChestType chest = listIterator5.next();
//            ImageView chestImageView = chest.getImageView();
//            if(chestImageView.getLayoutX()<0){
//                index5 += 1;
//            }
//            chestImageView.setLayoutX(chestImageView.getLayoutX()-170);
//        }
//        for (int i = 0; i < index1; i++) {
//            tntObjects.remove(0);
//        }
//        for (int i = 0; i < index2; i++) {
//            redOrcs.get(0).terminateJump();
//            redOrcs.remove(0);
//        }
//        for (int i = 0; i < index3; i++) {
//            greenOrcs.get(0).terminateJump();
//            greenOrcs.remove(0);
//        }
//        for (int i = 0; i < index4; i++) {
//            coins.remove(0);
//        }
//        for (int i = 0; i < index5; i++) {
//            chestTypeObjects.remove(0);
//        }
//    }
//
//    public void setChestObjects(ChestType chest){
//        chestTypeObjects.add(chest);
//    }
//
//    public void setTntObjects(TNT tnt){
//        tntObjects.add(tnt);
//    }
//
//    public void setCoinObjects(Coin coin){
//        coins.add(coin);
//    }
//
//    public void setRedOrcObjects(RedOrc redOrc){
//        redOrcs.add(redOrc);
//    }
//
//    public void setGreenOrcObjects(GreenOrc greenOrc){
//        greenOrcs.add(greenOrc);
//    }
//
//    public void updateCoin(int change){
//        System.out.println("updating the coin");
//        nOfCoinsAmount += change;
//        nOfCoins.setText(String.valueOf(nOfCoinsAmount));
//    }
//
//    public void loadImage( ChestType chestType){
//        chestType.generateTransition();
//    }
//
//    public ImageView getCoinSymbol(){
//        return coinSymbol;
//    }
//
//    public int getHeightOfIslands(String imageName){
//        return heightOfIslands.get(imageName);
//    }
//
//    public int getWidthOfIslands(String imageName){
//        return widthOfIslands.get(imageName);
//    }
//
//    public int getXOfPlatformForBoss(){
//        return (int)island5.getLayoutX();
//    }
//
//    public void checkCollisionWithChestAndPlayer(){
//
//        timer1 = new Timer();
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                int index = 0;
//                //double player.getBoundsInParent().getMinX() = player.getBoundsInParent().getMinX();
//                //double player.getBoundsInParent().getMaxX() = player.getBoundsInParent().getMaxX();
//                if(chestTypeObjects.size()>0) {
//                    System.out.println("size of chestType:"+chestTypeObjects.size());
//                    ListIterator<ChestType> listIterator = chestTypeObjects.listIterator();
//                    while (listIterator.hasNext()) {
//                        ChestType chestType = listIterator.next();
//                        if(!chestType.isCollided()) {
//                            ImageView chestTypeImageView = chestType.getImageView();
//                            //double chestTypeImageView.getBoundsInParent().getMaxX() = chestTypeImageView.getBoundsInParent().getMaxX();
//                            //double chestTypeImageView.getBoundsInParent().getMinX() = chestTypeImageView.getBoundsInParent().getMinX();
//                            if (player.getBoundsInParent().getMaxX() >= chestTypeImageView.getBoundsInParent().getMinX()) {
//                                if (player.getBoundsInParent().getMinX() <= chestTypeImageView.getBoundsInParent().getMaxX()) {
//                                    if (player.getBoundsInParent().getMaxY() >= chestTypeImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() <= chestTypeImageView.getBoundsInParent().getMaxY()) {
//                                        chestType.setCollided(true);
//                                        chestType.open(playerObj);
//                                        //loadImage(chestType);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        };
//        timer1.scheduleAtFixedRate(task, 1500, 100);
//    }
//
//    //OLD ONE
////      public void checkCollisionWithChestAndPlayer(){
////
////        timer1 = new Timer();
////        TimerTask task = new TimerTask() {
////            @Override
////            public void run() {
////                int index = 0;
////                double playerXFront = player.getBoundsInParent().getMinX();
////                double playerXLast = player.getBoundsInParent().getMaxX();
////                if(chestTypeObjects.size()>0) {
////                    System.out.println("size of chestType:"+chestTypeObjects.size());
////                    ListIterator<ChestType> listIterator = chestTypeObjects.listIterator();
////                    while (listIterator.hasNext()) {
////                        ChestType chestType = listIterator.next();
////                        if(!chestType.isCollided()) {
////                            ImageView chestTypeImageView = chestType.getImageView();
////                            double chestTypeImageViewXLast = chestTypeImageView.getBoundsInParent().getMaxX();
////                            double chestTypeImageViewXFront = chestTypeImageView.getBoundsInParent().getMinX();
////                            if (playerXLast >= chestTypeImageViewXFront) {
////                                if (playerXFront <= chestTypeImageViewXLast) {
////                                    if (player.getBoundsInParent().getMaxY() >= chestTypeImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() <= chestTypeImageView.getBoundsInParent().getMaxY()) {
////                                        chestType.setCollided(true);
////                                        chestType.open(playerObj);
////                                        //loadImage(chestType);
////                                    }
////                                }
////                            }
////                        }
////                    }
////                }
////            }
////        };
////        timer1.scheduleAtFixedRate(task, 1500, 100);
////    }
//
//    public void checkCollisionOfPlayerWithTnt(){
//        timer2 = new Timer();
//        TimerTask task2 = new TimerTask() {
//            @Override
//            public void run() {
//                int index2 = 0;
//                //double player.getBoundsInParent().getMinX() = player.getBoundsInParent().getMinX();
//                //double player.getBoundsInParent().getMaxX() = player.getBoundsInParent().getMaxX();
//                if(tntObjects.size()>0){
//                    System.out.println("size of tnt:"+tntObjects.size());
//                    ListIterator<TNT> listIterator = tntObjects.listIterator();
//                    while (listIterator.hasNext()) {
//                        TNT tnt = listIterator.next();
//                        if(!tnt.isCollided()) {
//                            ImageView tntImageView = tnt.getImageView();
//                            //double tntImageView.getBoundsInParent().getMinX() = tntImageView.getBoundsInParent().getMinX();
//                            //double tntImageView.getBoundsInParent().getMaxX() = tntImageView.getBoundsInParent().getMaxX();
//                            if (player.getBoundsInParent().getMaxX() >= tntImageView.getBoundsInParent().getMinX()) {
//                                if (player.getBoundsInParent().getMinX() <= tntImageView.getBoundsInParent().getMaxX()) {
//                                    if (player.getBoundsInParent().getMaxY() >= tntImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() <= tntImageView.getBoundsInParent().getMaxY()) {
//                                        tnt.setCollided(true);
//                                        tnt.initiate();
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//
//            }
//        };
//        timer2.scheduleAtFixedRate(task2, 2000, 100);
//    }
//
//
//    //OLD ONE
////     public void checkCollisionOfPlayerWithTnt(){
////        timer2 = new Timer();
////        TimerTask task2 = new TimerTask() {
////            @Override
////            public void run() {
////                int index2 = 0;
////                double playerXFront = player.getBoundsInParent().getMinX();
////                double playerXLast = player.getBoundsInParent().getMaxX();
////                if(tntObjects.size()>0){
////                    System.out.println("size of tnt:"+tntObjects.size());
////                    ListIterator<TNT> listIterator = tntObjects.listIterator();
////                    while (listIterator.hasNext()) {
////                        TNT tnt = listIterator.next();
////                        if(!tnt.isCollided()) {
////                            ImageView tntImageView = tnt.getImageView();
////                            double tntImageViewXFront = tntImageView.getBoundsInParent().getMinX();
////                            double tntImageViewXLast = tntImageView.getBoundsInParent().getMaxX();
////                            if (playerXLast >= tntImageViewXFront) {
////                                if (playerXFront <= tntImageViewXLast) {
////                                    if (player.getBoundsInParent().getMaxY() >= tntImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() <= tntImageView.getBoundsInParent().getMaxY()) {
////                                        tnt.setCollided(true);
////                                        tnt.initiate();
////                                    }
////                                }
////                            }
////                        }
////                    }
////                }
////
////            }
////        };
////        timer2.scheduleAtFixedRate(task2, 2000, 100);
////    }
//
//
//    public void checkCollisionOfPlayerWithCoin(){
//        System.out.println("in pc");
//        timer3 = new Timer();
//        TimerTask task3 = new TimerTask() {
//            @Override
//            public void run() {
//                int index2 = 0;
//                //double player.getBoundsInParent().getMinX() = player.getBoundsInParent().getMinX();
//                //double player.getBoundsInParent().getMaxX() = player.getBoundsInParent().getMaxX();
//                if(tntObjects.size()>0){
//                    System.out.println("size of coins:"+coins.size());
//                    ListIterator<Coin> listIterator = coins.listIterator();
//                    while (listIterator.hasNext()) {
//                        Coin coin = listIterator.next();
//                        ImageView coinImageView = coin.getImageView();
//                        //double coinImageView.getBoundsInParent().getMinX() = coinImageView.getBoundsInParent().getMinX();
//                        //double coinImageView.getBoundsInParent().getMaxX() = coinImageView.getBoundsInParent().getMaxX();
//                        if(!coin.isCollided()) {
//                            if (player.getBoundsInParent().getMaxX() >= coinImageView.getBoundsInParent().getMinX()) {
//                                if (player.getBoundsInParent().getMinX() <= coinImageView.getBoundsInParent().getMaxX()) {
//                                    if (player.getBoundsInParent().getMaxY() >= coinImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() <= coinImageView.getBoundsInParent().getMaxY()) {
//                                        coin.setCollided(true);
//                                        updateCoin(1);
//                                        playerObj.getCoins(1);
//                                        coin.fade();
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        };
//        timer3.scheduleAtFixedRate(task3, 500, 100);
//    }
//
//    //|OLD ONe
////      public void checkCollisionOfPlayerWithCoin(){
////        System.out.println("in pc");
////        timer3 = new Timer();
////        TimerTask task3 = new TimerTask() {
////            @Override
////            public void run() {
////                int index2 = 0;
////                double playerXFront = player.getBoundsInParent().getMinX();
////                double playerXLast = player.getBoundsInParent().getMaxX();
////                if(tntObjects.size()>0){
////                    System.out.println("size of coins:"+coins.size());
////                    ListIterator<Coin> listIterator = coins.listIterator();
////                    while (listIterator.hasNext()) {
////                        Coin coin = listIterator.next();
////                        ImageView coinImageView = coin.getImageView();
////                        double coinImageViewXFront = coinImageView.getBoundsInParent().getMinX();
////                        double coinImageViewXLast = coinImageView.getBoundsInParent().getMaxX();
////                        if(!coin.isCollided()) {
////                            if (playerXLast >= coinImageViewXFront) {
////                                if (playerXFront <= coinImageViewXLast) {
////                                    if (player.getBoundsInParent().getMaxY() >= coinImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() <= coinImageView.getBoundsInParent().getMaxY()) {
////                                        coin.setCollided(true);
////                                        updateCoin(1);
////                                        playerObj.getCoins(1);
////                                        coin.fade();
////                                    }
////                                }
////                            }
////                        }
////                    }
////                }
////            }
////        };
////        timer3.scheduleAtFixedRate(task3, 500, 100);
////    }
//
//    public void checkCollisionOfPlayerWithGreenOrc(){
//        System.out.println("in green p");
//        Timer timer4 = new Timer();
//        TimerTask task4 = new TimerTask() {
//            @Override
//            public void run() {
//                int index = 0;
//                //double player.getBoundsInParent().getMinX() = player.getBoundsInParent().getMinX();
//                //double player.getBoundsInParent().getMaxX() = player.getBoundsInParent().getMaxX();
//                //double player.getBoundsInParent().getMinY() = player.getBoundsInParent().getMinY();
//                //double player.getBoundsInParent().getMaxY() = player.getBoundsInParent().getMaxY();
//                if(greenOrcs.size()>0) {
//                    ListIterator<GreenOrc> listIterator4 = greenOrcs.listIterator();
//                    System.out.println("size of gOrc:"+greenOrcs.size());
//                    while (listIterator4.hasNext()) {
//                        GreenOrc gOrc = listIterator4.next();
//                        if (!gOrc.isCollided()) {
//                            ImageView greenOrcImageView = gOrc.getImageView();
//                            //double greenOrcImageView.getBoundsInParent().getMaxX() = greenOrcImageView.getBoundsInParent().getMaxX();
//                            //double greenOrcImageView.getBoundsInParent().getMinX() = greenOrcImageView.getBoundsInParent().getMinX();
//                            //double greenOrcImageView.getBoundsInParent().getMaxY() = greenOrcImageView.getBoundsInParent().getMaxY();
//                            //double greenOrcImageView.getBoundsInParent().getMinY() = greenOrcImageView.getBoundsInParent().getMinY();
//                            if (player.getBoundsInParent().getMinX() <= greenOrcImageView.getBoundsInParent().getMaxX()) {
//                                if (player.getBoundsInParent().getMaxX() >= greenOrcImageView.getBoundsInParent().getMinX()) {
//                                    if (player.getBoundsInParent().getMaxY() >= greenOrcImageView.getBoundsInParent().getMinY()) {
//                                        gOrc.slide();
//                                        gOrc.setCollided(true);
//                                    }
//                                }
//                            } else if (player.getBoundsInParent().getMinY() <= greenOrcImageView.getBoundsInParent().getMaxY()) {
//                                gOrc.killPlayer(playerObj);
//                                gOrc.setCollided(true);
//                            }
////                            if (playerXLast >= greenOrcImageViewXFront && playerXFront <= greenOrcImageViewXLast) {
////                                if (playerXLast < greenOrcImageViewXFront + 10) {
////                                    if ((playerYTop >= greenOrcImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMaxY() <= greenOrcImageViewYBottom) || (playerYTop <= greenOrcImageViewYTop && playerYBottom >= greenOrcImageViewYBottom)) {
////                                        gOrc.slide();
////                                    }
////                                } else if (playerYTop <= greenOrcImageViewYBottom && playerYBottom >= greenOrcImageViewYTop) {
////                                    gOrc.killPlayer(playerObj);
////                                }
////                                gOrc.setCollided(true);
////                            }
//                        }
//                    }
//                }
//            }
//        };
//        timer4.scheduleAtFixedRate(task4, 1000, 100);
//    }
//
//    public void checkCollisionOfPlayerWithRedOrc(){
//        Timer timer5 = new Timer();
//        TimerTask task5 = new TimerTask() {
//            @Override
//            public void run() {
//                int index = 0;
//                //double player.getBoundsInParent().getMinX() = player.getBoundsInParent().getMinX();
//                //double player.getBoundsInParent().getMaxX() = player.getBoundsInParent().getMaxX();
//                //double player.getBoundsInParent().getMinY() = player.getBoundsInParent().getMinY();
//                //double player.getBoundsInParent().getMaxY() = player.getBoundsInParent().getMaxY();
//                if(redOrcs.size()>0) {
//                    ListIterator<RedOrc> listIterator4 = redOrcs.listIterator();
//                    System.out.println("size of gOrc:"+redOrcs.size());
//                    while (listIterator4.hasNext()) {
//                        RedOrc rOrc = listIterator4.next();
//                        if (!rOrc.isCollided()) {
//                            ImageView redOrcImageView = rOrc.getImageView();
//                            //double redOrcImageView.getBoundsInParent().getMaxX() = redOrcImageView.getBoundsInParent().getMaxX();
//                            //double redOrcImageView.getBoundsInParent().getMinX() = redOrcImageView.getBoundsInParent().getMinX();
//                            //double redOrcImageView.getBoundsInParent().getMaxY() = redOrcImageView.getBoundsInParent().getMaxY();
//                            //double redOrcImageView.getBoundsInParent().getMinY() = redOrcImageView.getBoundsInParent().getMinY();
//                            if (player.getBoundsInParent().getMinX() <= redOrcImageView.getBoundsInParent().getMaxX()) {
//                                if (player.getBoundsInParent().getMaxX() >= redOrcImageView.getBoundsInParent().getMinX()) {
//                                    if (player.getBoundsInParent().getMaxY() >= redOrcImageView.getBoundsInParent().getMinY()) {
//                                        rOrc.slide();
//                                        rOrc.setCollided(true);
//                                    }
//                                }
//                            } else if (player.getBoundsInParent().getMinY() <= redOrcImageView.getBoundsInParent().getMaxY()) {
//                                rOrc.killPlayer(playerObj);
//                                rOrc.setCollided(true);
//                            }
////                            if (playerXLast >= greenOrcImageViewXFront && playerXFront <= greenOrcImageViewXLast) {
////                                if (playerXLast < greenOrcImageViewXFront + 10) {
////                                    if ((playerYTop >= greenOrcImageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMaxY() <= greenOrcImageViewYBottom) || (playerYTop <= greenOrcImageViewYTop && playerYBottom >= greenOrcImageViewYBottom)) {
////                                        gOrc.slide();
////                                    }
////                                } else if (playerYTop <= greenOrcImageViewYBottom && playerYBottom >= greenOrcImageViewYTop) {
////                                    gOrc.killPlayer(playerObj);
////                                }
////                                gOrc.setCollided(true);
////                            }
//                        }
//                    }
//                }
//            }
//        };
//        timer5.scheduleAtFixedRate(task5, 1000, 100);
//    }
//
//    //OLD ONE
////      public void checkCollisionOfPlayerWithRedOrc(){
////        System.out.println("in red p");
////        Timer timer5 = new Timer();
////        TimerTask task5 = new TimerTask() {
////            @Override
////            public void run() {
////                int index = 0;
////                double playerXFront = player.getBoundsInParent().getMinX();
////                double playerXLast = player.getBoundsInParent().getMaxX();
////                double playerYTop = player.getBoundsInParent().getMinY();
////                double playerYBottom = player.getBoundsInParent().getMaxY();
////                if (redOrcs.size() > 0) {
////                    System.out.println("size of rOrcs:"+redOrcs.size());
////                    ListIterator<RedOrc> listIterator4 = redOrcs.listIterator();
////                    while (listIterator4.hasNext()) {
////                        RedOrc rOrc = listIterator4.next();
////                        if(!rOrc.isCollided()) {
////                            ImageView redOrcImageView = rOrc.getImageView();
////                            double redOrcImageViewXLast = redOrcImageView.getBoundsInParent().getMaxX();
////                            double redOrcImageViewXFront = redOrcImageView.getBoundsInParent().getMinX();
////                            double redOrcImageViewYTop = redOrcImageView.getBoundsInParent().getMinY();
////                            double redOrcImageViewYBottom = redOrcImageView.getBoundsInParent().getMaxY();
////                            if (playerXFront <= redOrcImageViewXLast) {
////                                if (playerXLast >= redOrcImageViewXFront) {
////                                    if (player.getBoundsInParent().getMaxY() >= redOrcImageView.getBoundsInParent().getMinY()) {
////                                        rOrc.slide();
////                                        rOrc.setCollided(true);
////                                    }
////                                }
////                            } else if (playerYTop <= redOrcImageViewYBottom) {
////                                rOrc.killPlayer(playerObj);
////                                rOrc.setCollided(true);
////                            }
////
//////                            if (playerXLast >= redOrcImageViewXFront && playerXFront <= redOrcImageViewXLast) {
//////                                if (playerXLast < redOrcImageViewXFront + 50) {
//////                                    if ((playerYTop >= redOrcImageViewYTop && playerYBottom <= redOrcImageViewYBottom) || (playerYTop <= redOrcImageViewYTop && playerYBottom >= redOrcImageViewYBottom)) {
//////                                        rOrc.slide();
//////                                    }
//////                                } else if (playerYTop <= redOrcImageViewYBottom && playerYBottom >= redOrcImageViewYTop) {
//////                                    rOrc.killPlayer(playerObj);
//////                                }
////                                //rOrc.setCollided(true);
//////                            }
////                        }
////                    }
////                }
////            }
////        };
////        timer5.scheduleAtFixedRate(task5, 1000, 100);
////
////    }
//
//    public void checkCollisionOfEntitiesAndFire(ImageView imageView) {
//        System.out.println("ion e and F");
////        while (imageView.getOpacity()!=0){
//        if (player.getBoundsInParent().getMaxX() > imageView.getBoundsInParent().getMinX() && player.getBoundsInParent().getMinX() < imageView.getBoundsInParent().getMaxX()
//                && player.getBoundsInParent().getMaxY() > imageView.getBoundsInParent().getMinY() && player.getBoundsInParent().getMinY() < imageView.getBoundsInParent().getMaxY()) {
//            playerObj.burnt();
//        } else {
//            ListIterator<GreenOrc> listIterator1 = greenOrcs.listIterator();
//            ListIterator<RedOrc> listIterator2 = redOrcs.listIterator();
//            while (listIterator1.hasNext()) {
//                GreenOrc greenOrc = listIterator1.next();
//                ImageView temp = greenOrc.getImageView();
//                if (temp.getBoundsInParent().getMaxX() > imageView.getBoundsInParent().getMinX() && temp.getBoundsInParent().getMinX() < imageView.getBoundsInParent().getMaxX()
//                        && temp.getBoundsInParent().getMaxY() > imageView.getBoundsInParent().getMinY() && temp.getBoundsInParent().getMinY() < imageView.getBoundsInParent().getMaxY()) {
//                    greenOrc.burnt();
//                }
//            }
//            while (listIterator2.hasNext()) {
//                RedOrc redOrc = listIterator2.next();
//                ImageView temp = redOrc.getImageView();
//                if (temp.getBoundsInParent().getMaxX() > imageView.getBoundsInParent().getMinX() && temp.getBoundsInParent().getMinX() < imageView.getBoundsInParent().getMaxX()
//                        && temp.getBoundsInParent().getMaxY() > imageView.getBoundsInParent().getMinY() && temp.getBoundsInParent().getMinY() < imageView.getBoundsInParent().getMaxY()) {
//                    redOrc.burnt();
//                }
//            }
//        }
////     }
//    }
//
//
//
//}
//
//

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


//
//    public void jump(ImageView imageView, int sub, int gainedUpHeight, boolean flag4Up) throws InterruptedException {
//        boolean flag = false;
//        double imageViewPosFront = imageView.getBoundsInParent().getMinX();
//        double imageViewPosLast =imageView.getBoundsInParent().getMaxX();
//        if(imageView.getBoundsInParent().getMinX()>1500){
//            gameOver();
//        }
//        if(imageView.getBoundsInParent().getMaxY()>520){
//            if(obj.getClass().getName().equals("Player")){
//                if(player.getLayoutY()>739){
//                    gameOver();
//                }else{
//                    playerFalls = true;
//                }
//            }
//        }else if(!flag4Up){
//            try {
//                if (imageViewPosFront >= island1.getBoundsInParent().getMinX() && imageViewPosFront <= island1.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island1.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf1.getText()))) {
//                    flag = true;
//                } else if (imageViewPosFront >= island2.getBoundsInParent().getMinX() && imageViewPosFront <= island2.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island2.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf2.getText()))) {
//                    flag = true;
//                } else if (imageViewPosFront >= island3.getBoundsInParent().getMinX() && imageViewPosFront <= island3.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island3.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf3.getText()))) {
//                    flag = true;
//                } else if (imageViewPosFront >= island4.getBoundsInParent().getMinX() && imageViewPosFront <= island4.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island4.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf4.getText()))) {
//                    flag = true;
//                } else if (imageViewPosFront >= island5.getBoundsInParent().getMinX() && imageViewPosFront <= island5.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island5.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf5.getText()))) {
//                    flag = true;
//                } else if (imageViewPosFront >= island6.getBoundsInParent().getMinX() && imageViewPosFront <= island6.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText()))) {
//                    flag = true;
//                }
//            }catch (IndexOutOfBoundsException e){
//                System.out.println("c");
//            }
//        }else if(flag4Up){
//
//        }
//        if(flag || flag4Up){
//            if(obj.getClass().getName().equals("Player")){
//                Player p = (Player) obj;
//                p.setGainedUpHeight(gainedUpHeight+sub);
//            }else{
//                Enemy e = (Enemy) obj;
//                e.setGainedUpHeight(gainedUpHeight+sub);
//            }
//            imageView.setLayoutY(imageView.getBoundsInParent().getMinY() - sub);
//        }else{
//            imageView.setLayoutY(imageView.getBoundsInParent().getMinY() + sub);
//        }
//    }


//    public void jump() throws InterruptedException {
//        timer0 = new Timer();
//        TimerTask task1 = new TimerTask() {
//            boolean flag = false;
//            @Override
//            public void run() {
////                double playerPosFront = player.getBoundsInParent().getMinX();
////                double playerPosLast =player.getBoundsInParent().getMaxX();
////                if(player.getBoundsInParent().getMinX()>1500){
////                    gameOver();
////                }
////                if(player.getBoundsInParent().getMaxY()>520){
////                    if(player.getLayoutY()>739){
////                        gameOver();
////                    }else{
////                        playerFalls = true;
////                    }
////                }else {
////                    try {
////                        if (playerPosFront >= island1.getBoundsInParent().getMinX() && playerPosFront <= island1.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island1.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf1.getText()))) {
////                            flag = true;
////                        } else if (playerPosFront >= island2.getBoundsInParent().getMinX() && playerPosFront <= island2.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island2.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf2.getText()))) {
////                            flag = true;
////                        } else if (playerPosFront >= island3.getBoundsInParent().getMinX() && playerPosFront <= island3.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island3.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf3.getText()))) {
////                            flag = true;
////                        } else if (playerPosFront >= island4.getBoundsInParent().getMinX() && playerPosFront <= island4.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island4.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf4.getText()))) {
////                            flag = true;
////                        } else if (playerPosFront >= island5.getBoundsInParent().getMinX() && playerPosFront <= island5.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island5.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf5.getText()))) {
////                            flag = true;
////                        } else if (playerPosFront >= island6.getBoundsInParent().getMinX() && playerPosFront <= island6.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText()))) {
////                            flag = true;
////                        }
////                    }catch (IndexOutOfBoundsException e){
////                        System.out.println("c");
////                    }
////                    if (flag) {
////                        for (int i = 0; i < 10; i++) {
////                            player.setLayoutY(player.getBoundsInParent().getMinY() - 10);
////                        }
////                    }
////                }
////                System.out.println("before incrementing the miny:"+player.getBoundsInParent().getMinY());
////                player.setLayoutY(player.getBoundsInParent().getMinY() + 10);
////                System.out.println("bafter incrementing the miny:"+player.getBoundsInParent().getMinY());
////                flag = false;
//            }
//        };
//        timer0.scheduleAtFixedRate(task1, 500, 100);
//    }