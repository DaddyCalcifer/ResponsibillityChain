package com.example.responsibillitychain.Handlers;

import com.example.responsibillitychain.Logic.GameEngine;
import com.example.responsibillitychain.Models.Handler;
import com.example.responsibillitychain.Models.Player;
import com.example.responsibillitychain.Models.Result;

public class CoinHandler extends Handler {
    public CoinHandler(Handler next)
    {
        super(next);
    }
    public boolean handle(Result result, GameEngine game)
    {
        if(result != Result.COIN)
        {
            return super.handle(result, game);
        } else {
            game.getPlayer().Coins += 1;
            return true;
        }
    }
}
