package view;
import view.BoardView;
import javax.swing.*;

public class GraphicUI extends JFrame {
    public GraphicUI()
    {
        JLabel logo = new JLabel(new ImageIcon());
        this.add(logo);
        this.add(new BoardView());
        this.setSize(1000,800);
        this.setVisible(true);
    }
    public static void main(String[] args)
    {
        new GraphicUI();
    }
}
