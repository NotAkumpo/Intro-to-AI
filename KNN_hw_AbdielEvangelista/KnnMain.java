//Made by: Abdiel Evangelista

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

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

    static Scanner scanner = new Scanner(System.in);
    static String a;
    
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
    }
    
    static void resetForNextAnimal(){
        resetForNextK();
        for (int i=0; i < 16; i++){
            existingAnimals[i].resetScore();
        }
    }

    static void printTable(){
        System.out.println("");
        System.out.println("---------------------------------------------------- LABELLED DATASET OF ANIMALS -------------------------------------------------");
        System.out.println("|   Animal Name   |   Habitat    |    Diet    |    Number of Limbs    |   Covering   |    Primary Movement Method    |   Class   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

        for (int i=0; i < 16; i++){
            System.out.printf("| %15s | %12s | %10s | %21s | %12s | %29s | %9s |\n", existingAnimals[i].getName(), existingAnimals[i].getHabitat(), 
            existingAnimals[i].getDiet(), existingAnimals[i].getLimbs(), existingAnimals[i].getCovering(), existingAnimals[i].getMovement(), 
            existingAnimals[i].getClassification());
        }
    
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }

    static void askLoop(){
        while (true){
            a = scanner.next().toLowerCase();
            if (a.equals("yes")){
                break;
            }
            else if (a.equals("no")){
                System.exit(0);
            }
            else {
                System.out.println("");
                System.out.println("Please answer only yes or no.");
            }
        }
        inputAnimalKNN();
    }

    static void inputAnimalKNN(){
        String an;
        String ah;
        String ad;
        String al;
        String ac;
        String am;

        System.out.println("");

        System.out.println("ANIMAL NAME: ");

        an = scanner.nextLine();
        while (true){
            an = scanner.nextLine();
            if (an.equals("")){
                System.out.println("Animal name can't be blank.");
            }
            else {
                break;
            }

        }
        System.out.println("");

        System.out.print("Habitat (Land, Water or Both): ");
        while (true){
            ah = scanner.next().toLowerCase();
            if (ah.equals("land")){
                ah = "Land";
                break;
            } 
            else if (ah.equals("water")){
                ah = "Water";
                break;
            }
            else if (ah.equals("both")){
                ah = "Both";
                break;
            }
            else {
                System.out.println("Please input a valid habitat.");
            }
        }
        System.out.println("");

        System.out.print("Diet (Carnivore, Herbivore or Omnivore): ");
        while (true){
            ad = scanner.next().toLowerCase();
            if (ad.equals("carnivore")){
                ad = "Carnivore";
                break;
            } 
            else if (ad.equals("herbivore")){
                ad = "Herbivore";
                break;
            }
            else if (ad.equals("omnivore")){
                ad = "Omnivore";
                break;
            }
            else {
                System.out.println("Please input a valid diet.");
            }
        }
        System.out.println("");

        System.out.print("Number of Limbs (None, Two, Four or More than Four): ");
        al = scanner.nextLine().toLowerCase();
        while (true){
            al = scanner.nextLine().toLowerCase();
            if (al.equals("none")){
                al = "None";
                break;
            } 
            else if (al.equals("two")){
                al = "Two";
                break;
            }
            else if (al.equals("four")){
                al = "Four";
                break;
            }
            else if (al.equals("more than four")){
                al = "More than Four";
                break;
            }
            else {
                System.out.println("Please input a valid number of limbs.");
            }
        }
        System.out.println("");

        System.out.print("Covering (Skin, Fur, Scales, Feathers or Exoskeleton): ");
        while (true){
            ac = scanner.next().toLowerCase();
            if (ac.equals("skin")){
                ac = "Skin";
                break;
            } 
            else if (ac.equals("fur")){
                ac = "Fur";
                break;
            }
            else if (ac.equals("scales")){
                ac = "Scales";
                break;
            }
            else if (ac.equals("feathers")){
                ac = "Feathers";
                break;
            }
            else if (ac.equals("exoskeleton")){
                ac = "Exoskeleton";
                break;
            }
            else {
                System.out.println("Please input a valid covering.");
            }
        }
        System.out.println("");

        System.out.print("Primary Movement Method (Walk, Crawl, Swim or Fly): ");
        while (true){
            am = scanner.next().toLowerCase();
            if (am.equals("walk")){
                am = "Walk";
                break;
            } 
            else if (am.equals("crawl")){
                am = "Crawl";
                break;
            }
            else if (am.equals("swim")){
                am = "Swim";
                break;
            }
            else if (am.equals("fly")){
                am = "Fly";
                break;
            }
            else {
                System.out.println("Please input a valid primary movement method.");
            }
        }
        System.out.println("");

        NewAnimal na = new NewAnimal(an, ah, ad, al, ac, am);
        
        System.out.println("");

        System.out.println("------------------------------------------------------------ YOUR ANIMAL ---------------------------------------------");
        System.out.println("|   Animal Name   |   Habitat    |    Diet    |    Number of Limbs    |   Covering   |    Primary Movement Method    |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");

        System.out.printf("| %15s | %12s | %10s | %21s | %12s | %29s |\n", na.getName(), na.getHabitat(), na.getDiet(),na.getLimbs(), 
        na.getCovering(), na.getMovement());
        System.out.println("----------------------------------------------------------------------------------------------------------------------");


        findScores(na);

        for (int i=0; i < animalPlacing.size(); i++){
            System.out.println(animalPlacing.get(i).getName());
        }

        System.out.println("");
        oneNN();
        System.out.println("KNN RESULTS:");
        System.out.print("1 Nearest Neighbor: ");
        System.out.println(verdict);
        resetForNextK();
        fourNN();
        System.out.print("4 Nearest Neighbors: ");
        System.out.println(verdict);
        resetForNextK();
        fiveNN();
        System.out.print("5 Nearest Neighbors: ");
        System.out.println(verdict);
        sevenNN();
        System.out.print("7 Nearest Neighbors: ");
        System.out.println(verdict);
        resetForNextAnimal();
        System.out.println("");


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

        printTable();

        NewAnimal bear = new NewAnimal("Bear", "Land", "Omnivore", "Four", "Fur", "Crawl");
        findScores(bear);

        System.out.println("");
        System.out.println("SAMPLE ANIMAL: Bear");
        System.out.println("Habitat: Land");
        System.out.println("Diet: Omnivore");
        System.out.println("Number of Limbs: Four");
        System.out.println("Covering: Fur");
        System.out.println("Primary Movement Method: Crawl");
        System.out.println("");
        oneNN();
        System.out.println("KNN RESULTS:");
        System.out.print("1 Nearest Neighbor: ");
        System.out.println(verdict);
        resetForNextK();
        fourNN();
        System.out.print("4 Nearest Neighbors: ");
        System.out.println(verdict);
        resetForNextK();
        fiveNN();
        System.out.print("5 Nearest Neighbors: ");
        System.out.println(verdict);
        sevenNN();
        System.out.print("7 Nearest Neighbors: ");
        System.out.println(verdict);
        resetForNextAnimal();

        System.out.println("");
        System.out.println("Would you like to try with your own animal?");
        askLoop();
        
        while (true){
            System.out.println("Would you like to try again with a new animal?");
            askLoop();
        }

    }
}