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


        while(!solved){
            ArrayList<Node> children = sFrontier.get(sFrontier.size()-1).generateChildren();
            sFrontier.pop();
            for ( Node n : children ) {
                if (!explored.contains(n.returnFConfig())){
                    sFrontier.push(n);
                    explored.add(n.returnFConfig());
                }
            }
            if (!sFrontier.isEmpty()) {
                 solved = Arrays.deepEquals(goalState.returnConfig(), sFrontier.get(sFrontier.size()-1).returnConfig());
            }
               

        }

        ArrayList<Node> solutionPath = new ArrayList<>();
        Node o = sFrontier.get(sFrontier.size()-1);


        while (o != null){
            solutionPath.add(o);
            o = o.returnParent();
        }

        System.out.println("");
        System.out.println("Depth First Search for Configuration:");
        System.out.println("");
        initialState.printConfig();
        System.out.println("");
        System.out.println("\nSolution:");
        System.out.println("");
        for (int i = solutionPath.size() - 1; i >= 0; i--) {
            solutionPath.get(i).printConfig();
        }

    }
}
