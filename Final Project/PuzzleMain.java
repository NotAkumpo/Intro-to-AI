public class PuzzleMain {
    
    public static void main (String[] args){
        // int[][] t = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} }; // 0 Moves
        // int[][] t = { {1, 0, 4}, {3, 5, 2}, {6, 7, 8} }; //5 Moves 104352678
        // int[][] t = { {7, 2, 4}, {5, 0, 6}, {8, 1, 3} }; //Invalid 
        // int[][] t = { {1, 8, 0}, {4, 3, 2}, {7, 6, 5} }; // Conventional Config 180432765
        // int[][] t = { {1, 8, 2}, {6, 5, 7}, {0, 4, 3} };
        // int[][] t = { {1, 2, 0}, {3, 4, 5}, {6, 7, 8} }; // 2 Moves Left
        int[][] t = { {5, 3, 0}, {4, 1, 8}, {7, 6, 2} }; //
        // int[][] t = { {2, 3, 5}, {1, 0, 7}, {8, 4, 6} }; 
        PuzzleBFS p = new PuzzleAstar(t);
        // int[][] gsConfig = { {2, 8, 6}, {1, 0, 7}, {4, 5, 3} };
        // Node n = new Node(null, gsConfig, 0);
        // n.calculateHeuristic();
        // System.out.println(n.returnHeuristic());

    }


}
