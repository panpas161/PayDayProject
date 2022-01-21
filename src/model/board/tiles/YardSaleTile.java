package model.board.tiles;

import functions.DaysChecker;
import functions.PathFinder;
import model.board.Board;
import model.board.Tile;
import model.card.DealCard;
import model.player.Player;
import view.TilePopup;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class YardSaleTile extends Tile {
    public YardSaleTile(int number, Board board) throws IOException {
        super(
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("yard.png"))),
            board
        );
    }

    @Override
    public void performAction(Player player) {
        player.removeCash(100*player.getDice().getCurrentValue());
        player.addDealCard(new DealCard());
        new TilePopup(this);
    }
}
