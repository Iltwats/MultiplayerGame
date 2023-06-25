package com.atul.models;

import com.atul.constants.CardTypes;

public class Card {
    int number;
    CardTypes cardTypes;

    public Card(int number, CardTypes cardTypes) {
        this.number = number;
        this.cardTypes = cardTypes;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public CardTypes getCardTypes() {
        return cardTypes;
    }

    public void setCardTypes(CardTypes cardTypes) {
        this.cardTypes = cardTypes;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", cardTypes=" + cardTypes +
                '}';
    }
}

