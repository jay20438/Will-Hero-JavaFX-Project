package com.example.willherojavafxproject;

import javafx.scene.layout.AnchorPane;

public class GreenOrc extends Enemy
{
    public GreenOrc(String imageName,  double x, double y, double height, double width, AnchorPane anchorPane, Position bk) throws InterruptedException {
        super(imageName, x, y, height, width, anchorPane, bk, 100, 10);
//        super.jump();
    }
}
