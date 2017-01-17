package Graph.Utilities;

import Graph.Edge;
import Graph.GUI.JGraphPanel;
import Graph.Node;

import java.util.ArrayList;

/**
 * Created by Jok3r on 17.01.2017.
 */
public class DrawingClip {

    ArrayList<Edge> edges;
    ArrayList<Node> nodes;

    public DrawingClip(ArrayList <Node> nodeList, ArrayList<Edge> edgeList)
    {
//        this.nodes = new ArrayList<Node>(nodeList);
//        this.edges = new ArrayList<Edge>(edgeList);
        this.nodes = (ArrayList<Node>)nodeList.clone();
        this.edges = (ArrayList<Edge>)edgeList.clone();
    }

}
