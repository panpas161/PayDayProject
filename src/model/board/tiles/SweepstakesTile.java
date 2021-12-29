package model.board.tiles;

import functions.PathFinder;
import model.board.Tile;
import model.player.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SweepstakesTile extends Tile {
    public SweepstakesTile(int number, String day) throws IOException {
        super(
            number,
            day,
            ImageIO.read(new File(PathFinder.Images.getImage("sweep.png")))
        );
    }

    @Override
    public void performAction() {
        Player player = new Player("test",5000);
        player.getDice().roll();
        player.addCash(player.getDice().getCurrentValue());
    }
}
