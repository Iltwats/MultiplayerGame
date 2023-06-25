package com.atul.models;

import com.atul.constants.CardTypes;
import com.atul.constants.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Card card;
    @BeforeEach
    void initCard(){
        card = new Card(CardTypes.HEARTS, Rank.NINE);
    }
    @Test
    void getCardTypes() {
        assertEquals(card.getCardTypes(),CardTypes.HEARTS);
    }

    @Test
    void getRank() {
        assertEquals(card.getRank(),Rank.NINE);
    }
}