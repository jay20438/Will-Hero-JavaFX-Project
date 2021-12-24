package com.example.willherojavafxproject;

//import com.example.javafx2.GreenOrc;
//import com.example.WillHero.RedOrc;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Position
{
    public static boolean gameStatus;
    private static ArrayList<Integer> redOrc;
    private static ArrayList<Integer> greenOrc;
    public static List allRedOrcs;
    public static List allGreenOrcs;
    public static int wonGame = 0;
    private static int numberOfSteps = 0;
    private static int numberOfCoinsCollected = 0;

    public void intialize() throws Exception{
        gameStatus = true;
        allGreenOrcs = Collections.synchronizedList(new ArrayList<GreenOrc>());
        allRedOrcs = Collections.synchronizedList(new ArrayList<RedOrc>());
    }

    public void intContent(int numberOfSteps,int numberOfCoinsCollected)
    {

    }

}
