package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArcaneTest {
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
        lst_rooms.add(ne);
        lst_rooms.add(sw);
        lst_rooms.add(se);
        lst_rooms.add(n);
        lst_rooms.add(e);
        lst_rooms.add(s);
        lst_rooms.add(w);
        lst_rooms.add(c);

        return lst_rooms;
    }
    public Cave createCave(List<Adventurer> lst_adventurers, List<Creature> lst_creatures, List<Room> lst_rooms){
        Cave cave = new Cave(lst_creatures,lst_adventurers,lst_rooms);
        return cave;
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
        Arcane arcane = new Arcane(cave);
        assertNotNull(arcane.play());
    }
    @Test
    public void testPlayThree(){
        // provideInput("Testy");
        List<Room> lst_rooms = createRoomsTwo();
        List<Adventurer> lst_adventurers = createAdventurers(2);
        List<Creature> lst_creatures = createCreatures(5);
        Cave cave = createCave(lst_adventurers,lst_creatures,lst_rooms);
        Arcane arcane = new Arcane(cave);
        assertNotNull(arcane.play());

    }
}
