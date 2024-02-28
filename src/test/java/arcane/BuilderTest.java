package arcane;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BuilderTest {
    private static final Logger logger = (Logger) LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    @Test
    public void testAdventurerFactory(){

        AdventurerFactory af0 = new AdventurerFactory();
        assert(af0.getListOfAdventurers().isEmpty());

        AdventurerFactory af = new AdventurerFactory(10);
        assert(af.getListOfAdventurers().size() == 10);
        Adventurer c = af.createCoward();
        af.addAdventurers(c);
        assert(af.getListOfAdventurers().size() == 11);
        logger.info(af.getListOfAdventurers().get(10).getName()); // should be a coward name
        Adventurer k = af.createKnight();
        af.addAdventurers(k);
        Adventurer g = af.createGlutton();
        af.addAdventurers(g);
        assert(af.getListOfAdventurers().size() == 13);
    }}

