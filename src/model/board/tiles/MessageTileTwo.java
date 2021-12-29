package model.board.tiles;

import model.board.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import functions.PathFinder.Images;

public class MessageTileTwo extends Tile
{
    /**
     * Constructor.
     * Postcondition: Creates and initializes the message tile
     */
    public MessageTileTwo(int number, String day) throws IOException {
        super(
            number,
            day,
            ImageIO.read(new File(Images.getImage("mc2.png")))
        );
    }

    @Override
    public void performAction() {

    }
}
