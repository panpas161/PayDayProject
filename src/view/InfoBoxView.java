package view;

import model.player.Player;

import javax.swing.*;
import java.awt.*;

public class InfoBoxView extends JPanel {
    private JTextField title,monthsLeft,currentTurn,currentAction;
    public InfoBoxView()
    {
        title = new JTextField("Info Box");
        monthsLeft = new JTextField("0 Months left");
        currentTurn = new JTextField("");
        currentAction = new JTextField("");
        title.setEditable(false);
        monthsLeft.setEditable(false);
        currentTurn.setEditable(false);
        currentAction.setEditable(false);
        this.add(title);
        this.add(monthsLeft);
        this.add(currentTurn);
        this.add(currentAction);
    }
    public void setMonthsLeft(int months)
    {
        this.monthsLeft.setText(Integer.toString(months) + " Months left");
    }
    public void setCurrentPlayer(Player player)
    {
        this.currentTurn.setText("Turn: " + player.getName());
    }
    public void setCurrentAction()
    {
        this.currentAction.setText("--> ");
    }
}
