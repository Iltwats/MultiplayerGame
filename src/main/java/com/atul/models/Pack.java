package com.atul.models;

import com.atul.constants.CardTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Pack {
    ArrayList<Card> packs;

    public Pack() {
        this.packs = shuffledDeck();
    }

    public ArrayList<Card> getPacks() {
        return packs;
    }

    public void setPacks(ArrayList<Card> packs) {
        this.packs = packs;
    }

    public ArrayList<Card> shuffledDeck() {
        ArrayList<Card> shuffledCards = new ArrayList<>();
        for (CardTypes cardTypes : CardTypes.values()) {
            for (int i = 1; i <= 13; i++) {
                shuffledCards.add(new Card(i, cardTypes));
            }
        }
        // using seed so everytime shuffle is different.
        Collections.shuffle(shuffledCards, new Random(System.currentTimeMillis()));
        return shuffledCards;
    }
}
