package Graph.GUI;

import Graph.Utilities.Constants;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;

/**
 * Created by Jok3r on 13.01.2017.
 */
public class JLeftMenuPanel extends JPanel{

    JButton jButtonStartAlgorithm;

    JTextField jStartNodeTextField;
    JTextField jEndNodeTextField;

    JLabel jStartNodeLabel;
    JLabel jEndNodeLabel;

    JPanel boxLayoutPanel;

    public static JTextArea menuConsole;


    public JLeftMenuPanel()
    {
        this.setBackground(new Color(204,204,204));
        this.setPreferredSize(new Dimension(Constants.PANEL_LEFT_MENU_SIZE_X, Constants.PANEL_LEFT_MENU_SIZE_Y));
        this.setLayout(new BorderLayout());

        initComponents();
        addBoxLayout();

        writeToConsole("Ready ...");

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
        jEndNodeLabel = new JLabel("End Node");
        jStartNodeTextField = new JTextField();
        jEndNodeTextField = new JTextField();

        menuConsole = new JTextArea(13,1);
        menuConsole.setSize(new Dimension(Constants.PANEL_LEFT_MENU_SIZE_X,120));
        menuConsole.setEditable(false);
    }

}
