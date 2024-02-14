package arcane;

import org.junit.jupiter.api.Test;
import java.util.*;
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
        Adventurer adventurerFirst = new Adventurer();
        Creature creatureFirst = new Creature();
        room.addAdventurerPresence(adventurerFirst);
        room.addCreaturePresence(creatureFirst);
        List<Adventurer> currentAdventurers = room.getAdventurersPresent();
        List<Creature> currentCreatures = room.getCreaturesPresent();
        assert(currentAdventurers.size() == 1);
        assert(currentCreatures.size() == 1);
        room.removeAdventurerPresence(adventurerFirst);
        room.removeCreaturePresence(creatureFirst);
        List<Adventurer> updatedAdventurers = room.getAdventurersPresent();
        List<Creature> updatedCreatures = room.getCreaturesPresent();
        assert(updatedCreatures.isEmpty());
        assert(updatedAdventurers.isEmpty());
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
    @Test
    public void testAddFood(){
        Room room = new Room("test room");
        Food food = new Food();
        room.addFoodPresent(food);
        assert(room.getFoodsPresent().size() == 1);
        Food food1 = new Food();
        Food food2 = new Food();
        room.addFoodPresent(food1);
        room.addFoodPresent(food2);
        assert(room.getFoodsPresent().size() == 3);
    }
}