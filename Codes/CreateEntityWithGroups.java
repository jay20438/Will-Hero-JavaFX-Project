//package com.example.willherojavafxproject;
//
//import javafx.concurrent.Task;
//import javafx.scene.Group;
//
//import java.util.HashMap;
//import java.util.Random;
//
//public class CreateEntity{
//    private Group gpOperatingOn;
//    private Random random;
//    private String[] entities;
//    private int greenOrcMaxNo;
//    public  int redOrcMaxNo;
//    private int tntMaxNo;
//    private int randNoLevel1;
//    private int randNoLevel2;
//    private int randNoLevel3;
//    private blankController bk;
//    private HashMap<String, Integer> widthOfEntities;
//    private HashMap<String, Integer> heightOfEntities;
//
//    public CreateEntity(Group gp, blankController bk){
//        widthOfEntities = new HashMap<>();
//        heightOfEntities = new HashMap<>();
//        this.bk = bk;
//        this.gpOperatingOn = gp;
//        random = new Random();
//        entities = new String[]{"greenOrc", "redOrc", "tnt", "closedChest", "coin", "tntFire"};
//        greenOrcMaxNo = 3;
//        redOrcMaxNo = 3;
//        tntMaxNo = 3;
//        heightOfEntities.put("greenOrc",62);
//        widthOfEntities.put("greenOrc",61);
//        heightOfEntities.put("redOrc",62);
//        widthOfEntities.put("redOrc",61);
//        heightOfEntities.put("tnt",56);
//        widthOfEntities.put("tnt",60);
//        heightOfEntities.put("closedChest",80);
//        widthOfEntities.put("closedChest",60);
//        heightOfEntities.put("openChest",80);
//        widthOfEntities.put("openChest",60);
//        heightOfEntities.put("coin",48);
//        widthOfEntities.put("coin",32);
//        heightOfEntities.put("tntFire", 150);
//        widthOfEntities.put("tntFire", 200);
//    }
//
//    public void create() {
//        boolean flag = true;
//        double depthOfBaseOfIslands =bk.getDepthOfBaseOfIsland(gpOperatingOn)+  gpOperatingOn.getBoundsInLocal().getMinY();
//        randNoLevel1 = random.nextInt(2);
//        if(randNoLevel1 == 0){
//        }else{
//            randNoLevel2 = random.nextInt(5);
//            double heightOfEntity = heightOfEntities.get(entities[randNoLevel2]);
//            if(entities[randNoLevel2].equals("closedChest")){
//                ChestType chestType = new ChestType("closedChest", gpOperatingOn, gpOperatingOn.getBoundsInLocal().getMinX() + random.nextInt((int) gpOperatingOn.getBoundsInParent().getWidth()-40), depthOfBaseOfIslands - heightOfEntity + 30, heightOfEntities.get("closedChest"), widthOfEntities.get("closedChest"));
//                bk.setChestObjects(chestType);
//                System.out.println("closed chest c");
//            }else{
//                randNoLevel3 = random.nextInt(3) + 1;
//                double length = gpOperatingOn.getBoundsInParent().getWidth();
//                double[] dist = new double[randNoLevel3+1];
//                double sum = length - randNoLevel3*widthOfEntities.get(entities[randNoLevel3]);
//                int maxPart = (int) sum/(randNoLevel3+1);
//                for (int i = 0; i < randNoLevel3; i++) {
//                    dist[i] = random.nextInt(maxPart);
//                }
//                int help4Sum = 0;
//                for (int i = 0; i < randNoLevel3; i++) {
//                    help4Sum += dist[i];
//                    if (entities[randNoLevel2].equals("greenOrc")){
//                        System.out.println("gOrc c");
//                        GreenOrc greenOrc = new GreenOrc("greenOrc", gpOperatingOn, gpOperatingOn.getBoundsInLocal().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("greenOrc"), widthOfEntities.get("greenOrc"));
//                    }else if(entities[randNoLevel2].equals("redOrc")){
//                        System.out.println("rOrc c");
//                        RedOrc redOrc = new RedOrc("redOrc", gpOperatingOn, gpOperatingOn.getBoundsInLocal().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("redOrc"), widthOfEntities.get("redOrc"));
//                    }else if(entities[randNoLevel2].equals("coin")){
//                        System.out.println("coin c");
//                        Coin coin = new Coin("coin", gpOperatingOn, gpOperatingOn.getBoundsInLocal().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), -70 + depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("coin"), widthOfEntities.get("coin"));
//                    }else if(entities[randNoLevel2].equals("tnt")){
//                        System.out.println("tnt c");
//                        TNT tnt = new TNT("tnt", gpOperatingOn, gpOperatingOn.getBoundsInLocal().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("tnt"), widthOfEntities.get("tnt"));
//                        bk.setTntObjects(tnt);
//                    }
//                }
//            }
//        }
//    }
//
//    public double getHeightOfEntity(String name){
//        return heightOfEntities.get(name);
//    }
//
//    public double getWidthOfEntity(String name){
//        return widthOfEntities.get(name);
//    }
//}