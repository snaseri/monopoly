package com.nsa.cm6123.assessment.monopoly.board;

import com.nsa.cm6123.assessment.monopoly.player.Player;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Board {

    //Variables to get rid of magic number error check
    private final long brownHousesValue = 60L;
    private final long lblueHouseValue1 = 100L;
    private final long lblueHouseValue2 = 120L;
    private final long pinkHouseValue1 = 140L;
    private final long pinkHouseValue2 = 160L;
    private final long orangeHouseValue1 = 180L;
    private final long orangeHouseValue2 = 200L;
    private final long redHouseValue = 220L;
    private final long redHouseValue2 = 240L;
    private final long yellowHouseValue = 260L;
    private final long yellowHouseValue2 = 280L;
    private final long greenHouseValue = 300L;
    private final long greenHouseValue2 = 320L;
    private final long dblueHouseValue = 350L;
    private final long dblueHouseValue2 = 400L;
    private final long stationValue = 200L;

    //predefining location names for the board generation
    private ArrayList<String> locationNames = new
   ArrayList<>(Arrays.asList("Start",
/*Brown*/   "Old Kent Road", "Whitechapel Road",
            "King's Cross station",
/*LBlue*/   "The Angel, Islington", "Euston Road", "Pentonville Road",
/*PINK*/    "Pall Mall", "Whitehall", "Northumberland Avenue",
/*Orange*/  "Bow Street", "Marlborough Street", "Vine Street",
/*Red*/     "Strand", "Fleet Street", "Trafalgar Square",
/*Yellow*/  "Leicester Square", "Coventry Street", "Piccadilly",
/*Green*/   "Regent Street", "Oxford Street", "Bond Street",
/*DBlue*/   "Park Lane", "Mayfair"
    ));

    private ArrayList<Long> values = new ArrayList<>(Arrays.asList(0L,
           /*Brown*/   brownHousesValue, brownHousesValue,
           /*Station*/ stationValue,
           /*LBlue*/   lblueHouseValue1, lblueHouseValue1, lblueHouseValue2,
           /*PINK*/    pinkHouseValue1, pinkHouseValue1, pinkHouseValue2,
           /*Orange*/  orangeHouseValue1, orangeHouseValue1, orangeHouseValue2,
           /*Red*/     redHouseValue, redHouseValue, redHouseValue2,
           /*Yellow*/  yellowHouseValue, yellowHouseValue, yellowHouseValue2,
           /*Green*/   greenHouseValue, greenHouseValue, greenHouseValue2,
           /*DBlue*/   dblueHouseValue, dblueHouseValue2
           ));

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
        } else {
            logger.info("Board created:  = length: " + aLength
                    + ", Width = " + aWidth);
            //Adding a tile for each tile their should be on the
            // board depending on its size
            for (int i = 0; i < boardSquares; i++) {
                String locNames = locationNames.get(i);
                Long locValues = values.get(i);
                Location location = new Location(locNames, locValues);
                Square square = new Square(i, location);
                boardtiles.add(square);
            }
        }

    }

// Methods
    public int getBoardSize() {
        //Finding out the perimeter of the rectangle
        // to work out the number of squares.
        return boardSquares;
    }
    // a method to get all the squares created
    // as an ArrayList
    public ArrayList<Square> getAllSquareCreated() {
        return boardtiles;
    }

    public ArrayList<String> getLocationNames() {
        return locationNames;
    }


}
