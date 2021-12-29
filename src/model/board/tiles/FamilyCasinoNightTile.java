package model.board.tiles;

import functions.PathFinder;
import model.board.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FamilyCasinoNightTile extends Tile {
    public FamilyCasinoNightTile(int number, String day) throws IOException {
        super(
            number,
            day,
            ImageIO.read(new File(PathFinder.Images.getImage("casino.png")))
        );
    }

    @Override
    public void performAction() {

    }
}
