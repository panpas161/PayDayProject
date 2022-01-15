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
    public Tile(int position,String day,BufferedImage image)
    {
        this.position = position;
        this.day = day;
        this.image = image;
        this.playersPresent = new ArrayList<>();
    }
    public String getDate()
    {
        return this.position + " " + this.day;
    }

    public BufferedImage getImage()
    {
        return this.image;
    }

    public int getPosition()
    {
        return this.position;
    }

//    public void adjustToBoard(int index)
//    {
//
//    }

    public void addPlayer(Player player)
    {
        this.playersPresent.add(player);
    }

    public abstract void performAction(Player player);
}
