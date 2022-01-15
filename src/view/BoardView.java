package view;

import model.board.Board;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class BoardView extends JPanel
{
    public BoardView(Board board)
    {
        ArrayList<JLabel> dates = new ArrayList<>();
        ArrayList<JLabel> tileImages = new ArrayList<>();
        ArrayList<JPanel> tiles = new ArrayList<>();
        JPanel jackpot = new JPanel();
        for(int i = 0; i< board.getTiles().length; i++)
        {
            dates.add(
                new JLabel(board.getTiles()[i].getDate())
            );
            tileImages.add(
                new JLabel(new ImageIcon(board.getTiles()[i].getImage()))
            );
            tileImages.get(i).setPreferredSize(new Dimension(30,40));
            JPanel tile = new JPanel();
            tile.add(dates.get(i));
            tile.add(tileImages.get(i));
            tile.setPreferredSize(new Dimension(100,100));
            tiles.add(tile);
        }
        for(int i=0;i<32;i++)
        {
            this.add(tiles.get(i));
        }

        //jackpot

    }
}
