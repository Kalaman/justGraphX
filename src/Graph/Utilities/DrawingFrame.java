package Graph.Utilities;

import Graph.Main;
import Graph.Structure.Edge;
import Graph.Structure.Node;

import java.util.ArrayList;

/**
 * Created by Jok3r on 17.01.2017.
 */
public class DrawingFrame {

    ArrayList<Edge> edges = new ArrayList<>();
    ArrayList<Node> nodes = new ArrayList<>();

    String heapInfo = "";

    public DrawingFrame(ArrayList <Node> nodeList, ArrayList<Edge> edgeList , String heapInfo)
    {
        for (Edge currentEdge : edgeList)
        {
            this.edges.add(new Edge(currentEdge));
        }

        for (Node currentNode : nodeList)
        {
            this.nodes.add(new Node(currentNode));
        }
        this.heapInfo = heapInfo;

    }

}
