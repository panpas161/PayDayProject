package model.board;

import model.card.Card;

import java.awt.image.BufferedImage;

/**
 * This class represents the tiles on the board
 */
public abstract class Tile{
    private int position;
    private String day;
    private BufferedImage image;
    /**
     * Constructor.
     * Postcondition: constructs a new Tile
     * @param position: the tile's number(aka the date)
     * @param day: The date's string
     * @param image: The image of the tile
     */
    public Tile(int position,String day,BufferedImage image)
    {
        this.position = position;
        this.day = day;
        this.image = image;
    }
    public abstract void performAction();
}
