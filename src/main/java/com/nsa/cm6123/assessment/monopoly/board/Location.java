package com.nsa.cm6123.assessment.monopoly.board;

import com.nsa.cm6123.assessment.monopoly.player.Player;

public class Location {

    private String name;
    private long value;
    private Player owner;
    //Creating a player for squares that are not owned by anyone
    private static Player player = new Player("None", 0L, 0, 0);

    // LOCATION CONSTRUCTOR

    public Location(final String aName, final long aValue,
                    final Player aOwner) {
        this.name = aName;
        this.value = aValue;
        this.owner = aOwner;
    }

    public Location(final String aName) {
        this(aName, 0L,  player);
    }
    public Location(final String aName, final long aValue) {
        this(aName, aValue, player);
    }


    //METHODS

    public String getName() {
        return name;
    }

    public void setName(final String newName) {
        name = newName;
    }

    public long getValue() {
        return value;
    }

    public void setValue(final long newValue) {
        value = newValue;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(final Player newOwner) {
        owner = newOwner;
    }

}
