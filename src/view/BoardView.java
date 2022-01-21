package view;

import com.sun.jdi.Field;
import functions.PathFinder;
import model.board.Board;
import model.player.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Native;
import java.util.ArrayList;


public class BoardView extends JPanel
{
    JLabel playerOnePawn;
    JLabel playerTwoPawn;
    ArrayList<JLabel> dates;
    ArrayList<JLabel> tileImages;
    ArrayList<JPanel> tiles;
    JPanel jackpot;
    GridBagConstraints c;
    Player p1;
    Player p2;
    Board board;
    JLabel jackpotImage;
    JPanel tilesPanel;
    public BoardView(Board board, Player p1, Player p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
        dates = new ArrayList<>();
        tileImages = new ArrayList<>();
        tiles = new ArrayList<>();
        jackpot = new JPanel();
        playerOnePawn = new JLabel(
            new ImageIcon(
                p1.getPawnImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)
            )
        );
        playerTwoPawn = new JLabel(
            new ImageIcon(
                p2.getPawnImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)
            )
        );
        c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        for(int i = 0; i< board.getTiles().length; i++)
        {
            ImageIcon tempBoardIcon = new ImageIcon(board.getTiles()[i].getImage().getScaledInstance(100,80,Image.SCALE_SMOOTH));
            dates.add(
                new JLabel(board.getTiles()[i].getDate())
            );
            tileImages.add(
                new JLabel(tempBoardIcon)
            );
            JPanel tile = new JPanel();
            tile.setLayout(new GridBagLayout());
            c.gridx = 0;
            c.gridy = 0;
            tile.add(dates.get(i),c);
            c.gridy = 1;
            tileImages.get(i).setLayout(new GridLayout(1,2));
            tile.add(tileImages.get(i),c);
            tiles.add(tile);
        }
        c.gridx = 0;
        c.gridy = 0;
        for(int i=0;i<32;i++)
        {
            if(c.gridx%6 == 0)
            {
                c.gridx = 0;
                c.gridy++;
            }
            this.add(tiles.get(i),c);
            c.gridx++;
        }
        updatePawns();
        //jackpot
        try
        {
            jackpotImage = new JLabel(
                new ImageIcon(
                    ImageIO.read(new File(PathFinder.Images.getImage("jackpot.png")))
                )
            );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
//        this.add(jackpotImage,c);
    }

    /**
     * Transformer.
     * Post Condition: changes the pawns position on the board
     */
    public void updatePawns()
    {
        c.gridx = 0;
        c.gridy = 1;
        tiles.get(p1.getCurrentPosition()).add(playerOnePawn,c,1);
//        System.out.println("test--\n" + board.getTiles()[p1.getCurrentPosition()].getPlayersPresent());
        tiles.get(p2.getCurrentPosition()).add(playerTwoPawn,c,1);
    }
}
