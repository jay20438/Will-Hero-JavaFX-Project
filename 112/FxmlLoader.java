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
            if(fileUrl == null){
                throw new FileNotFoundException("fxml file can not be found");
            }
            FXMLLoader fxmlLoader = new FXMLLoader(fileUrl);
            view  = new Scene(fxmlLoader.load());
        }catch (Exception e){
        }
        return view;
    }

    public static Scene getScene(String filename, Object obj, String className){
        try{
            URL fileUrl = HelloApplication.class.getResource(filename+".fxml");
            if(fileUrl == null){
                throw new FileNotFoundException("fxml file can not be found");
            }
            FXMLLoader fxmlLoader = new FXMLLoader(fileUrl);
            fxmlLoader.setController(null);
            if(className.equals("Homepage")){
                fxmlLoader.setController((Homepage)obj);
            }else if(className.equals("Position")){
//                fxmlLoader.
                fxmlLoader.setController((Position)obj);
            }else if(className.equals("SettingsPageView")){
                fxmlLoader.setController((SettingsPageView)obj);
            }else if(className.equals("LoadGamePage")){
                fxmlLoader.setController((LoadGamePage)obj);
            }else if(className.equals("GameOutcome")){
                fxmlLoader.setController((GameOutcome)obj);
            }
            view  = new Scene(fxmlLoader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }
}
