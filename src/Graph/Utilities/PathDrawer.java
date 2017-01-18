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

    ArrayList<DrawingFrame> drawingFrame;
    private int index = 0;
    private JGraphPanel jGraphPanel;

    public PathDrawer(ArrayList<DrawingFrame> drawingClip , JGraphPanel jGraphPanel){
        this.drawingFrame = drawingClip;
        this.jGraphPanel = jGraphPanel;
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
        if (index < drawingFrame.size()) {

            ++index;
            step(index);
        }
        else JLeftMenuPanel.writeToConsole("Algorithm finished !");
    }

    private void step(int index)
    {
        JStatusBar.writeToStatusBar("Step ("+ (index+1) + "/"+ drawingFrame.size()+") " + Main.SELECTED_ALGORITHM + " Algorithm");
        jGraphPanel.nodeArrayList = drawingFrame.get(index).nodes;
        jGraphPanel.edgeArrayList = drawingFrame.get(index).edges;

        jGraphPanel.repaint();

        if(index == 0)
        {
            JStatusBar.unlockNavigationBackwardButtons(false);
            JStatusBar.unlockNavigationForwardButtons(true);
        }
        else if (index + 1  ==  drawingFrame.size()) {
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
        index = drawingFrame.size()-1;

        step(index);
    }

    public void jumpToStart(){
        index = 0;

        step(index);
    }
}

