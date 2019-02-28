package com.nsa.cm6123.assessment.monopoly;

import com.nsa.cm6123.assessment.monopoly.board.Board;
import com.nsa.cm6123.assessment.monopoly.board.Square;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void checkBoardPerimeterFormula() throws Exception {
        Board board = new Board(2,2);
        assertEquals(8, board.getBoardSize());
    }

    @Test
    public void checkNumberOfBoardSquaresCreated() throws Exception {
        Board board = new Board(2,2);
        assertEquals(8, board.getAllSquareCreated().size());
    }

    @Test
    public void getAllSquaresCreatedSquarePosition() throws Exception {
        Board board = new Board(2,2);
        assertEquals(4,board.getAllSquareCreated().get(4).getPosition());
    }

    @Test
    public void getAllSquaresCreatedSize() throws Exception {
        Board board = new Board(6,6);
        assertEquals(24, board.getAllSquareCreated().size());
    }

}
