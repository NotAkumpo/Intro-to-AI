//Made by: Abdiel Evangelista

public class Animal{


    //fields
    private String name;
    private String habitat;
    private String diet;
    private String limbs;
    private String covering;
    private String movement;
    private String classification;
    private Integer currScore;

    //constructor
    public Animal(String n, String h, String d, String l, String c, String m, String cl){
        name = n;
        habitat = h;
        diet = d;
        limbs = l;
        covering = c;
        movement = m;
        classification = cl;
        currScore = 0;
    }

    //methods
    public String getHabitat() {
        return habitat;
    }

    public String getDiet() {
        return diet;
    }

    public String getLimbs() {
        return limbs;
    }

    public String getCovering() {
        return covering;
    }

    public String getMovement() {
        return movement;
    }

    public void deriveScore(NewAnimal a){
        if (!habitat.equals(a.getHabitat())){
            currScore += 2;
        }
        if (!diet.equals(a.getDiet())){
            currScore += 1;
        }
        if (!limbs.equals(a.getLimbs())){
            currScore += 3;
        }
        if (!covering.equals(a.getCovering())){
            currScore += 2;
        }
        if (!movement.equals(a.getMovement())){
            currScore += 2;
        }
    }

    public void resetScore(){
        currScore = 0;
    }

    public int getScore(){
        return currScore;
    }

    public String getClassification(){
        return classification;
    }

    public String getName(){
        return name;
    }

}