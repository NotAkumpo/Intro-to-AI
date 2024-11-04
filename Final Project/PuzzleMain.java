public class PuzzleMain {
    
    public static void main (String[] args){
        // int[][] t = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} };
        int[][] t = { {1, 0, 4}, {3, 5, 2}, {6, 7, 8} };
        // int[][] t = { {7, 2, 4}, {5, 0, 6}, {8, 1, 3} };
        // int[][] t = { {1, 8, 0}, {4, 3, 2}, {7, 6, 5} };
        PuzzleBFS p = new PuzzleBFS(t);
    }


}
