public class Animal{


    //fields
    private String habitat;
    private String diet;
    private String limbs;
    private String covering;
    private String movement;
    private String classification;
    private Integer currScore;

    //constructor
    public Animal(String h, String d, String l, String c, String m, String cl){
        habitat = h;
        diet = d;
        limbs = l;
        covering = c;
        movement = m;
        classification = cl;
        currScore = 0;
    }

    //methods
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

    public int getScore(){
        return currScore;
    }

    public String getClassification(){
        return classification;
    }


}