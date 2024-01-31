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
    public void testGettingNeighbors(){
        Room room = new Room("test room");
        Room room_neighbor = new Room("neighbor_room");
        room.addNeighbor(room_neighbor);
        assert(room.getNeighbor().size() == 1);
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
        room.setAdventurerPresence(false);
        room.setCreaturePresence(false);
        assert(!room.adventurerHere());
        assert(!room.creatureHere());
    }
    @Test
    public void testGetRandomNeighbor(){
        Room room = new Room("test room");
        Room neighbor_1 = new Room("neighbor 1");
        Room neighbor_2 = new Room("neighbor 2");
        room.addNeighbor(neighbor_1);
        room.addNeighbor(neighbor_2);
        Room random_neighbor = room.getRandomNeighbor();
        assert(random_neighbor.equals(neighbor_1) || random_neighbor.equals(neighbor_2));
    }
}