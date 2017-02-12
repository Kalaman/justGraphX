package Graph.Utilities;

import Graph.GUI.JGraphPanel;
import Graph.Structure.Edge;
import Graph.Structure.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
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
            if (extractedNode.equals(startNode) == false)
                extractedNode.changeNodeType(Constants.NODE_TYPE.NODE_BRIDGE);

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

            String heapInfo = createHeapInfo(minHeap.toArray());

            dijkstraDrawingClip.add(new DrawingFrame(JGraphPanel.nodeArrayList,JGraphPanel.edgeArrayList,heapInfo));
        }


        return dijkstraDrawingClip;
    }

    public static ArrayList<DrawingFrame> DFS (Node startNode){
        ArrayList<DrawingFrame> dfsDrawingClip = new ArrayList<>();

        for(Node currentNode :JGraphPanel.nodeArrayList)
        {
            currentNode.setKey(Constants.INFINITY);
            currentNode.setPi(Constants.DEFAULT_NODE);
        }
        startNode.setKey(0);
        startNode.markNode(true);

        DFSRecursiv(startNode,dfsDrawingClip);


        return dfsDrawingClip;
    }

    public static void DFSRecursiv (Node node,ArrayList<DrawingFrame> drawingFrameList){
        node.markNode(true);
        if (node.getPi() != Constants.DEFAULT_NODE)
            node.getEdgeByNeigbour(node.getPi()).mark(true);

        drawingFrameList.add(new DrawingFrame(JGraphPanel.nodeArrayList,JGraphPanel.edgeArrayList,""));

       for (int i=0;i<node.getEdges().size();++i)
       {
           Node neighbour = node.getEdges().get(i).getNeighbour(node);
           if (neighbour.marked == false)
           {
               DFSRecursiv(neighbour,drawingFrameList);
           }
       }
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
            if (extractedNode.equals(startNode) == false)
                extractedNode.changeNodeType(Constants.NODE_TYPE.NODE_BRIDGE);

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

            String heapInfo = createHeapInfo(minHeap.toArray());

            mcstDrawingClip.add(new DrawingFrame(JGraphPanel.nodeArrayList,JGraphPanel.edgeArrayList,heapInfo));
        }


        return mcstDrawingClip;
    }

    public static String createHeapInfo (Object [] nodesInHeap)
    {
        Arrays.sort(nodesInHeap);

        String heapInfo = "\n";

        for(Object currentObject : nodesInHeap)
        {
            Node currentNode = ((Node)currentObject);
//            if (currentNode.getKey() == Constants.INFINITY)
//                heapInfo += "\t" + currentNode.toString()+ " = INFINITY" + "\n";
//            else
//                heapInfo += "\t" + currentNode.toString()+ " = " + currentNode.getKey() + "\n";
            if (currentNode.getKey() != Constants.INFINITY)
                heapInfo += "\t" + currentNode.toString()+ " = " + currentNode.getKey() + "\n";
        }

        if (heapInfo.equals("\n"))
            heapInfo += "\t--EMPTY--";

        return heapInfo;
    }


}
