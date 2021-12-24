package view;

import model.player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerUI extends JPanel implements ActionListener
{
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
        rollDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.getDice().roll();
            }
        });
        this.add(rollDice);
        viewDealCards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCardsPopup(player.getDealCards());
            }
        });
        this.add(viewDealCards);
        getLoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(getLoan);
        endTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(endTurn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
