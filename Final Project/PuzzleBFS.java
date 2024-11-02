import java.util.PriorityQueue;

public class PuzzleBFS {
    
    //fields
    private Node goalState;
    private Node initialState; 
    private PriorityQueue<Node> frontier;

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
        frontier = new PriorityQueue<>();
        
        //just a bunch of testers
        goalState.printConfig();
        initialState.printConfig();
        System.out.println(goalState.returnOpenSpot());
        System.out.println(initialState.returnOpenSpot());
        for ( Node n : initialState.generateChildren() ) {
            n.printConfig();
        }

    }


    //methods


}
