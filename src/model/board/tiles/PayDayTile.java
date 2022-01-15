package model.board.tiles;

import controller.Config;
import functions.DaysChecker;
import functions.PathFinder;
import model.board.Tile;
import model.event.PayDay;
import model.player.Player;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PayDayTile extends Tile {

    public PayDayTile(int number) throws IOException {
        super(
                number,
                DaysChecker.Days.getDay(number),
                ImageIO.read(new File(PathFinder.Images.getImage("pay.png")))
        );
    }
    @Override
    public void performAction(Player player) {
        new PayDay(player);
    }
}
