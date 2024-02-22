package com.example.responsibillitychain.Logic;

import com.example.responsibillitychain.Models.EnterObject;
import com.example.responsibillitychain.Models.Spike;

import java.util.ArrayList;
import java.util.List;

public class Kabanchik{
    List<EnterObject> mainObj;
    GameEngine game;
    public Kabanchik(List<EnterObject> objs, GameEngine game)
    {
        this.game = game;
        mainObj = new ArrayList<EnterObject>();
        mainObj.addAll(objs);
    }
    public Kabanchik(GameEngine game)
    {
        mainObj = new ArrayList<EnterObject>();
        this.game = game;
    }
    public void addObj(EnterObject spike)
    {
        mainObj.add(spike);
    }
    public void ClearObjs()
    {
        mainObj.clear();
    }

    public void makeMove()
    {
        for (var obj:
             mainObj) {
            if(game.CheckCords(obj.X, obj.Y)){
                continue;
            }
            if(obj.X < game.player.X) {
                obj.X += 1;
                continue;
            }
            if(obj.X > game.player.X) {
                obj.X -= 1;
                continue;
            }
            if(obj.Y < game.player.Y) {
                obj.Y += 1;
                continue;
            }
            if(obj.Y > game.player.Y) {
                obj.Y -= 1;
                continue;
            }
        }
    }
}
