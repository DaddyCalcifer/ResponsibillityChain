package com.example.responsibillitychain.Logic;


import com.example.responsibillitychain.Handlers.CoinHandler;
import com.example.responsibillitychain.Handlers.HealHandler;
import com.example.responsibillitychain.Handlers.LoseHandler;
import com.example.responsibillitychain.Models.Handler;
import com.example.responsibillitychain.Models.Player;
import com.example.responsibillitychain.Models.Result;

public class ActionChain {
    Handler chain;
    public ActionChain() {
        buildChain();

    }

    private void buildChain() {
        chain = new HealHandler(new LoseHandler(new CoinHandler(null)));
    }
    public Handler getChain()
    {
        return chain;
    }
    public void handle(Result result, GameEngine gameEngine)
    {
        chain.handle(result,gameEngine);
    }
}