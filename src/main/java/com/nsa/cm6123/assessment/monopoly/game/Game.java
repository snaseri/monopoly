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

    private final long circutReward = 200L;
    private final int player1ListIndex = 0;
    private final int player2ListIndex = 1;
    private final int player3ListIndex = 2;
    private final int player4ListIndex = 3;

    private final int rentDivder = 5;

    private int loop;
    private final int width = 6;
    private final int length = 6;
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

    public void payRent(final Player owner,
                        final Player tenant) {
        long rentValue = board.getSquareByPosition(tenant.getPosition()).
                getLocation().getValue() / rentDivder;
        tenant.setBalance(tenant.getBalance() - rentValue);
        owner.setBalance(owner.getBalance() + rentValue);
    }

    // This method checks to see if the square that the
    // player is on doesn't have a owner and the player
    // has enough money to purchase
    public void propertyPurchase() {
        for (Player player : players) {
            if (board.getSquareByPosition(player.getPosition()).
                    getLocation().getOwner().getToken().equals("None") &&
                    player.getBalance() >= board.getSquareByPosition(player.
                            getPosition()).getLocation().getValue()) {
                long newPlayerBalance = player.getBalance() -
                board.getSquareByPosition(player.getPosition()).
                        getLocation().getValue();
                player.setBalance(newPlayerBalance);
                board.getSquareByPosition(player.getPosition()).getLocation()
                        .setOwner(player);
                logger.info("Player " + player.getToken() + " purchased " +
                board.getSquareByPosition(player.getPosition()).
                        getLocation().getName() +
                " and now has a balance of " + player.getBalance());
          //Else if checks to see if the property is owned by a player
          //who is not himself or the start square.
            } else if (!
                    board.getSquareByPosition(player.getPosition())
                            .getLocation().getOwner().
                            getToken().equalsIgnoreCase("None") &&
                    !board.getSquareByPosition(player.getPosition())
                            .getLocation().getOwner().getToken()
                            .equalsIgnoreCase("Start") &&
            !board.getSquareByPosition(player.getPosition())
                    .getLocation().getOwner().
                    equals(player)) {
                this.payRent(board.getSquareByPosition(player.getPosition())
                                .getLocation().getOwner(), player);
                logger.info("Player " + player.getToken()
                        + " has payed rent to "
                + board.getSquareByPosition(player.getPosition())
                        .getLocation().getOwner().getToken());
            }
        }
    }


    public Board getBoard() {
        return board;
    }

    public void circutReward(final Player player) {
        player.setBalance(player.getBalance() + circutReward);
    }

    public void loopAroundBoard(final int numOfLoops) {
        while (loop < numOfLoops) {

            for (Player player : players) {
                if (!player.rollAndMove()) {
                    continue;
                } else {
                    int playerPasses = player.getPasses() + 1;
                    player.setPasses(playerPasses);
                    this.circutReward(player);
                }
            }
            this.propertyPurchase();

            if (players.get(player1ListIndex).getPasses() == numOfLoops &&
                players.get(player2ListIndex).getPasses() == numOfLoops &&
                players.get(player3ListIndex).getPasses() == numOfLoops &&
                players.get(player4ListIndex).getPasses() == numOfLoops) {
                break;
            }
        }
    }
}


