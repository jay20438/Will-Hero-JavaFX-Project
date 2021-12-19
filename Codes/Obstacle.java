package com.example.javafx2;

import java.util.ArrayList;

abstract class Obstacle
{
    private ArrayList<RedOrc> redOrc;
    private ArrayList<GreenOrc> greenOrc;
    private String typeOfObstacle;
    private boolean destroyObject;
    private int width;
    private int xPosition;
    private int yPosition;

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
