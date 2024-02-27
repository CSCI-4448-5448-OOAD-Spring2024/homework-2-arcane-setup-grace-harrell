package arcane;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public abstract class CreatureFactory{
    public Creature createCreature() {
        Creature creature = new Creature();
        creature.setName(getRandomCreatureName());
        return creature;
    }
    public Demon createDemon(){
        Demon demon = new Demon();
        demon.setName(getRandomDemonName());
        return demon;
    }

    private String getRandomCreatureName() {
        List<String> creatureNames = Arrays.asList("Goblin", "Ogre", "Ghoul", "Wraith");
        return getRandomName(creatureNames);
    }

    private String getRandomDemonName() {
        List<String> demonNames = Arrays.asList("Satan", "Demon");
        return getRandomName(demonNames);
    }

    public String getRandomName(List<String> nameList) {
        Random random = new Random();
        return nameList.get(random.nextInt(nameList.size()));
    }
}
