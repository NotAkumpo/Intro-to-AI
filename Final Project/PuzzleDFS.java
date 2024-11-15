import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PuzzleDFS extends PuzzleBFS {

    protected Stack<Node> sFrontier;

    //constructor
    public PuzzleDFS(int[][] c){
        super(c);
    }

    //methods
    @Override
    protected void runSearch(){

        sFrontier = new Stack<Node>();
        sFrontier.push(initialState);

        // for ( Node n : sFrontier ) {
        //     n.printConfig();
        // }

        // System.out.println("-----");

        while(!solved){
            ArrayList<Node> children = sFrontier.get(sFrontier.size()-1).generateChildren();
            sFrontier.pop();
            for ( Node n : children ) {
                if (!explored.contains(n.returnFConfig())){
                    sFrontier.push(n);
                    explored.add(n.returnFConfig());
                }
            }
            solved = Arrays.deepEquals(goalState.returnConfig(), sFrontier.get(sFrontier.size()-1).returnConfig());

            // for ( Node n : sFrontier ) {
            //     n.printConfig();
            // }

            // System.out.println("-----");

        }

        Node o = sFrontier.get(sFrontier.size()-1);
        while (o != null){
            o.printConfig();
            o = o.returnParent();
        }

    }



}
