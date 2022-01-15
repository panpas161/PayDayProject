package view;
import controller.Controller;
import model.board.Board;
import view.BoardView;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import functions.PathFinder.Images;

public class GraphicUI extends JFrame {
    Controller controller;
    JLabel logo;
    JPanel boardPanel;
    JPanel infoBox;
    JPanel playerOnePanel;
    JPanel playerTwoPanel;
    JPanel left,right;
    JLabel playerOnePawn;
    JLabel playerTwoPawn;
    public GraphicUI(Board board) throws IOException {
        controller = new Controller();
        left = new JPanel();
        right = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,2));
        //logo
        logo = new JLabel(new ImageIcon(Images.getImage("talos.jpg")));
        left.add(logo);

        //board
        boardPanel = new BoardView(board);
//        playerOnePawn = new JLabel(new ImageIcon(controller.getPlayer1().getPawnImage()));
//        boardPanel.add(playerOnePawn);
        left.add(boardPanel);

        //player1 panel
        playerOnePanel = new PlayerUI(controller.getPlayer1(), controller.getTurn());
        playerOnePanel.setLayout(new GridLayout(2,1));
        right.add(playerOnePanel);

        //info box
        infoBox = new InfoBoxView(controller.getTurn().getCurrentPlayer());
        right.add(infoBox);

        //player2 panel
        playerTwoPanel = new PlayerUI(controller.getPlayer2(), controller.getTurn());
        playerTwoPanel.setLayout(new GridLayout(2,1));
        right.add(playerTwoPanel);

        //left panel
        left.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.add(left,constraints);

        //right panel
        right.setLayout(new GridLayout(3,1));
        this.add(right);



        this.setLayout(new GridLayout(1,2));
        this.setSize(1000,800);
        this.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        new GraphicUI(new Board());
    }
}
