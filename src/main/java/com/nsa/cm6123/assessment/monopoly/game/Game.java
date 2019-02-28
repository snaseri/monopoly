package com.nsa.cm6123.assessment.monopoly.game;

import com.nsa.cm6123.assessment.monopoly.board.Board;
import com.nsa.cm6123.assessment.monopoly.player.Player;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Game {

    private final int player1ListIndex = 0;
    private final int player2ListIndex = 1;
    private final int player3ListIndex = 2;
    private final int player4ListIndex = 3;

    private int loop;
    private final int width = 5;
    private final int length = 5;
    private Board board = new Board(width, length);


    private static Logger logger = null;
    static {
        InputStream stream =
                Player.class.getClassLoader().
                        getResourceAsStream("logging.properties");
        //replace Player with the name of the class
        try {
            LogManager.getLogManager().readConfiguration(stream);
            logger = Logger.getLogger(Player.class.getName());
            //replace Player with the name of the class
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> tokens = new
            ArrayList<>(Arrays.asList("TopHat", "Dog", "Car", "BattleShip"));
    private ArrayList<Player> players = new ArrayList<>();


    public void generatePlayers() {
        final int numberOfPlayers = 4;
        for (int i = 0; i < numberOfPlayers; i++) {
            String playerToken = tokens.get(i);
            Player player = new Player(playerToken);
            players.add(player);
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(final int num) {
        return players.get(num);
    }

    public Board getBoard() {
        return board;
    }
    public void loopAroundBoard(final int numOfLoops) {
        while (loop < numOfLoops) {

            for (Player player : players) {
                if (!player.rollAndMove()) {
                    continue;

                } else {
                    int playerPasses = player.getPasses() + 1;
                    player.setPasses(playerPasses);
                }
            }
            if (players.get(player1ListIndex).getPasses() == numOfLoops &&
                players.get(player2ListIndex).getPasses() == numOfLoops &&
                players.get(player3ListIndex).getPasses() == numOfLoops &&
                players.get(player4ListIndex).getPasses() == numOfLoops) {
                break;
            }
        }
    }
}


