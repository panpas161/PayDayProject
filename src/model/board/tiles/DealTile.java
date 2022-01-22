package model.board.tiles;

import functions.DaysChecker;
import functions.PathFinder;
import model.board.Board;
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
    public DealTile(int number, Board board) throws IOException {
        super(
        "Deal",
    "",
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("deal.png"))),
            board
        );
    }

    @Override
    public void performAction(Player player)
    {
        board.getDealCardDeck().draw(player);
        int lastDealCardIndex = player.getDealCards().size()-1;
        new DealCardPopup(player.getDealCards().get(lastDealCardIndex),player);
    }
}
