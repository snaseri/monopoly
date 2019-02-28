package com.nsa.cm6123.assessment.monopoly;

import com.nsa.cm6123.assessment.monopoly.board.Location;
import com.nsa.cm6123.assessment.monopoly.board.Square;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocationTest {

    private Location start;
    private Square square;

    @Before
    public void squareAndLocationConstructor(){
        start = new Location("Start");
        square = new Square(0,  start);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Start", square.getLocation().getName());
    }
    @Test
    public void setName() throws Exception {
        start.setName("End");
        assertEquals("End", square.getLocation().getName());
    }
}