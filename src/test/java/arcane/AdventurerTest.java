package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.logging.Logger;

class AdventurerTest {
    private static final Logger logger = Logger.getLogger(AdventurerTest.class.getName());
    @Test
    public void testAdventurerName() {

        // gives an input string to the System
        String testName = "Test Name";
        ByteArrayInputStream testInput = new ByteArrayInputStream(testName.getBytes());
        System.setIn(testInput);

        // creates a new adventurer
        Adventurer adventurer = new Adventurer();
        logger.info("\nHello " + adventurer.getName());
        assert adventurer.getName().equals("Test Name");

    }

}