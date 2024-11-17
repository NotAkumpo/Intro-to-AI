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

        System.out.println("");
        System.out.println("A* Search for Configuration:");
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
