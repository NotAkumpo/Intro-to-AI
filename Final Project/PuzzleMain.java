import java.util.Scanner;

public class PuzzleMain {
    
    public static void main (String[] args){
        Scanner myScanner = new Scanner(System.in);
        // int[][] t = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} }; // 0 Moves
        // int[][] t = { {1, 0, 4}, {3, 5, 2}, {6, 7, 8} }; //5 Moves 104352678
        // int[][] t = { {7, 2, 4}, {5, 0, 6}, {8, 1, 3} }; //Invalid 
        // int[][] t = { {1, 8, 0}, {4, 3, 2}, {7, 6, 5} }; // Conventional Config 180432765
        // int[][] t = { {1, 8, 2}, {6, 5, 7}, {0, 4, 3} };
        // int[][] t = { {1, 2, 0}, {3, 4, 5}, {6, 7, 8} }; // 2 Moves Left
        System.out.println("Which Search Algorithm would you like to use?\n(a) Breath First Search\n(b) Depth First Search\n(c) A*");
        System.out.print("Enter (a/b/c):");
        String searchAlgo = myScanner.nextLine();

        if (!searchAlgo.equals("a") && !searchAlgo.equals("b") && !searchAlgo.equals("c")) {
            System.out.println("Invalid input! Please enter a/b/c");
            return;
        }

        System.out.println("\nWhat configuration would you like to use?\nPlease input the puzzle in this format '123450678' (let 0 represent the blank space).");        
        System.out.print("Enter:");
        String confInput = myScanner.nextLine();

        if (confInput.length() != 9) {
            System.out.println("Invalid input! Please enter exactly 9 digits.");
            return;
        }

        int[][] x = new int[3][3];

        // fill the array
        for (int i = 0; i < 9; i++) {
            int row = i / 3;
            int col = i % 3; 
            x[row][col] = Character.getNumericValue(confInput.charAt(i));
        }

        
        if (searchAlgo.equals("a")) {
            PuzzleBFS p = new PuzzleBFS(x);
        } else if (searchAlgo.equals("b")) {
            PuzzleBFS p = new PuzzleDFS(x);
        } else {
            PuzzleBFS p = new PuzzleAstar(x);
        }

        //int[][] t = { {5, 3, 0}, {4, 1, 8}, {7, 6, 2} }; //
        // int[][] t = { {2, 3, 5}, {1, 0, 7}, {8, 4, 6} }; 
        //PuzzleBFS p = new PuzzleAstar(t);
        // int[][] gsConfig = { {2, 8, 6}, {1, 0, 7}, {4, 5, 3} };
        // Node n = new Node(null, gsConfig, 0);
        // n.calculateHeuristic();
        // System.out.println(n.returnHeuristic());

    }


}
