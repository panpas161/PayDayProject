package model.board;

import controller.Controller;
import model.card.Card;
import model.player.Player;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class represents the tiles on the board
 */
public abstract class Tile{
    private int position;
    protected String day;
    private BufferedImage image;
    private ArrayList<Player> playersPresent;
    protected Board board;
    protected Controller controller;
    /**
     * Constructor.
     * Postcondition: constructs a new Tile
     * @param position: the tile's number(aka the date)
     * @param day: The date's string
     * @param image: The image of the tile
     */
    public Tile(int position,String day,BufferedImage image,Board board)
    {
        this.position = position;
        this.day = day;
        this.image = image;
        this.playersPresent = new ArrayList<>();
        this.board = board;
    }

    /**
     * Accessor.
     * Post Condition: returns the date of the tile
     * @return
     */
    public String getDate()
    {
        return this.position + " " + this.day;
    }

    /**
     * Accessor.
     * Post Condition: returns the image of the tile
     * @return
     */
    public BufferedImage getImage()
    {
        return this.image;
    }

    /**
     * Accessor.
     * Post Condition: returns the position the player is currently in
     * @return
     */
    public int getPosition()
    {
        return this.position;
    }

    /**
     * Transformer.
     * Post Condition: adds a player to the tile
     * @param player: the player to be added
     */
    public void addPlayer(Player player)
    {
        this.playersPresent.add(player);
    }

    public ArrayList<Player> getPlayersPresent()
    {
        return this.playersPresent;
    }

    /**
     * Transformer.
     * Post Condition: the action that is performed when a player is on the tile
     * @param player
     */
    public abstract void performAction(Player player);
}
