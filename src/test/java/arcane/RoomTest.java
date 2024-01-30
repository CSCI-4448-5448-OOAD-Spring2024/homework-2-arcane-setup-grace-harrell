package arcane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    public void testRoom(){
        Room room = new Room("test room");
        assert(room.getRoomName().equals("test room"));
        room.setRoomName("room name 2");
        assert(room.getRoomName().equals("room name 2"));
        assert(room.getNeighbor().isEmpty());
        room.addNeighbor("neighbor_1");
        room.addNeighbor("neighbor_2");
        assert(room.getNeighbor().size() == 2);
        room.setAdventurerPresence(true);
        room.setCreaturePresence(true);
        assert(room.adventurerHere());
        assert(room.creatureHere());
    }
}