package Graph.Utilities;

import Graph.GUI.JGraphPanel;
import Graph.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Jok3r on 17.01.2017.
 */
public class Algorithm {

    public static ArrayList<DrawingFrame> MCST (Node startNode){

        ArrayList<DrawingFrame> mcstDrawingClip = new ArrayList<>();

        /*NodeComparator nodeComparator = new NodeComparator();
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(JGraphPanel.currentNodeArrayList.size(), new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return Double.compare(n1.getKey(),n2.getKey());
            }
        }); */

        PriorityQueue<Node> minHeap = new PriorityQueue<Node>();

        for(Node currentNode :JGraphPanel.currentNodeArrayList)
        {
            currentNode.setKey(Constants.INFINITY);
            currentNode.setPi(Constants.DEFAULT_NODE);
        }
        startNode.setKey(0);

        for(Node currentNode:JGraphPanel.currentNodeArrayList)
            minHeap.add(currentNode);

        Node extractedNode;

        while(minHeap.size() > 0)
        {
            extractedNode = minHeap.poll();
            extractedNode.changeNodeType(Constants.NODE_TYPE.NODE_START);

            if(extractedNode.getPi().equals(Constants.DEFAULT_NODE) == false)
            {
                Node pi = extractedNode.getPi();
                extractedNode.getEdgeByNeigbour(pi).mark(true);
            }

            for (int i=0;i<extractedNode.getEdges().size();++i)
            {
                Node neighbourNode = extractedNode.getEdges().get(i).getNeighbour(extractedNode);

                if (minHeap.contains(neighbourNode) && extractedNode.getEdges().get(i).getValue() < neighbourNode.getKey())
                {
                    minHeap.remove(neighbourNode);

                    neighbourNode.setKey(extractedNode.getEdges().get(i).getValue());
                    neighbourNode.setPi(extractedNode);

                    minHeap.add(neighbourNode);
                }
            }

            mcstDrawingClip.add(new DrawingFrame(JGraphPanel.currentNodeArrayList,JGraphPanel.currentEdgeArrayList));
        }


        return mcstDrawingClip;
    }


}
