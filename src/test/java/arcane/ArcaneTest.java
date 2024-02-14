package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArcaneTest {
    public List<Adventurer> createAdventurers(int numAdventurers){
        List<Adventurer> lstAdventurers = new ArrayList<>();
        List<String> lstNamesAdventurers = new ArrayList<>();
        int numAdventurersCreated = 0;
        while (numAdventurersCreated < numAdventurers){
            Adventurer newAdventurer = new Adventurer();
            if (!lstNamesAdventurers.contains(newAdventurer.getName())){
                lstAdventurers.add(newAdventurer);
                lstNamesAdventurers.add(newAdventurer.getName());
                numAdventurersCreated += 1;
            }
        }
        return lstAdventurers;
    }
    public List<Creature> createCreatures(int numCreatures){
        List<Creature> lstCreatures = new ArrayList<>();
        for (int i = 0; i < numCreatures; i++){
            Creature new_creature = new Creature();
            lstCreatures.add(new_creature);
        }
        return lstCreatures;
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
    public Dice createDice(int numSides){
        return new Dice();
    }
//    public void provideInput(String testName) {
//        ByteArrayInputStream testInput = new ByteArrayInputStream(testName.getBytes());
//        System.setIn(testInput);
//    }
    @Test
    public void testPlayTwo(){
        // provideInput("Testy");
        List<Room> lst_rooms = createRoomsTwo();
        List<Adventurer> lst_adventurers = createAdventurers(1);
        List<Creature> lst_creatures = createCreatures(1);
        Cave cave = createCave(lst_adventurers,lst_creatures,lst_rooms);
        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        assertNotNull(arcane.play());
    }
    @Test
    public void testPlayThree(){
        // provideInput("Testy");
        List<Room> lst_rooms = createRoomsThree();
        List<Adventurer> lst_adventurers = createAdventurers(2);
        List<Creature> lst_creatures = createCreatures(5);
        Cave cave = createCave(lst_adventurers,lst_creatures,lst_rooms);
        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        assertNotNull(arcane.play());

    }

    @Test
    public void testOrderFight(){
        List<Room> lst_rooms = createRoomsTwo();
        List<Adventurer> lst_adventurers = createAdventurers(1);
        List<Creature> lst_creatures = createCreatures(6);
        int health = 8;
        for (Creature creature: lst_creatures){
            creature.setHealth(health);
            health -= 1;
        }
        Cave cave = createCave(lst_adventurers,lst_creatures,lst_rooms);
        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        arcane.play();
    }
    @Test
    public void testMoveAdventurers(){
        List<Room> lst_rooms = createRoomsThree();
        List<Adventurer> lst_adventurers = createAdventurers(8);
        List<Creature> lst_creatures = createCreatures(3);
        int healthCreatures = 4;
        for (Creature creature: lst_creatures){
            creature.setHealth(healthCreatures);
            healthCreatures -= 1;
        }
        int healthAdventurers = 10;
        for (Adventurer adventurer: lst_adventurers){
            adventurer.setHealth(healthAdventurers);
            healthAdventurers -= 1;
        }
        Cave cave = createCave(lst_adventurers,lst_creatures,lst_rooms);
        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        arcane.play();
    }
}
