package model.board.tiles;

import functions.DaysChecker;
import functions.PathFinder;
import model.board.Dice;
import model.board.Tile;
import model.player.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LotteryTile extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the lottery tile
     */
    public LotteryTile(int number) throws IOException {
        super(
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("lottery.png")))
        );
    }

    @Override
    public void performAction(Player player) {
        Dice tempDice = new Dice();
        Player p2 = new Player("test",500,null);
        player.getDice().rollEvent();
        p2.getDice().rollEvent();
        while(true)
        {
            tempDice.roll();
            int rolledNumber = tempDice.getCurrentValue();
            if (player.getDice().getCurrentValue() == rolledNumber)
            {
                player.addCash(1000);
                break;
            }
            else if(p2.getDice().getCurrentValue() == rolledNumber)
            {
                p2.addCash(1000);
                break;
            }
        }
    }
}
