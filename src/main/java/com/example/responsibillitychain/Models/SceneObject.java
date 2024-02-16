package com.example.responsibillitychain.Models;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public abstract class SceneObject {
    final protected int SIZE = 20;
    public Integer X,Y;
    public abstract Shape asObj();
    public void SetCords(int x, int y)
    {
        X = x; Y = y;
    }
}
