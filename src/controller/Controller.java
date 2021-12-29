package controller;
import model.board.Board;
import model.board.Dice;
import model.player.Player;
import model.deck.MailCardDeck;
import model.deck.DealCardDeck;

import java.io.IOException;

/**
 * Controller is the "brain" of the game all the initializations occur here.
 */
public class Controller {
    private Player p1,p2;
    private MailCardDeck mailCardDeck;
    private DealCardDeck dealCardDeck;
    private Board board;
    private int months;
    /**
     * Constructor.
     * constructs a new Controller,with
     * 2 players
     * 2 card decks
     * @param months: the months the game will last
     */
    public Controller(int months) throws IOException {
        p1 = new Player("Player1",3500);
        p2 = new Player("Player2",3500);
        mailCardDeck = new MailCardDeck();
        dealCardDeck = new DealCardDeck();
        board = new Board();
        board.addPlayer(p1);
        board.addPlayer(p2);
        this.months = months;
    }
}
