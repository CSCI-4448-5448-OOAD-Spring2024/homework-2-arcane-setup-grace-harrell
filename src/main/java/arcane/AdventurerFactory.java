package arcane;
import java.util.*;
import java.util.logging.Logger;
public class AdventurerFactory{

    private static List<Adventurer> adventurers = new ArrayList<>();
    public static List <Adventurer> listOfAdventurers(int numAdventurers, int numKnights, int numGluttons, int numCowards) {
        for (int i = 0; i < numAdventurers; i++) {
            adventurers.add(createAdventurer());
        }
        for (int i = 0; i < numKnights; i++) {
            adventurers.add(createKnight());
        }
        for (int i = 0; i < numGluttons; i++) {
            adventurers.add(createGlutton());
        }
        for (int i = 0; i < numCowards; i++) {
            adventurers.add(createCoward());
        }
        return adventurers;
    }

    public static Adventurer createAdventurer() {
        Adventurer adventurer = new Adventurer();
        adventurer.setName(getRandomAdventurerName());
        return adventurer;
    }

    public static Knight createKnight() {
        Knight knight = new Knight();
        knight.setName(getRandomKnightName());
        return knight;
    }

    public static Glutton createGlutton() {
        Glutton glutton = new Glutton();
        glutton.setName(getRandomGluttonName());
        return glutton;
    }

    public static Coward createCoward() {
        Coward coward = new Coward();
        coward.setName(getRandomCowardName());
        return coward;
    }

    private static String getRandomAdventurerName() {
        List<String> adventurerNames = Arrays.asList("Ethan", "Olivia", "Liam","Emma","Jackson","Sophia","Aiden","Ava","Lucas","Isabella","Noah","Benjamin","Harper","James","Alex");
        return getRandomName(adventurerNames);
    }

    private static String getRandomKnightName() {
        List<String> knightNames = Arrays.asList("Sir Lancelot","Sir Galahad", "Sir Arthur", "Sir Gawain", "Sir Percival");
        return getRandomName(knightNames);
    }

    private static String getRandomGluttonName() {
        List<String> gluttonNames = Arrays.asList("Greedy Gus","Chubs", "Devouring Dave", "Snacking Sam", "Gluttonous Gilbert");
        return getRandomName(gluttonNames);
    }

    private static String getRandomCowardName() {
        List<String> cowardNames = Arrays.asList("Trembling Tim","Shivering Sheila", "Cowering Carl", "Anxious Andy", "Frightened Freddy");
        return getRandomName(cowardNames);
    }

    public static String getRandomName(List<String> nameList) {
        Random random = new Random();
        return nameList.get(random.nextInt(nameList.size()));
    }
    public List<Adventurer> getAdventurers(){
        return adventurers;
    }
}
