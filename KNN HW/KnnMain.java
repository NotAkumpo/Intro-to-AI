import java.util.Arrays;
import java.util.Comparator;

public class KnnMain {

    public static void main (String[] args){

        Animal lion = new Animal("Land","Carnivore","Four","Fur","Crawl", "Mammal");
        Animal human = new Animal("Land", "Omnivore", "Four", "Skin", "Walk", "Mammal");
        Animal platypus = new Animal("Both", "Carnivore", "Four", "Fur", "Crawl", "Mammal");
        Animal deer = new Animal("Land", "Herbivore", "Four", "Fur", "Crawl", "Mammal");
        Animal eagle = new Animal("Land", "Carnivore", "Two", "Feathers", "Fly", "Bird");
        Animal chicken = new Animal("Land", "Omnivore", "Two", "Feathers", "Walk", "Bird");
        Animal swan = new Animal("Both", "Herbivore", "Two", "Feathers", "Swim", "Bird");
        Animal penguin = new Animal("Both", "Carnivore", "Two", "Feathers", "Walk", "Bird");
        Animal clownfish = new Animal("Water", "Herbivore", "None", "Scales", "Swim", "Fish");
        Animal shark = new Animal("Water", "Carnivore", "None", "Scales", "Swim", "Fish");
        Animal catfish = new Animal("Water", "Omnivore", "None", "Skin", "Swim", "Fish");
        Animal mudskipper = new Animal("Both", "Carnivore", "Two", "Scales", "Crawl", "Fish");
        Animal beetle = new Animal("Land", "Omnivore", "More than Four", "Exoskeleton", "Crawl", "Insect");
        Animal wasp = new Animal("Land", "Omnivore", "More than Four", "Exoskeleton", "Fly", "Insect");
        Animal centipede = new Animal("Land", "Carnivore", "More than Four", "Exoskeleton", "Crawl", "Insect");
        Animal waterbug = new Animal("Water", "Herbivore", "More than Four", "Exoskeleton", "Crawl", "Insect");

        Animal[] existingAnimals = new Animal[16];

        existingAnimals[0] = lion;
        existingAnimals[1] = human;
        existingAnimals[2] = platypus;
        existingAnimals[3] = deer;
        existingAnimals[4] = eagle;
        existingAnimals[5] = chicken;
        existingAnimals[6] = swan;
        existingAnimals[7] = penguin;
        existingAnimals[8] = clownfish;
        existingAnimals[9] = shark;
        existingAnimals[10] = catfish;
        existingAnimals[11] = mudskipper;
        existingAnimals[12] = beetle;
        existingAnimals[13] = wasp;
        existingAnimals[14] = centipede;
        existingAnimals[15] = waterbug;

        NewAnimal hippo = new NewAnimal("Land", "Omnivore", "Four", "Skin", "Crawl");

        for(int i = 0; i < existingAnimals.length; i++){
            existingAnimals[i].deriveScore(hippo);
        }

        Arrays.sort(existingAnimals, Comparator.comparingInt(Animal::getScore));

        System.out.println(existingAnimals[0].getClassification());

        // for(int i = 0; i < existingAnimals.length; i++){
        //     System.out.println(existingAnimals[i].getClassification());
        // }
        

    }
}