package com.example.responsibillitychain.Logic;

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
}
