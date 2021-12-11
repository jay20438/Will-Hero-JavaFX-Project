package com.example.javafxproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.URL;

public class FxmlLoader {

    private Scene view;
    //private Names JavaFxProject;

    public Scene getScene(String filename) {
        try{
            URL fileUrl = HelloApplication.class.getResource(filename+".fxml");
            System.out.println(fileUrl);
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("fxml file can not be found");
            }
            FXMLLoader fxmlLoader = new FXMLLoader(fileUrl);
            view  = new Scene(fxmlLoader.load());
        }catch (Exception e){
            System.out.println("No page " + filename + " please check the fxml file");
        }
        return view;
    }
}