package arcane;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class CreatureTest {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CreatureTest.class);

    @Test
    public  void testCreatureName() {
        Creature creature = new Creature();
        String creatureName = creature.getName();
        logger.info("Created a " + creatureName);
    }

}
