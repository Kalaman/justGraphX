package Graph.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graph.Utilities.Constants;

/**
 * Created by Jok3r on 13.01.2017.
 */
public class JStatusBar extends JPanel{

    public static JLabel jStatusLabel = new JLabel();

    public static JButton jButtonForward = new JButton("->");
    public static JButton jButtonBackward = new JButton("<-");

    public JStatusBar ()
    {
        this.setPreferredSize(new Dimension(Constants.PANEL_STATUS_BAR_SIZE_X, Constants.PANEL_STATUS_BAR_SIZE_Y));
        this.setLayout(new BorderLayout());
        this.add(jStatusLabel,BorderLayout.WEST);

        JPanel navigationPanel = new JPanel(new FlowLayout());
        navigationPanel.add(jButtonBackward);
        navigationPanel.add(jButtonForward);
        this.add(navigationPanel,BorderLayout.EAST);

        jButtonForward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JGraphPanel.pathDrawer.makeNextStep();
            }
        });

        writeToStatusBar("Ready");
    }

    public static void writeToStatusBar (String status)
    {
        jStatusLabel.setText(" ["+ status + "]");
    }
}
