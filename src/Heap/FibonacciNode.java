package Heap;

import java.util.ArrayList;

/**
 * Created by Kalaman on 10.01.17.
 */
public class FibonacciNode {

    public int value;
    public int rank;

    public FibonacciNode parent;
    public FibonacciNode left;
    public FibonacciNode right;

    public ArrayList<FibonacciNode> child;

    private boolean marked;

    /**
     * Constructor for Heap.Constants.nilNode
     */
    public FibonacciNode(){
        value = -1;
    }

    public FibonacciNode(int value){
        this.value = value;
        this.rank = 0;
        this.parent = Constants.nilNode;

        this.left = this;
        this.right = this;

        this.marked = false;
        this.child = new ArrayList<FibonacciNode>();
    }


    public boolean isMarked() {
        return marked;
    }
}
