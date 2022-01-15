package model.event;

import controller.Config;
import model.player.Player;
import view.EventPopup;

import java.awt.image.BufferedImage;

public class PayDay extends Event{
    Player player;
    public PayDay(Player player)
    {
        super(3, "payday", "PayDay", "", null);
        this.player = player;
        performAction();
    }

    @Override
    public void performAction() {
        Config.Events.payDay(player);
        new EventPopup(this);
    }
}
