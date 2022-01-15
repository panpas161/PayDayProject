package model.card.mail;

import functions.MessageGenerator;

import model.board.Board;
import model.card.MailCard;
import model.player.Player;
import view.MailCardPopup;

import java.awt.image.BufferedImage;

public class PayNeighbor extends MailCard {

    public PayNeighbor(Board board) {
        super(
                "Πλήρωσε τον γείτονα",
                MessageGenerator.PayNeighbor.getDescription(),
                null,
                "test",
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
        this.getOwner().sendMoney(rival,500);
        new MailCardPopup(this);
    }
}
