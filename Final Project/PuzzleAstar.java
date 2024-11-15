import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleAstar extends PuzzleBFS {
    
    //constructor
    public PuzzleAstar(int[][] c){
        super(c);
    }

    //methods
    @Override
    protected void runSearch(){

        Node winner = frontier.get(0);

        // for ( Node n : frontier ) {
        //     n.printConfig();
        // }

        //System.out.println("-----");

        while(!solved){
            ArrayList<Node> children = winner.generateChildren();
            frontier.remove(winner);
            for ( Node n : children ) {
                if (!explored.contains(n.returnFConfig())){
                    n.calculateHeuristic();
                    frontier.add(n);
                    explored.add(n.returnFConfig());
                }
            }

            // for ( Node n : frontier ) {
            //     n.printConfig();
            // }

            //System.out.println("-----");

            Double winnerHeuristic = 100.0;

            for ( Node n : frontier ) {
                if (n.returnHeuristic() < winnerHeuristic){
                    winner = n;
                    winnerHeuristic = n.returnHeuristic();
                }
            }
            solved = Arrays.deepEquals(goalState.returnConfig(), winner.returnConfig());
        }

        Node o = winner;
        ArrayList<Node> solutionPath = new ArrayList<>();

        // gets the path from the goal state to the inital state
        while (o != null){
            solutionPath.add(o);
            o = o.returnParent();
        }

        // goes through the elements in solution path in reverse
        System.out.println("\nSolution:");
        for (int i = solutionPath.size() - 1; i >= 0; i--) {
            solutionPath.get(i).printConfig();
        }
    }
    
}
