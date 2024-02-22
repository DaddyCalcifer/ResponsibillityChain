package com.example.responsibillitychain.Models;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Player extends SceneObject{
    public Integer Coins;
    public Integer Lives;
    public Player() {
        Coins = 0;
        Lives = 3;
    }
    @Override
    public Shape asObj()
    {
        Rectangle playa = new Rectangle();
        playa.setFill(Color.BLUE);
        playa.setHeight(SIZE);
        playa.setWidth(SIZE);
        playa.setX(X*SIZE);
        playa.setY(Y*SIZE);

        return playa;
    }
}
