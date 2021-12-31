package com.example.willherojavafxproject;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class CommonAnimations {

    static public TranslateTransition makeYTranslationalObj(ImageView imageView, int from, int to, boolean autoReverse, Duration duration){
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(imageView);
        translateTransition.setDuration(duration);
        translateTransition.setAutoReverse(autoReverse);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setByY(imageView.getBoundsInLocal().getMinY()-70);
        return translateTransition;
    }

    static public ImageView makeImageAndSetCoord(String imageName, double x, double y, double height, double width){
        ImageView imageView = new ImageView();
        Image image = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ imageName + ".png"));
        imageView.setImage(image);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        return imageView;
    }

    static public void replaceImageView(String newImage, ImageView imageView){
        Image image = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ newImage + ".png"));
        imageView.setImage(image);

    }

    static public void setCoordinates(ImageView imageView, double x, double y, double height, double width){
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
    }

    static public void loadImage(String imageName){

    }

//    public void implementGravity(){
//        timer0 = new Timer();
//        TimerTask task1 = new TimerTask() {
//            boolean flag = false;
//            @Override
//            public void run() {
//                double playerPosFront = player.getBoundsInParent().getMinX();
//                double playerPosLast =player.getBoundsInParent().getMaxX();
//                if(player.getBoundsInParent().getMinX()>1500){
//                    gameOver();
//                }
//                if(player.getBoundsInParent().getMaxY()>520){
//                    if(player.getLayoutY()>739){
//                        gameOver();
//                    }else{
//                        playerFalls = true;
//                    }
//                }else {
//                    try {
//                        if (playerPosFront >= island1.getBoundsInParent().getMinX() && playerPosFront <= island1.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island1.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf1.getText()))) {
//                            flag = true;
//                        } else if (playerPosFront >= island2.getBoundsInParent().getMinX() && playerPosFront <= island2.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island2.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf2.getText()))) {
//                            flag = true;
//                        } else if (playerPosFront >= island3.getBoundsInParent().getMinX() && playerPosFront <= island3.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island3.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf3.getText()))) {
//                            flag = true;
//                        } else if (playerPosFront >= island4.getBoundsInParent().getMinX() && playerPosFront <= island4.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island4.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf4.getText()))) {
//                            flag = true;
//                        } else if (playerPosFront >= island5.getBoundsInParent().getMinX() && playerPosFront <= island5.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island5.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf5.getText()))) {
//                            flag = true;
//                        } else if (playerPosFront >= island6.getBoundsInParent().getMinX() && playerPosFront <= island6.getBoundsInParent().getMaxX() && player.getBoundsInParent().getMaxY() > (island6.getBoundsInParent().getMinY() + depthOfBaseOfIslands.get(tf6.getText()))) {
//                            flag = true;
//                        }
//                    }catch (IndexOutOfBoundsException e){
//                        System.out.println("c");
//                    }
//                    if (flag) {
//                        for (int i = 0; i < 10; i++) {
//                            player.setLayoutY(player.getBoundsInParent().getMinY() - 10);
//                        }
//                    }
//                }
//                System.out.println("before incrementing the miny:"+player.getBoundsInParent().getMinY());
//                player.setLayoutY(player.getBoundsInParent().getMinY() + 10);
//                System.out.println("bafter incrementing the miny:"+player.getBoundsInParent().getMinY());
//                flag = false;
//            }
//        };
//        timer0.scheduleAtFixedRate(task1, 500, 100);
//    }
}
