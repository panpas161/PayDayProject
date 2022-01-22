package model.event;

import functions.PathFinder;
import model.player.Player;
import view.EventPopup;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class SundayFootballDay extends Event{
    public SundayFootballDay() throws IOException {
        super(
            1,
            "sunday_football_day",
                "Ποδοσφαιρικός Αγώνας Κυριακής",
                "",
                ImageIO.read(new File(PathFinder.Images.getImage("Barcelona_Real.jpg"))),
                4
        );
        String[] optionStrings = {
                "Νίκη Μπαρτσελόνα",
                "Ισοπαλία",
                "Νίκη Ρεάλ",
                "Δε θέλω να κάνω πρόβλεψη"
        };
        setOptionStrings(optionStrings);
        performAction();
    }

    @Override
    public void performAction()
    {
        new EventPopup(this);
    }
}
