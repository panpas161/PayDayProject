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
    JLabel diceImage;
    Player player;
    public PlayerUI(Player player, Turn turn)
    {
        this.player = player;
        name = new JLabel(player.getName());
        balance = new JLabel("Money: " + player.getBalance() + " Euros");
        loan = new JLabel("Loans: " + player.getLoans() + " Euros");
        bills = new JLabel("Bills: " + player.getBills() + " Euros");
        detailsPanel = new JPanel();
        rollDice = new JButton("Roll Dice");
        viewDealCards = new JButton("My Deal Cards");
        getLoan = new JButton("Get Loan");
        endTurn = new JButton("End Turn");
        buttonsPanel = new JPanel();

        GridBagConstraints c = new GridBagConstraints();
        detailsPanel.setLayout(new GridBagLayout());

        //name
        name.setHorizontalAlignment(JLabel.CENTER);
        c.fill = GridBagConstraints.VERTICAL;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 0;
        c.gridy = 0;
        detailsPanel.add(name,c);

        //balance
        balance.setHorizontalAlignment(JLabel.CENTER);
        c.gridy = 1;
        detailsPanel.add(balance,c);

        //loan
        loan.setHorizontalAlignment(JLabel.CENTER);
        c.gridy = 2;
        detailsPanel.add(loan,c);

        //bills
        bills.setHorizontalAlignment(JLabel.CENTER);
        c.gridy = 3;
        detailsPanel.add(bills,c);

        //dice image
        try
        {
            c.gridy = 4;
            diceImage = new JLabel(getDiceImage(player));
            detailsPanel.add(diceImage,c);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //details panel
        if(turn.getCurrentPlayer() != player)
        {
            setEnabledButtons(false);
        }
        this.add(detailsPanel);

        //events
        Timer timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePlayerInfo();
            }
        });
        timer.setRepeats(true);
        timer.start();

        //buttons
        rollDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turn.rollAndMovePlayer(player);
                try{
                    diceImage.setIcon(getDiceImage(player));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
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
        this.setLayout(new GridLayout(2,1));
        buttonsPanel.add(endTurn);
        this.add(buttonsPanel);
    }

    public void updatePlayerInfo()
    {
        this.balance.setText("Money: " + player.getBalance() + " Euros");
        this.loan.setText("Loans: " + player.getLoans() + " Euros");
        this.bills.setText("Bills: " + player.getBills() + " Euros");
    }

    public JButton getEndTurn()
    {
        return this.endTurn;
    }

    public void setEndTurnListener(ActionListener listener)
    {
        this.endTurn.addActionListener(listener);
    }

    public void setEnabledButtons(boolean enabled)
    {
        rollDice.setEnabled(enabled);
        viewDealCards.setEnabled(enabled);
        getLoan.setEnabled(enabled);
        endTurn.setEnabled(enabled);
    }

    private ImageIcon getDiceImage(Player player) throws IOException
    {
        int currentDiceValue = player.getDice().getCurrentValue();
        ImageIcon diceImage;
        if(currentDiceValue == 1)
        {
            diceImage = new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-1.jpg")))
                );
        }
        else if(currentDiceValue == 2)
        {
            diceImage = new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-2.jpg")))
                );
        }
        else if(currentDiceValue == 3)
        {
            diceImage = new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-3.jpg")))
                );
        }
        else if(currentDiceValue == 4)
        {
            diceImage = new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-4.jpg")))
                );
        }
        else if(currentDiceValue == 5)
        {
            diceImage = new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-5.jpg")))
                );
        }
        else
        {
            diceImage = new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("dice-6.jpg")))
                );
        }
        return new ImageIcon(
                            diceImage.getImage().getScaledInstance(55,55,Image.SCALE_SMOOTH)
                    );
    }
}

