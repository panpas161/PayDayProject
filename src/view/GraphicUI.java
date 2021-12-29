package view;
import model.board.Board;
import view.BoardView;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import functions.PathFinder.Images;

public class GraphicUI extends JFrame {

    public GraphicUI(Board board)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4,2));
        //logo
        JLabel logo = new JLabel(new ImageIcon(Images.getImage("talos.jpg")));
        this.add(logo);
        //board
        JPanel boardPanel = new BoardView(board);
        this.add(boardPanel);
        //info box
        JPanel infoBox = new InfoBoxView();
        this.add(infoBox);
        this.setSize(1000,800);
        this.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        new GraphicUI(new Board());
    }
}
