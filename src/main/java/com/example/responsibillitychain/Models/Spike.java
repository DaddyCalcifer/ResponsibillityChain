package com.example.responsibillitychain.Models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Spike extends EnterObject{
    public Spike(int x, int y) {
        X = x; Y = y;
    }
    @Override
    public Result onEnter()
    {
        return Result.SPIKE;
    }
    @Override
    public Shape asObj()
    {
        Rectangle obj = new Rectangle();
        obj.setFill(Color.RED);
        obj.setHeight(SIZE);
        obj.setWidth(SIZE);
        obj.setX(X*SIZE);
        obj.setY(Y*SIZE);
        return obj;
    }
}
