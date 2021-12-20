package model.board;

import model.player.Player;
/**
 * Dice class represents the dice of each player
 */
public class Dice {
    private Player player;
    /**
     * Constructor.
     * Postcondition: creates a dice instance that belongs to a player
     * @param player is the owner of the dice(of Player class).
     */
    public Dice(Player player)
    {
        this.player = player;
    }
    public void roll()
    {

    }
}
