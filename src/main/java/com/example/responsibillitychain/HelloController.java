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
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements EventHandler<KeyEvent> {
    @FXML
    private Pane mainPane;
    @FXML
    private VBox mainWindow;
    GameEngine game;

    public void initialize()
    {
        mainPane.toFront();
        mainWindow.setOnKeyPressed(this::handle);
        game = new GameEngine(mainPane);
        game.objects.add(new Spike(3,6));
        game.objects.add(new Spike(10,3));
        game.objects.add(new Spike(5,0));
        game.objects.add(new Spike(0,12));
        game.objects.add(new Coin(12,1));
        game.objects.add(new Coin(2,2));
        game.objects.add(new Heal(9,2));
        game.objects.add(new Heal(2,9));

        for (var sp:
             game.objects) {
            if(sp.getClass()==Spike.class)
            {
                game.enemyLogic.addObj(sp);
            }
        }

        game.GameMove(mainPane);
    }
    @Override
    public void handle(KeyEvent e) {
        if (e.getCode() == KeyCode.W)
            game.PlayerMove(0, -1);
        if (e.getCode() == KeyCode.A)
            game.PlayerMove(-1, 0);
        if (e.getCode() == KeyCode.S)
            game.PlayerMove(0, 1);
        if (e.getCode() == KeyCode.D)
            game.PlayerMove(1, 0);

        game.GameMove(mainPane);
    }
}