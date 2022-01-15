package model.card.mail;

import functions.MessageGenerator;

import model.board.Board;
import model.board.Tile;
import model.board.tiles.BuyerTile;
import model.card.MailCard;
import model.player.Player;
import view.MailCardPopup;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class MoveToDealOrBuyer extends MailCard {

    public MoveToDealOrBuyer(Board board) {
        super(
        "Μετακίνηση σε θέση Συμφωνίας/Αγοραστή.",
            MessageGenerator.MoveToDealOrBuyer.getDescription(),
            null,
            "",
                board
        );
    }

    @Override
    public void performAction()
    {
        Player player = getOwner();
        int playerPosition = player.getCurrentPosition();

        int buyerPosition = board.getTilePosition(BuyerTile.class,playerPosition);
        int dealPosition = board.getTilePosition(MoveToDealOrBuyer.class,playerPosition);
        if(buyerPosition > dealPosition)
        {
            player.setCurrentPosition(dealPosition);
        }
        else
        {
            player.setCurrentMonth(buyerPosition);
        }
        new MailCardPopup(this);
    }
}
