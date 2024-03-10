package arcane;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdventurerFactory{
    private static final Logger logger = (Logger) LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    private static List<Adventurer> adventurers = new ArrayList<>();

    private List<String> adventurerNames = new ArrayList<>(Arrays.asList("Ethan", "Olivia", "Liam","Emma","Jackson","Sophia","Aiden","Ava","Lucas","Isabella","Noah","Benjamin","Harper","James","Alex"));
    private List<String> knightNames = new ArrayList<>(Arrays.asList("Sir Lancelot","Sir Galahad", "Sir Arthur", "Sir Gawain", "Sir Percival"));
    private List<String> gluttonNames = new ArrayList<>(Arrays.asList("Greedy Gus","Chubs", "Devouring Dave", "Snacking Sam", "Gluttonous Gilbert"));
    private List<String> cowardNames = new ArrayList<>(Arrays.asList("Trembling Tim","Shivering Sheila", "Cowering Carl", "Anxious Andy", "Frightened Freddy"));






    //default constructor --> No Args
    public AdventurerFactory(){};
   // Constructor with arguments
    public AdventurerFactory(int numAdventurers){
        for(int i = 0; i < numAdventurers; i++) adventurers.add(createAdventurer());
    }
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
        if (adventurerNames.isEmpty()){
            adventurerNames = Arrays.asList("Ethan", "Olivia", "Liam","Emma","Jackson","Sophia","Aiden","Ava","Lucas","Isabella","Noah","Benjamin","Harper","James","Alex");
        }
        String name = getRandomName(adventurerNames);
        adventurerNames.remove(name);
        return name;

    }

    private String getRandomKnightName() {
        if (knightNames.isEmpty()){
            knightNames = Arrays.asList("Sir Lancelot","Sir Galahad", "Sir Arthur", "Sir Gawain", "Sir Percival");
        }
        String name = getRandomName(knightNames);
        knightNames.remove(name);
        return name;
    }

    private String getRandomGluttonName() {
        if (gluttonNames.isEmpty()){
            gluttonNames = Arrays.asList("Greedy Gus","Chubs", "Devouring Dave", "Snacking Sam", "Gluttonous Gilbert");
        }
        String name = getRandomName(gluttonNames);
        gluttonNames.remove(name);
        return name;
    }

    private String getRandomCowardName() {
        if (cowardNames.isEmpty()){
            cowardNames = Arrays.asList("Trembling Tim","Shivering Sheila", "Cowering Carl", "Anxious Andy", "Frightened Freddy");
        }
        String name = getRandomName(cowardNames);
        cowardNames.remove(name);
        return name;
    }

    public String getRandomName(List<String> nameList) {
        Random random = new Random();
        return nameList.get(random.nextInt(nameList.size()));
    }

//    public void addAdventurers(Adventurer adventurer){
//        adventurers.add(adventurer);
//    }
    public List<Adventurer> getListOfAdventurers(){
        return adventurers;
    }
}
