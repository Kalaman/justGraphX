package Graph.Utilities;

import Graph.GUI.JGraphPanel;
import Graph.Structure.Edge;
import Graph.Structure.Node;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Jok3r on 17.01.2017.
 */
public class Algorithm {

    public static ArrayList<DrawingFrame> Dijkstra (Node startNode)
    {
        ArrayList<DrawingFrame> dijkstraDrawingClip = new ArrayList<>();

        PriorityQueue<Node> minHeap = new PriorityQueue<Node>();

        for(Node currentNode :JGraphPanel.nodeArrayList)
        {
            currentNode.setKey(Constants.INFINITY);
            currentNode.setPi(Constants.DEFAULT_NODE);
        }
        startNode.setKey(0);

        for(Node currentNode:JGraphPanel.nodeArrayList)
            minHeap.add(currentNode);

        Node extractedNode;
        while (minHeap.size() > 0)
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
                Edge currenEdge = extractedNode.getEdges().get(i);

                if (neighbourNode.getKey() > (extractedNode.getKey() + currenEdge.getValue()))
                {
                    minHeap.remove(neighbourNode);

                    neighbourNode.setKey(extractedNode.getKey() + currenEdge.getValue());
                    neighbourNode.setPi(extractedNode);

                    minHeap.add(neighbourNode);
                }
            }

            dijkstraDrawingClip.add(new DrawingFrame(JGraphPanel.nodeArrayList,JGraphPanel.edgeArrayList));
        }


        return dijkstraDrawingClip;
    }

    public static ArrayList<DrawingFrame> MCST (Node startNode){

        ArrayList<DrawingFrame> mcstDrawingClip = new ArrayList<>();

        PriorityQueue<Node> minHeap = new PriorityQueue<Node>();

        for(Node currentNode :JGraphPanel.nodeArrayList)
        {
            currentNode.setKey(Constants.INFINITY);
            currentNode.setPi(Constants.DEFAULT_NODE);
        }
        startNode.setKey(0);

        for(Node currentNode:JGraphPanel.nodeArrayList)
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

            mcstDrawingClip.add(new DrawingFrame(JGraphPanel.nodeArrayList,JGraphPanel.edgeArrayList));
        }


        return mcstDrawingClip;
    }


}
