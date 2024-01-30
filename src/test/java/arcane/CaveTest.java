package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
    void provideInput(String testName) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(testName.getBytes());
        System.setIn(testInput);
    }
    @Test
    public void testCaveSize(){
        provideInput("Testy");
        Cave cave = new Cave();

        List<Room> cave_rooms = cave.getCaveRooms();
        assert(cave_rooms.size() == 4);
    }

    @Test
    public void testRandomCharacters(){
        provideInput("Testy");
        Cave cave = new Cave();
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

        Cave cave = new Cave();

        List<Room> cave_rooms = cave.getCaveRooms();

        for (Room caveRoom : cave_rooms) {
            assert (caveRoom.getNeighbor().size() == 2);
        }
    }

    @Test
    public void testCaveStatus(){
        // gives an input string to the System for the adventurer name
        provideInput("Testy");
        // creature new cave
        Cave cave = new Cave();
        boolean together = cave.caveStatus();
    }
}