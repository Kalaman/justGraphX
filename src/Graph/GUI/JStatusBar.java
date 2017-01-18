package Graph.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graph.Structure.Edge;
import Graph.Structure.Node;
import Graph.Utilities.CSVReader;
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
    public static JButton jButtonReset = new JButton("Reset");

    private JGraphPanel jGraphPanel;

    public JStatusBar (JGraphPanel jGraphPanel)
    {
        this.setPreferredSize(new Dimension(Constants.PANEL_STATUS_BAR_SIZE_X, Constants.PANEL_STATUS_BAR_SIZE_Y));
        this.setLayout(new BorderLayout());
        this.add(jStatusLabel,BorderLayout.WEST);
        this.jGraphPanel = jGraphPanel;

        JPanel navigationPanel = new JPanel(new FlowLayout());
        navigationPanel.add(jButtonJumpStart);
        navigationPanel.add(jButtonBackward);
        navigationPanel.add(jButtonForward);
        navigationPanel.add(jButtonJumpEnd);
        navigationPanel.add(jButtonReset);
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

        jButtonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unlockNavigationButtons(false);
                JLeftMenuPanel.lockMenu(false);

                CSVReader.nodeHashMap.clear();

                for (Node currentNode :jGraphPanel.nodeArrayList){
                    currentNode.changeNodeType(Constants.NODE_TYPE.NODE_NORMAL);

                    CSVReader.nodeHashMap.put(currentNode.toString(),currentNode);
                }

                for (Edge currentEdge: jGraphPanel.edgeArrayList)
                {
                    currentEdge.mark(false);
                }



                jGraphPanel.repaint();

                JLeftMenuPanel.writeToConsole("Graph reseted");
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

    public static void unlockNavigationForwardButtons(boolean lock)
    {
        jButtonForward.setEnabled(lock);
        jButtonJumpEnd.setEnabled(lock);
    }

    public static void unlockNavigationBackwardButtons(boolean lock)
    {
        jButtonBackward.setEnabled(lock);
        jButtonJumpStart.setEnabled(lock);
    }
}
