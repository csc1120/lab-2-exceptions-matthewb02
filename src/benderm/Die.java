/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Matthew Bender
 * Last Updated: 9/11/2024
 */
package benderm;

import java.util.Random;

/**
 * Die generates random integers within a given boundary.
 */
public class Die {
    private static Random random = new Random();
    private int numSides;
    private int currentValue = 0;

    /**
     * Creates a Die object.
     *
     * @param numSides maximum number that can be generated
     */
    public Die(int numSides) {
        this.numSides = numSides;
    }

    /**
     * Prepares next random number.
     */
    public void roll() {
        currentValue = random.nextInt(numSides) + 1;
    }

    /**
     * Returns the most recently generated number,
     * then removes that number from memory.
     *
     * @return previously generated random number
     * @throws DieNotRolledException unless .roll() was the last called method
     */
    public int getCurrentValue() throws DieNotRolledException {
        int value = currentValue;
        if (value < 1 || value > numSides) {
            throw new DieNotRolledException();
        }
        currentValue = 0;
        return value;
    }
}