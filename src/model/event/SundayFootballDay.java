package model.event;

import functions.PathFinder;

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
    }
}
