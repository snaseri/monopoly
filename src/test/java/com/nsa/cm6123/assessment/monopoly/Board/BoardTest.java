package com.nsa.cm6123.assessment.monopoly.Board;

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
        assertEquals(8, board.getTotalSquareCreated());
    }

    @Test
    public void checkSquarePositions() throws Exception {
        Board board = new Board(2,2);
        Square square = new Square(4);
        System.out.println(board.getSquareByPosition(4).getPosition());
        assertEquals(square.getPosition(),board.getSquareByPosition(4).getPosition());
    }

    @Test
    public void checkBoardStartIsAtCorrectPlace() throws Exception {
        Board board = new Board(11,11);
        assertEquals(0, board.getStartSquare().getPosition());
    }

}
