package model.board.tiles;

import functions.PathFinder;
import model.board.Tile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RadioContestTile extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the radio contest tile
     */
    public RadioContestTile(int number, String day) throws IOException {
        super(
            number,
            day,
            ImageIO.read(new File(PathFinder.Images.getImage("radio.png")))
        );
    }

    @Override
    public void performAction() {

    }
}
