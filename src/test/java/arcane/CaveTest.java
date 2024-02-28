package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    @Test
    public void testBuilderObject(){
        Cave cave = new Cave.Builder().createFullyConnectedRooms(6)
                .createAndAddAdventurers(1)
                .createAndAddCowards(1)
                .createAndAddCreatures(1)
                .createAndAddDemons(1)
                .createAndAddFood(10)
                .build();
        logger.info("Cave Adventurer size: " + cave.getAllAdventurers().size());
        cave.printCaveStatus(0);
    }

    @Test
    public void testBuilder(){
        AdventurerFactory af = new AdventurerFactory(2);
        CreatureFactory cf = new CreatureFactory(7);
        FoodFactory ff = new FoodFactory(10);

        Cave cave = new Cave.Builder(af,cf,ff)
                .createFullyConnectedRooms(10)
                .randomlyDistributeAllEntities()
                .build();
        cave.printCaveStatus(0);
    }
    @Test
    public void testCaveSizeFullyConnected(){
        Cave cave = new Cave.Builder().createFullyConnectedRooms(9)
                .createAndAddAdventurers(2)
                .createAndAddCowards(2)
                .createAndAddKnights(2)
                .createAndAddCreatures(4)
                .createAndAddDemons(1)
                .createAndAddFood(10)
                .build();
        List<Room> cave_rooms = cave.getCaveRooms();
        cave.printCaveStatus(1);
        assert(cave_rooms.size() == 9);
    }

    @Test
    public void testBuilder2x2Grid(){
        AdventurerFactory af = new AdventurerFactory(2);
        CreatureFactory cf = new CreatureFactory(7);
        FoodFactory ff = new FoodFactory(10);

        Cave cave = new Cave.Builder(af,cf,ff)
                .create2x2Grid()
                .randomlyDistributeAllEntities()
                .createAndAddAdventurers(3)
                .createAndAddGluttons(2)
                .createAndAddDemons(2)
                .build();
        cave.printCaveStatus(0);
    }

    @Test
    public void testBuilder3x3Grid(){
        Cave cave = new Cave.Builder()
                .create3x3Grid()
                .randomlyDistributeAllEntities()
                .createAndAddAdventurers(3)
                .createAndAddGluttons(2)
                .createAndAddDemons(2)
                .build();
        cave.printCaveStatus(0);
    }

    @Test
    public void testBuilderAddRooms(){
        AdventurerFactory af = new AdventurerFactory(2);
        CreatureFactory cf = new CreatureFactory(4);
        FoodFactory ff = new FoodFactory(10);
        Cave cave = new Cave.Builder(af, cf, ff)
                .createFullyConnectedRooms(6)
                .randomlyDistributeAllEntities()
                .createAndAddAdventurers(3)
                .createAndAddGluttons(2)
                .createAndAddDemons(2)
                .createAndAddRoom("New Room 1")
                .createAndAddRoom("New Room 2")
                .addToRoom("New Room 1", af.createAdventurer())
                .addToRoom("New Room 1", ff.createFood())
                .addToRoom("New Room 2", cf.createCreature())
                .build();
        cave.printCaveStatus(0);
    }
}