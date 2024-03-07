package arcane;

import org.junit.jupiter.api.Test;

import org.slf4j.LoggerFactory;

import java.util.*;
import org.slf4j.Logger;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    public List<Room> createRoomsThree(){
        List<Room> lst_rooms = new ArrayList<>();
        Room nw = new Room("Northwest");
        Room ne = new Room("Northeast");
        Room sw = new Room("Southwest");
        Room se = new Room("Southeast");
        Room n = new Room("North");
        Room s = new Room("South");
        Room w = new Room("West");
        Room e = new Room("East");
        Room c = new Room("Center");
        // adding in the two neighbors of each room
        nw.addNeighbor(n);
        nw.addNeighbor(w);
        n.addNeighbor(nw);
        n.addNeighbor(ne);
        n.addNeighbor(c);
        ne.addNeighbor(n);
        ne.addNeighbor(e);
        e.addNeighbor(ne);
        e.addNeighbor(c);
        e.addNeighbor(se);
        se.addNeighbor(e);
        se.addNeighbor(s);
        s.addNeighbor(c);
        s.addNeighbor(sw);
        s.addNeighbor(se);
        sw.addNeighbor(s);
        sw.addNeighbor(w);
        w.addNeighbor(nw);
        w.addNeighbor(sw);
        w.addNeighbor(c);
        c.addNeighbor(n);
        c.addNeighbor(e);
        c.addNeighbor(s);
        c.addNeighbor(w);

        lst_rooms.add(nw);
        lst_rooms.add(n);
        lst_rooms.add(ne);

        lst_rooms.add(e);
        lst_rooms.add(c);
        lst_rooms.add(w);

        lst_rooms.add(sw);
        lst_rooms.add(s);
        lst_rooms.add(se);

        return lst_rooms;
    }



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
        room.removeFoodPresence(food1);
        assert(room.getFoodsPresent().size() == 2);
    }
    @Test
    public void testMoveExtras(){
        List<Room> lstRooms = createRoomsThree();
        Adventurer adv1 = new Adventurer();
        Adventurer adv2 = new Adventurer();
        Adventurer adv3 = new Adventurer();
        Creature creature = new Creature();
        Room crowded = lstRooms.get(0);
        crowded.addAdventurerPresence(adv1);
        crowded.addAdventurerPresence(adv2);
        crowded.addAdventurerPresence(adv3);
        crowded.addCreaturePresence(creature);
        crowded.moveExtraAdventurers(adv1);
        assert(crowded.getAdventurersPresent().size() == 1);
        assert(crowded.getAdventurersPresent().get(0) == adv1);
    }
}