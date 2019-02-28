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
        game.loopAroundBoard(1);
        assertEquals(400, game.getPlayers().get(0).getBalance());
    }
}
