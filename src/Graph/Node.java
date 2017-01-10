package Graph;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by Kalaman on 09.01.17.
 */
public class Node {

    private String name;
    private Point xyPosition;

    private HashMap<Node,Double> edgeMap;

    public Node (String name,int x,int y){
        this.name = name;
        this.xyPosition = new Point(x,y);
        this.edgeMap = new HashMap<>();
    }

    public double getPosX ()
    {
        return xyPosition.getX();
    }

    public double getPosY ()
    {
        return xyPosition.getX();
    }

    public String toString()
    {
        return this.name;
    }

}
