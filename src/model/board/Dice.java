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
     * Postcondition: creates a Dice instance that belongs to a player
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
     * Transformer.
     * Post Condition: Rolls the dice without a chance of jackpot
     */
    public void rollEvent()
    {
        this.currentValue = new Random().nextInt(6) + 1;
    }

    /**
     * Transformer.
     * Post Condition: rolls the dice with the intention to move the player
     */
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

    /**
     * Accessor.
     * Post Condition: returns the value the dice has landed in
     * @return
     */
    public int getCurrentValue()
    {
        return this.currentValue;
    }
}
