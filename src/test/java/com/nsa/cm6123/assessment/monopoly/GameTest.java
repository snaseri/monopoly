package com.nsa.cm6123.assessment.monopoly;

import com.nsa.cm6123.assessment.monopoly.board.Board;
import com.nsa.cm6123.assessment.monopoly.player.Player;
import com.nsa.cm6123.assessment.monopoly.game.Game;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.Arrays;


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
        assertEquals(20, game.getBoard().getBoardSize());
    }

    @Test
    public void loopAroundBoard() throws Exception {
        game.loopAroundBoard(1);
        assertEquals("Dog", "Dog");
    }
}
