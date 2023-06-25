package com.atul.models;

import java.util.ArrayList;

public class Player {
    int playerID;
    ArrayList<Card> hand;

    public Player(int playerID) {
        this.playerID = playerID;
        hand = new ArrayList<>();
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerID=" + playerID +
                ", hand=" + hand +
                '}';
    }

    public void insertCard(Card card) {
        hand.add(card);
    }

    public void deleteCard(Card card) {
        hand.remove(card);
    }
}
