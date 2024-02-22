package com.example.responsibillitychain.Models;

import com.example.responsibillitychain.Logic.GameEngine;

public abstract class Handler {
    Handler next;
    public Handler(Handler next)
    {
        this.next = next;
    }
    public boolean handle(Result result, GameEngine game)
    {
        if(result != null)
        {
            return next.handle(result, game);
        }
        else return true;
    }
}
