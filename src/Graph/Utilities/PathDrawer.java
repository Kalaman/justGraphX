package Graph.Utilities;

import Graph.GUI.JGraphPanel;
import Graph.GUI.JLeftMenuPanel;
import Graph.GUI.JStatusBar;
import Graph.Main;

import java.util.ArrayList;

/**
 * Created by Jok3r on 17.01.2017.
 */
public class PathDrawer {

    ArrayList<DrawingFrame> drawingFrames;
    private int index = 0;
    private JGraphPanel jGraphPanel;

    public PathDrawer(ArrayList<DrawingFrame> drawingFrames , JGraphPanel jGraphPanel){
        this.drawingFrames = drawingFrames;
        this.jGraphPanel = jGraphPanel;
        JStatusBar.writeToStatusBar("Step ("+ (index+1) + "/"+ drawingFrames.size()+") " + Main.SELECTED_ALGORITHM + " Algorithm");
    }

    public void makePrevStep ()
    {
        if (index > 0) {
            --index;
            step(index);
        }
        else {
            JLeftMenuPanel.writeToConsole("Algorithm finished !");
        }

    }


    public void makeNextStep ()
    {
        if (index < drawingFrames.size()) {

            ++index;
            step(index);
        }
        else JLeftMenuPanel.writeToConsole("Algorithm finished !");
    }

    private void step(int index)
    {
        JStatusBar.writeToStatusBar("Step ("+ (index+1) + "/"+ drawingFrames.size()+") " + Main.SELECTED_ALGORITHM + " Algorithm");
        JLeftMenuPanel.writeToConsole("Heap after Step "+ index +drawingFrames.get(index).heapInfo);

        jGraphPanel.nodeArrayList = drawingFrames.get(index).nodes;
        jGraphPanel.edgeArrayList = drawingFrames.get(index).edges;

        jGraphPanel.repaint();

        if(index == 0)
        {
            JStatusBar.unlockNavigationBackwardButtons(false);
            JStatusBar.unlockNavigationForwardButtons(true);
        }
        else if (index + 1  ==  drawingFrames.size()) {
            JStatusBar.unlockNavigationForwardButtons(false);
            JStatusBar.unlockNavigationBackwardButtons(true);
        }
        else
        {
            JStatusBar.unlockNavigationBackwardButtons(true);
            JStatusBar.unlockNavigationForwardButtons(true);
        }
    }

    public void jumpToEnd(){
        index = drawingFrames.size()-1;

        step(index);
    }

    public void jumpToStart(){
        index = 0;

        step(index);
    }
}

