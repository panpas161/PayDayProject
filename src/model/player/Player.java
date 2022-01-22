package model.player;

import controller.Config;
import functions.DaysChecker;
import model.board.Dice;
import model.card.DealCard;
import model.event.PayDay;
import model.event.SundayFootballDay;
import model.event.ThursdayRiseValueCrypto;
import view.EventPopup;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Player class Represents a player.
 */
public class Player {
    private String name;
    private float balance;
    private float bills;
    private float loans;
    private ArrayList<DealCard> dealCards;
    private Dice dice;
    private int currentPosition;
    private int currentMonth;
    private BufferedImage pawn;
    /**
     * Constructor.
     * Postcondition: Creates and initializes a player
     * @param name: The player's name
     * @param balance: The player's starting balance
     */
    public Player(String name,float balance,BufferedImage pawn)
    {
        this.name = name;
        this.balance = balance;
        this.bills = 0;
        this.loans = 0;
        dealCards = new ArrayList<>();
        dice = new Dice(this);
        this.currentPosition = 0;
        this.currentMonth = 0;
        this.pawn = pawn;
    }
    /**
     * Accessor.
     * Postcondition: Returns the players's name
     * @return the player's name
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * Transformer.
     * Postcondition: sets the players's name
     * @param name: the new player's name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * Accessor.
     * Postcondition: Returns the players's balance value
     * @return the player's balance value
    */
    public float getBalance()
    {
        return this.balance;
    }
    /**
     * Transformer.
     * Postcondition: sets the player's balance value
     * @param balance: the new balance value
     */
    public void setBalance(float balance)
    {
        this.balance = balance;
    }

    /**
     * Transformer.
     * Post Condition: sends money to another player
     * @param receiver: the player that gets the money
     * @param amount: the amount to be sent
     */
    public void sendMoney(Player receiver,float amount)
    {
        if(this.balance >= amount)
        {
            this.balance -= amount;
            receiver.addCash(amount);
        }
    }
    /**
     * Transformer.
     * Postcondition: adds a deal card to the player's deck
     * @param dealCard: the deal card that is added to the player's deck
     */
    public void addDealCard(DealCard dealCard)
    {
        this.dealCards.add(dealCard);
    }
    /**
     * Transformer.
     * Postcondition: removes a deal card from the player's deck
     * @param dealCard: the deal card that is removed from the player's deck
     */
    public void removeDealCard(DealCard dealCard)
    {
        this.dealCards.remove(dealCard);
    }

    /**
     * Accessor.
     * Post Condition: returns the deal cards
     * @return
     */
    public ArrayList<DealCard> getDealCards() {
        return this.dealCards;
    }

    /**
     * Transformer.
     * Postcondition: pays all player's bills removing them from his balance
     */
    public void payAllBills()
    {
        if(this.bills < this.balance)
        {
            removeCash(bills);
            removeBills(bills);
        }
    }
    /**
     * Transformer.
     * Postcondition: pays certain amount of bills
     * @param amount: the amount to be paid
     */
    public void payBillAmount(float amount)
    {
        if(amount < this.balance)
        {
            removeCash(amount);
            removeBills(amount);
        }
    }
    /**
     * Transformer.
     * Postcondition: sets the bills value
     * @param bills: the new bills value
     */
    public void setBills(float bills)
    {
        this.bills = bills;
    }
    /**
     * Accessor.
     * Postcondition: Returns the bills value
     * @return the bills value
     */
    public float getBills()
    {
        return this.bills;
    }
    /**
     * Transformer.
     * Postcondition: adds a certain amount of bills
     * @param bills: the bills to be added
     */
    public void addBills(float bills)
    {
        this.bills += bills;
    }
    /**
     * Transformer.
     * Postcondition: dcereases the bills value
     * @param bills: the amount of bills to be removed
     */
    public void removeBills(float bills)
    {
        this.bills -= bills;
    }
    /**
     * Transformer.
     * Postcondition: sets the loans value
     * @param loans: the new loans value
     */
    public void setLoans(float loans) {
        this.loans = loans;
    }
    /**
     * Accessor.
     * Postcondition: Returns the players's loan value
     * @return the player's loan value
     */
    public float getLoans() {
        return loans;
    }
    /**
     * Transformer.
     * Postcondition: pays certain amount of bills
     * @param loanValue: the amount to be paid
     */
    public void takeLoan(float loanValue)
    {
        this.loans += loanValue;
        this.balance += loanValue;
    }
    /**
     * Transformer.
     * Postcondition: decreases the loans value
     * @param loanValue: the amount of loans to be removed
     */
    public void decreaseLoanValue(float loanValue)
    {
        this.loans -= loanValue;
    }
    /**
     * Transformer.
     * Postcondition: adds money to the existing balance
     * @param cash: the money to be added
     */
    public void addCash(float cash)
    {
        this.balance += cash;
    }
    /**
     * Transformer.
     * Postcondition: removes money from the balance
     * @param cash: the money to be removed
     */
    public void removeCash(float cash)
    {
        if(cash > balance)
        {
            takeLoan(cash-balance);
        }
        this.balance -= cash;
    }

    /** Accessor.
     * Post Condition: returns the dice instance
     * @return
     */
    public Dice getDice()
    {
        return this.dice;
    }

    /** Accessor.
     * Post Condition: returns the player's current position
     * @return
     */
    public int getCurrentPosition()
    {
        return this.currentPosition;
    }

    /**
     * Transformer
     * Post Condition: alters the current position variable
     * @param position
     */
    public void setCurrentPosition(int position)
    {
        this.currentPosition = position;
        DaysChecker.Days.checkDayEvent(currentPosition);
    }

    /** Transformer.
     * Post Condition: moves player right to a certain position
     * @param position
     */
    public void movePositionRight(int position)
    {
        this.currentPosition += position;
    }

    /**
     * Accessor.
     * Post Condition: gets the month the player is currently in
     * @return
     */
    public int getCurrentMonth()
    {
        return this.currentMonth;
    }

    /** Transformer.
     * Post Condition: sets the month that the player is currently in
     * @param month: the new value of the month
     */
    public void setCurrentMonth(int month)
    {
        this.currentMonth = month;
    }

    /**
     * Accessor.
     * Post Condition: returns the pawn image of the player
     * @return
     */
    public BufferedImage getPawnImage()
    {
        return this.pawn;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", bills=" + bills +
                ", loans=" + loans +
                ", dealCards=" + dealCards +
                ", dice=" + dice +
                ", currentPosition=" + currentPosition +
                ", currentMonth=" + currentMonth +
                ", pawn=" + pawn +
                '}';
    }
}
