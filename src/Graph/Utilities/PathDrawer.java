package Graph.Utilities;

import Graph.GUI.JGraphPanel;
import Graph.GUI.JLeftMenuPanel;

import java.util.ArrayList;

/**
 * Created by Jok3r on 17.01.2017.
 */
public class PathDrawer {

    ArrayList<DrawingFrame> drawingFrame;
    private int index = 0;
    private JGraphPanel jGraphPanel;

    public PathDrawer(ArrayList<DrawingFrame> drawingClip , JGraphPanel jGraphPanel){
        this.drawingFrame = drawingClip;
        this.jGraphPanel = jGraphPanel;
    }

    public void makePrevStep ()
    {
        if (index > 0)
            --index;
        if (index < drawingFrame.size()) {
            JLeftMenuPanel.writeToConsole("Make step " + index);

            jGraphPanel.currentNodeArrayList = drawingFrame.get(index).nodes;
            jGraphPanel.currentEdgeArrayList = drawingFrame.get(index).edges;

            jGraphPanel.repaint();
        }
        else JLeftMenuPanel.writeToConsole("Algorithm finished !");
    }


    public void makeNextStep ()
    {

        if (index < drawingFrame.size()) {

            ++index;
            JLeftMenuPanel.writeToConsole("Make step " + index);

            jGraphPanel.currentNodeArrayList = drawingFrame.get(index).nodes;
            jGraphPanel.currentEdgeArrayList = drawingFrame.get(index).edges;

            jGraphPanel.repaint();
        }
        else JLeftMenuPanel.writeToConsole("Algorithm finished !");
    }

    public void jumpToEnd(){
        index = drawingFrame.size()-1;

        jGraphPanel.currentNodeArrayList = drawingFrame.get(index).nodes;
        jGraphPanel.currentEdgeArrayList = drawingFrame.get(index).edges;

        jGraphPanel.repaint();

    }

    public void jumpToStart(){
        index = 0;

        jGraphPanel.currentNodeArrayList = drawingFrame.get(index).nodes;
        jGraphPanel.currentEdgeArrayList = drawingFrame.get(index).edges;

        jGraphPanel.repaint();

    }
}

