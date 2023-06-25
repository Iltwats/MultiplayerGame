package com.atul.models;

import com.atul.constants.CardTypes;
import com.atul.constants.Rank;

public class Card {
    CardTypes cardTypes;
    Rank rank;

    public Card(CardTypes cardTypes, Rank rank) {
        this.rank = rank;
        this.cardTypes = cardTypes;
    }

    public CardTypes getCardTypes() {
        return cardTypes;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + cardTypes;
    }
}

