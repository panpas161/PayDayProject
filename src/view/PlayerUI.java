package view;

import model.player.Player;

import javax.swing.*;

public class PlayerUI extends JPanel {
    public PlayerUI(Player player)
    {
        JLabel name = new JLabel(player.getName());
        JLabel balance = new JLabel("Money: " + player.getBalance() + "Euros");
        JLabel loan = new JLabel("Loan" + player.getLoans() + "Euros");
        JLabel bills = new JLabel("Bills: " + player.getBills() + "Euros");
        JButton rollDice = new JButton("Roll Dice");
        JButton viewDealCards = new JButton("My Deal Cards");
        JButton getLoan = new JButton("Get Loan");
        JButton endTurn = new JButton("End Turn");
        this.add(name);
        this.add(balance);
        this.add(loan);
        this.add(bills);
        this.add(rollDice);
        this.add(viewDealCards);
        this.add(getLoan);
        this.add(endTurn);
    }
}
