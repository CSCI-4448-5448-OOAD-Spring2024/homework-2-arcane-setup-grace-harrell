package arcane;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
    @Test
    public void testCave(){
        Cave cave = new Cave();
        int count = 0;

        List<Room> cave_rooms = cave.getCave();
        assert(cave_rooms.size() == 4);

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
}