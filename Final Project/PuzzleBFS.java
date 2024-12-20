import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class PuzzleBFS {
    
    //fields
    protected Node goalState;
    protected Node initialState; 
    protected ArrayList<Node> frontier;
    protected HashSet<String> explored;
    protected boolean solved;

    //constructor
    public PuzzleBFS(int[][] c){
        int[][] gsConfig = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} };
        int os = 0;

        goalState = new Node(null, gsConfig, 0);

        if (c[0][0] == 0){
            os = 0;
        }
        else if (c[0][1] == 0){
            os = 1;
        }
        else if (c[0][2] == 0){
            os = 2;
        }
        else if (c[1][0] == 0){
            os = 3;
        }
        else if (c[1][1] == 0){
            os = 4;
        }
        else if (c[1][2] == 0){
            os = 5;
        }
        else if (c[2][0] == 0){
            os = 6;
        }
        else if (c[2][1] == 0){
            os = 7;
        }
        else if (c[2][2] == 0){
            os = 8;
        }

        initialState = new Node(null, c, os);
        frontier = new ArrayList<Node>();
        explored = new HashSet<String>();
        frontier.add(initialState);
        explored.add(initialState.returnFConfig());

        solved = Arrays.deepEquals(goalState.returnConfig(), initialState.returnConfig());

        runSearch();

    }


    //methods
    protected void runSearch(){

        while(!solved){
            ArrayList<Node> children = frontier.get(0).generateChildren();
            frontier.remove(0);
            for ( Node n : children ) {
                if (!explored.contains(n.returnFConfig())){
                    frontier.add(n);
                    explored.add(n.returnFConfig());
                }
            }
            solved = Arrays.deepEquals(goalState.returnConfig(), frontier.get(0).returnConfig());

        }

        ArrayList<Node> solutionPath = new ArrayList<>();

        Node o = frontier.get(0);
        while (o != null){
            solutionPath.add(o);
            o = o.returnParent();
        }

        System.out.println("");
        System.out.println("Breadth First Search for Configuration:");
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
