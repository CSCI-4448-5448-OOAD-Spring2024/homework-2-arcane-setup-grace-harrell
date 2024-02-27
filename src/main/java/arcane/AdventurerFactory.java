package arcane;
import java.util.*;
import java.util.logging.Logger;
public abstract class AdventurerFactory{
    public Adventurer createAdventurer() {
        Adventurer adventurer = new Adventurer();
        adventurer.setName(getRandomAdventurerName());
        return adventurer;
    }

    public Knight createKnight() {
        Knight knight = new Knight();
        knight.setName(getRandomKnightName());
        return knight;
    }

    public Glutton createGlutton() {
        Glutton glutton = new Glutton();
        glutton.setName(getRandomGluttonName());
        return glutton;
    }

    public Coward createCoward() {
        Coward coward = new Coward();
        coward.setName(getRandomCowardName());
        return coward;
    }

    private String getRandomAdventurerName() {
        List<String> adventurerNames = Arrays.asList("Ethan", "Olivia", "Liam","Emma","Jackson","Sophia","Aiden","Ava","Lucas","Isabella","Noah","Benjamin","Harper","James","Alex");
        return getRandomName(adventurerNames);
    }

    private String getRandomKnightName() {
        List<String> knightNames = Arrays.asList("Sir Lancelot","Sir Galahad", "Sir Arthur", "Sir Gawain", "Sir Percival");
        return getRandomName(knightNames);
    }

    private String getRandomGluttonName() {
        List<String> gluttonNames = Arrays.asList("Greedy Gus","Chubs", "Devouring Dave", "Snacking Sam", "Gluttonous Gilbert");
        return getRandomName(gluttonNames);
    }

    private String getRandomCowardName() {
        List<String> cowardNames = Arrays.asList("Trembling Tim","Shivering Sheila", "Cowering Carl", "Anxious Andy", "Frightened Freddy");
        return getRandomName(cowardNames);
    }

    public String getRandomName(List<String> nameList) {
        Random random = new Random();
        return nameList.get(random.nextInt(nameList.size()));
    }
}
