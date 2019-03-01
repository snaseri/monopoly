package com.nsa.cm6123.assessment.monopoly.board;

public class Location {

    private String name;
    private long value;

    public Location(final String aName, final long aValue) {
        this.name = aName;
        this.value = aValue;
    }

    public Location(final String aName) {
        this(aName, 0L);
    }

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

}
