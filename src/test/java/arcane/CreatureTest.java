package arcane;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class CreatureTest {
    private static final Logger logger = (Logger) LoggerFactory.getLogger("csci.ooad.arcane.Arcane");

    @Test
    public  void testCreatureName() {
        Creature creature = new Creature();
        String creatureName = creature.getName();
        logger.info("Created a " + creatureName);
        assert creature.getHealth() == 3;
    }

}
