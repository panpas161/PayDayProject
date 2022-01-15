package model.board.tiles;

import functions.DaysChecker;
import functions.PathFinder;
import model.board.Tile;
import model.player.Player;
import view.DealCardPopup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DealTile extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the deal tile
     */
    public DealTile(int number) throws IOException {
        super(
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("deal.png")))
        );
    }

    @Override
    public void performAction(Player player) {
//        new DealCardPopup();//drawcard
    }
}
