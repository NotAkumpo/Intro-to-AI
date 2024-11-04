import java.util.Arrays;
import java.util.ArrayList;

public class PuzzleBFS {
    
    //fields
    private Node goalState;
    private Node initialState; 
    private ArrayList<Node> frontier;
    private boolean solved;

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
        frontier.add(initialState);

        solved = Arrays.deepEquals(goalState.returnConfig(), initialState.returnConfig());

        runBFS();

    }


    //methods
    private void runBFS(){

        for ( Node n : frontier ) {
            n.printConfig();
        }

        System.out.println("-----");

        while(!solved){

            for ( Node n : frontier.get(0).generateChildren() ) {
                frontier.add(n);
            }
            frontier.remove(0);
            solved = Arrays.deepEquals(goalState.returnConfig(), frontier.get(0).returnConfig());

            for ( Node n : frontier ) {
                n.printConfig();
            }

            System.out.println("-----");

        }

        Node o = frontier.get(0);
        while (o != null){
            o.printConfig();
            o = o.returnParent();
        }

    }


}
