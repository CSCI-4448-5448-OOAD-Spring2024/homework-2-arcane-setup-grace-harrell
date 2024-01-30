package arcane;

import org.junit.jupiter.api.Test;

public class CreatureTest {

    @Test
    public  void testCreatureName() {
        Creature creature = new Creature();
        String creatureName = creature.getName();
        System.out.print("Created a " + creatureName);
    }

}
