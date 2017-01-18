package Graph.Utilities;

import Graph.Edge;
import Graph.GUI.JGraphPanel;
import Graph.Node;

import java.util.ArrayList;

/**
 * Created by Jok3r on 17.01.2017.
 */
public class DrawingFrame {

    ArrayList<Edge> edges = new ArrayList<>();
    ArrayList<Node> nodes = new ArrayList<>();

    public DrawingFrame(ArrayList <Node> nodeList, ArrayList<Edge> edgeList)
    {
        for (Edge currentEdge : edgeList)
        {
            this.edges.add(new Edge(currentEdge));
        }

        for (Node currentNode : nodeList)
        {
            this.nodes.add(new Node(currentNode));
        }

    }

}
