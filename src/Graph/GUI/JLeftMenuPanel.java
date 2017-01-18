package Graph.GUI;

import Graph.Main;
import Graph.Structure.Node;
import Graph.Utilities.Algorithm;
import Graph.Utilities.CSVReader;
import Graph.Utilities.Constants;
import Graph.Utilities.PathDrawer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Jok3r on 13.01.2017.
 */
public class JLeftMenuPanel extends JPanel{

    public static JButton jButtonStartAlgorithm;

    public static JTextField jStartNodeTextField;

    JLabel jStartNodeLabel;

    public static JComboBox jAlgorithmComboBox;

    JPanel boxLayoutPanel;
    public JGraphPanel jGraphPanel;

    public static JTextArea menuConsole;

    public static Node startNode = Constants.DEFAULT_NODE;



    public JLeftMenuPanel(JGraphPanel jGraphPanel)
    {
        this.setPreferredSize(new Dimension(Constants.PANEL_LEFT_MENU_SIZE_X, Constants.PANEL_LEFT_MENU_SIZE_Y));
        this.setLayout(new BorderLayout());

        initComponents();
        addBoxLayout();
        addFlowLayout();
        addTextFieldListeners();
        addComboBoxListeners();
        addButtonListener();

        writeToConsole("Ready ...");

        this.jGraphPanel = jGraphPanel;
        this.add(jButtonStartAlgorithm,BorderLayout.SOUTH);
    }

    private void addBoxLayout() {
        boxLayoutPanel = new JPanel();
        boxLayoutPanel.setLayout(new BoxLayout(boxLayoutPanel,BoxLayout.Y_AXIS));

        //Lets the console auto scroll
        DefaultCaret caret = (DefaultCaret)menuConsole.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        JScrollPane scrollPane = new JScrollPane(menuConsole);

        this.add(scrollPane,BorderLayout.NORTH);
        this.add(boxLayoutPanel);
    }

    private void addFlowLayout()
    {
        JPanel jPanelNodeStart = new JPanel();
        JPanel jPanelNodeEnd = new JPanel();
        JPanel jPanelAlgorithm = new JPanel();

        jPanelNodeStart.setMaximumSize(new Dimension(Constants.PANEL_LEFT_MENU_SIZE_X,40));
        jPanelNodeEnd.setMaximumSize(new Dimension(Constants.PANEL_LEFT_MENU_SIZE_X,40));

        jPanelNodeStart.setLayout(new FlowLayout());
        jPanelNodeEnd.setLayout(new FlowLayout());
        jPanelAlgorithm.setLayout(new FlowLayout());

        jPanelNodeStart.add(this.jStartNodeLabel);
        jPanelNodeStart.add(this.jStartNodeTextField);

        jPanelAlgorithm.add(new JLabel("Algorithm"));
        jPanelAlgorithm.add(this.jAlgorithmComboBox);

        this.boxLayoutPanel.add(jPanelNodeStart);
        this.boxLayoutPanel.add(jPanelNodeEnd);
        this.boxLayoutPanel.add(jPanelAlgorithm);

        //boxLayoutPanel;
    }

    public static void writeToConsole (String message){
        if (menuConsole.getText().length() > 0)
            menuConsole.setText(menuConsole.getText() + "\n-> " + message);
        else
            menuConsole.setText("-> " + message);
    }

    public void initComponents()
    {
        jButtonStartAlgorithm = new JButton("Start");
        jStartNodeLabel = new JLabel("Start Node");
        jStartNodeTextField = new JTextField(16);
        jAlgorithmComboBox = new JComboBox(Constants.ALGORITHMS);

        jButtonStartAlgorithm.setEnabled(false);

        menuConsole = new JTextArea(15,1);
        menuConsole.setSize(new Dimension(Constants.PANEL_LEFT_MENU_SIZE_X,120));
        menuConsole.setEditable(false);
    }

    private void addButtonListener()
    {
        jButtonStartAlgorithm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.SELECTED_ALGORITHM == Constants.ALGORITHM_MCST) {
                    jGraphPanel.pathDrawer = new PathDrawer(Algorithm.MCST(startNode), jGraphPanel);
                }
                else {
                    jGraphPanel.pathDrawer = new PathDrawer(Algorithm.Dijkstra(startNode), jGraphPanel);
                }
                JStatusBar.unlockNavigationForwardButtons(true);
                lockMenu(true);
                writeToConsole(Main.SELECTED_ALGORITHM + " Algorithm started !");
            }
        });
    }


    private void addComboBoxListeners ()
    {

        jAlgorithmComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    Main.SELECTED_ALGORITHM = e.getItemSelectable().getSelectedObjects()[0].toString();
                    writeToConsole(Main.SELECTED_ALGORITHM + " Algorithm chosen");
                }
            }
        });
    }

    private void addTextFieldListeners ()
    {
        jStartNodeTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateGraph(e, Constants.NODE_TYPE.NODE_START);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateGraph(e, Constants.NODE_TYPE.NODE_START);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

    }

    public static void lockMenu (boolean b)
    {
        jAlgorithmComboBox.setEnabled(!b);
        jButtonStartAlgorithm.setEnabled(!b);
        jStartNodeTextField.setEnabled(!b);
    }

    private void updateGraph(DocumentEvent e, Constants.NODE_TYPE nodeType)
    {
        try {
            String input = e.getDocument().getText(0, e.getDocument().getLength()).toString().toUpperCase();
            if (CSVReader.nodeHashMap.containsKey(input))
            {
                Node node = CSVReader.nodeHashMap.get(input);
                node.changeNodeType(nodeType);

                switch (nodeType)
                {
                    case NODE_START:
                        startNode = node;
                        break;
                }

                writeToConsole("Select Node " + input + " as " + nodeType);

                jGraphPanel.repaint();
            }
            else
            {
                switch (nodeType)
                {
                    case NODE_START:
                        startNode.changeNodeType(Constants.NODE_TYPE.NODE_NORMAL);
                        jGraphPanel.repaint();
                        break;
                }
            }

        }catch(Exception ee){
            ee.printStackTrace();
        }

        if (startNode.nodeType == Constants.NODE_TYPE.NODE_START){
            jButtonStartAlgorithm.setEnabled(true);
        }
        else {
            jButtonStartAlgorithm.setEnabled(false);
        }

    }

}
