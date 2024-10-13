public class NewAnimal {
    

    //fields
    private String habitat;
    private String diet;
    private String limbs;
    private String covering;
    private String movement;

    //constructor
    public NewAnimal(String h, String d, String l, String c, String m){
        habitat = h;
        diet = d;
        limbs = l;
        covering = c;
        movement = m;
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


}
