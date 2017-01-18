package Graph;

import java.util.HashMap;

/**
 * Created by Kalaman on 09.01.17.
 */
public class Edge {

    double value;

    Node node1;
    Node node2;

    public boolean marked;


    public Edge (Node node1,Node node2){
        this.value = Math.sqrt(Math.pow((node2.getPosX()-node1.getPosX()),2) + Math.pow((node2.getPosY()-node1.getPosY()),2));

        this.node1 = node1;
        this.node2 = node2;

        marked = false;
    }

    public Edge (Edge cpyEdge)
    {
        this.value = cpyEdge.getValue();
        this.node1 = new Node(String.valueOf(cpyEdge.getNode1().getName()),cpyEdge.getNode1().getPosX(),cpyEdge.getNode1().getPosY());
        this.node2 = new Node(String.valueOf(cpyEdge.getNode2().getName()),cpyEdge.getNode2().getPosX(),cpyEdge.getNode2().getPosY());
        this.marked = cpyEdge.marked;
    }

    public void mark (boolean mark)
    {
        this.marked = mark;
    }

    public Node getNeighbour (Node node)
    {
        if (node.equals(node1))
            return getNode2();
        else
            return getNode1();
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public String toString()
    {
        if (value % 2 == 0)
            return String.valueOf((int)value);
        else
            return String.format("%.2f", value);
    }

    public double getValue() {
        return value;
    }
}
