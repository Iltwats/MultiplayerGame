package com.atul.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    public boolean hasCards() {
        return hand.isEmpty();
    }

    public boolean hasCardInHand(Card card) {
        return hand.contains(card);
    }

    @Override
    public String toString() {
        return name;
    }
}
