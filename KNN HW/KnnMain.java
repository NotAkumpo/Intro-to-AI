import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class KnnMain {

    static Animal lion = new Animal("Lion", "Land","Carnivore","Four","Fur","Crawl", "Mammal");
    static Animal human = new Animal("Human","Land", "Omnivore", "Four", "Skin", "Walk", "Mammal");
    static Animal platypus = new Animal("Platypus","Both", "Carnivore", "Four", "Fur", "Crawl", "Mammal");
    static Animal deer = new Animal("Deer","Land", "Herbivore", "Four", "Fur", "Crawl", "Mammal");
    static Animal eagle = new Animal("Eagle","Land", "Carnivore", "Two", "Feathers", "Fly", "Bird");
    static Animal chicken = new Animal("Chicken","Land", "Omnivore", "Two", "Feathers", "Walk", "Bird");
    static Animal swan = new Animal("Swan","Both", "Herbivore", "Two", "Feathers", "Swim", "Bird");
    static Animal penguin = new Animal("Penguin","Both", "Carnivore", "Two", "Feathers", "Walk", "Bird");
    static Animal clownfish = new Animal("Clownfish","Water", "Herbivore", "None", "Scales", "Swim", "Fish");
    static Animal shark = new Animal("Shark","Water", "Carnivore", "None", "Scales", "Swim", "Fish");
    static Animal catfish = new Animal("Catfish","Water", "Omnivore", "None", "Skin", "Swim", "Fish");
    static Animal mudskipper = new Animal("Mudskipper","Both", "Carnivore", "Two", "Scales", "Crawl", "Fish");
    static Animal beetle = new Animal("Beetle","Land", "Omnivore", "More than Four", "Exoskeleton", "Crawl", "Insect");
    static Animal wasp = new Animal("Wasp","Land", "Omnivore", "More than Four", "Exoskeleton", "Fly", "Insect");
    static Animal centipede = new Animal("Centipede","Land", "Carnivore", "More than Four", "Exoskeleton", "Crawl", "Insect");
    static Animal waterbug = new Animal("Waterbug","Water", "Herbivore", "More than Four", "Exoskeleton", "Crawl", "Insect");

    static Animal[] existingAnimals = { lion, human, platypus, deer, eagle, chicken, swan, penguin,
        clownfish, shark, catfish, mudskipper, beetle, wasp, centipede, waterbug };

    static ArrayList<Animal> animalPlacing = new ArrayList<Animal>();

    static int mammalScore = 0;
    static int birdScore = 0;
    static int fishScore = 0;
    static int insectScore = 0;
    static String verdict;
    
    static void findScores(NewAnimal na){
        for(int i = 0; i < 16; i++){
            existingAnimals[i].deriveScore(na);
        }

        Arrays.sort(existingAnimals, Comparator.comparingInt(Animal::getScore));
    }

    static void addTies(int j){
        for (int i=j; i < 15; i++){
            if (existingAnimals[i].getScore() == existingAnimals[i+1].getScore()){
                animalPlacing.add(existingAnimals[i+1]);
            }
            else {
                break;
            }
        }
    }

    static void tallyScores(){
        for (int i=0; i < animalPlacing.size(); i++){
            if (animalPlacing.get(i).getClassification().equals("Mammal")){
                mammalScore++;
            }
            else if (animalPlacing.get(i).getClassification().equals("Bird")){
                birdScore++;
            }
            else if (animalPlacing.get(i).getClassification().equals("Fish")){
                fishScore++;
            }
            else if (animalPlacing.get(i).getClassification().equals("Insect")){
                insectScore++;
            }
        }
    }

    static void determineWinner(){
        if (mammalScore >= birdScore && mammalScore >= fishScore && mammalScore >= insectScore) {
            verdict = "Mammal";
        } else if (birdScore >= mammalScore && birdScore >= fishScore && birdScore >= insectScore) {
            verdict = "Bird";
        } else if (fishScore >= mammalScore && fishScore >= birdScore && fishScore >= insectScore) {
            verdict = "Fish";
        } else {
            verdict = "Insect";
        }
    }

    static void resetForNextK(){
        mammalScore = 0;
        birdScore = 0;
        fishScore = 0;
        insectScore = 0;
        animalPlacing.clear();
        verdict = "";
        // for (int i=0; i < 16; i++){
        //     existingAnimals[i].resetScore();
        // }
    }

    static void oneNN(){
        animalPlacing.add(existingAnimals[0]);
        addTies(0);
        tallyScores();
        determineWinner();
    }

    static void fourNN(){
        for (int i=0; i<4; i++){
            animalPlacing.add(existingAnimals[i]);
        }
        addTies(3);
        tallyScores();
        determineWinner();
    }

    static void fiveNN(){
        for (int i=0; i<5; i++){
            animalPlacing.add(existingAnimals[i]);
        }
        addTies(4);
        tallyScores();
        determineWinner();
    }

    static void sevenNN(){
        for (int i=0; i<7; i++){
            animalPlacing.add(existingAnimals[i]);
        }
        addTies(6);
        tallyScores();
        determineWinner();
    }

    public static void main (String[] args){

        NewAnimal hippo = new NewAnimal("Land", "Omnivore", "Four", "Skin", "Crawl");

        findScores(hippo);
        oneNN();
        System.out.println(verdict);
        for (int i=0; i < animalPlacing.size(); i++){
            System.out.println(animalPlacing.get(i).getName());
            System.out.println(animalPlacing.get(i).getScore());
        }
        System.out.println(mammalScore);
            System.out.println(birdScore);
            System.out.println(insectScore);
            System.out.println(fishScore);
        System.out.println("");
        resetForNextK();
        fourNN();
        System.out.println(verdict);
        for (int i=0; i < animalPlacing.size(); i++){
            System.out.println(animalPlacing.get(i).getName());
            System.out.println(animalPlacing.get(i).getScore());
        }
        System.out.println(mammalScore);
            System.out.println(birdScore);
            System.out.println(insectScore);
            System.out.println(fishScore);
        System.out.println("");
        resetForNextK();
        fiveNN();
        System.out.println(verdict);
        for (int i=0; i < animalPlacing.size(); i++){
            System.out.println(animalPlacing.get(i).getName());
            System.out.println(animalPlacing.get(i).getScore());
        }
        System.out.println(mammalScore);
            System.out.println(birdScore);
            System.out.println(insectScore);
            System.out.println(fishScore);
        System.out.println("");
        resetForNextK();
        sevenNN();
        System.out.println(verdict);
        for (int i=0; i < animalPlacing.size(); i++){
            System.out.println(animalPlacing.get(i).getName());
            System.out.println(animalPlacing.get(i).getScore());
        }
        System.out.println(mammalScore);
            System.out.println(birdScore);
            System.out.println(insectScore);
            System.out.println(fishScore);

        

    }
}