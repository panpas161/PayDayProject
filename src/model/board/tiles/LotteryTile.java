package model.board.tiles;

import functions.DaysChecker;
import functions.PathFinder;
import model.board.Board;
import model.board.Dice;
import model.board.Tile;
import model.player.Player;
import view.TilePopup;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LotteryTile extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the lottery tile
     */
    public LotteryTile(int number, Board board) throws IOException {
        super(
        "Lottery",
        "Προσφέρονται 1000 ευρώ σε έναν παίκτη μέσω κλήρωσης διαλέξτε ενα νούμερο απο το 1 μεχρι το 6",
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("lottery.png"))),
            board
        );
    }

    @Override
    public void performAction(Player player) {
        Dice tempDice = new Dice();
        Player p2 = board.getPlayer2();
        int choices[] = new int[6];
        for(int i=0;i<6;i++)
            choices[i] = i+1;
//        int p1Number = (int) JOptionPane.showInputDialog(null, "Choose now...",
//                "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
//                // default
//                // icon
//                choices, // Array of choices
//                choices[0]); // Initial choi
        int p1Number = 1;
        int p2Number = 5;
        while(true)
        {
            tempDice.roll();
            int rolledNumber = tempDice.getCurrentValue();
            if (p1Number == rolledNumber) //fix
            {
                player.addCash(1000);
                break;
            }
            else if(p2Number == rolledNumber)
            {
                p2.addCash(1000);
                break;
            }
        }
        new TilePopup(this);
    }
}
