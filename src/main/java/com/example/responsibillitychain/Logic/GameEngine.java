package com.example.responsibillitychain.Logic;

import com.example.responsibillitychain.HelloApplication;
import com.example.responsibillitychain.Models.EnterObject;
import com.example.responsibillitychain.Models.Player;
import com.example.responsibillitychain.Models.SceneObject;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    Player player;
    Pane pane;
    ActionChain chain;

    public Kabanchik enemyLogic = new Kabanchik(this);

    public final int maxX = 35, maxY = 20;
    public List<EnterObject> objects = new ArrayList<EnterObject>();
    public GameEngine(Pane pane)
    {
        chain = new ActionChain();
        player = new Player();
        player.SetCords(6,6);

        this.pane = pane;
        GameMove(this.pane);
    }

    public Player getPlayer() {
        return player;
    }

    void DrawScene(Pane pane)
    {
        pane.getChildren().clear();
        pane.getChildren().add(player.asObj());
        for (int i = 0; i < objects.size(); i++) {
            pane.getChildren().add(objects.get(i).asObj());
        }
    }
    public void GameMove(Pane pane)
    {
        if(player.Lives <= 0)
        {
            System.out.println("Вы проиграли! Начните игру сначала!");
            return;
        }

        for (int i = 0; i < objects.size(); i++) {
            if(player.X == objects.get(i).X && player.Y == objects.get(i).Y) {
                chain.handle(objects.get(i).onEnter(), this);
                objects.remove(i);
            }
        }
        DrawScene(pane);

        System.out.println("Жизней: " + player.Lives);
        System.out.println("Монет: " + player.Coins);
        System.out.println("X: " + player.X + "      Y: " + player.Y);
        System.out.println("\n\n");
    }
    public boolean CheckCords(int X, int Y)
    {
        for (var o:
             objects) {
            if(o.X == X && o.Y == Y)
                return false;
        }
        return true;
    }
    public void PlayerMove(int X, int Y)
    {
        enemyLogic.makeMove();
        if(player.X+X < maxX && player.X+X >= 0)
            player.X += X;
        if(player.Y+Y < maxY && player.Y+Y >= 0)
            player.Y += Y;
    }
}
