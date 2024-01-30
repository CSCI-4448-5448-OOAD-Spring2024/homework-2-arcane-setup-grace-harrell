package arcane;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
    @Test
    public void testCaveSize(){
        Cave cave = new Cave();

        List<Room> cave_rooms = cave.getCaveRooms();
        assert(cave_rooms.size() == 4);
    }

    @Test
    public void testRandomCharacters(){
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
        Cave cave = new Cave();

        List<Room> cave_rooms = cave.getCaveRooms();

        for (Room caveRoom : cave_rooms) {
            assert (caveRoom.getNeighbor().size() == 2);
        }
    }
}