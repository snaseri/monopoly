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

        assertEquals(100L, topHat.getBalance());

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

    @Test
    public void checkSetPosition() {
        Player player = new Player("Top Hat", 200L, 6,0);
        player.setPosition(3);
        assertEquals(3, player.getPosition());
    }

    @Test
    public void checkPlayerGetPositionMethod() {
        Player topHat = new Player("Top Hat", 200L, 6,0);
        assertEquals(6, topHat.getPosition());
    }

    @Test
    public void playerMove() {
        Player topHat = new Player("Top Hat", 200L, 0,0);
        int dice_num = 3;
        int new_position = topHat.getPosition() + dice_num;
        topHat.setPosition(new_position);
        assertEquals(3, topHat.getPosition());
    }

    @Test
    public void rollAndMoveFullBoardLoop() {
        Player player = new Player("Dog", 200L, 25,0);
        assertEquals(true, player.rollAndMove());
    }

    @Test
    public void rollAndMoveNotFullBoardLoop() {
        assertEquals(false, topHat.rollAndMove());
    }

    @Test
    public void getPasses() {
        assertEquals(0, topHat.getPasses());
    }

    @Test
    public void setPasses() {
        topHat.setPasses(2);
        assertEquals(2, topHat.getPasses());
    }

    @Test
    public void getNetworth() {
        assertEquals(200, topHat.getNetworth());
    }

    @Test
    public void setNetworth() {
        topHat.setNetworth(5);
        assertEquals(5, topHat.getNetworth());
    }
}