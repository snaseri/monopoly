package com.nsa.cm6123.assessment.monopoly.board;

public class Square {

    private int position;
    private Location location;
    private static Location start = new Location("Start");
        // SQUARE CONSTRUCTOR
    public Square(final int aPosition, final Location aLocation) {
        this.position = aPosition;
        this.location = aLocation;
    }

    public Square(final int aPosition) {
        this(aPosition, start);
    }


// METHODS
    // Gets the board position of the square
    public int getPosition() {
        return position;
    }

    public Location getLocation() {
        return location;
    }
}
