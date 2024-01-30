package arcane;

import java.util.Random;

public class Creature extends Character{
    // selects creature name randomly from an array of potential names
    public Creature(){
        String [] creatureTypes = new String[4];
        creatureTypes[0] = "Goblin";
        creatureTypes[1] = "Ogre";
        creatureTypes[2] = "Ghoul";
        creatureTypes[3] = "Wraith";

        // generates a random index for creatureTypes
        Random ran = new Random();
        int idx = ran.nextInt(3);
        setName(creatureTypes[idx]);
    }

}
