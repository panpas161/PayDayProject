package model.player;

import controller.Config;
import view.PayLoansPopup;

import java.util.ArrayList;

public class Turn {
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private int turnNumber;
    public Turn(Player p1,Player p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        turnNumber = 1;
        currentPlayer = p1;
    }
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
        if(currentPlayer.getCurrentPosition() > 31)
        {
            Config.Events.payDay(currentPlayer);
        }
        currentPlayer.movePositionRight(currentPlayer.getDice().getCurrentValue());
        currentPlayer.getDice().roll();
    }

    public void checkIfGameFinished()
    {
        if(p1.getCurrentMonth() == Config.Values.gameMonths() && p2.getCurrentMonth() == Config.Values.gameMonths())
        {
            if(p1.getBalance() > p2.getBalance())
            {
                Config.Events.playerWon(p1);
            }
            else
            {
                Config.Events.playerWon(p2);
            }
        }
    }
    public int currentTurnNumber()
    {
        return this.turnNumber;
    }
    public Player getCurrentPlayer()
    {
        return this.currentPlayer;
    }
}
