import java.util.ArrayList;


public class Node {
    
    //fields
    private Node parent;
    private int[][] config;
    private String fConfig;
    private int openSpot;
    private Double heuristic;  

    //constructor
    public Node(Node p, int[][] c, int os) {
        parent = p;
        config = c;
        openSpot = os;
        fConfig = "";
        heuristic = null;
        flatten();
    }

    //methods
    public void printConfig(){
        System.out.println("-------");
        for ( int i=0; i<3; i++ ){
            if (config[i][0] == 0) {
                System.out.println("| |" + config[i][1] + "|" + config[i][2] + "|");
            } else if (config[i][1] == 0) {
                System.out.println("|" + config[i][0] + "| |" + config[i][2] + "|");
            } else if (config[i][2] == 0) {
                System.out.println("|" + config[i][0] + "|" + config[i][1] + "| |");
            } else {
                System.out.println("|" + config[i][0] + "|" + config[i][1] + "|" + config[i][2] + "|");
            }
            System.out.println("-------");
        }
        System.out.println("");
    }

    public ArrayList<Node> generateChildren(){
        ArrayList<Node> children = new ArrayList<>();

        Node child1 = new Node(this, configDeepCopy(config), openSpot);
        Node child2 = new Node(this, configDeepCopy(config), openSpot);
        Node child3 = new Node(this, configDeepCopy(config), openSpot);
        Node child4 = new Node(this, configDeepCopy(config), openSpot);

        switch (openSpot){
            case 0:
                child1.transform(0, 0, 0, 1, 1);
                children.add(child1);
                child2.transform(0, 0, 1, 0, 3);
                children.add(child2);
                child3 = null;
                child4 = null;
                break;
            case 1:
                child1.transform(0, 1, 0, 2, 2);
                children.add(child1);
                child2.transform(0, 1, 1, 1, 4);
                children.add(child2);
                child3.transform(0, 1, 0, 0, 0);
                children.add(child3);
                child4 = null;
                break; 
            case 2:
                child1.transform(0, 2, 1, 2, 5);
                children.add(child1);
                child2.transform(0, 2, 0, 1, 1);
                children.add(child2);
                child3 = null;
                child4 = null;
                break;
            case 3:
                child1.transform(1, 0, 0, 0, 0);
                children.add(child1);
                child2.transform(1, 0, 1, 1, 4);
                children.add(child2);
                child3.transform(1, 0, 2, 0, 6);
                children.add(child3);
                child4 = null;
                break;
            case 4:
                child1.transform(1, 1, 0, 1, 1);
                children.add(child1);
                child2.transform(1, 1, 1, 2, 5);
                children.add(child2);
                child3.transform(1, 1, 2, 1, 7);
                children.add(child3);
                child4.transform(1, 1, 1, 0, 3);
                children.add(child4);
                break;
            case 5:
                child1.transform(1, 2, 0, 2, 2);
                children.add(child1);
                child2.transform(1, 2, 2, 2, 8);
                children.add(child2);
                child3.transform(1, 2, 1, 1, 4);
                children.add(child3);
                child4 = null;
                break;
            case 6:
                child1.transform(2, 0, 1, 0, 3);
                children.add(child1);
                child2.transform(2, 0, 2, 1, 7);
                children.add(child2);
                child3 = null;
                child4 = null;
                break;
            case 7:
                child1.transform(2, 1, 1, 1, 4);
                children.add(child1);
                child2.transform(2, 1, 2, 2, 8);
                children.add(child2);
                child3.transform(2, 1, 2, 0, 6);
                children.add(child3);
                child4 = null;
                break;
            case 8:
                child1.transform(2, 2, 1, 2, 5);
                children.add(child1);
                child2.transform(2, 2, 2, 1, 7);
                children.add(child2);
                child3 = null;
                child4 = null;
                break;
        }

        return children;
    }

    public void transform(int r1, int c1, int r2, int c2, int os){
        config[r1][c1] = config[r2][c2];
        config[r2][c2] = 0;
        openSpot = os;
        fConfig = "";
        flatten();
    }

    public int[][] configDeepCopy(int [][] c){
        int[][] copy = new int[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                copy[i][j] = c[i][j];
            }
        }
        return copy;
    }

    private void flatten(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                fConfig += Integer.toString(config[i][j]);
            }
        }
    }

    //I GOT CANCER FROM CALCULATING THIS THING, I WAS WRITING MATH EQUATIONS FOR 2 HOURS FOR 2 LINES OF CODE    
    public void calculateHeuristic(){
        heuristic = 0.0;
        for (double i=0; i<3; i++){
            for (double j=0; j<3; j++){
                double x = (double)config[(int)i][(int)j];
                heuristic += Math.round( ( (Math.abs( x - ((3 * i) + 1) )) / 3) );
                // System.out.println(Math.round( ( (Math.abs( x - ((3 * i) + 1) )) / 3) ));
                heuristic += Math.abs( ( x % 3 ) - j );
                // System.out.println(Math.abs( ( x % 3 ) - j ));
                // System.out.println(heuristic);
            }
        }
        // System.out.println("Success");
        // System.out.println("");
    }

    public String returnFConfig(){
        return fConfig;
    }

    public int[][] returnConfig(){
        return config;
    }

    public Node returnParent(){
        return parent;
    }

    public int returnOpenSpot(){
        return openSpot;
    }

    public Double returnHeuristic(){
        return heuristic;
    }

}
