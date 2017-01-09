import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Kalaman on 09.01.17.
 */
public class CSVReader {

    public static ArrayList<Node> getNodeList ()
    {
        ArrayList<Node> nodeArrayList = new ArrayList<>();

        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader("Beispielgraph.csv"));

            //Creating Nodes
            while ((line = br.readLine()) != null && !line.equals("?")) {

                String[] nodeData = line.split(",");

                nodeData[1] = nodeData[1].replaceAll(" ","");
                nodeData[2] = nodeData[2].replaceAll(" ","");

                nodeArrayList.add(new Node(nodeData[0],Integer.parseInt(nodeData[1]),Integer.parseInt(nodeData[2])));
            }

            //Adding Edges
            while ((line = br.readLine()) != null) {
                //Do stuff here
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return nodeArrayList;
    }

}
