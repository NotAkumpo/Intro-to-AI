import java.util.ArrayList;

public class Node {
    
    //fields
    private Node parent;
    private int[][] config; 

    //constructor
    public Node(Node p, int[][] c) {
        parent = p;
        config = c;
    }

    //methods
    public void printConfig(){
        for ( int i=0; i<3; i++ ){
            System.out.println(config[i][0] + " " + config[i][1] + " " + config[i][2]);
        }
        System.out.println("");
    }

    public ArrayList<Node> generateChildren(){
        ArrayList<Node> children = new ArrayList<>();
        if (config[0][0] == 0){
            
        }
        else if (config[0][1] == 0){

        }
        else if (config[0][2] == 0){

        }
        else if (config[1][0] == 0){

        }
        else if (config[1][1] == 0){

        }
        else if (config[1][2] == 0){

        }
        else if (config[2][0] == 0){

        }
        else if (config[2][1] == 0){

        }
        else if (config[2][2] == 0){

        }
        return children;
    }

    public int[][] returnConfig(){
        return config;
    }

}
