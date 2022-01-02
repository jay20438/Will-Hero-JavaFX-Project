package com.example.willherojavafxproject;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.image.Image;
import java.io.IOException;
import java.io.Serializable;

public class HelloApplication extends Application implements Serializable {
    static transient Stage staged;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("userLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1077, 522);
        //1017, 532
        Image icon = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ "WillHeroIcon.jpg"));
        stage.getIcons().add(icon);
        staged = stage;
        stage.setTitle("WILL HERO");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        System.exit(0);
    }

    public static void setDifferentScene(Scene scene){
        staged.setScene(scene);
    }




}















//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.scene.Group;
//import javafx.scene.image.Image;
//import java.io.IOException;
//
//public class HelloApplication extends Application {
//    private static Stage staged;
//
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("blank.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1518, 736);
//        //1017, 532
//        Image icon = new Image(HelloApplication.class.getResourceAsStream("WillHeroImages/"+ "WillHeroIcon.jpg"));
//        stage.getIcons().add(icon);
//        stage.setTitle("WILL HERO");
//        staged = stage;
//        stage.setTitle("");
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
//        System.out.println("hiStart");
//    }
//
//    public static void main(String[] args) {
//        launch();
//        System.exit(0);
//        System.out.println("hiMain");
//    }
//
//    public static void setDifferentScene(Scene scene){
//        staged.setScene(scene);
//    }
//}