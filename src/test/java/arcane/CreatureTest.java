package arcane;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class CreatureTest {
    private static final Logger logger = Logger.getLogger(CreatureTest.class.getName());

    @Test
    public  void testCreatureName() {
        Creature creature = new Creature();
        String creatureName = creature.getName();
        logger.info("Created a " + creatureName);
        assert creature.getHealth() == 3;
    }

}
