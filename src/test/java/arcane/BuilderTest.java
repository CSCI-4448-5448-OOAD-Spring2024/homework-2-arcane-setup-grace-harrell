package arcane;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BuilderTest {
    private static final Logger logger = (Logger) LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    @Test
    public void testAdventurerFactory(){
        int numAdventurers = 1;
        int numKnights = 1;
        int numGluttons = 1;
        int numCowards = 1;
        List<Adventurer> adventurerList = AdventurerFactory.listOfAdventurers(1, 1, 1, 1);
        logger.info(String.valueOf(adventurerList.size()));
        assert(adventurerList.size() == 4);
        logger.info(adventurerList.getLast().getName()); // should be a coward name
    }}
