import Graph.GUI.JMainFrame;
import Graph.Utilities.CSVReader;

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
