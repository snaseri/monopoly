package com.nsa.cm6123.assessment.monopoly.Board;

import com.nsa.cm6123.assessment.monopoly.board.Board;
import com.nsa.cm6123.assessment.monopoly.board.Square;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void checkBoardPerimeterFormula() throws Exception {
        Board board = new Board(2,2);
        System.out.println("BOARD SQUAERS ARE " + board.getSquares());
        assertEquals(8, board.getSquares());
    }

    @Test
    public void checkNumberOfBoardSquaresCreated() throws Exception {
        Board board = new Board(2,2);
        System.out.println("BOARD SQUAERS ARE " + board.getSquares());
        assertEquals(8, boardtiles.size());
    }


}
