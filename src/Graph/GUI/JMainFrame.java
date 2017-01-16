package Graph.GUI;

import Graph.Utilities.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jok3r on 13.01.2017.
 */
public class JMainFrame extends JFrame{

    JLeftMenuPanel jLeftMenuPanel = new JLeftMenuPanel();
    JStatusBar jStatusBar = new JStatusBar();
    JGraphPanel jGraphPanel = new JGraphPanel();

    public JMainFrame() throws HeadlessException {
        super("justGraphX");
        this.setSize(new Dimension(Constants.FRAME_SIZE_X,Constants.FRAME_SIZE_Y));
        this.add(jLeftMenuPanel,BorderLayout.WEST);
        this.add(jStatusBar,BorderLayout.SOUTH);
        this.add(jGraphPanel);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
