package model.board;
import java.util.Random;

/**
 * Dice class represents the dice of each player
 */
public class Dice {
    int currentValue;
    /**
     * Constructor.
     * Postcondition: creates a dice instance that belongs to a player
     */
    public Dice()
    {
        roll();
    }
    public void roll()
    {
        this.currentValue = new Random().nextInt(6) + 1;
    }
    public int getCurrentValue()
    {
        return this.currentValue;
    }
}
