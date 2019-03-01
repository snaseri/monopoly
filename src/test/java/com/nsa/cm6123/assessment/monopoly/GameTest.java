package com.nsa.cm6123.assessment.monopoly;

import com.nsa.cm6123.assessment.monopoly.game.Game;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;

    @Before
    public void constructGameAndGeneratePlayers() {
        game = new Game();
        game.generatePlayers();

    }


    @Test
    public void getPlayers() throws Exception {
        assertEquals(4,game.getPlayers().size());
    }

    @Test
    public void getPlayer() throws Exception {
        assertEquals("Dog", game.getPlayer(1).getToken());
    }

    @Test
    public void checkGeneratedBoard() throws Exception {
        assertEquals(24, game.getBoard().getBoardSize());
    }

    @Test
    public void loopAroundBoard() throws Exception {
        game.loopAroundBoard(1);
        assertEquals(1, game.getPlayers().get(0).getPasses());
    }

    @Test
    public void add200BalanceAfterCircut() throws Exception {
        game.circutReward(game.getPlayer(0));
        assertEquals(400, game.getPlayers().get(0).getBalance());
    }

    @Test
    public void propertyPurchase() throws Exception {
        game.getPlayer(0).setPosition(1);
        game.propertyPurchase();
        assertEquals(140, game.getPlayer(0).getBalance());
    }

    @Test
    public void PurchasedPropertyIsntBoughtByAnotherPlayer() throws Exception {
        game.getPlayer(0).setPosition(1);
        game.propertyPurchase();
        game.getPlayer(1).setPosition(1);
        game.propertyPurchase();
        assertEquals(200, game.getPlayer(1).getBalance());
    }

    @Test
    public void startSquareCannotBePurchased() throws Exception {
        game.getPlayer(0).setPosition(0);
        game.propertyPurchase();
        assertEquals(game.getBoard().getSquareByPosition(0).getLocation().
                getOwner().getToken(), "Start");
    }

}
