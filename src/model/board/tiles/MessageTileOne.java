package model.board.tiles;

import functions.DaysChecker;
import functions.PathFinder;
import model.board.Tile;
import model.player.Player;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MessageTileOne extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the message tile
     */
    public MessageTileOne(int number) throws IOException {
        super(
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("mc1.png")))
        );
    }

    @Override
    public void performAction(Player player) {
        board.getMailCardDeck().draw(player);
    }
}
