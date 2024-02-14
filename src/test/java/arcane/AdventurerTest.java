package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.logging.Logger;

class AdventurerTest {
    private static final Logger logger = Logger.getLogger(AdventurerTest.class.getName());
    @Test
    public void testAdventurerName() {

        // creates a new adventurer
        Adventurer adventurer = new Adventurer();
        logger.info("\nHello " + adventurer.getName());
        assert adventurer.getHealth() == 5;

    }

}