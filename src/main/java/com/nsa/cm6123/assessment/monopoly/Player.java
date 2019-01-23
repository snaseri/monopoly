package com.nsa.cm6123.assessment.monopoly;

import java.util.Objects;

public class Player {

    private String token;
    private long balance;

    private static final long STARTING_BALANCE = 200L;


    public Player(final String aToken, final long aBalance) {
        this.token = aToken;
        this.balance = aBalance;
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
}
