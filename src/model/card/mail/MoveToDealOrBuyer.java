package model.card.mail;

import functions.MessageGenerator;

import functions.PathFinder;
import model.board.Board;
import model.board.Tile;
import model.board.tiles.BuyerTile;
import model.board.tiles.DealTile;
import model.card.MailCard;
import model.player.Player;
import view.MailCardPopup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MoveToDealOrBuyer extends MailCard {

    public MoveToDealOrBuyer(Board board) throws IOException {
        super(
        "Μετακίνηση σε θέση Συμφωνίας/Αγοραστή.",
            MessageGenerator.MoveToDealOrBuyer.getDescription(),
            ImageIO.read(new File(PathFinder.Images.getImage("caretta.jpg"))),
        "Εντάξει",
            board
        );
    }

    @Override
    public void performAction()
    {
        Player player = getOwner();
        int playerPosition = player.getCurrentPosition();
        int buyerPosition = board.getTilePosition(BuyerTile.class,playerPosition);
        int dealPosition = board.getTilePosition(DealTile.class,playerPosition);
        if(buyerPosition > dealPosition)
        {
            board.movePlayerToPosition(player,dealPosition);
        }
        else
        {
            board.movePlayerToPosition(player,buyerPosition);
        }
    }
}
