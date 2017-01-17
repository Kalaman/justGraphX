package Graph.Utilities;

import Graph.GUI.JGraphPanel;
import Graph.GUI.JLeftMenuPanel;

import java.util.ArrayList;

/**
 * Created by Jok3r on 17.01.2017.
 */
public class PathDrawer {

    ArrayList<DrawingClip> drawingClip;
    private int index = 0;
    private JGraphPanel jGraphPanel;

    public PathDrawer(ArrayList<DrawingClip> drawingClip , JGraphPanel jGraphPanel){
        this.drawingClip = drawingClip;
        this.jGraphPanel = jGraphPanel;
    }

    public void makeNextStep ()
    {
        JLeftMenuPanel.writeToConsole("Make step " + index);
        if (index < drawingClip.size()) {
            jGraphPanel.currentNodeArrayList = drawingClip.get(index).nodes;
            jGraphPanel.currentEdgeArrayList = drawingClip.get(index).edges;

            jGraphPanel.repaint();

            ++index;
        }
        else JLeftMenuPanel.writeToConsole("Algorithm finished !");
    }

    public void skipToEnd (){
        index = drawingClip.size()-1;

        jGraphPanel.currentNodeArrayList = drawingClip.get(index).nodes;
        jGraphPanel.currentEdgeArrayList = drawingClip.get(index).edges;

        jGraphPanel.repaint();

    }
}

