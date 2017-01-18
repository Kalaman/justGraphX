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
    public static JButton jButtonJumpEnd = new JButton("->>");
    public static JButton jButtonBackward = new JButton("<-");
    public static JButton jButtonJumpStart = new JButton("<<-");

    public JStatusBar ()
    {
        this.setPreferredSize(new Dimension(Constants.PANEL_STATUS_BAR_SIZE_X, Constants.PANEL_STATUS_BAR_SIZE_Y));
        this.setLayout(new BorderLayout());
        this.add(jStatusLabel,BorderLayout.WEST);

        JPanel navigationPanel = new JPanel(new FlowLayout());
        navigationPanel.add(jButtonJumpStart);
        navigationPanel.add(jButtonBackward);
        navigationPanel.add(jButtonForward);
        navigationPanel.add(jButtonJumpEnd);
        this.add(navigationPanel,BorderLayout.EAST);

        setButtonListeners();

        JStatusBar.unlockNavigationButtons(false);

        writeToStatusBar("Ready");
    }

    private void setButtonListeners ()
    {
        jButtonBackward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JGraphPanel.pathDrawer.makePrevStep();
            }
        });
        jButtonForward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JGraphPanel.pathDrawer.makeNextStep();
            }
        });

        jButtonJumpStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JGraphPanel.pathDrawer.jumpToStart();
            }
        });

        jButtonJumpEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JGraphPanel.pathDrawer.jumpToEnd();
            }
        });
    }

    public static void writeToStatusBar (String status)
    {
        jStatusLabel.setText(" ["+ status + "]");
    }

    public static void unlockNavigationButtons(boolean lock)
    {
        jButtonBackward.setEnabled(lock);
        jButtonForward.setEnabled(lock);
        jButtonJumpStart.setEnabled(lock);
        jButtonJumpEnd.setEnabled(lock);
    }
}
