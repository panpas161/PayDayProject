package model.board.tiles;

import functions.DaysChecker;
import model.board.Board;
import model.board.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import functions.PathFinder.Images;
import model.player.Player;
import view.TilePopup;

public class MessageTileTwo extends Tile
{
    /**
     * Constructor.
     * Postcondition: Creates and initializes the message tile
     */
    public MessageTileTwo(int number, Board board) throws IOException {
        super(
        "Message",
        "",
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(Images.getImage("mc2.png"))),
            board
        );
    }

    @Override
    public void performAction(Player player) {
        board.getMailCardDeck().draw(player);
        board.getMailCardDeck().draw(player);
    }
}
