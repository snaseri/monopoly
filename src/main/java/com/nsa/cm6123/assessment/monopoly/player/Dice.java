package com.nsa.cm6123.assessment.monopoly.player;
import java.util.Random;

public class Dice {

    public int roll() {

        Random rand = new Random();

// Source: https://stackoverflow.com/questions/5887709/
// getting-random-numbers-in-java
    // Obtain a number between [0 - 49].
        final int diceMaximumValue = 6;
        int n = rand.nextInt(diceMaximumValue);

    // Add 1 to the result to get a number from the required range
    // (i.e., [1 - 50]).
        n += 1;

// End Source
        return n;
    }

}
