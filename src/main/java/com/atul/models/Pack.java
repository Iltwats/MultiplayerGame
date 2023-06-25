package com.atul.models;



import com.atul.constants.CardTypes;
import com.atul.constants.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Pack {
    private final List<Card> cards;

    public Pack() {
        cards = new ArrayList<>();
        for (CardTypes cardTypes : CardTypes.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(cardTypes, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }
}
