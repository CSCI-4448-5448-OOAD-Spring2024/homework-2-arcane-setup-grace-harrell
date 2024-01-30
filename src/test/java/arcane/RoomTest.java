package arcane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    public void testRoomCreation(){
        Room room = new Room("test room");
        assert(room.getRoomName().equals("test room"));
    }
    @Test
    public void testChangingRoomName(){
        Room room = new Room("test room");
        assert(room.getRoomName().equals("test room"));
        room.setRoomName("room name 2");
        assert(room.getRoomName().equals("room name 2"));
    }
    @Test
    public void testAddingNeighbors(){
        Room room = new Room("test room");
        Room neighbor_room_1 = new Room("Neighbor 1");
        Room neighbor_room_2 = new Room("Neighbor 2");
        assert(room.getNeighbor().isEmpty());
        room.addNeighbor(neighbor_room_1);
        room.addNeighbor(neighbor_room_2);
        assert(room.getNeighbor().size() == 2);
    }
    @Test
    public void testAddingCharacters(){
        Room room = new Room("test room");
        room.setAdventurerPresence(true);
        room.setCreaturePresence(true);
        assert(room.adventurerHere());
        assert(room.creatureHere());
    }
}