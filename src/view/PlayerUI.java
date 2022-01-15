package view;

import functions.PathFinder;
import model.player.Player;
import model.player.Turn;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PlayerUI extends JPanel
{
    JLabel name,balance,loan,bills;
    JPanel detailsPanel;
    JButton rollDice,viewDealCards,getLoan,endTurn;
    JPanel buttonsPanel;
    public PlayerUI(Player player, Turn turn)
    {
        name = new JLabel(player.getName());
        balance = new JLabel("Money: " + player.getBalance() + "Euros");
        loan = new JLabel("Loans: " + player.getLoans() + "Euros");
        bills = new JLabel("Bills: " + player.getBills() + "Euros");
        detailsPanel = new JPanel();
        rollDice = new JButton("Roll Dice");
        viewDealCards = new JButton("My Deal Cards");
        getLoan = new JButton("Get Loan");
        endTurn = new JButton("End Turn");
        buttonsPanel = new JPanel();
        //name
        name.setHorizontalAlignment(JLabel.CENTER);
        detailsPanel.add(name);

        //balance
        balance.setHorizontalAlignment(JLabel.CENTER);
        detailsPanel.add(balance);

        //loan
        loan.setHorizontalAlignment(JLabel.CENTER);
        detailsPanel.add(loan);

        //bills
        bills.setHorizontalAlignment(JLabel.CENTER);
        detailsPanel.add(bills);

        //dice image
        try{
            detailsPanel.add(getDiceImage(player));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //details panel
        detailsPanel.setLayout(new GridLayout(5,1));
        this.add(detailsPanel);
        //buttons
        rollDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.getDice().roll();
                System.out.println("Old Position: " + player.getCurrentPosition());
                try{
                    detailsPanel.add(getDiceImage(player));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                detailsPanel.repaint();
                player.movePositionRight(player.getDice().getCurrentValue());
                System.out.println("Dice Rolled: " + player.getDice().getCurrentValue());
                System.out.println("New Position: " + player.getCurrentPosition());
                rollDice.setEnabled(false);
            }
        });
        buttonsPanel.add(rollDice);
        viewDealCards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewDealCardsPopup(player);
            }
        });
        buttonsPanel.add(viewDealCards);
        getLoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int loanValue = Integer.parseInt(JOptionPane.showInputDialog("Enter the loan amount"));
                player.takeLoan(loanValue);
            }
        });
        buttonsPanel.add(getLoan);
        endTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turn.nextTurn();
                setEnabledButtons(false);
            }
        });
        buttonsPanel.add(endTurn);
        this.add(buttonsPanel);
    }

    private void setEnabledButtons(boolean enabled)
    {
        rollDice.setEnabled(enabled);
        viewDealCards.setEnabled(enabled);
        getLoan.setEnabled(enabled);
        endTurn.setEnabled(enabled);
    }

    private JLabel getDiceImage(Player player) throws IOException
    {
        int currentDiceValue = player.getDice().getCurrentValue();
        JLabel diceImage;
        if(currentDiceValue == 1)
        {
            diceImage = new JLabel(
                new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-1.jpg")))
                )
            );
        }
        else if(currentDiceValue == 2)
        {
            diceImage = new JLabel(
                new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-2.jpg")))
                )
            );
        }
        else if(currentDiceValue == 3)
        {
            diceImage = new JLabel(
                new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-3.jpg")))
                )
            );
        }
        else if(currentDiceValue == 4)
        {
            diceImage = new JLabel(
                new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-4.jpg")))
                )
            );
        }
        else if(currentDiceValue == 5)
        {
            diceImage = new JLabel(
                new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-5.jpg")))
                )
            );
        }
        else
        {
            diceImage = new JLabel(
                new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-6.jpg")))
                )
            );
        }
        return diceImage;
    }
}

