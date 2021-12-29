package model.board.tiles;

import model.board.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import functions.PathFinder.Images;

public class BuyerTile extends Tile {

    public BuyerTile(int number, String day) throws IOException {
        super(
            number,
            day,
            ImageIO.read(new File(Images.getImage("buyer.png")))
        );
    }

    @Override
    public void performAction() {

    }
}
