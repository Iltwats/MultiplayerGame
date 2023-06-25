package com.atul.services;

import com.atul.models.Card;
import com.atul.models.Player;

import java.util.ArrayList;

public interface MultiplayerGame {

    /**
     *  Starts the game, with initial card distribution from pile
     *  and continue until cards are over or there is a result
     */
    void start();

    /**
     * Plays the game, for each player with respect to each player moves
     * @param player, the player playing
     * @param card, card of the player
     */
    void playCard(Player player, Card card);

}
