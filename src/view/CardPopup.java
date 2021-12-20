package view;

import model.card.MailCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class CardPopup extends JFrame {
    Frame f;
    TextField description;
    Button confirm;
    public CardPopup(MailCard card)
    {
        this.setTitle(card.getTitle());
        description = new TextField(card.getDescription());
        description.setBounds(50,100,60,50);
        confirm = new Button(card.getConfirmText());
    }
}
