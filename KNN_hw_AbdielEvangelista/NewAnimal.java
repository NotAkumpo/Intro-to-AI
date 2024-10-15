//Made by: Abdiel Evangelista

public class NewAnimal {
    

    //fields
    private String name;
    private String habitat;
    private String diet;
    private String limbs;
    private String covering;
    private String movement;

    //constructor
    public NewAnimal(String n, String h, String d, String l, String c, String m){
        name = n;
        habitat = h;
        diet = d;
        limbs = l;
        covering = c;
        movement = m;
    }


    //methods
    public String getName(){
        return name;
    }

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


}
