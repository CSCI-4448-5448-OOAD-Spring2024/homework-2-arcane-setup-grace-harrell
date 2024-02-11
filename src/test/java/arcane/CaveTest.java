package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
    public void provideInput(String testName) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(testName.getBytes());
        System.setIn(testInput);
    }
    @Test
    public void testCaveSize(){
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        Cave cave = new Cave(creature, adventurer);

        List<Room> cave_rooms = cave.getCaveRooms();
        int count_foods = 0;
        for (Room caveRoom : cave_rooms) {
            count_foods += caveRoom.getFoodsPresent().size();
        }
        assert(cave_rooms.size() == 4);
        assert(count_foods == 10);
    }

    @Test
    public void testRandomCharacters(){
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        Cave cave = new Cave(creature, adventurer);
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

        Cave cave = new Cave(creature, adventurer);

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
        Cave cave = new Cave(creature, adventurer);
        cave.printCaveStatus();
    }

    @Test
    public void testCreatureAdventurerRooms(){
        provideInput("Testy");

        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        Cave cave = new Cave(creature, adventurer);
        cave.printCaveStatus();

        Room adventurerRoom = cave.getAdventurerRoom();
        Room creatureRoom = cave.getCreatureRoom();

        System.out.println(adventurerRoom.getRoomName());
        System.out.println(creatureRoom.getRoomName());

        assertNotNull(adventurerRoom);
        assertNotNull(creatureRoom);
    }
    @Test
    public void testFindAdventurer(){
        Creature creature = new Creature();
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        Cave cave = new Cave(creature, adventurer);
        Room adventurer_here = cave.getAdventurerRoom();
        assert(adventurer_here.adventurerHere());
    }
    @Test
    public void testFindCreature(){
        Creature creature = new Creature();
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        Cave cave = new Cave(creature, adventurer);
        Room creature_here = cave.getCreatureRoom();
        assert(creature_here.creatureHere());
    }

}