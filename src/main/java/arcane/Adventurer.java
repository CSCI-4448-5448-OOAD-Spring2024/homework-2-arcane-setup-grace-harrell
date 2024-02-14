package arcane;

import java.util.*;
import java.util.logging.Logger;

public class Adventurer extends Entity{

    private static final Logger logger = Logger.getLogger(Adventurer.class.getName());
    private List<String> lstAdventurers = new ArrayList<>(Arrays.asList("Ethan", "Olivia", "Liam","Emma","Jackson","Sophia","Aiden","Ava","Lucas","Isabella","Noah","Benjamin","Harper","James","Alex"));

    public Adventurer(){
        Random ran = new Random();
        int idx = ran.nextInt(lstAdventurers.size());
        String nameUsed = lstAdventurers.get(idx);
        setName(nameUsed);
    }

}