package com.atul.services;

import com.atul.constants.Rank;
import com.atul.models.Card;
import com.atul.models.Pack;
import com.atul.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiplayerGameImpl implements MultiplayerGame {
    private final List<Player> players;
    private final Pack pack;
    private final List<Card> discardPile;
    private final Map<Rank, Integer> rankActionMap;
    private int currentPlayerIndex;
    private int direction;
    private boolean gameOver;

    public MultiplayerGameImpl(List<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        this.pack = new Pack();
        discardPile = new ArrayList<>();
        rankActionMap = getRankActionMap();
        currentPlayerIndex = 0;
        direction = 1;
        gameOver = false;
    }

    private Map<Rank, Integer> getRankActionMap() {
        final Map<Rank, Integer> rankActionMap;
        rankActionMap = new HashMap<>();

        rankActionMap.put(Rank.ACE, 0); // Skip next player
        rankActionMap.put(Rank.KING, -1); // Reverse sequence
        rankActionMap.put(Rank.QUEEN, 2); // Draw 2 cards
        rankActionMap.put(Rank.JACK, 4); // Draw 4 cards
        return rankActionMap;
    }

    @Override
    public void start() {
        System.out.println("Starting the card game!");
        dealInitialCards();
        playGame();
        System.out.println("Game over!");
    }

    /**
     * Drives the game for each individual player
     * @param player, who is playing
     * @param card, which is being discarded
     */
    @Override
    public void playCard(Player player, Card card) {
        if (player.equals(players.get(currentPlayerIndex))) {
            if (canPlayCard(discardPile.get(discardPile.size() - 1), player)) {
                if (player.hasCardInHand(card)) {
                    player.removeCardFromHand(card);
                    discardPile.add(card);
                    System.out.println(player + " played " + card);

                    if (player.hasCards()) {
                        gameOver = true;
                        System.out.println(player + " wins the game!");
                    } else {
                        applyCardAction(card);
                        currentPlayerIndex = getNextPlayerIndex();
                    }
                } else {
                    System.out.println(player + " does not have the card: " + card);
                }
            } else {
                System.out.println(player + " cannot play the card: " + card);
            }
        } else {
            System.out.println("It is not " + player + "'s turn to play.");
        }
    }
    private void dealInitialCards() {
        for (Player player : players) {
            List<Card> hand = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Card card = pack.drawCard();
                hand.add(card);
            }
            player.setHand(hand);
        }

        discardPile.add(pack.drawCard());
    }

    /**
     * Drives the game for all the players
     */
    private void playGame() {
        while (!gameOver) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\n" + currentPlayer + "'s turn");
            System.out.println("Cards in hand: " + currentPlayer.getHand());
            Card topCard = discardPile.get(discardPile.size() - 1);
            System.out.println("Top card on the discard pile: " + topCard);

            if (canPlayCard(topCard, currentPlayer)) {
                Card cardToPlay = currentPlayer.getHand().get(0); // Play the first card in hand
                currentPlayer.removeCardFromHand(cardToPlay);
                discardPile.add(cardToPlay);
                System.out.println(currentPlayer + " played " + cardToPlay);

                if (currentPlayer.hasCards()) {
                    gameOver = true;
                    System.out.println(currentPlayer + " wins the game!");
                    break;
                }

                applyCardAction(cardToPlay);

                if (rankActionMap.containsKey(cardToPlay.getRank())) {
                    currentPlayerIndex = getNextPlayerIndex();
                }
            } else {
                Card drawnCard = pack.drawCard();
                currentPlayer.addCardToHand(drawnCard);
                System.out.println(currentPlayer + " drew a card: " + drawnCard);

                if (pack.isEmpty()) {
                    gameOver = true;
                    System.out.println("Draw pile is empty. The game ends in a draw.");
                    break;
                }
            }

            currentPlayerIndex = getNextPlayerIndex();
        }
    }

    /**
     * Checks condition if another player can play onto the card played
     * by previous player
     * @param topCard, previous played card
     * @param player, current player
     * @return true, if can be played, else false
     */
    private boolean canPlayCard(Card topCard, Player player) {
        for (Card card : player.getHand()) {
            if (card.getCardTypes() == topCard.getCardTypes() || card.getRank() == topCard.getRank()) {
                return true;
            }
        }
        return false;
    }

    private int getNextPlayerIndex() {
        int nextPlayerIndex = currentPlayerIndex + direction;
        if (nextPlayerIndex < 0) {
            nextPlayerIndex = players.size() - 1;
        } else if (nextPlayerIndex >= players.size()) {
            nextPlayerIndex = 0;
        }
        return nextPlayerIndex;
    }

    /**
     * Determines what will happen when an action card is played
     * @param card
     */
    private void applyCardAction(Card card) {
        Integer action = rankActionMap.get(card.getRank());
        if (action != null) {
            if (action > 0) {
                for (int i = 0; i < action; i++) {
                    Player nextPlayer = players.get(getNextPlayerIndex());
                    Card drawnCard = pack.drawCard();
                    if (drawnCard != null) {
                        nextPlayer.addCardToHand(drawnCard);
                        System.out.println(nextPlayer + " drew a card: " + drawnCard);
                    } else {
                        gameOver = true;
                        System.out.println("Draw pile is empty. The game ends in a draw.");
                        return;
                    }
                }
            } else if (action == 0) {
                Player nextPlayer = players.get(getNextPlayerIndex());
                System.out.println(nextPlayer + "'s turn is skipped!");
            } else if (action == -1) {
                direction *= -1;
                System.out.println("Direction is reversed!");
            }
        }
    }
}

