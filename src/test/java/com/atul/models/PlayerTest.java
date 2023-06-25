package com.atul.models;

import com.atul.constants.CardTypes;
import com.atul.constants.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Card card;
    Player player;

    @BeforeEach
    void setup(){
        card = new Card(CardTypes.CLUBS, Rank.KING);
        player = new Player("Player");
        player.addCardToHand(card);
    }
    @Test
    void getName() {
        assertEquals(player.getName(),"Player");
    }

    @Test
    void getHand() {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardTypes.CLUBS, Rank.KING);
        hand.add(card1);
        assertEquals(player.getHand().toString(), hand.toString());
    }

    @Test
    void addCardToHand() {
        assertFalse(player.getHand().isEmpty());
    }

    @Test
    void removeCardFromHand() {
        player.removeCardFromHand(card);
        assertTrue(player.getHand().isEmpty());
    }

}