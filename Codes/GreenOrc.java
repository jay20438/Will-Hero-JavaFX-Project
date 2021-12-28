package com.example.willherojavafxproject;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

public class GreenOrc extends Enemy
{
    public GreenOrc(String imageName,  double x, double y, double height, double width, AnchorPane anchorPane, blankController bk) throws InterruptedException {
        super(imageName, x, y, height, width, anchorPane, bk);

    }
}
