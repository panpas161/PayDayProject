package model.event;

import functions.PathFinder;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ThursdayRiseValueCrypto extends Event{
    public ThursdayRiseValueCrypto() throws IOException {
        super(
            2,
            "thursday_rise_in_value_of_cryptos",
                "Crypto Thursday",
                "Ποντάρισμα σε κρυπτονομίσματα",
                ImageIO.read(new File(PathFinder.Images.getImage("")))
        );
        performAction();
    }

    @Override
    public void performAction() {

    }
}
