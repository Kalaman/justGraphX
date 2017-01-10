package Heap;

import java.util.ArrayList;

/**
 * Created by Kalaman on 10.01.17.
 */
public class FibonacciHeap {

    int n;
    FibonacciNode min;
    ArrayList<FibonacciNode> rootList;

    public FibonacciHeap(){
        rootList = new ArrayList<>();
        min = Constants.nilNode;
    }

    public void insert(int value)
    {
        FibonacciNode newNode = new FibonacciNode(value);

        //Same like "If min == NIL"
        if (this.min.equals(Constants.nilNode))
        {
            this.rootList.add(newNode);
            this.min = newNode;
        }
        else
        {
            this.rootList.add(newNode);
            if (newNode.value < min.value)
                min = newNode;
        }

        this.n = n+1;
    }

    public void union (FibonacciHeap heap1)
    {
        FibonacciHeap heap2 = this;
    }


}
