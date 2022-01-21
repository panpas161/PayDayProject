package model.player;

import controller.Config;
import model.board.Board;
import model.event.PlayerWon;
import view.PayLoansPopup;

import java.util.ArrayList;

public class Turn {
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private int turnNumber;
    private Board board;

    /**
     * Constructor.
     * Post Condition: creates a turn instance
     * @param p1
     * @param p2
     * @param board
     */
    public Turn(Player p1, Player p2, Board board)
    {
        this.p1 = p1;
        this.p2 = p2;
        turnNumber = 1;
        currentPlayer = p1;
        this.board = board;
    }

    /**
     * Transformer.
     * Post Condition: changes the turn of the players
     */
    public void nextTurn()
    {
        if(turnNumber == 1)
        {
            currentPlayer = this.p1;
            turnNumber++;
        }
        else
        {
            currentPlayer = this.p2;
            turnNumber = 1;
        }
        checkIfGameFinished();
    }

    /**
     * Trasnformer.
     * Post Condition: rolls the dice and moves the player to the corresponding location
     * @param player: the player that is moved
     */
    public void rollAndMovePlayer(Player player)
    {
        player.getDice().roll();
        board.movePlayerToPositionRight(player,player.getDice().getCurrentValue());
    }

    /**
     * Transformer.
     * Post Condition: checks if a player won the game.
     */
    public void checkIfGameFinished()
    {
        if(p1.getCurrentMonth() == Config.Values.gameMonths() && p2.getCurrentMonth() == Config.Values.gameMonths())
        {
            if(p1.getBalance() > p2.getBalance())
            {
                new PlayerWon(p1);
            }
            else
            {
                new PlayerWon(p2);
            }
        }
    }

    /**
     * Accessor.
     * Post Condition: returns the current turn number
     * @return
     */
    public int currentTurnNumber()
    {
        return this.turnNumber;
    }

    /**
     * Accessor.
     * Post Condition: returns the player that is active
     * @return
     */
    public Player getCurrentPlayer()
    {
        return this.currentPlayer;
    }
}
