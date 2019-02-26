package com.nsa.cm6123.assessment.monopoly.player;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Player {


    // Add this block to the start of each class that you wish to log.
    // It is not elegant by any means, but I don't want to drag in more dependencies to get a
    // better framework

    private static Logger LOGGER = null;

    static {
        InputStream stream = Player.class.getClassLoader().getResourceAsStream("logging.properties"); //replace Player with the name of the class
        try {
            LogManager.getLogManager().readConfiguration(stream);
            LOGGER = Logger.getLogger(Player.class.getName());//replace Player with the name of the class
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //end of logging block

    private String token;
    private long balance;

    private static final long STARTING_BALANCE = 200L;


    public Player(final String aToken, final long aBalance) {
        this.token = aToken;
        this.balance = aBalance;
        LOGGER.info("Player created: Token = " + token + ", aBalance = " + balance); // you can log like this using the methods, or...
        LOGGER.log(Level.INFO, "Player created: Token = " + token + ", aBalance = " + balance); // like this, specifying the level as a parameter
        // pick one and be consistent.

    }


    public Player(final String aToken) {
        this(aToken, STARTING_BALANCE);
    }

    public Player() {
        this("Top Hat");
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
