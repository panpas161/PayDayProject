package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//import functions.DaysChecker.Days.getDay;


public class BoardView extends JPanel
{
    public BoardView()
    {
        ArrayList<JLabel> dates = new ArrayList<>();
        ArrayList<JLabel> tileImages = new ArrayList<>();
        dates.add(new JLabel("Start"));
        for(int i=1;i<=32;i++)
        {
            dates.add(
                new JLabel(i + "monday") //getDay(i)
            );
            tileImages.add(
                new JLabel(new ImageIcon())
            );
        }
    }
}
