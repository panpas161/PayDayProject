package view;

import model.card.Card;
import model.card.MailCard;

import javax.swing.*;
import java.awt.*;

public class MailCardPopup extends JFrame {
    TextField description;
    Button confirm;
    public MailCardPopup(MailCard card)
    {
        this.setTitle(card.getTitle());
        description = new TextField(card.getDescription());
        description.setBounds(50,100,60,50);
        confirm = new Button(card.getConfirmText());
    }
}
