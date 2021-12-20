package model.board;

import model.board.tiles.*;

import functions.DaysChecker.Days;
import model.player.Player;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 * This class represents the board of the game
 */
public class Board {
    private BufferedImage logo;
    private ArrayList<Tile> tiles;
    private ArrayList<Player> players;
    /**
     * Constructor.
     * Postcondition: Creates and initializes the board
     */
    public Board()
    {
        tiles = new ArrayList<>();
        players = new ArrayList<>();
        for(int i=1;i<=31;i++)
        {
            tiles.add(new BuyerTile(i,Days.getDay(i)));
            tiles.add(new DealTile(i,Days.getDay(i)));
            //more tiles etc.
        }
    }
    /**
     * Transformer.
     * Postcondition: adds a player to the board
     */
    public void addPlayer(Player player)
    {
        players.add(player);
    }
    /**
     * Accessor.
     * Get the player's current position(in which tile he/she is currently on)
     * @param player
     * @return the tile that the player is currently on
     */
    public int getPlayerPosition(Player player)
    {
        return 0;
    }

    /**
     * Transformer.
     * moves a player to certain position
     * @param player: the player
     * @param position: tile's position to be moved on
     */
    public void movePlayerToPosition(Player player, int position)
    {

    }
}
