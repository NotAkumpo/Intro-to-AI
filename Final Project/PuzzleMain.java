import java.util.Scanner;

public class PuzzleMain {
    
    public static void main (String[] args){
        clearScreen();
        Scanner myScanner = new Scanner(System.in);
        int[][] t = { {1, 0, 4}, {3, 5, 2}, {6, 7, 8} };
        Node n = new Node(null, t, 1);
        int[][] u = { {1, 2, 0}, {3, 4, 5}, {6, 7, 8} };
        Node o = new Node(null, u, 2);
        String searchAlgo;

        System.out.println("Hello! Welcome to the 8-Puzzle Solver!");
        System.out.println("(Press Enter to Continue)");
        myScanner.nextLine();
        clearScreen();

        System.out.println("First is a demonstration of the solution of the BFS, DFS and A* search algorithms for this puzzle configuration:");
        n.printConfig();
        System.out.println("(Press Enter to Continue)");
        myScanner.nextLine();
        clearScreen();

        PuzzleBFS s1 = new PuzzleBFS(t);
        System.out.println("Next is Depth First Search!");
        System.out.println("(Press Enter to Continue)");
        myScanner.nextLine();
        clearScreen();

        PuzzleBFS s2 = new PuzzleDFS(t);
        System.out.println("Next is A* Search!");
        System.out.println("(Press Enter to Continue)");
        myScanner.nextLine();
        clearScreen();

        PuzzleBFS s3 = new PuzzleAstar(t);
        System.out.println("(Press Enter to Continue)");
        myScanner.nextLine();
        clearScreen();

        System.out.println("Next is for this configuration:");
        o.printConfig();
        System.out.println("(Press Enter to Continue)");
        myScanner.nextLine();
        clearScreen();

        PuzzleBFS s4 = new PuzzleBFS(u);
        System.out.println("Next is Depth First Search!");
        System.out.println("(Press Enter to Continue)");
        myScanner.nextLine();
        clearScreen();

        PuzzleBFS s5 = new PuzzleDFS(u);
        System.out.println("Next is A* Search!");
        System.out.println("(Press Enter to Continue)");
        myScanner.nextLine();
        clearScreen();

        PuzzleBFS s6 = new PuzzleAstar(u);
        System.out.println("(Press Enter to Continue)");
        myScanner.nextLine();
        clearScreen();
        
        while (true) {
            System.out.println("Your Turn!");
            System.out.println("Which Search Algorithm would you like to use?\n(a) Breath First Search\n(b) Depth First Search\n(c) A*");
            System.out.print("Enter (a/b/c): ");
            searchAlgo = myScanner.nextLine();

            if (searchAlgo.equalsIgnoreCase("a") || searchAlgo.equalsIgnoreCase("b") ||  searchAlgo.equalsIgnoreCase("c")) {
                break;

            }

            System.out.println("Invalid input! Please enter a/b/c");
    
        }

        String confInput;

        System.out.println("\nWhat configuration would you like to use?\nPlease input the puzzle in this format '123450678' (let 0 represent the blank space).");


        while (true) {        
            System.out.print("Enter: ");
            confInput = myScanner.nextLine();

            if (confInput.length() != 9) {
                System.out.println("Invalid input! Please enter exactly 9 digits.");
                continue;
            }

            if (!confInput.matches("[0-8]+")) {
                System.out.println("Invalid input! Please use only digits 0-8.");
                continue;
            }

            boolean hasDuplicates = false;
            for (char c : "012345678".toCharArray()) {
                if (confInput.chars().filter(ch -> ch == c).count() > 1) {
                    hasDuplicates = true;
                    break;
                }
            }

            if (hasDuplicates) {
                System.out.println("");
                System.out.println("Invalid input! Each digit from 0-8 must appear exactly once.");
                continue;
            }
            
            if (!isSolvable(confInput)) {
                System.out.println("");
                System.out.println("Chosen input is unsolvable, please input another configuration");
                continue;
            }

            System.out.println("");
            System.out.println("");
            break;
            

        }
       



        int[][] x = new int[3][3];
        // fill the array
        for (int i = 0; i < 9; i++) {
            int row = i / 3;
            int col = i % 3; 
            x[row][col] = Character.getNumericValue(confInput.charAt(i));
        }

        
        if (searchAlgo.equalsIgnoreCase("a")) {
            PuzzleBFS p = new PuzzleBFS(x);
        } else if (searchAlgo.equalsIgnoreCase("b")) { 
            PuzzleBFS p = new PuzzleDFS(x);
        } else if (searchAlgo.equalsIgnoreCase("c"))  {
            PuzzleBFS p = new PuzzleAstar(x);
        }

        //int[][] t = { {5, 3, 0}, {4, 1, 8}, {7, 6, 2} }; //
        // int[][] t = { {2, 3, 5}, {1, 0, 7}, {8, 4, 6} }; 
        //PuzzleBFS p = new PuzzleAstar(t);
        // int[][] gsConfig = { {2, 8, 6}, {1, 0, 7}, {4, 5, 3} };
        // Node n = new Node(null, gsConfig, 0);
        // n.calculateHeuristic();
        // System.out.println(n.returnHeuristic());

        System.out.println("Thank you for using the 8-Puzzle Solver!");
        myScanner.nextLine();
        clearScreen();

    }

    public static boolean isSolvable(String config) {
        int inversions = 0;

        for (int i = 0; i < config.length(); i++) {
            for (int j = i + 1; j < config.length(); j++) {
                int num1 = Character.getNumericValue(config.charAt(i));
                int num2 = Character.getNumericValue(config.charAt(j));

                // Count pairs (num1, num2) where num1 > num2 and num1, num2 != 0
                if (num1 != 0 && num2 != 0 && num1 > num2) {
                    inversions++;
                }
            }
        }

        // The puzzle is solvable if the number of inversions is even
        return inversions % 2 == 0;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    

    
}
