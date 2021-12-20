package model.board.tiles;

import model.board.Tile;

import java.awt.image.BufferedImage;

public class DealTile extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the deal tile
     */
    public DealTile(int number, String day) {
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
