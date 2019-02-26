package com.nsa.cm6123.assessment.monopoly;

import com.nsa.cm6123.assessment.monopoly.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player topHat;
    private static final long EXPECTED_BALANCE = 200L;


    @Before
    public void constructTopHatPlayer() {
        topHat = new Player("Top Hat");

    }

    @Test
    public void playerShouldStartWith200Dollars() throws Exception {
        assertEquals(EXPECTED_BALANCE, topHat.getBalance());
    }

    @Test
    public void getToken() {
        assertEquals("Top Hat", topHat.getToken());
    }

    @Test
    public void setToken() {
        topHat.setToken("Dog");
        assertEquals("Dog", topHat.getToken());


    }

    @Test
    public void getBalance() {
        assertEquals(EXPECTED_BALANCE, topHat.getBalance());

    }

    @Test
    public void setBalance() {
//        final long half = 100L;
        topHat.setBalance(100L);
//        assertEquals(half, topHat.getBalance());

        assertEquals(100L, topHat.getBalance());git

    }

    @Test
    public void toStringEquals() {
        String expectedObject = "Player{" +
                "token='" + "Top Hat" + '\'' +
                ", balance=" + EXPECTED_BALANCE +
                '}';
        assertEquals(expectedObject, topHat.toString());
    }

    @Test
    public void tokensAreEqual() {
        Player topHat2 = new Player("Top Hat");
        assertEquals(topHat, topHat2);
    }

    @Test
    public void tokensHashCode() {
        Player topHat2 = new Player("Top Hat");
        assertEquals(topHat.hashCode(), topHat2.hashCode());
    }
}
