package com.example.willherojavafxproject;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.Random;

public class CreateEntity {
    private ImageView imageViewOfIslandOperatingUpon;
    private Random random;
    private String[] entities;
    private int greenOrcMaxNo;
    public  int redOrcMaxNo;
    private int tntMaxNo;
    private int randNoLevel1;
    private AnchorPane anchorPane;
    private int randNoLevel2;
    private int randNoLevel3;
    private blankController bk;
    private HashMap<String, Integer> widthOfEntities;
    private HashMap<String, Integer> heightOfEntities;
    int rOrcNo = 0;
    int gOrcNo = 0;

    public CreateEntity(blankController bk, AnchorPane anchorPane){
        this.anchorPane = anchorPane;
        this.imageViewOfIslandOperatingUpon = imageViewOfIslandOperatingUpon;
        widthOfEntities = new HashMap<>();
        heightOfEntities = new HashMap<>();
        this.bk = bk;
//        this.gpOperatingOn = gp;
        random = new Random();
        entities = new String[]{"greenOrc", "redOrc", "tnt", "closedChest", "coin", "tntFire", "coins", "playerWithKnife", "playerWithMissile", "crushedPlayer", "boss"};
        greenOrcMaxNo = 3;
        redOrcMaxNo = 3;
        tntMaxNo = 3;
        heightOfEntities.put("coins", 46);
        widthOfEntities.put("coins", 39);
        heightOfEntities.put("playerWithKnife", 93);
        widthOfEntities.put("playerWithKnife", 75);
        heightOfEntities.put("playerWithMissile", 72);
        widthOfEntities.put("playerWithMissile", 63);
        heightOfEntities.put("greenOrc",62);
        widthOfEntities.put("greenOrc",61);
        heightOfEntities.put("redOrc",62);
        widthOfEntities.put("redOrc",61);
        heightOfEntities.put("tnt",56);
        widthOfEntities.put("tnt",60);
        heightOfEntities.put("closedChest",80);
        widthOfEntities.put("closedChest",60);
        heightOfEntities.put("openChest",80);
        widthOfEntities.put("openChest",60);
        heightOfEntities.put("coin",48);
        widthOfEntities.put("coin",32);
        heightOfEntities.put("tntFire", 150);
        widthOfEntities.put("tntFire", 200);
        heightOfEntities.put("crushedPlayer",50);
        widthOfEntities.put("crushedPlayer",50);
        heightOfEntities.put("boss", 184);
        widthOfEntities.put("boss", 171);
    }

    public void create(ImageView imageViewOfIslandOperatingUpon) throws InterruptedException {
        boolean flag = true;
       // double depthOfBaseOfIslands =bk.getDepthOfBaseOfIsland(gpOperatingOn)+  gpOperatingOn.getBoundsInLocal().getMinY();
        double depthOfBaseOfIslands = bk.getDepthOfBaseOfIsland(imageViewOfIslandOperatingUpon) + imageViewOfIslandOperatingUpon.getBoundsInParent().getMinY();
        randNoLevel1 = random.nextInt(2);
        if(randNoLevel1 == 0){
        }else{
            randNoLevel2 = random.nextInt(5);
            double heightOfEntity = heightOfEntities.get(entities[randNoLevel2]);
            if(entities[randNoLevel2].equals("closedChest")){
                ChestType chestType = new ChestType("closedChest",  imageViewOfIslandOperatingUpon.getBoundsInParent().getMinX() + random.nextInt((int) imageViewOfIslandOperatingUpon.getBoundsInParent().getWidth()-40), depthOfBaseOfIslands - heightOfEntity + 30, heightOfEntities.get("closedChest"), widthOfEntities.get("closedChest"), anchorPane, bk, false);
                bk.setChestObjects(chestType);
                //System.out.println("closed chest c");
            }else{
                randNoLevel3 = random.nextInt(3) + 1;
                double length = imageViewOfIslandOperatingUpon.getBoundsInParent().getWidth();
                double[] dist = new double[randNoLevel3+1];
                double sum = length - randNoLevel3*widthOfEntities.get(entities[randNoLevel3]);
                int maxPart = (int) sum/(randNoLevel3+1);
                for (int i = 0; i < randNoLevel3; i++) {
                    dist[i] = random.nextInt(maxPart);
                }
                int help4Sum = 0;
                for (int i = 0; i < randNoLevel3; i++) {
                    help4Sum += dist[i];
                    if (entities[randNoLevel2].equals("greenOrc")){
                        gOrcNo += 1;
                        System.out.println("gOrc c");
                        GreenOrc greenOrc = new GreenOrc("greenOrc", imageViewOfIslandOperatingUpon.getBoundsInParent().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("greenOrc"), widthOfEntities.get("greenOrc"), anchorPane, bk);
                        bk.setGreenOrcObjects(greenOrc);
                    }else if(entities[randNoLevel2].equals("redOrc")){
                        rOrcNo += 1;
                        System.out.println("rOrc c");
                        RedOrc redOrc = new RedOrc("redOrc", imageViewOfIslandOperatingUpon.getBoundsInParent().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("redOrc"), widthOfEntities.get("redOrc"), anchorPane, bk);
                        bk.setRedOrcObjects(redOrc);
                    }else if(entities[randNoLevel2].equals("coin")){
                        //System.out.println("coin c");
                        Coin coin = new Coin("coin", imageViewOfIslandOperatingUpon.getBoundsInParent().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), -70 + depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("coin"), widthOfEntities.get("coin"), anchorPane);
                        bk.setCoinObjects(coin);
                    }else if(entities[randNoLevel2].equals("tnt")){
                        //System.out.println("tnt c");
                        TNT tnt = new TNT("tnt", imageViewOfIslandOperatingUpon.getBoundsInParent().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("tnt"), widthOfEntities.get("tnt"), anchorPane, this);
                       bk.setTntObjects(tnt);
                    }
                }
            }
        }
    }

    public double getHeightOfEntity(String name){
        return heightOfEntities.get(name);
    }

    public double getWidthOfEntity(String name){
        return widthOfEntities.get(name);
    }

    public Player createPlayer() throws InterruptedException {
        return new Player("PlayerNew", 144, 315, 93, 49, anchorPane, this, bk);
    }

    public Boss createBoss(int x) throws InterruptedException {
        return new Boss("boss", x, -200, heightOfEntities.get("boss"), widthOfEntities.get("boss"), anchorPane, bk);
    }

    public void createScene4Boss(ImageView i1, ImageView i2, ImageView i3, ImageView i6){
        CommonAnimations.replaceImageView("smallestFloatingIsland", i1);
        i1.setLayoutX(i6.getBoundsInParent().getMaxX()+47);
        i1.setFitWidth(bk.getWidthOfIslands("smallestFloatingIsland"));
        i1.setFitHeight(bk.getHeightOfIslands("smallestFloatingIsland"));
        i1.setLayoutY(352);
        CommonAnimations.replaceImageView("platform4Boss", i2);
        i2.setLayoutX(i1.getBoundsInParent().getMaxX()+60);
        i2.setFitWidth(bk.getWidthOfIslands("platform4Boss"));
        i2.setFitHeight(bk.getHeightOfIslands("platform4Boss"));
        i2.setLayoutY(279);
        CommonAnimations.replaceImageView("mediumFloatingIsland", i3);
        i3.setLayoutX(i2.getBoundsInParent().getMaxX()+47);
        i3.setFitWidth(bk.getWidthOfIslands("mediumFloatingIsland"));
        i3.setFitHeight(bk.getHeightOfIslands("mediumFloatingIsland"));
        i3.setLayoutY(352);
    }

    public blankController getBk(){
        return bk;
    }
}
