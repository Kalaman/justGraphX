import Graph.GUI.JMainFrame;
import Graph.Node;
import Graph.Utilities.CSVReader;
import Graph.Utilities.Constants;

import java.util.PriorityQueue;

/**
 * Created by Kalaman on 09.01.17.
 */
public class Main {

    public static void main(String [] arg){
        CSVReader.getNodeList();

        new JMainFrame();
    }
}
