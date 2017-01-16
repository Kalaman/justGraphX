package Graph.GUI;

import javax.swing.*;
import java.awt.*;
import Graph.Utilities.Constants;

/**
 * Created by Jok3r on 13.01.2017.
 */
public class JStatusBar extends JPanel{

    JLabel jStatusLabel = new JLabel(" Ready ...");

    public JStatusBar ()
    {
        this.setPreferredSize(new Dimension(Constants.PANEL_STATUS_BAR_SIZE_X, Constants.PANEL_STATUS_BAR_SIZE_Y));
        this.setLayout(new BorderLayout());
        this.add(jStatusLabel,BorderLayout.WEST);
    }
}
