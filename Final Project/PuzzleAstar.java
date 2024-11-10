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

        for ( Node n : frontier ) {
            n.printConfig();
        }

        System.out.println("-----");

        while(!solved){
            ArrayList<Node> children = winner.generateChildren();
            frontier.remove(winner);
            for ( Node n : children ) {
                if (!explored.contains(n.returnFConfig())){
                    n.calculateHeuristic();
                    frontier.add(n);
                    explored.add(n.returnFConfig());
                }
                solved = Arrays.deepEquals(goalState.returnConfig(), winner.returnConfig());
            }

            for ( Node n : frontier ) {
                n.printConfig();
            }

            System.out.println("-----");

            Double winnerHeuristic = 100.0;

            for ( Node n : frontier ) {
                if (n.returnHeuristic() < winnerHeuristic){
                    winner = n;
                    winnerHeuristic = n.returnHeuristic();
                }
            }

        }

        Node o = winner;
        while (o != null){
            o.printConfig();
            o = o.returnParent();
        }
    }
    
}
