package model.event;

import functions.PathFinder;
import model.player.Player;

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
                ImageIO.read(new File(PathFinder.Images.getImage("")))
        );
        performAction();
    }

    @Override
    public void performAction()
    {

    }
}
