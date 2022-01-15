package view;

import controller.Config;
import model.player.Player;

import javax.swing.*;
import java.awt.*;

public class InfoBoxView extends JPanel {
    private JTextField title,monthsLeft,currentTurn,currentAction;
    private Player currentPlayer;
    public InfoBoxView(Player player)
    {
        title = new JTextField("Info Box");
        monthsLeft = new JTextField("0 Months left");
        currentTurn = new JTextField("");
        currentAction = new JTextField("");
        title.setEditable(false);
        monthsLeft.setEditable(false);
        currentTurn.setEditable(false);
        currentAction.setEditable(false);
        this.setLayout(new GridLayout(4,1));
        this.add(title);
        this.add(monthsLeft);
        this.add(currentTurn);
        this.add(currentAction);
        setCurrentPlayer(player);
    }
    public void setCurrentPlayer(Player player)
    {
        this.currentPlayer = player;
        this.monthsLeft.setText(Config.Values.gameMonths() - player.getCurrentMonth() + " Months left");
        this.currentTurn.setText("Turn: " + player.getName());
        this.currentAction.setText("--> ");
    }
}
