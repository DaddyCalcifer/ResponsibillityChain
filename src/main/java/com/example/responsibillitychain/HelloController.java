package com.example.responsibillitychain;

import com.example.responsibillitychain.Logic.GameEngine;
import com.example.responsibillitychain.Models.Coin;
import com.example.responsibillitychain.Models.Heal;
import com.example.responsibillitychain.Models.Spike;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements EventHandler<KeyEvent> {
    @FXML
    private Pane mainPane;
    GameEngine game;

    public void initialize()
    {
        mainPane.toFront();
        game = new GameEngine(mainPane);
        game.objects.add(new Spike(3,6));
        game.objects.add(new Spike(10,3));
        game.objects.add(new Spike(5,0));
        game.objects.add(new Spike(0,12));
        game.objects.add(new Coin(12,1));
        game.objects.add(new Coin(2,2));
        game.objects.add(new Heal(9,2));
        game.objects.add(new Heal(2,9));

        game.GameMove(mainPane);
        System.out.println("XD");
    }
    @Override
    public void handle(KeyEvent e)
    {

        game.GameMove(mainPane);
        System.out.println("pressed");
    }
    @FXML
    public void moveUp()
    {
        game.getPlayer().Y-=1;
        game.GameMove(mainPane);
    }
    @FXML
    public void moveDown()
    {
        game.getPlayer().Y+=1;
        game.GameMove(mainPane);
    }
    @FXML
    public void moveLeft()
    {
        game.getPlayer().X-=1;
        game.GameMove(mainPane);
    }
    @FXML
    public void moveRight()
    {
        game.getPlayer().X+=1;
        game.GameMove(mainPane);
    }
}