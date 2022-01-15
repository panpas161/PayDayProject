package model.board;
import controller.Controller;
import model.player.Player;

import java.util.Random;

/**
 * Dice class represents the dice of each player
 */
public class Dice {
    private int currentValue;
    private Player owner;
    /**
     * Constructor.
     * Postcondition: creates a dice instance that belongs to a player
     */
    public Dice(Player owner)
    {
        rollEvent();
        this.owner = owner;
    }

    /**
     * Constructor.
     * Post Condition: Creates a Dice instance that doesn't have an owner
     */
    public Dice()
    {
        rollEvent();
        this.owner = null;
    }
    /**
     *
     * Postcondition: Rolls the dice without a chance of jackpot
     */
    public void rollEvent()
    {
        this.currentValue = new Random().nextInt(6) + 1;
    }

    public void roll()
    {
        rollEvent();
        if(owner != null)
        {
            if (this.currentValue == 6) {
                owner.addCash(Controller.jackpot.getValue());
                Controller.jackpot.setValue(0);
            }
        }
    }
    public int getCurrentValue()
    {
        return this.currentValue;
    }
}
