package model.board.tiles;

import model.board.Tile;

import java.awt.image.BufferedImage;

public class RadioContestTile extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the radio contest tile
     */
    public RadioContestTile(int number, String day) {
        super(
            number,
            day,
        null
        );
    }

    @Override
    public void performAction() {

    }
}
