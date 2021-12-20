package model.board.tiles;

import model.board.Tile;

import java.awt.image.BufferedImage;

public class MessageTile extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the message tile
     */
    public MessageTile(int number, String day) {
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
