package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
    private static final Logger logger = Logger.getLogger(String.valueOf(CaveTest.class));


    public  List<Room> createFourRooms(){
        // creating the 4 rooms
        Room nw = new Room("Northwest");
        Room ne =  new Room("Northeast");
        Room sw = new Room("Southwest");
        Room se = new Room ("Southeast");

        //adding in the two neighbors of each room
        nw.addNeighbor(ne);
        nw.addNeighbor(sw);
        ne.addNeighbor(nw);
        ne.addNeighbor(se);
        sw.addNeighbor(nw);
        sw.addNeighbor(se);
        se.addNeighbor(ne);
        se.addNeighbor(sw);

        List<Room> rooms = new ArrayList<>();
        rooms.add(nw);
        rooms.add(ne);
        rooms.add(sw);
        rooms.add(se);

        return rooms;

    }
    public void provideInput(String testName) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(testName.getBytes());
        System.setIn(testInput);
    }
    @Test
    public void testCaveSize(){
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();

        List<Room> rooms = createFourRooms();

        Cave cave = new Cave(creature, adventurer, rooms);

    }

    @Test
    public void testRandomCharacters(){
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        List<Room> rooms = createFourRooms();
        Cave cave = new Cave(creature, adventurer, rooms);
        int count = 0;

        List<Room> cave_rooms = cave.getCaveRooms();

        for (Room caveRoom : cave_rooms) {
            assert (caveRoom.getNeighbor().size() == 2);
            if (caveRoom.creatureHere()) {
                count += 1;
            }
            if (caveRoom.adventurerHere()) {
                count += 1;
            }
        }
        assert(count == 2);
    }

    @Test
    public void testNumNeighbors(){
        provideInput("Testy");

        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        List<Room> rooms = createFourRooms();

        Cave cave = new Cave(creature, adventurer, rooms);

        List<Room> cave_rooms = cave.getCaveRooms();

        for (Room caveRoom : cave_rooms) {
            assert (caveRoom.getNeighbor().size() == 2);
        }
    }

    @Test
    public void testPrintCaveStatus(){
        // gives an input string to the System for the adventurer name
        provideInput("Testy");

        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        List<Room> rooms = createFourRooms();
        Cave cave = new Cave(creature, adventurer, rooms);
        cave.printCaveStatus();
    }

    @Test
    public void testCreatureAdventurerRooms(){
        provideInput("Testy");

        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        List<Room> rooms = createFourRooms();
        Cave cave = new Cave(creature, adventurer, rooms);
        cave.printCaveStatus();

        Room adventurerRoom = cave.getAdventurerRoom();
        Room creatureRoom = cave.getCreatureRoom();

        logger.info(adventurerRoom.getRoomName());
        logger.info(creatureRoom.getRoomName());

        assertNotNull(adventurerRoom);
        assertNotNull(creatureRoom);
    }
    @Test
    public void testFindAdventurer(){
        Creature creature = new Creature();
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        List<Room> rooms = createFourRooms();
        Cave cave = new Cave(creature, adventurer, rooms);
        Room adventurer_here = cave.getAdventurerRoom();
        assert(adventurer_here.adventurerHere());
    }
    @Test
    public void testFindCreature(){
        Creature creature = new Creature();
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        List<Room> rooms = createFourRooms();
        Cave cave = new Cave(creature, adventurer, rooms);
        Room creature_here = cave.getCreatureRoom();
        assert(creature_here.creatureHere());
    }

}