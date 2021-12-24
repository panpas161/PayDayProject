package model.player;

import model.board.Dice;
import model.card.DealCard;

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
    /**
     * Constructor.
     * Postcondition: Creates and initializes a player
     * @param name: The player's name
     * @param balance: The player's starting balance
     */
    public Player(String name,float balance)
    {
        this.name = name;
        this.balance = balance;
        this.bills = 0;
        this.loans = 0;
        dealCards = new ArrayList<>();
        dice = new Dice();
        this.currentPosition = 0;
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
            //code
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
        this.balance -= cash;
    }

    public Dice getDice()
    {
        return this.dice;
    }
    public int getCurrentPosition()
    {
        return this.currentPosition;
    }
    public void setCurrentPosition(int position)
    {
        this.currentPosition = position;
    }
}
