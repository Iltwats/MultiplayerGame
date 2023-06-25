package com.atul.services;

import com.atul.models.Card;
import com.atul.models.Player;

import java.util.ArrayList;

public interface MultiplayerGame {

    void start();
    void playCard(Player player, Card card);

}
