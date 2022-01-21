package model.board.tiles;

import functions.DaysChecker;
import functions.PathFinder;
import model.board.Board;
import model.board.Tile;
import model.player.Player;
import controller.Controller;
import view.TilePopup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FamilyCasinoNightTile extends Tile {
    public FamilyCasinoNightTile(int number,Board board) throws IOException {
        super(
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("casino.png"))),
            board
        );
    }

    @Override
    public void performAction(Player player) {
        if(player.getDice().getCurrentValue()%2==0)
        {
            player.addCash(500);
        }
        else
        {
            player.removeCash(500);
            Controller.jackpot.addValue(500);
        }
        new TilePopup(this);
    }
}
