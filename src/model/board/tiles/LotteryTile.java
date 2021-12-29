package model.board.tiles;

import functions.PathFinder;
import model.board.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LotteryTile extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the lottery tile
     */
    public LotteryTile(int number, String day) throws IOException {
        super(
            number,
            day,
            ImageIO.read(new File(PathFinder.Images.getImage("lottery.png")))
        );
    }

    @Override
    public void performAction() {

    }
}
