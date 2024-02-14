package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");

public List<Adventurer> createAdventurers(int num_adventurers){
    List<Adventurer> lst_adventurers = new ArrayList<>();
    for (int i = 0; i < num_adventurers; i++){
        Adventurer new_adventurer = new Adventurer();
        lst_adventurers.add(new_adventurer);
    }
    return lst_adventurers;
}
    public List<Creature> createCreatures(int num_creatures){
        List<Creature> lst_creatures = new ArrayList<>();
        for (int i = 0; i < num_creatures; i++){
            Creature new_creature = new Creature();
            lst_creatures.add(new_creature);
        }
        return lst_creatures;
    }

    public List<Room> createRoomsTwo(){
        List<Room> lst_rooms = new ArrayList<>();
        Room nw = new Room("Northwest");
        Room ne = new Room("Northeast");
        Room sw = new Room("Southwest");
        Room se = new Room("Southeast");

        // adding in the two neighbors of each room
        nw.addNeighbor(ne);
        nw.addNeighbor(sw);
        ne.addNeighbor(nw);
        ne.addNeighbor(se);
        sw.addNeighbor(nw);
        sw.addNeighbor(se);
        se.addNeighbor(ne);
        se.addNeighbor(sw);

        lst_rooms.add(nw);
        lst_rooms.add(ne);
        lst_rooms.add(sw);
        lst_rooms.add(se);

        return lst_rooms;
    }
    public Room getRandomRoom(List<Room> lstRooms){

        // if the rooms haven't been created, throw an error
        if (lstRooms.isEmpty()){
            throw new IllegalStateException("Cave is empty");
        }
        // find a random value by getting a random index
        Random rand = new Random();
        return lstRooms.get(rand.nextInt(lstRooms.size()));
    }
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

        for (int i = 0; i < 10; i++){
            Food addFood = new Food();
            getRandomRoom(lst_rooms).addFoodPresent(addFood);
        }
        return lst_rooms;
    }
    public Cave createCave(List<Adventurer> lst_adventurers, List<Creature> lst_creatures, List<Room> lst_rooms){
        return new Cave(lst_creatures,lst_adventurers,lst_rooms);
    }
    @Test
    public void testCaveSize(){
        List<Room> lstRooms = createRoomsThree();
        List<Adventurer> lstAdventurers = createAdventurers(2);
        List<Creature> lstCreatures = createCreatures(5);
        Cave cave = createCave(lstAdventurers,lstCreatures,lstRooms);

        List<Room> cave_rooms = cave.getCaveRooms();
        cave.printCaveStatus(1);
        assert(cave_rooms.size() == 9);
    }

    @Test
    public void testCaveThree(){
        List<Room> lstRooms = createRoomsTwo();
        List<Adventurer> lstAdventurers = createAdventurers(1);
        List<Creature> lstCreatures = createCreatures(1);
        Cave cave = createCave(lstAdventurers,lstCreatures,lstRooms);

        List<Room> cave_rooms = cave.getCaveRooms();

        assert(cave_rooms.size() == 4);
    }

    @Test
    public void testNumNeighbors(){
        List<Room> lstRooms = createRoomsTwo();
        List<Adventurer> lstAdventurers = createAdventurers(1);
        List<Creature> lstCreatures = createCreatures(1);
        Cave cave = createCave(lstAdventurers,lstCreatures,lstRooms);

        List<Room> cave_rooms = cave.getCaveRooms();

    }

    @Test
    public void testPrintCaveStatus(){
        // gives an input string to the System for the adventurer name

        List<Room> lstRooms = createRoomsTwo();
        List<Adventurer> lstAdventurers = createAdventurers(1);
        List<Creature> lstCreatures = createCreatures(1);
        Cave cave = createCave(lstAdventurers,lstCreatures,lstRooms);

        int turnId = 0;
        cave.printCaveStatus(turnId);
    }

    @Test
    public void testCreatureAdventurerRooms(){

        List<Room> lstRooms = createRoomsTwo();
        List<Adventurer> lstAdventurers = createAdventurers(1);
        List<Creature> lstCreatures = createCreatures(1);
        Cave cave = createCave(lstAdventurers,lstCreatures,lstRooms);

        int turnId = 0;
        cave.printCaveStatus(turnId);

        Room adventurerRoom = cave.getAdventurerRoom(lstAdventurers.get(0));
        Room creatureRoom = cave.getCreatureRoom();

        logger.info(adventurerRoom.getRoomName());
        logger.info(creatureRoom.getRoomName());

        assertNotNull(adventurerRoom);
        assertNotNull(creatureRoom);
    }
    @Test
    public void testFindAdventurer(){
        List<Room> lstRooms = createRoomsTwo();
        List<Adventurer> lstAdventurers = createAdventurers(1);
        List<Creature> lstCreatures = createCreatures(1);
        Cave cave = createCave(lstAdventurers,lstCreatures,lstRooms);
        Room adventurerHere = cave.getAdventurerRoom(lstAdventurers.get(0));
        List<Adventurer> allAdventurers = adventurerHere.getAdventurersPresent();
        assert(allAdventurers.size() == 1);
    }
    @Test
    public void testFindCreature(){
        List<Room> lstRooms = createRoomsTwo();
        List<Adventurer> lstAdventurers = createAdventurers(1);
        List<Creature> lstCreatures = createCreatures(1);
        Cave cave = createCave(lstAdventurers,lstCreatures,lstRooms);
        Room creatureHere = cave.getCreatureRoom();
        List<Creature> allCreatures = creatureHere.getCreaturesPresent();
        assert(allCreatures.size() == 1);
    }

}