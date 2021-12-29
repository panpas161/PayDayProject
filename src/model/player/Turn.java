package model.player;

import java.util.ArrayList;

public class Turn {
    private ArrayList<Player> players;
    private int turnNumber;
    public Turn(ArrayList<Player> players)
    {
        this.players = players;
        turnNumber = 1;
    }
    public void nextTurn()
    {
        if(turnNumber >=1 && turnNumber<=players.size())
        {
            turnNumber++;
        }
        else
        {
            turnNumber = 1;
        }
        players.get(turnNumber).getDice().roll();
        players.get(turnNumber).movePositionRight(players.get(turnNumber).getDice().getCurrentValue());
    }
    public int currentTurnNumber()
    {
        return this.turnNumber;
    }
    public Player getCurrentPlayer()
    {
        return players.get(currentTurnNumber());
    }
}
