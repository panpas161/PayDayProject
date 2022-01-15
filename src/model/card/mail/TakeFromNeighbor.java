package model.card.mail;

import functions.MessageGenerator;
import model.board.Board;
import model.card.MailCard;
import model.player.Player;
import view.MailCardPopup;

import java.awt.image.BufferedImage;

public class TakeFromNeighbor extends MailCard {
    /**
     * Constructor.
     * Postcondition: Creates and initializes a take from neighbor card
     */
    public TakeFromNeighbor(Board board) {
        super(
        "Πάρε λεφτά από τον γείτονα",
            MessageGenerator.TakeFromNeighbor.getDescription(),
        null,
        "",
            board
        );

    }

    @Override
    public void performAction()
    {
        Player rival;
        if(this.getOwner() == board.getPlayer1())
        {
            rival = board.getPlayer2();
        }
        else
        {
            rival = board.getPlayer1();
        }
        rival.sendMoney(this.getOwner(),500);
        new MailCardPopup(this);
    }
}
