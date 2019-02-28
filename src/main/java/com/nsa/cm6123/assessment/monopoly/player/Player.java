package com.nsa.cm6123.assessment.monopoly.player;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Player {


    // Add this block to the start of each class that you wish to log.
    // It is not elegant by any means, but I don't want
    // to drag in more dependencies to get a
    // better framework

    private static Logger logger = null;

    static {
        InputStream stream = Player.class.getClassLoader().
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

    //end of logging block

    private String token;
    private long balance;
    private int position;
    private final int boardSize = 24;
    private int pass;

    private static final long STARTING_BALANCE = 200L;


    public Player(final String aToken, final long aBalance,
                  final int aPosition, final int aPass) {
        this.token = aToken;
        this.balance = aBalance;
        this.position = aPosition;
        //pass checks to see how many times a player has been around a board
        this.pass = aPass;
        logger.info("Player created: Token = " + token
                + ", aBalance = " + balance);
        // you can log like this using the methods, or...
        // pick one and be consistent.

    }


// Player Methods

    public Player(final String aToken, final long aBalance,
                  final int aPosition) {
        this(aToken, STARTING_BALANCE,  aPosition, 0);
    }

    public Player(final String aToken, final long aBalance) {
        this(aToken, STARTING_BALANCE,  0, 0);
    }

    public Player(final String aToken) {
        this(aToken, STARTING_BALANCE, 0, 0);
    }

    public Player() {
        this("Top Hat", STARTING_BALANCE, 0, 0);
    }


    public String getToken() {
        return token;
    }

    public void setToken(final String aToken) {
        this.token = aToken;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(final long aBalance) {
        this.balance = aBalance;
    }

    public int getPasses() {
        return pass;
    }

    public void setPasses(final int num) {
        this.pass = num;
    }

    // this method returns true if player has gone around the board
    public boolean rollAndMove() {
        Dice dice = new Dice();
        int n = dice.roll();
        position = position + n;
        if (position > boardSize) {
            position = position - boardSize;

            logger.info("Player with Token " + token + " rolled a "
                    + n + " and now is on Square position " + position);

            logger.info("Player " + token +
                    " has looped around the board");

            return true;
        } else {
            logger.info("Player with Token " + token + " rolled a "
                    + n + " and now is on Square position " + position);
            return false;
        }

        }

//    public Square getCurrentSquare(){
//
//    }

    public int getPosition() {
        return position;
    }


    public void setPosition(final int newPosition) {
        position = newPosition;
    }

    @Override
    public String toString() {
        return "Player{" +
                "token='" + token + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return balance == player.balance &&
                Objects.equals(token, player.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, balance);
    }

    public void doNothing() {

    }
}
