package model.board.tiles;

import functions.DaysChecker;
import model.board.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import functions.PathFinder.Images;
import model.player.Player;

public class MessageTileTwo extends Tile
{
    /**
     * Constructor.
     * Postcondition: Creates and initializes the message tile
     */
    public MessageTileTwo(int number) throws IOException {
        super(
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(Images.getImage("mc2.png")))
        );
    }

    @Override
    public void performAction(Player player) {
        board.getMailCardDeck().draw(player);
        board.getMailCardDeck().draw(player);
    }
}
