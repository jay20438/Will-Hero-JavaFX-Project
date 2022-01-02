package com.example.willherojavafxproject;

import javafx.scene.layout.AnchorPane;

public class RedOrc extends Enemy{

    public RedOrc(String imageName, double x, double y, double height, double width, AnchorPane anchorPane, Position bk) throws InterruptedException {
        super(imageName, x, y, height, width, anchorPane, bk, 100, 10);

    }


}
