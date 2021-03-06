package Graph.Utilities;

import Graph.Structure.Node;

import java.util.Comparator;

/**
 * Created by Jok3r on 17.01.2017.
 */
public class NodeComparator implements Comparator<Node>{

    @Override
        public int compare(Node o1, Node o2) {
            return Double.compare(o2.getKey(), o1.getKey());
        }
}
