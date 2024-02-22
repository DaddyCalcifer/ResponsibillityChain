package com.example.responsibillitychain.Handlers;

import com.example.responsibillitychain.Logic.GameEngine;
import com.example.responsibillitychain.Models.Handler;
import com.example.responsibillitychain.Models.Player;
import com.example.responsibillitychain.Models.Result;

public class LoseHandler extends Handler {
    public LoseHandler(Handler next)
    {
        super(next);
    }
    public boolean handle(Result result, GameEngine game)
    {
        if(result != Result.SPIKE)
        {
            return super.handle(result, game);
        } else {
            game.getPlayer().Lives -= 1;
            return true;
        }
    }
}
