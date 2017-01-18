package Graph;

import Graph.Utilities.Constants;
import com.sun.tools.internal.jxc.ap.Const;
import sun.jvm.hotspot.oops.CompressedLineNumberReadStream;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Kalaman on 09.01.17.
 */
public class Node implements Comparable <Node>{

    private String name = "";
    private Point xyPosition;

    private Node pi = Constants.DEFAULT_NODE;
    private double key = Constants.INFINITY;;

    private boolean marked;
    private int [] color = new int [3];

    public Constants.NODE_TYPE nodeType;

    private ArrayList<Edge> edges;

    public Node (String name,int x,int y){
        this.name = name;
        this.xyPosition = new Point(x,y);
        this.edges = new ArrayList<>();

        this.key = Constants.INFINITY;
        this.pi = Constants.DEFAULT_NODE;

        changeNodeType(Constants.NODE_TYPE.NODE_NORMAL);
    }

    public Node (String name,int x,int y,boolean marked){
        this(name,x,y);
        markNode(marked);
    }

    public Node (Node cpyNode)
    {
        this.name = String.valueOf(cpyNode.name);
        this.xyPosition = new Point(cpyNode.getPosX(),cpyNode.getPosY());
        this.edges = new ArrayList<>();
        this.color = cpyNode.getColor();

        for(Edge currentEdge: cpyNode.getEdges())
        {
            edges.add(new Edge(currentEdge));
        }
        this.key = cpyNode.getKey();
        if (cpyNode.getPi() == null || cpyNode.getPi().equals(Constants.DEFAULT_NODE))
            this.pi = Constants.DEFAULT_NODE;
        else
            this.pi = new Node(cpyNode.getPi());
    }

    public void setKey(double key) {
        this.key = key;
    }

    public void setPi(Node pi) {
        this.pi = pi;
    }

    public void markNode (boolean mark)
    {
        this.marked = mark;
    }

    public int getPosX ()
    {
        return (int)xyPosition.getX();
    }

    public int getPosY ()
    {
        return (int)xyPosition.getY();
    }

    public String toString()
    {
        return this.name;
    }

    public void changeNodeType (Constants.NODE_TYPE newNodeType){
        this.nodeType = newNodeType;

        switch (nodeType)
        {
            case NODE_START:
                color = Constants.NODE_START_COLOR;
                break;
            case NODE_END:
                color = Constants.NODE_END_COLOR;
                break;
            case NODE_NORMAL:
                color = Constants.NODE_NORMAL_COLOR;
                break;
        }
    }

    public double getKey() {
        return key;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void addEdge (Edge edge)
    {
        edges.add(edge);
    }

    public Node getPi() {
        return pi;
    }

    public Edge getEdgeByNeigbour (Node node)
    {
        for (Edge currentEdge : edges)
        {
            if (currentEdge.getNeighbour(this).equals(node))
            {
                return currentEdge;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public int [] getColor ()
    {
        return this.color;
    }

    @Override
    public int compareTo(Node o) {
        if (this.key == o.key) return 0;
        else if (this.key > o.key) return 1;
        else return -1;
    }
}
