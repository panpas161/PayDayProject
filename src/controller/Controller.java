package controller;
import model.board.Board;
import model.board.Dice;
import model.event.Jackpot;
import model.player.Player;
import model.deck.MailCardDeck;
import model.deck.DealCardDeck;
import model.player.Turn;

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
    private Turn turn;
    public static Jackpot jackpot;

    static {
        try {
            jackpot = new Jackpot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor.
     * constructs a new Controller,with
     * 2 players
     * 2 card decks
     */
    public Controller() throws IOException {
        p1 = new Player("Player1",3500,Config.Images.PawnPlayerOne());
        p2 = new Player("Player2",3500, Config.Images.PawnPlayerTwo());
        board = new Board(p1,p2);
        mailCardDeck = new MailCardDeck(board);
        dealCardDeck = new DealCardDeck();
        board.setMailCardDeck(mailCardDeck);
        board.setDealCardDeck(dealCardDeck);
        this.months = Config.Values.gameMonths();
        turn = new Turn(p1,p2,board);
    }
    public Player getPlayer1()
    {
        return this.p1;
    }
    public Player getPlayer2()
    {
        return this.p2;
    }

    public Turn getTurn()
    {
        return this.turn;
    }

    public DealCardDeck getDealCardDeck()
    {
        return this.dealCardDeck;
    }

    public MailCardDeck getMailCardDeck()
    {
        return this.mailCardDeck;
    }

    public Board getBoard()
    {
        return this.board;
    }
}
