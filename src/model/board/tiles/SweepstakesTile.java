package model.board.tiles;

import functions.DaysChecker;
import functions.PathFinder;
import model.board.Board;
import model.board.Tile;
import model.player.Player;
import view.TilePopup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SweepstakesTile extends Tile {
    public SweepstakesTile(int number, Board board) throws IOException {
        super(
            "Sweepstakes",
            "Κερδίζεις 1000 * τον αριθμό του ζαριού σε ευρώ.",
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("sweep.png"))),
            board
        );
    }

    @Override
    public void performAction(Player player) {
        player.getDice().rollEvent();
        player.addCash(1000 * player.getDice().getCurrentValue());
        setDescription(
                "<html>" +
                getDescription() +
                "<br> Your dice rolled: " + player.getDice().getCurrentValue() +
                "</html>"
        );
        new TilePopup(this);
    }
}
