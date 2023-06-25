package com.atul.models;

import com.atul.constants.CardTypes;
import com.atul.constants.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PackTest {

    @Test
    public void shuffleCheck() {
        List<Card> originalPack = new ArrayList<>();
        for (CardTypes cardTypes : CardTypes.values()) {
            for (Rank rank : Rank.values()) {
                originalPack.add(new Card(cardTypes, rank));
            }
        }
        Pack pack = new Pack();
        List<Card> shuffled = pack.getCards();
        assertNotSame(originalPack.toString(), shuffled.toString());
    }

    @Test
    void drawCard() {
        Pack pack = new Pack();
        assertNotNull(pack.drawCard());
    }

    @Test
    void isEmpty() {
        Pack pack = new Pack();
        assertFalse(pack.isEmpty());
    }
}