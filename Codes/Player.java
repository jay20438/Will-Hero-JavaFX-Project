package com.example.javafx2;

import java.util.*;

public class Player
{
    private final String username;
    private int amountOfCoins;
    private int life;
    private int score;

    public Player(String username)
    {
        this.username= username;
        this.amountOfCoins = amountOfCoins;
        this.life = life;
        this.score =score;
    }

    public String getUsername()
    {
        return username;
    }

    public int getAmountOfCoins()
    {
        return amountOfCoins;
    }

    public int getScore()
    {
        return score;
    }

    public int getLife()
    {
        return life;
    }


}
