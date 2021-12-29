package model.board;

import model.board.tiles.*;

import functions.DaysChecker.Days;
import model.player.Player;

import java.awt.image.BufferedImage;
import java.io.IOException;
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
    public Board() throws IOException {
        tiles = new ArrayList<>();
        players = new ArrayList<>();
        tiles.add(new StartTile());
        for(int i=1;i<32;i++)
        {
            tiles.add(new BuyerTile(i,Days.getDay(i)));
            tiles.add(new DealTile(i,Days.getDay(i)));
            tiles.add(new FamilyCasinoNightTile(i,Days.getDay(i)));
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
        return player.getCurrentPosition();
    }

    /**
     * Transformer.
     * moves a player to certain position
     * @param player: the player
     * @param position: tile's position to be moved on
     */
    public void movePlayerToPosition(Player player, int position)
    {
        player.setCurrentPosition(position);
    }

    public ArrayList<Tile> getTiles()
    {
        return this.tiles;
    }
}
