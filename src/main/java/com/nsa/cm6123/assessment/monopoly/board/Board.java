package com.nsa.cm6123.assessment.monopoly.board;

import com.nsa.cm6123.assessment.monopoly.player.Player;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Board {

    private int boardSquares;
    private final int width;
    private final int length;
    private ArrayList<Square> boardtiles = new ArrayList<>();

    private ArrayList squares = new ArrayList();

    private static Logger logger = null;
    static {
        InputStream stream =
                Player.class.getClassLoader().
                        getResourceAsStream("logging.properties");
        //replace Player with the name of the class
        try {
            LogManager.getLogManager().readConfiguration(stream);
            logger = Logger.getLogger(Player.class.getName());
            //replace Player with the name of the class
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // a Board Constructor
    public Board(final int aWidth, final int aLength) {
        this.width = aWidth;
        this.length = aLength;
        this.boardSquares = (2 * width) + (2 * length);

        if (width <= 1 || length <= 1) {
            throw new IllegalArgumentException("Minimum Size is 2 x 2 ");
        }

        //Adding a tile for each tile their should be on the
        // board depending on its size
        for (int i = 0; i < boardSquares; i++) {
            Square square = new Square(i);
            boardtiles.add(square);
        }

    }

// Methods
    public int getBoardSize() {
        //Finding out the perimeter of the rectangle
        // to work out the number of squares.
        return boardSquares;
    }

    // a method to get all the squares created
    // and added to the board/the arraylist
    public int getTotalSquareCreated() {
        return boardtiles.size();
    }

    // Gets the nth square of the board
    public Square getSquareByPosition(final int index) {
        return boardtiles.get(index);
    }

    // Gets the first starting square of the board
    public Square getStartSquare() {

        return boardtiles.get(0);
    }


}
