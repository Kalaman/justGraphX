package Graph;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kalaman on 09.01.17.
 */
public class Node {

    private String name;
    private Point xyPosition;

    private ArrayList<Edge> edges;

    public Node (String name,int x,int y){
        this.name = name;
        this.xyPosition = new Point(x,y);
        this.edges = new ArrayList<>();
    }


    public int getPosX ()
    {
        return (int)xyPosition.getX();
    }

    public int getPosY ()
    {
        return (int)xyPosition.getY();
    }

    public String toString()
    {
        return this.name;
    }

}
