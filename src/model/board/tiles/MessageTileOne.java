package model.board.tiles;

import functions.PathFinder;
import model.board.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MessageTileOne extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the message tile
     */
    public MessageTileOne(int number, String day) throws IOException {
        super(
            number,
            day,
            ImageIO.read(new File(PathFinder.Images.getImage("mc1.png")))
        );
    }

    @Override
    public void performAction() {

    }
}
