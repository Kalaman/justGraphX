package Graph.GUI;

import Graph.Structure.Edge;
import Graph.Structure.Node;
import Graph.Utilities.CSVReader;
import Graph.Utilities.Constants;
import Graph.Utilities.PathDrawer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Jok3r on 13.01.2017.
 */
public class JGraphPanel extends JPanel{

    public static ArrayList<Node> nodeArrayList;
    public static ArrayList<Edge> edgeArrayList;

    public static PathDrawer pathDrawer;


    public JGraphPanel()
    {
        this.setPreferredSize(new Dimension(Constants.PANEL_GRAPH_SIZE_X,Constants.PANEL_GRAPH_SIZE_Y));

        nodeArrayList = CSVReader.getNodeList();
        edgeArrayList = CSVReader.getEdgeList();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        Color defaultColor = g.getColor();
        Stroke defaultStroke = g2.getStroke();


        for(Edge currentEdge:edgeArrayList){
            int pointX1 = currentEdge.getNode1().getPosX() * Constants.SIZE_MULTIPLIKATOR;
            int pointY1 = currentEdge.getNode1().getPosY() * Constants.SIZE_MULTIPLIKATOR;

            int pointX2 = currentEdge.getNode2().getPosX() * Constants.SIZE_MULTIPLIKATOR;
            int pointY2 = currentEdge.getNode2().getPosY() * Constants.SIZE_MULTIPLIKATOR;

            FontMetrics fm = g.getFontMetrics();
            double textWidth = fm.getStringBounds(currentEdge.toString(), g).getWidth();


            if (currentEdge.marked) {
                g2.setColor(new Color(Constants.EDGE_FOUND_COLOR[0], Constants.EDGE_FOUND_COLOR[1], Constants.EDGE_FOUND_COLOR[2]));
                g2.setStroke(new BasicStroke(2));
            }
            else {
                g2.setColor(new Color(Constants.EDGE_DEFAULT_COLOR[0], Constants.EDGE_DEFAULT_COLOR[1], Constants.EDGE_DEFAULT_COLOR[2]));
                g2.setStroke(defaultStroke);
            }
            g2.drawLine(pointX1,pointY1,pointX2,pointY2);
            g2.setColor(Color.BLUE);
            g2.drawString(currentEdge.toString(),(int)((pointX1+pointX2)/2) - (int)(textWidth/2),(int)((pointY1+pointY2)/2) );
            g2.setColor(defaultColor);
        }


        for(Node currentNode:nodeArrayList){
            int positionX = currentNode.getPosX() * Constants.SIZE_MULTIPLIKATOR;
            int positionY = currentNode.getPosY() * Constants.SIZE_MULTIPLIKATOR;

            int [] color = currentNode.getColor();
            g.setColor(new Color (color[0],color[1],color[2]));
            g.fillOval(positionX-(Constants.NODE_WIDTH/2),positionY-(Constants.NODE_HEIGHT/2), Constants.NODE_WIDTH,Constants.NODE_HEIGHT);
            g.setColor(Color.WHITE);

            FontMetrics fm = g.getFontMetrics();
            double textWidth = fm.getStringBounds(currentNode.toString(), g).getWidth();

            g.drawString(currentNode.toString(),(int)(positionX-textWidth/2),(int)(positionY+fm.getAscent()/2));

        }


    }

}
