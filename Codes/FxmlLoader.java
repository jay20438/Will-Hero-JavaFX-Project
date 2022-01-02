package com.example.willherojavafxproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.net.URL;

public class FxmlLoader implements Serializable {

    static transient Scene view;
    //private Names JavaFxProject;

    public static Scene getScene(String filename) {
        try{
            URL fileUrl = HelloApplication.class.getResource(filename+".fxml");
            System.out.println(fileUrl);
            if(fileUrl == null){
                throw new FileNotFoundException("fxml file can not be found");
            }
            FXMLLoader fxmlLoader = new FXMLLoader(fileUrl);
            view  = new Scene(fxmlLoader.load());
        }catch (Exception e){
            System.out.println("No page " + filename + " please check the fxml file");
        }
        return view;
    }

    public static Scene getScene(String filename, Object obj, String className){
        try{
            URL fileUrl = HelloApplication.class.getResource(filename+".fxml");
            System.out.println(fileUrl);
            if(fileUrl == null){
                throw new FileNotFoundException("fxml file can not be found");
            }
            FXMLLoader fxmlLoader = new FXMLLoader(fileUrl);
            fxmlLoader.setController(null);
            System.out.println("jgh");
            System.out.println("opop");
            if(className.equals("Homepage")){
                System.out.println("hituier");
                fxmlLoader.setController((Homepage)obj);
            }else if(className.equals("Position")){
//                fxmlLoader.
                fxmlLoader.setController((Position)obj);
            }else if(className.equals("SettingsPageView")){
                fxmlLoader.setController((SettingsPageView)obj);
            }else if(className.equals("LoadGamePage")){
                fxmlLoader.setController((LoadGamePage)obj);
            }
            System.out.println("toper");
            view  = new Scene(fxmlLoader.load());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("No page " + filename + " please check the fxml file");
        }
        return view;
    }
}
