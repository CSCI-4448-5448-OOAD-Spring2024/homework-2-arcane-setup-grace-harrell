package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class AdventurerTest {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    @Test
    public void testAdventurerName() {

        // creates a new adventurer
        Adventurer adventurer = new Adventurer();
        assert adventurer.getHealth() == 5;
    }
}