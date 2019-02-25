package com.nsa.cm6123.assessment.monopoly.board;

import com.nsa.cm6123.assessment.monopoly.player.Player;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Board {

    private int boardSquares;
    private int width;
    private int length;
    ArrayList<Square> boardtiles = new ArrayList<>();

    ArrayList squares = new ArrayList();

    private static Logger LOGGER = null;
    static {
        InputStream stream = Player.class.getClassLoader().getResourceAsStream("logging.properties"); //replace Player with the name of the class
        try {
            LogManager.getLogManager().readConfiguration(stream);
            LOGGER = Logger.getLogger(Player.class.getName());//replace Player with the name of the class
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // a Board Constructor
    public Board(int width, int length){
        this.width = width;
        this.length = length;
        int boardSquares = (2*width) + (2*length);

        if (width<=1 || length<=1){
            throw new IllegalArgumentException("Minimum Size is 2 x 2 ");
        }




    }

// Methods
    public int getSquares(){
        //Finding out the perimeter of the rectangle to work out the number of squares.

        LOGGER.info("Number of squares: " + boardSquares);
        return boardSquares;
    }



}
