package Graph.Utilities;

import Graph.Structure.Node;

/**
 * Created by Jok3r on 13.01.2017.
 */
public class Constants {

    public static final int SIZE_MULTIPLIKATOR = 7;

    public static final int FRAME_SIZE_X = 155 * SIZE_MULTIPLIKATOR;
    public static final int FRAME_SIZE_Y = 100 * SIZE_MULTIPLIKATOR;

    public static final int PANEL_LEFT_MENU_SIZE_X = 45 * SIZE_MULTIPLIKATOR;
    public static final int PANEL_LEFT_MENU_SIZE_Y = FRAME_SIZE_Y;

    public static final int PANEL_GRAPH_SIZE_X = FRAME_SIZE_X - PANEL_LEFT_MENU_SIZE_X;
    public static final int PANEL_GRAPH_SIZE_Y = FRAME_SIZE_Y;

    public static final int PANEL_STATUS_BAR_SIZE_X = FRAME_SIZE_X;
    public static final int PANEL_STATUS_BAR_SIZE_Y = 4 * SIZE_MULTIPLIKATOR;

    public static final int NODE_WIDTH = 25;
    public static final int NODE_HEIGHT = NODE_WIDTH;


    public static final int [] EDGE_FOUND_COLOR = {
            25,
            193,
            14
    };

    public static final int [] EDGE_DEFAULT_COLOR = {
            0,
            0,
            0
    };

    public static final int [] NODE_BRIDGE_COLOR = {
            115,
            225,
            0
    };

    public static final int [] NODE_START_COLOR = {
            255,
            165,
            0
    };

    public static final int [] NODE_NORMAL_COLOR = {
            107,
            107,
            106
    };


    public enum NODE_TYPE {
        NODE_START,
        NODE_BRIDGE,
        NODE_NORMAL
    }

    public static final String ALGORITHM_DIJKSTRA = "Dijkstra";
    public static final String ALGORITHM_MCST = "MCST";
    public static final String ALGORITHM_DFS = "DFS";

    public static final String [] ALGORITHMS = {ALGORITHM_MCST,ALGORITHM_DIJKSTRA,ALGORITHM_DFS};

    public static final Node DEFAULT_NODE = new Node("-1",1337,1337);

    public static final double INFINITY = 999999;

}
