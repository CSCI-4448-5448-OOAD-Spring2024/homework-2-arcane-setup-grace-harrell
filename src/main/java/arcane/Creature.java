package arcane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Creature extends Entity{
    // selects creature name randomly from an array of potential names
    private List<String> lstCreatureNames = new ArrayList<>(Arrays.asList("Goblin", "Ogre", "Ghoul", "Wraith"));

    public Creature(){
        // generates a random index for creatureTypes
        Random ran = new Random();
        int idx = ran.nextInt(lstCreatureNames.size());
        String nameUsed = lstCreatureNames.get(idx);
        setName(nameUsed);
        setHealth(3);
    }
}
