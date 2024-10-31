import java.util.PriorityQueue;

public class PuzzleBFS {
    
    //fields
    private Node goalState;
    private Node initialState; 
    private PriorityQueue<Node> frontier;

    //constructor
    public PuzzleBFS(int[][] c){
        int[][] gsConfig = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} };
        goalState = new Node(null, gsConfig);

        initialState = new Node(null, c);
        frontier = new PriorityQueue<>();
    }


    //methods


}
