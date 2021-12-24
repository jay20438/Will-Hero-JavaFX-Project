//package com.example.willherojavafxproject;
//
//import javafx.concurrent.Task;
//import javafx.scene.Group;
//
//import java.util.HashMap;
//import java.util.Random;
//
//public class CreateEntity2{
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
//    public CreateEntity2(Group gp, blankController bk){
//        widthOfEntities = new HashMap<>();
//        heightOfEntities = new HashMap<>();
//        this.bk = bk;
//        this.gpOperatingOn = gp;
//        random = new Random();
//        entities = new String[]{"greenOrc", "redOrc", "tnt", "closedChest", "coin"};
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
//    }
//
//    public void create() {
//        boolean flag = true;
////        double islandBaseY = gpOperatingOn.getBoundsInParent().getMinY() + bk.getDepthOfBaseOfIsland(gpOperatingOn);
//        double depthOfBaseOfIslands =bk.getDepthOfBaseOfIsland(gpOperatingOn)+  gpOperatingOn.getBoundsInLocal().getMinY();
////        System.out.println("depthOfBaseOfIslands:"+depthOfBaseOfIslands);
////        System.out.println("gp min y before:"+gpOperatingOn.getBoundsInParent().getMinY());
//        randNoLevel1 = random.nextInt(2);
//        if(randNoLevel1 == 0){
//        }else{
//            randNoLevel2 = random.nextInt(5);
////            System.out.println("r2:" + randNoLevel2);
//            double heightOfEntity = heightOfEntities.get(entities[randNoLevel2]);
////            System.out.println("heightOfEn:"+heightOfEntity);
//            if(entities[randNoLevel2].equals("closedChest")){
//                new ChestType("closedChest", gpOperatingOn, gpOperatingOn.getBoundsInLocal().getMinX() + random.nextInt((int) gpOperatingOn.getBoundsInParent().getWidth()-40), depthOfBaseOfIslands - heightOfEntity + 30, heightOfEntities.get("closedChest"), widthOfEntities.get("closedChest"));
//                System.out.println("closed chest c");
//            }else{
//                randNoLevel3 = random.nextInt(3) + 1;
////                System.out.println("r3:"+ randNoLevel3);
//                double length = gpOperatingOn.getBoundsInParent().getWidth();
////                System.out.println("length:" + length);
//                double[] dist = new double[randNoLevel3+1];
//                double sum = length - randNoLevel3*widthOfEntities.get(entities[randNoLevel3]);
////                System.out.println("sum:" + sum);
//                int maxPart = (int) sum/(randNoLevel3+1);
////                System.out.println("maxPart:" + maxPart);
//                for (int i = 0; i < randNoLevel3; i++) {
//                    dist[i] = random.nextInt(maxPart);
//                }
//                int help4Sum = 0;
//                for (int i = 0; i < randNoLevel3; i++) {
//                    help4Sum += dist[i];
//                    if (entities[randNoLevel2].equals("greenOrc")){
//                        System.out.println("gOrc c");
//                        new GreenOrc("greenOrc", gpOperatingOn, gpOperatingOn.getBoundsInLocal().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("greenOrc"), widthOfEntities.get("greenOrc"));
//                    }else if(entities[randNoLevel2].equals("redOrc")){
//                        System.out.println("rOrc c");
//                        new RedOrc("redOrc", gpOperatingOn, gpOperatingOn.getBoundsInLocal().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("redOrc"), widthOfEntities.get("redOrc"));
//                    }else if(entities[randNoLevel2].equals("coin")){
//                        System.out.println("coin c");
//                        new Coin("coin", gpOperatingOn, gpOperatingOn.getBoundsInLocal().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), -70 + depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("coin"), widthOfEntities.get("coin"));
//                    }else if(entities[randNoLevel2].equals("tnt")){
//                        System.out.println("tnt c");
//                        new TNT("tnt", gpOperatingOn, gpOperatingOn.getBoundsInLocal().getMinX() + help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), depthOfBaseOfIslands - heightOfEntity, heightOfEntities.get("tnt"), widthOfEntities.get("tnt"));
//                    }
//                }
//            }
//        }
////        System.out.println("gp min y after:"+gpOperatingOn.getBoundsInParent().getMinY());
//    }
//
//}
//
//
////public class CreateEntity extends Task<Void> {
////    private Group gpOperatingOn;
////    private Random random;
////    private String[] entities;
////    private int greenOrcMaxNo;
////    public  int redOrcMaxNo;
////    private int tntMaxNo;
////    private int randNoLevel1;
////    private int randNoLevel2;
////    private int randNoLevel3;
////    private blankController bk;
////    private HashMap<String, Integer> widthOfEntities;
////    private HashMap<String, Integer> heightOfEntities;
////
////    public CreateEntity(Group gp, blankController bk){
////        System.out.println("hitlo");
////        widthOfEntities = new HashMap<>();
////        heightOfEntities = new HashMap<>();
////        this.bk = bk;
////        this.gpOperatingOn = gp;
////        random = new Random();
////        entities = new String[]{"greenOrc", "redOrc", "tnt", "closedChest", "coin"};
////        greenOrcMaxNo = 3;
////        redOrcMaxNo = 3;
////        tntMaxNo = 3;
////        heightOfEntities.put("greenOrc",62);
////        widthOfEntities.put("greenOrc",61);
////        heightOfEntities.put("redOrc",62);
////        widthOfEntities.put("redOrc",61);
////        heightOfEntities.put("tnt",56);
////        widthOfEntities.put("tnt",60);
////        heightOfEntities.put("closedChest",80);
////        widthOfEntities.put("closedChest",60);
////        heightOfEntities.put("openChest",80);
////        widthOfEntities.put("openChest",60);
////        heightOfEntities.put("coin",48);
////        widthOfEntities.put("coin",32);
////    }
//////
//////    @Override
//////    public void run(){
//////        boolean flag = true;
//////        double islandBaseY = gpOperatingOn.getBoundsInParent().getMinY() + bk.getDepthOfIsland(gpOperatingOn);
//////        randNoLevel1 = random.nextInt(2);
//////        if(randNoLevel1 == 0){
//////        }else{
//////            randNoLevel2 = random.nextInt(5);
//////            System.out.println(randNoLevel2);
//////            double heightOfEntity = heightOfEntities.get(entities[randNoLevel2]);
//////            if(entities[randNoLevel2].equals("closed")){
//////                new ChestType("", gpOperatingOn, random.nextInt((int)gpOperatingOn.getBoundsInParent().getMinX(), (int)gpOperatingOn.getBoundsInParent().getMaxX()-20), islandBaseY - heightOfEntity, heightOfEntities.get("closedChest"), widthOfEntities.get("closedChest"));
//////            }else{
//////                randNoLevel3 = random.nextInt(3) + 1;
//////                double length = gpOperatingOn.getBoundsInParent().getWidth();
//////                double[] dist = new double[randNoLevel3+1];
//////                double sum = length - randNoLevel3*widthOfEntities.get(entities[randNoLevel3]);
//////                int maxPart = (int) sum/(randNoLevel3+1);
//////                for (int i = 0; i < randNoLevel3; i++) {
//////                    dist[i] = random.nextInt(maxPart);
//////                }
//////                int help4Sum = 0;
//////                for (int i = 0; i < randNoLevel3; i++) {
//////                    help4Sum += dist[i];
//////                    if (entities[randNoLevel2].equals("greenOrc")){
//////                        new GreenOrc("greenOrc", gpOperatingOn, help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), islandBaseY - heightOfEntity, heightOfEntities.get("greenOrc"), widthOfEntities.get("greenOrc"));
//////                    }else if(entities[randNoLevel2].equals("redOrc")){
//////                        new RedOrc("redOrc", gpOperatingOn, help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), islandBaseY - heightOfEntity, heightOfEntities.get("redOrc"), widthOfEntities.get("redOrc"));
//////                    }else if(entities[randNoLevel2].equals("coin")){
//////                        new Coin("coin", gpOperatingOn, help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), islandBaseY - heightOfEntity, heightOfEntities.get("coin"), widthOfEntities.get("coin"));
//////                    }
//////                }
//////            }
//////        }
//////    }
////
////    @Override
////    protected Void call() throws Exception {
////        System.out.println("jitlo");
////        boolean flag = true;
////        double islandBaseY = gpOperatingOn.getBoundsInParent().getMinY() + bk.getDepthOfIsland(gpOperatingOn);
////        randNoLevel1 = random.nextInt(2);
////        if(randNoLevel1 == 0){
////        }else{
////            randNoLevel2 = random.nextInt(5);
////            System.out.println(randNoLevel2);
////            double heightOfEntity = heightOfEntities.get(entities[randNoLevel2]);
////            if(entities[randNoLevel2].equals("closed")){
////                new ChestType("", gpOperatingOn, random.nextInt((int)gpOperatingOn.getBoundsInParent().getMinX(), (int)gpOperatingOn.getBoundsInParent().getMaxX()-20), islandBaseY - heightOfEntity, heightOfEntities.get("closedChest"), widthOfEntities.get("closedChest"));
////            }else{
////                randNoLevel3 = random.nextInt(3) + 1;
////                double length = gpOperatingOn.getBoundsInParent().getWidth();
////                double[] dist = new double[randNoLevel3+1];
////                double sum = length - randNoLevel3*widthOfEntities.get(entities[randNoLevel3]);
////                int maxPart = (int) sum/(randNoLevel3+1);
////                for (int i = 0; i < randNoLevel3; i++) {
////                    dist[i] = random.nextInt(maxPart);
////                }
////                int help4Sum = 0;
////                for (int i = 0; i < randNoLevel3; i++) {
////                    help4Sum += dist[i];
////                    if (entities[randNoLevel2].equals("greenOrc")){
////                        new GreenOrc("greenOrc", gpOperatingOn, help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), islandBaseY - heightOfEntity, heightOfEntities.get("greenOrc"), widthOfEntities.get("greenOrc"));
////                    }else if(entities[randNoLevel2].equals("redOrc")){
////                        new RedOrc("redOrc", gpOperatingOn, help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), islandBaseY - heightOfEntity, heightOfEntities.get("redOrc"), widthOfEntities.get("redOrc"));
////                    }else if(entities[randNoLevel2].equals("coin")){
////                        new Coin("coin", gpOperatingOn, help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), islandBaseY - heightOfEntity, heightOfEntities.get("coin"), widthOfEntities.get("coin"));
////                    }
////                }
////            }
////        }
////        return null;
////    }
////}
//
////
////    @Override
////    public void run(){
////        boolean flag = true;
////        double islandBaseY = gpOperatingOn.getBoundsInParent().getMinY() + bk.getDepthOfIsland(gpOperatingOn);
////        randNoLevel1 = random.nextInt(2);
////        if(randNoLevel1 == 0){
////        }else{
////            randNoLevel2 = random.nextInt(5);
////            System.out.println(randNoLevel2);
////            double heightOfEntity = heightOfEntities.get(entities[randNoLevel2]);
////            if(entities[randNoLevel2].equals("closed")){
////                new ChestType("", gpOperatingOn, random.nextInt((int)gpOperatingOn.getBoundsInParent().getMinX(), (int)gpOperatingOn.getBoundsInParent().getMaxX()-20), islandBaseY - heightOfEntity, heightOfEntities.get("closedChest"), widthOfEntities.get("closedChest"));
////            }else{
////                randNoLevel3 = random.nextInt(3) + 1;
////                double length = gpOperatingOn.getBoundsInParent().getWidth();
////                double[] dist = new double[randNoLevel3+1];
////                double sum = length - randNoLevel3*widthOfEntities.get(entities[randNoLevel3]);
////                int maxPart = (int) sum/(randNoLevel3+1);
////                for (int i = 0; i < randNoLevel3; i++) {
////                    dist[i] = random.nextInt(maxPart);
////                }
////                int help4Sum = 0;
////                for (int i = 0; i < randNoLevel3; i++) {
////                    help4Sum += dist[i];
////                    if (entities[randNoLevel2].equals("greenOrc")){
////                        new GreenOrc("greenOrc", gpOperatingOn, help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), islandBaseY - heightOfEntity, heightOfEntities.get("greenOrc"), widthOfEntities.get("greenOrc"));
////                    }else if(entities[randNoLevel2].equals("redOrc")){
////                        new RedOrc("redOrc", gpOperatingOn, help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), islandBaseY - heightOfEntity, heightOfEntities.get("redOrc"), widthOfEntities.get("redOrc"));
////                    }else if(entities[randNoLevel2].equals("coin")){
////                        new Coin("coin", gpOperatingOn, help4Sum + i*widthOfEntities.get(entities[randNoLevel2]), islandBaseY - heightOfEntity, heightOfEntities.get("coin"), widthOfEntities.get("coin"));
////                    }
////                }
////            }
////        }
////    }
