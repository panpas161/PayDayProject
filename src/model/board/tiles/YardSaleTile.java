package model.board.tiles;

import functions.DaysChecker;
import functions.PathFinder;
import model.board.Tile;
import model.player.Player;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class YardSaleTile extends Tile {
    public YardSaleTile(int number) throws IOException {
        super(
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("yard.png")))
        );
    }

    @Override
    public void performAction(Player player) {
        player.removeCash(100*player.getDice().getCurrentValue());
//        player.addDealCard();
    }
}
