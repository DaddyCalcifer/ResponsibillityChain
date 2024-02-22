package com.example.responsibillitychain.Handlers;

import com.example.responsibillitychain.Logic.GameEngine;
import com.example.responsibillitychain.Models.Handler;
import com.example.responsibillitychain.Models.Player;
import com.example.responsibillitychain.Models.Result;

public class HealHandler extends Handler {
    public HealHandler(Handler next)
    {
        super(next);
    }
    public boolean handle(Result result, GameEngine game)
    {
        if(result != Result.HEAL)
        {
            return super.handle(result, game);
        } else {
            game.getPlayer().Lives += 1;
            return true;
        }
    }
}
