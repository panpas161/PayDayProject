package model.board.tiles;

import functions.PathFinder;
import model.board.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DealTile extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the deal tile
     */
    public DealTile(int number, String day) throws IOException {
        super(
            number,
            day,
            ImageIO.read(new File(PathFinder.Images.getImage("deal.png")))
        );
    }

    @Override
    public void performAction() {

    }
}
