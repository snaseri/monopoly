package com.nsa.cm6123.assessment.monopoly;

import com.nsa.cm6123.assessment.monopoly.game.Game;
import com.nsa.cm6123.assessment.monopoly.player.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Player player1;
    private Player player2;

    @Before
    public void constructGameAndGeneratePlayers() {
        game = new Game();
        game.generatePlayers();
        player1 = game.getPlayer(0);
        player2 = game.getPlayer(1);

    }


    @Test
    public void getPlayers() throws Exception {
        assertEquals(4,game.getPlayers().size());
    }

    @Test
    public void getPlayer() throws Exception {
        assertEquals("Dog", player2.getToken());
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
        game.circutReward(player1);
        assertEquals(400, game.getPlayers().get(0).getBalance());
    }

    @Test
    public void propertyPurchase() throws Exception {
        player1.setPosition(1);
        game.propertyPurchase();
        assertEquals(140, player1.getBalance());
    }

    @Test
    public void PurchasedPropertyIsntBoughtByAnotherPlayer() throws Exception {
        player1.setPosition(1);
        game.propertyPurchase();
        player2.setPosition(1);
        game.propertyPurchase();
        assertEquals(188, player2.getBalance());
    }

    @Test
    public void startSquareCannotBePurchased() throws Exception {
        player1.setPosition(0);
        game.propertyPurchase();
        assertEquals(game.getBoard().getSquareByPosition(0).getLocation().
                getOwner().getToken(), "Start");
    }

    @Test
    public void checkpayRentTenantsBalance() throws Exception {
        player1.setPosition(1);
        game.propertyPurchase();
        player2.setPosition(1);
        game.payRent(player1,player2);
        assertEquals(188, player2.getBalance());
    }

    @Test
    public void checkpayRentOwnersBalance() throws Exception {
        player1.setPosition(1);
        game.propertyPurchase();
        player1.setBalance(0);
        player2.setPosition(1);
        game.payRent(player1,player2);
        assertEquals(12, player1.getBalance());
    }


    @Test
    public void checkTenantDoesntPurchaseProperty() throws Exception {
        player1.setPosition(1);
        game.propertyPurchase();
        player2.setPosition(1);
        game.propertyPurchase();
        assertEquals(game.getBoard().getSquareByPosition(1).getLocation().getOwner(),
                player1);
    }

    @Test
    public void noRentPayedToStartSquare() throws Exception {
        player1.setPosition(0);
        game.propertyPurchase();
        player2.setPosition(0);
        game.propertyPurchase();
        assertEquals(200,
                player2.getBalance());
    }

    @Test
    public void updateNetworth() throws Exception {
        player1.setBalance(600);
        //This square is worth 400
        game.getBoard().getAllSquareCreated().get(23).
                getLocation().setOwner(player1);
        game.updateNetworth();
        assertEquals(1000,
                player1.getNetworth());
    }

    @Test
    public void updateNetworthWith3SquaresOwned() throws Exception {
        player1.setBalance(600);
        //This square is worth 400, 350, 320
        game.getBoard().getAllSquareCreated().get(23).
                getLocation().setOwner(player1);
        game.getBoard().getAllSquareCreated().get(22).
                getLocation().setOwner(player1);
        game.getBoard().getAllSquareCreated().get(21).
                getLocation().setOwner(player1);
        game.updateNetworth();
        assertEquals(1670,
                player1.getNetworth());
    }


}
