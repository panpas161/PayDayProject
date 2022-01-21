package model.board;

import controller.Config;
import functions.DaysChecker;
import model.board.tiles.*;

import model.card.DealCard;
import model.card.MailCard;
import model.deck.DealCardDeck;
import model.deck.MailCardDeck;
import model.event.Jackpot;
import model.event.PayDay;
import model.player.Player;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This class represents the board of the game
 */
public class Board {
    private BufferedImage logo;
    private Tile[] tiles;
    private Player p1,p2;
    private MailCardDeck mailCardDeck;
    private DealCardDeck dealCardDeck;
    /**
     * Constructor.
     * Postcondition: Creates and initializes the board
     */
    public Board(Player p1,Player p2,MailCardDeck mailCardDeck,DealCardDeck dealCardDeck) throws IOException
    {
        tiles = Config.Values.Tiles(false,this);
        this.p1 = p1;
        this.p2 = p2;
        this.mailCardDeck = mailCardDeck;
        this.dealCardDeck = dealCardDeck;
    }

    /**
     * Constructor.
     * Post Condition: creates an instance of the board without initializing the decks
     * @param p1
     * @param p2
     */
    public Board(Player p1,Player p2) throws IOException
    {
        tiles = Config.Values.Tiles(false,this);
        this.p1 = p1;
        this.p2 = p2;
    }
    /**
     * Accessor.
     * Post Condition: Get the player's current position(in which tile he/she is currently on)
     * @param player
     * @return the tile that the player is currently on
     */
    public int getPlayerPosition(Player player)
    {
        return player.getCurrentPosition();
    }

    /**
     * Accessor.
     * Post Condition: returns the tile that a player is currently on
     * @param player: the player to search for
     * @return
     */
    public Tile getCurrentPlayerTile(Player player)
    {
        return tiles[player.getCurrentPosition()];
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
        this.tiles[position].performAction(player);
    }

    /**
     * Transformer.
     * Post Condition: moves the player right to a certain position and checks for events
     * @param player: the player to be moved
     * @param position: the position the player is moved on
     */
    public void movePlayerToPositionRight(Player player,int position)
    {
        player.movePositionRight(position);
        if(player.getCurrentPosition() > 31)
        {
            new PayDay(player);
        }
        DaysChecker.Days.checkDayEvent(position);
        this.tiles[player.getCurrentPosition()].addPlayer(player);
        this.tiles[player.getCurrentPosition()].performAction(player);
//        System.out.println(this.tiles[player.getCurrentPosition()].getPlayersPresent());
    }

    /**
     * Accessor.
     * Post Condition: returns the tiles of the board
     * @return
     */
    public Tile[] getTiles()
    {
        return this.tiles;
    }
    /**
     *
     * Post Condition: Will return a certain tile's position
     * @param tile: The tile object we're looking for
     * @param startPosition: Search will start on this position
     * @return
     */
    public int getTilePosition(Class tile,int startPosition)
    {
        for(int i=startPosition;i<this.tiles.length;i++)
        {
            if(tiles[i].getClass() == tile)
            {
                return tiles[i].getPosition();
            }
        }
        return -1;
    }

    /**
     * Accessor.
     * Post Condition: returns the first player of the board
     * @return
     */
    public Player getPlayer1()
    {
        return this.p1;
    }

    /**
     * Accessor.
     * Post Condition: returns the second player of the board
     * @return
     */
    public Player getPlayer2()
    {
        return this.p2;
    }

    public void adjustPlayersToTiles()
    {
        int playerOnePosition = p1.getCurrentPosition();
        int playerTwoPosition = p2.getCurrentPosition();
        tiles[playerOnePosition].addPlayer(p1);
        tiles[playerTwoPosition].addPlayer(p2);
    }

    /**
     * Transformer.
     * Post Condition: adds a deal card deck to the board
     * @param dealCardDeck
     */
    public void setDealCardDeck(DealCardDeck dealCardDeck)
    {
        this.dealCardDeck = dealCardDeck;
    }

    /**
     * Accessor.
     * Post Condition: returns the deck of deal cards
     * @return
     */
    public DealCardDeck getDealCardDeck()
    {
        return this.dealCardDeck;
    }

    /**
     * Transformer.
     * Post Condition: adds a deck of mail cards
     * @param mailCardDeck: the mail card deck
     */
    public void setMailCardDeck(MailCardDeck mailCardDeck)
    {
        this.mailCardDeck = mailCardDeck;
    }

    /**
     * Accessor.
     * Post Condition: returns a mail card deck
     * @return
     */
    public MailCardDeck getMailCardDeck()
    {
        return this.mailCardDeck;
    }
}
