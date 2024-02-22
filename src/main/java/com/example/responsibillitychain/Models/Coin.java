package com.example.responsibillitychain.Models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Sphere;

public class Coin extends EnterObject{
    public Coin(int x, int y) {
        X = x; Y = y;
    }
    @Override
    public Result onEnter()
    {
        return Result.COIN;
    }
    @Override
    public Shape asObj()
    {
        Circle obj = new Circle();
        obj.setRadius(SIZE/2);
        obj.setFill(Color.GOLD);
        obj.setCenterX(X*SIZE+(SIZE/2));
        obj.setCenterY(Y*SIZE+(SIZE/2));
        return obj;
    }
}
