package Graph;

import Graph.GUI.JMainFrame;
import Graph.Utilities.CSVReader;
import Graph.Utilities.Constants;

/**
 * Created by Kalaman on 09.01.17.
 */
public class Main {

    public static String SELECTED_ALGORITHM = Constants.ALGORITHM_MCST;

    public static void main(String [] arg){
        CSVReader.getNodeList();

        //Change
        new JMainFrame();
    }
}
