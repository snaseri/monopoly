package com.nsa.cm6123.assessment.monopoly;

import com.nsa.cm6123.assessment.monopoly.board.Location;
import com.nsa.cm6123.assessment.monopoly.board.Square;
import com.nsa.cm6123.assessment.monopoly.board.Board;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocationTest {

    private Location start;
    private Square square;
    private Board board;

    @Before
    public void squareAndLocationConstructor(){
        start = new Location("Start");
        square = new Square(0,  start);
        board = new Board(6, 6);
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

    @Test
    public void totalNumberOfLocations() throws Exception {
        assertEquals(24,board.getLocationNames().size());
    }

    @Test
    public void checkRandomLocationName() throws Exception {
        assertEquals("Oxford Street",board.getLocationNames().get(20));
    }

    @Test
    public void checkRandomLocationName2() throws Exception {
        assertEquals("Start",board.getLocationNames().get(0));
    }
}