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
            "Yard Sale",
            "Πληρώνεις τη τράπεζα 100 * τον αριθμό που έφερες με το ζάρι σε ευρώ",
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("yard.png"))),
            board
        );
    }

    @Override
    public void performAction(Player player) {
        player.getDice().rollEvent();
        player.removeCash(100*player.getDice().getCurrentValue());
        setDescription(
            "<html>" +
            getDescription() + "<br> Your dice rolled: " + player.getDice().getCurrentValue() + "<br>" +
            "You got a deal card!" +
            "</html>"
        );
        board.drawDealCard(player);
        new TilePopup(this);
    }
}
