package com.atul;

import com.atul.services.MultiplayerGame;
import com.atul.services.MultiplayerGameImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> playerNames = Arrays.asList("Player 1", "Player 2", "Player 3", "Player 4");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of players between 2 and 4(inclusive)!");
        int numOfPlayers = sc.nextInt();
        if (numOfPlayers < 2 || numOfPlayers > 4) {
            throw new Exception("Not a valid players for the game");
        }

        MultiplayerGame multiplayerGame = new MultiplayerGameImpl(playerNames.subList(0,numOfPlayers));
        multiplayerGame.start();
    }
}
