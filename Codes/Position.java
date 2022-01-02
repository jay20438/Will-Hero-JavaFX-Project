package com.example.willherojavafxproject;
import java.io.Serializable;
import java.net.URL;
import java.util.*;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;

public class Position implements Initializable, Serializable {
    private String[] namesOfIslands;
    private double[] coordinatesOfAnchorPane;
    private double[] coordinatesOfbG;
    private String[] textFieldData;
    private HashMap<String, Integer> widthOfIslands;
    private HashMap<String, Integer> heightOfIslands;
    private HashMap<String, Integer> depthOfBaseOfIslands;
    private HashMap<String, String[]> islandsCoordinateInfo;
    private ArrayList<ChestType> chestTypeObjects;
    private ArrayList<TNT> tntObjects;
    private ArrayList<RedOrc> redOrcs;
    private ArrayList<GreenOrc> greenOrcs;
    private ArrayList<Coin> coins;
    private Random random;
    private FxmlLoader fxmlLoader;
    private transient Timer timer1;
    private transient Timer timer2;
    private transient Timer timer3;
    private transient Timer timer4;
    private transient Timer timer5;
    private transient Timer timer6;
    private int nOfCoinsAmount;
    private int noOfFramesCreated;
    private CreateEntity createEntity;
    private boolean playerFalls;
    private int nOfClick;
    boolean flagToStopCreating = true;
    private Boss boss;
    private Player playerObj;
    private boolean flagForBossLoaded;
    private Homepage homepage;
    private boolean gameOver;

    public Position(Player player, Homepage homepage){
        gameOver = false;
        this.homepage = homepage;
        playerObj = player;
        tntObjects = new ArrayList<>();
        redOrcs = new ArrayList<>();
        greenOrcs = new ArrayList<>();
        coins = new ArrayList<>();
        chestTypeObjects = new ArrayList<>();
        fxmlLoader = new FxmlLoader();
        random = new Random();
        widthOfIslands = new HashMap<>();
        heightOfIslands = new HashMap<>();
        depthOfBaseOfIslands = new HashMap<>();
        islandsCoordinateInfo = new HashMap<>();
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
        depthOfBaseOfIslands.put("platform4Boss", 111);
        noOfFramesCreated = 0;
        playerFalls = false;
        flagForBossLoaded = false;
        nOfCoinsAmount = 0;
        nOfClick = 0;
        timer6 = new Timer();
        //coordinatesOfAnchorAndBg = new int[2][4];
    }



    @FXML
    private transient ImageView coinSymbol;

    @FXML
    private transient TextField nOfCoins;

    @FXML
    private transient TextField nOfSteps;

    @FXML
    private transient ImageView background;

    @FXML
    private transient ImageView island1;

    @FXML
    private transient ImageView island2;

    @FXML
    private transient ImageView island3;

    @FXML
    private transient ImageView island4;

    @FXML
    private transient ImageView island5;

    @FXML
    private transient ImageView island6;

    @FXML
    private transient ImageView player;

    @FXML
    private transient AnchorPane mainAnchorPane;

    @FXML
    private transient TextField tf1;

    @FXML
    private transient TextField tf2;

    @FXML
    private transient TextField tf3;

    @FXML
    private transient TextField tf4;

    @FXML
    private transient TextField tf5;

    @FXML
    private transient TextField tf6;

    @FXML
    private transient ImageView tnt;



    @FXML
    void moveContent(MouseEvent event) throws FileNotFoundException, InterruptedException {
        if(playerObj.isLiving() && !playerFalls){
            nOfClick += 1;
            nOfSteps.setText(String.valueOf(nOfClick));
            playerObj.throwWeapon();
        }

        if(nOfClick>120 && island6.getBoundsInParent().getMaxX()<1408){
            if(!playerFalls)
                createEntity = new CreateEntity(this, mainAnchorPane);
                player.setLayoutX(player.getLayoutX() + 150);
                if(player.getBoundsInParent().getMaxX()>island5.getLayoutX() && !flagForBossLoaded){
                    flagForBossLoaded = true;
                    boss = createEntity.createBoss((int) (island5.getLayoutX()+200 + random.nextInt((int)island5.getFitWidth()-200-171)), island5.getLayoutY()+20, island6.getBoundsInParent().getMaxX()-10);
                    boss.bringDownBoss((double)island5.getLayoutY());
                }
        }else if(!playerFalls && playerObj.isLiving()) {
            moveEntities();
            if(flagToStopCreating) {
                if (nOfClick > 114) {
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
                        //bcreateEntity.create(island1);
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
        if (gameOver) {
            FxmlLoader fxmlLoader = new FxmlLoader();
            GameOutcome gm = null;
            if (playerObj.getGameStatusWin()) {
                gm = new GameOutcome("You win the Game!!", String.valueOf(nOfClick), String.valueOf(nOfCoinsAmount), homepage);
            } else {
                gm = new GameOutcome("You loose the Game!!", String.valueOf(nOfClick), String.valueOf(nOfCoinsAmount), homepage);
            }
            HelloApplication.setDifferentScene(fxmlLoader.getScene("gameOutcome", gm, "GameOutcome"));
        }
    }

    public void createIsland(int identifier, ImageView imageView1, ImageView imageView2, ImageView imageView3) throws FileNotFoundException {
        int randNo1 = random.nextInt(6);
        int randNo2 = random.nextInt( 6);
        int randNo3 = random.nextInt( 6);
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
            if (!homepage.getGame().getLoadedGame() && !homepage.getGame().getResumedGame()) {
                createEntity = new CreateEntity(this, mainAnchorPane);
                try {
                    createEntity.formPlayerImage(playerObj);
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
                    createEntity = new CreateEntity(this, mainAnchorPane);
                    createEntity.create(island4);
                    createEntity = new CreateEntity(this, mainAnchorPane);
                    createEntity.create(island5);
                    createEntity = new CreateEntity(this, mainAnchorPane);
                    createEntity.create(island6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                island1.setLayoutX(-1000);
                island2.setLayoutX(-1000);
                island3.setLayoutX(-1000);
                island4.setLayoutX(-1000);
                island5.setLayoutX(-1000);
                island6.setLayoutX(-1000);
                reviveEverything();
            }
            checkCollisionOfPlayerWithCoin();
            checkCollisionWithChestAndPlayer();
            checkCollisionOfPlayerWithRedOrc();
            checkCollisionOfPlayerWithGreenOrc();
            checkCollisionOfPlayerWithTnt();
//        }
    }


      synchronized public void  jump(ImageView imageView, Object obj, int sub, boolean flag4Up, boolean living) throws InterruptedException {
        boolean flag = false;
            try {
                if (imageView.getBoundsInParent().getMaxY() > 520) {
                    if (obj.getClass().getName().equals("com.example.willherojavafxproject.Player")) {
                        if (player.getLayoutY() > 736) {
                            playerObj.changeStatusOfLiving(false);
                            gameOver();
                        } else {
                            playerFalls = true;
                        }
                    }
                } else if (!flag4Up) {
                    if (imageView.getBoundsInParent().getMaxX() >= island1.getBoundsInParent().getMinX() && imageView.getBoundsInParent().getMinX() <= island1.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island1.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf1.getText()))) {
                        flag = true;
                    } else if (imageView.getBoundsInParent().getMaxX() >= island2.getBoundsInParent().getMinX() && imageView.getBoundsInParent().getMinX() <= island2.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island2.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf2.getText()))) {
                        flag = true;
                    } else if (imageView.getBoundsInParent().getMaxX() >= island3.getBoundsInParent().getMinX() && imageView.getBoundsInParent().getMinX() <= island3.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island3.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf3.getText()))) {
                        flag = true;
                    } else if (imageView.getBoundsInParent().getMaxX() >= island4.getBoundsInParent().getMinX() && imageView.getBoundsInParent().getMinX() <= island4.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island4.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf4.getText()))) {
                        flag = true;
                    } else if (imageView.getBoundsInParent().getMaxX() >= island5.getBoundsInParent().getMinX() && imageView.getBoundsInParent().getMinX() <= island5.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island5.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf5.getText()))) {
                        flag = true;
                    } else if (imageView.getBoundsInParent().getMaxX() >= island6.getBoundsInParent().getMinX() && imageView.getBoundsInParent().getMinX() <= island6.getBoundsInParent().getMaxX() && imageView.getBoundsInParent().getMaxY() > (island6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText()))) {
                        flag = true;
                    }
                }
            }catch(IndexOutOfBoundsException e){
            }
            if (flag || flag4Up) {
                flag4Up = true;
                if (obj.getClass().getName().equals("com.example.willherojavafxproject.Player")) {
                    Player p = (Player) obj;
                    if (living) {
                        p.setGainedUpHeight(p.getGainedUpHeight() + sub);
                    }
                    if (flag && !living) {
                        p.terminateJump();
                        gameOver();
                    }
                } else if (obj.getClass().getName().equals("com.example.willherojavafxproject.RedOrc") || obj.getClass().getName().equals("com.example.willherojavafxproject.GreenOrc") || obj.getClass().getName().equals("com.example.willherojavafxproject.Boss")) {
                    Enemy e = (Enemy) obj;
                    if (living) {
                        e.setGainedUpHeight(e.getGainedUpHeight() + sub);
                    }
                    if (flag && !living) {
                        e.terminateJump();
                    }
                }
                if (living) {
                    imageView.setLayoutY(imageView.getBoundsInParent().getMinY() - sub);
                }
            }
            if (!flag4Up) {
                imageView.setLayoutY(imageView.getBoundsInParent().getMinY() + sub);
            }
    }



    public void gameOver() throws InterruptedException {
        if(playerObj.isLiving()) {
            terminateJumpOfAllOrcs();
            if(boss!=null){
                boss.terminateJump();
            }
        }else{
            gameOver = true;
        }
        playerObj.terminateJump();

    }

    public void terminateJumpOfAllOrcs(){
        ListIterator<RedOrc> listIterator1 = redOrcs.listIterator();
        ListIterator<GreenOrc> listIterator2 = greenOrcs.listIterator();
        while (listIterator1.hasNext()){
            RedOrc redOrc = listIterator1.next();
            redOrc.terminateJump();
        }

        while (listIterator2.hasNext()){
            GreenOrc  greenOrc = listIterator2.next();
            greenOrc.terminateJump();
        }
    }

    @FXML
    void goToSettings(MouseEvent event) throws InterruptedException {
        homepage.getGame().pauseGame(event);
    }



    public void startJumpsOfAllOrcs() throws InterruptedException {
        ListIterator<RedOrc> listIterator1 = redOrcs.listIterator();
        ListIterator<GreenOrc> listIterator2 = greenOrcs.listIterator();
        while (listIterator1.hasNext()){
            RedOrc redOrc = listIterator1.next();
            redOrc.jump();
        }

        while (listIterator2.hasNext()){
            GreenOrc  greenOrc = listIterator2.next();
            greenOrc.jump();
        }
    }

    public void makeAllTimerCancel() throws InterruptedException {
        try {
            timer1.cancel();
            timer2.cancel();
            timer3.cancel();
            timer4.cancel();
            timer5.cancel();
            if (boss != null) {
                timer6.cancel();
                boss.terminateJump();
                boss.terminateMoveLeft();
            }
            terminateJumpOfAllOrcs();
            playerObj.terminateJump();
        }catch (NullPointerException e){}
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
        return 0;

    }

    public int getDepthOfBaseOfIsland(String name){
        return (int)depthOfBaseOfIslands.get(name);
    }

    public void stopBossMoving(){
        boss.terminateMoveLeft();
    }

    public void moveEntities(){
        int index1 = -1;
        int index2 = -1;
        int index3 = -1;
        int index4 = -1;
        int index5 = -1;
        player.setLayoutX(160);
        island1.setLayoutX(island1.getLayoutX() - 170);
        island2.setLayoutX(island2.getLayoutX() - 170);
        island3.setLayoutX(island3.getLayoutX() - 170);
        island4.setLayoutX(island4.getLayoutX() - 170);
        island5.setLayoutX(island5.getLayoutX() - 170);
        island6.setLayoutX(island6.getLayoutX() - 170);
        ListIterator<TNT> listIterator1 = tntObjects.listIterator();
        ListIterator<RedOrc> listIterator2 = redOrcs.listIterator();
        ListIterator<GreenOrc> listIterator3 = greenOrcs.listIterator();
        ListIterator<Coin> listIterator4 = coins.listIterator();
        ListIterator<ChestType> listIterator5 = chestTypeObjects.listIterator();
        while (listIterator1.hasNext()){
            TNT tnt = listIterator1.next();
            ImageView tntImageView = tnt.getImageView();
            if(tntImageView.getBoundsInParent().getMaxX()<0){
                index1 += 1;
            }else {
                tntImageView.setLayoutX(tntImageView.getLayoutX() - 170);
            }
        }
        while (listIterator2.hasNext()){
            RedOrc redOrc = listIterator2.next();
            ImageView redOrcImageView = redOrc.getImageView();
            if (redOrcImageView.getBoundsInParent().getMaxX()<0){
                index2 += 1;
            }else {
                redOrcImageView.setLayoutX(redOrcImageView.getLayoutX() - 170);
            }
        }
        while (listIterator3.hasNext()){
            GreenOrc  greenOrc = listIterator3.next();
            ImageView greenOrcImageView = greenOrc.getImageView();
            if(greenOrcImageView.getBoundsInParent().getMaxX()<0){
                index3 += 1;
            }else {
                greenOrcImageView.setLayoutX(greenOrcImageView.getLayoutX() - 170);
            }
        }

        while (listIterator4.hasNext()){
            Coin coin = listIterator4.next();
            ImageView coinImageView = coin.getImageView();
            if(coinImageView.getBoundsInParent().getMaxX()<0){
                index4 += 1;
            }else{
                coinImageView.setLayoutX(coinImageView.getLayoutX()-170);
            }

        }

        while (listIterator5.hasNext()){
            ChestType chest = listIterator5.next();
            ImageView chestImageView = chest.getImageView();
            if(chestImageView.getBoundsInParent().getMaxX()<0){
                index5 += 1;
            }else {
                chestImageView.setLayoutX(chestImageView.getLayoutX() - 170);
            }
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

    public void storeIslandsCoordinatesInformation(){

        islandsCoordinateInfo.put("island1", new String[]{tf1.getText(), String.valueOf(island1.getLayoutX()), String.valueOf(island1.getLayoutY()), String.valueOf(island1.getFitHeight()), String.valueOf(island1.getFitWidth())});

        islandsCoordinateInfo.put("island2", new String[]{tf2.getText(), String.valueOf(island2.getLayoutX()), String.valueOf(island2.getLayoutY()), String.valueOf(island2.getFitHeight()), String.valueOf(island2.getFitWidth())});

        islandsCoordinateInfo.put("island3", new String[]{tf3.getText(), String.valueOf(island3.getLayoutX()), String.valueOf(island3.getLayoutY()), String.valueOf(island3.getFitHeight()), String.valueOf(island3.getFitWidth())});
        islandsCoordinateInfo.put("island4", new String[]{tf4.getText(), String.valueOf(island4.getLayoutX()), String.valueOf(island4.getLayoutY()), String.valueOf(island4.getFitHeight()), String.valueOf(island4.getFitWidth())});
        islandsCoordinateInfo.put("island5", new String[]{tf5.getText(), String.valueOf(island5.getLayoutX()), String.valueOf(island5.getLayoutY()), String.valueOf(island5.getFitHeight()), String.valueOf(island5.getFitWidth())});
        islandsCoordinateInfo.put("island6", new String[]{tf6.getText(), String.valueOf(island6.getLayoutX()), String.valueOf(island6.getLayoutY()), String.valueOf(island6.getFitHeight()), String.valueOf(island6.getFitWidth())});
    }

    public void reviveAllIslands(){
        String[] arr;
        arr = islandsCoordinateInfo.get("island1");
        CommonAnimations.replaceImageView(arr[0], island1, Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]));

        arr = islandsCoordinateInfo.get("island2");
        CommonAnimations.replaceImageView(arr[0], island2, Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]));

        arr = islandsCoordinateInfo.get("island3");
        CommonAnimations.replaceImageView(arr[0], island3, Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]));

        arr = islandsCoordinateInfo.get("island4");
        CommonAnimations.replaceImageView(arr[0], island4, Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]));

        arr = islandsCoordinateInfo.get("island5");
        CommonAnimations.replaceImageView(arr[0], island5, Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]));

        arr = islandsCoordinateInfo.get("island6");
        CommonAnimations.replaceImageView(arr[0], island6, Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]));
    }


    public void storeCoordinates(){
        textFieldData = new String[]{tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText(), tf5.getText(), tf6.getText()};
        //coordinatesOfAnchorPane = new double[]{mainAnchorPane.getLayoutX(), mainAnchorPane.getLayoutY(), mainAnchorPane.getBoundsInParent().getHeight(), mainAnchorPane.getBoundsInParent().getWidth()};
        //coordinatesOfbG = new double[]{background.getLayoutX(), background.getLayoutY(), background.getBoundsInParent().getHeight(), background.getBoundsInParent().getWidth()};
        ListIterator<TNT> listIterator1 = tntObjects.listIterator();
        ListIterator<RedOrc> listIterator2 = redOrcs.listIterator();
        ListIterator<GreenOrc> listIterator3 = greenOrcs.listIterator();
        ListIterator<Coin> listIterator4 = coins.listIterator();
        ListIterator<ChestType> listIterator5 = chestTypeObjects.listIterator();
        while (listIterator1.hasNext()){
            TNT tnt = listIterator1.next();
            tnt.store();
        }

        while (listIterator2.hasNext()){
            RedOrc redOrc = listIterator2.next();
            redOrc.store();
        }

        while (listIterator3.hasNext()){
            GreenOrc  greenOrc = listIterator3.next();
            greenOrc.store();
        }

        while (listIterator4.hasNext()){
            Coin coin = listIterator4.next();
            coin.store();
        }

        while (listIterator5.hasNext()){
            ChestType chest = listIterator5.next();
            chest.store();
        }
        playerObj.store();
        if(boss!=null){
            boss.store();
        }

        storeIslandsCoordinatesInformation();
        try {
            gameOver();
        }catch (InterruptedException e){
        }
        //mainAnchorPane.getChildren().removeAll();
        //mainAnchorPane = null;
    }

    public void reviveEverything() {
        nOfCoins.setText(String.valueOf(nOfCoinsAmount));
        nOfSteps.setText(String.valueOf(nOfClick));
//        mainAnchorPane = new AnchorPane();
//        mainAnchorPane.setLayoutX(coordinatesOfAnchorPane[0]);
//        mainAnchorPane.setLayoutY(coordinatesOfAnchorPane[1]);
//        mainAnchorPane.setPrefHeight(coordinatesOfAnchorPane[2]);
//        mainAnchorPane.setPrefWidth(coordinatesOfAnchorPane[3]);
        //mainAnchorPane.getChildren().add(CommonAnimations.makeImageAndSetCoord("backGround", coordinatesOfbG[0], coordinatesOfbG[1], coordinatesOfbG[2], coordinatesOfbG[3]));
//        tf1 = new TextField();
        tf1.setText(textFieldData[0]);
//        tf2 = new TextField();
       tf2.setText(textFieldData[1]);
//        tf3 = new TextField();
        tf3.setText(textFieldData[2]);
//        tf4 = new TextField();
        tf4.setText(textFieldData[3]);
//        tf5 = new TextField();
        tf5.setText(textFieldData[4]);
//        tf6 = new TextField();
        tf6.setText(textFieldData[5]);
        reviveAllIslands();
        playerObj.revive(mainAnchorPane);
        player = playerObj.getMineImageView();
        try {
            boss.revive(mainAnchorPane);
            boss.reviveMoveLeft();
            flagForBossLoaded = true;
        }catch(Exception e){
        }
        ListIterator<TNT> listIterator1 = tntObjects.listIterator();
        ListIterator<RedOrc> listIterator2 = redOrcs.listIterator();
        ListIterator<GreenOrc> listIterator3 = greenOrcs.listIterator();
        ListIterator<Coin> listIterator4 = coins.listIterator();
        ListIterator<ChestType> listIterator5 = chestTypeObjects.listIterator();
        try {
            while (listIterator1.hasNext()) {

                TNT tnt = listIterator1.next();
                tnt.revive(mainAnchorPane);
            }

            while (listIterator2.hasNext()) {

                RedOrc redOrc = listIterator2.next();
                redOrc.revive(mainAnchorPane);
            }

            while (listIterator3.hasNext()) {

                GreenOrc greenOrc = listIterator3.next();
                greenOrc.revive(mainAnchorPane);
            }
        }catch (InterruptedException e){

        }

        while (listIterator4.hasNext()){

            Coin coin = listIterator4.next();
            coin.revive(mainAnchorPane);
        }

        while (listIterator5.hasNext()){

            ChestType chest = listIterator5.next();
            chest.revive(mainAnchorPane);
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
                if(chestTypeObjects.size()>0) {
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
        timer1.scheduleAtFixedRate(task, 1500, 120);
    }


    public void checkCollisionOfPlayerWithTnt(){
        timer2 = new Timer();
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                if(tntObjects.size()>0){
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
                if(coins.size()>0){
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
        timer3.scheduleAtFixedRate(task3, 500, 120);

    }


     public void checkCollisionOfPlayerWithGreenOrc(){

        timer4 = new Timer();
        TimerTask task4 = new TimerTask() {
            @Override
            public void run() {
                if(greenOrcs.size()>0) {
                    ListIterator<GreenOrc> listIterator4 = greenOrcs.listIterator();
                    while (listIterator4.hasNext()) {
                        GreenOrc gOrc = listIterator4.next();
                        if (!gOrc.isCollided()) {
                            ImageView greenOrcImageView = gOrc.getImageView();
                            if(player.getBoundsInParent().getMaxX()>=greenOrcImageView.getLayoutX() && player.getLayoutX()<greenOrcImageView.getBoundsInParent().getMaxX()){
                                if(player.getBoundsInParent().getMinY()>=(greenOrcImageView.getBoundsInParent().getMaxY()-7) && player.getLayoutY()<=greenOrcImageView.getBoundsInParent().getMaxY()){
                                    gOrc.killPlayer(playerObj);
                                }else if(player.getBoundsInParent().getMaxY()>=greenOrcImageView.getLayoutY() && player.getBoundsInParent().getMinY()<= greenOrcImageView.getBoundsInParent().getMaxY()){
                                    int x = (int)greenOrcImageView.getLayoutX();
                                    playerObj.setCoordinatesAfterCollision(x-25);
                                    gOrc.slide(300);
                                }
                                gOrc.setCollided(true);
                            }
                        }
                    }
                }
            }
        };
        timer4.scheduleAtFixedRate(task4, 1000, 120);
    }

    public void checkCollisionOfPlayerWithRedOrc(){
        timer5 = new Timer();
        TimerTask task5 = new TimerTask() {
            @Override
            public void run() {
                if(redOrcs.size()>0) {
                    ListIterator<RedOrc> listIterator4 = redOrcs.listIterator();
                    while (listIterator4.hasNext()) {
                        RedOrc rOrc = listIterator4.next();
                        if (!rOrc.isCollided()) {
                            ImageView redOrcImageView = rOrc.getImageView();
                            if(player.getBoundsInParent().getMaxX()>=redOrcImageView.getLayoutX() && player.getLayoutX()<redOrcImageView.getBoundsInParent().getMaxX()){
                                // not setting the is collided flag because it is not needed as we don't have any array list
                                if((player.getBoundsInParent().getMinY()>=redOrcImageView.getBoundsInParent().getMaxY()-7) && player.getLayoutY()<=redOrcImageView.getBoundsInParent().getMaxY()){
                                    rOrc.killPlayer(playerObj);
                                }else if(player.getBoundsInParent().getMaxY()>redOrcImageView.getLayoutY() && player.getBoundsInParent().getMinY()<= redOrcImageView.getBoundsInParent().getMaxY()){
                                    int x = (int)redOrcImageView.getLayoutX();
                                    playerObj.setCoordinatesAfterCollision(x-30);
                                    rOrc.slide(200);
                                }
                                rOrc.setCollided(true);
                            }
                        }
                    }
                }
            }
        };
        timer5.scheduleAtFixedRate(task5, 1000, 110);
    }


      public void checkCollisionOfEntitiesAndFire(ImageView imageView) {

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

    public void checkCollisionOfPlayerAndBoss(){
        timer6 = new Timer();
        TimerTask timerTask  = new TimerTask() {
            @Override
            public void run() {
                ImageView bossImageView = boss.getImageView();
                if(player.getBoundsInParent().getMaxX()>=bossImageView.getLayoutX() && player.getLayoutX()<bossImageView.getBoundsInParent().getMaxX()){
                    // not setting the is collided flag because it is not needed as we don't have any array list
                    if(player.getBoundsInParent().getMinY()>=(bossImageView.getBoundsInParent().getMaxY()-10)&& player.getLayoutY()<=bossImageView.getBoundsInParent().getMaxY()){
                        boss.killPlayer(playerObj);
                    }else if(player.getBoundsInParent().getMaxY()>bossImageView.getLayoutY()&& player.getBoundsInParent().getMinY()<= bossImageView.getBoundsInParent().getMaxY()){
                        int x = (int)bossImageView.getLayoutX();
                        playerObj.setCoordinatesAfterCollision(x-100);
                        boss.slide(50);
                    }
                }
            }
        };
        timer6.scheduleAtFixedRate(timerTask, 100, 100);
    }

    public void checkCollisionOfOrcAndWeapon(ImageView imageView) throws InterruptedException {
        ListIterator<GreenOrc> listIterator8 = greenOrcs.listIterator();
        while (listIterator8.hasNext()) {
            GreenOrc greenOrc = listIterator8.next();
            ImageView temp = greenOrc.getImageView();
            if (temp.getBoundsInParent().getMaxX() > imageView.getBoundsInParent().getMinX() && temp.getBoundsInParent().getMinX() < imageView.getBoundsInParent().getMaxX()
                    && temp.getBoundsInParent().getMaxY() > imageView.getBoundsInParent().getMinY() && temp.getBoundsInParent().getMinY() < imageView.getBoundsInParent().getMaxY()) {
                greenOrc.die();
            }
        }

        ListIterator<RedOrc> listIterator9 = redOrcs.listIterator();
        while (listIterator9.hasNext()) {
            RedOrc redOrc = listIterator9.next();
            ImageView temp = redOrc.getImageView();
            if (temp.getBoundsInParent().getMaxX() > imageView.getBoundsInParent().getMinX() && temp.getBoundsInParent().getMinX() < imageView.getBoundsInParent().getMaxX()
                    && temp.getBoundsInParent().getMaxY() > imageView.getBoundsInParent().getMinY() && temp.getBoundsInParent().getMinY() < imageView.getBoundsInParent().getMaxY()) {
                redOrc.die();
            }
        }

        if(boss!=null){
            ImageView bossImageView = boss.getImageView();
            if(imageView.getBoundsInParent().getMaxX()>bossImageView.getLayoutX() && (imageView.getLayoutX()+100)<bossImageView.getBoundsInParent().getMaxX()){
                if(imageView.getBoundsInParent().getMaxX()>bossImageView.getLayoutY() && imageView.getLayoutY()<bossImageView.getBoundsInParent().getMaxY()){
                    boss.die();
                    playerObj.changeGameStatusWin(true);
                    gameOver();
                }
            }
        }
    }
}