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
        logger.info(af.getListOfAdventurers().getLast().getName()); // should be a coward name

        Adventurer k = af.createKnight();
        af.addAdventurers(k);
        Adventurer g = af.createGlutton();
        af.addAdventurers(g);
        assert(af.getListOfAdventurers().size() == 13);
    }


    @Test public void testRoomsConnected(){
        AdventurerFactory af = new AdventurerFactory(2);
        CreatureFactory cf = new CreatureFactory(7);
        FoodFactory ff = new FoodFactory(10);
        Cave cave = new Cave.Builder(af, cf, ff).createFullyConnectedRooms(10)
                .randomlyDistribute()
                .build();
        assert(cave.getCaveRooms().size() == 10);
        cave.printCaveStatus(0);
        Room room  = cave.getRandomRoom();
        logger.info(room.getNeighbor().toString());
        assert(room.getNeighbor().size() == 9);
        //assert(room.getNeighbor().equals(cave.getCaveRooms().remove(room)));

    }

    @Test
    public void testSequentialDistibution(){
        AdventurerFactory af = new AdventurerFactory(2);
        CreatureFactory cf = new CreatureFactory(7);
        FoodFactory ff = new FoodFactory(10);
        Cave cave = new Cave.Builder(af, cf, ff).createFullyConnectedRooms(10)
                .sequentiallyDistributeAllEntities()
                .build();
        cave.printCaveStatus(0);


        Cave cave2 = new Cave.Builder(af, cf, ff).createFullyConnectedRooms(3)
                .sequentiallyDistributeAllEntities()
                .build();
        cave2.printCaveStatus(0);
    }



}

