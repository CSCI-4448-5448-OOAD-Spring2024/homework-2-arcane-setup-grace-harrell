package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

class TurnTest {

    // function to allow for mock user input
    public void provideInput(String testName) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(testName.getBytes());
        System.setIn(testInput);
    }


    public  List<Room> createFourRooms(){
        // creating the 4 rooms
        Room nw = new Room("Northwest");
        Room ne =  new Room("Northeast");
        Room sw = new Room("Southwest");
        Room se = new Room ("Southeast");

        //adding in the two neighbors of each room
        nw.addNeighbor(ne);
        nw.addNeighbor(sw);
        ne.addNeighbor(nw);
        ne.addNeighbor(se);
        sw.addNeighbor(nw);
        sw.addNeighbor(se);
        se.addNeighbor(ne);
        se.addNeighbor(sw);

        List<Room> rooms = new ArrayList<>();
        rooms.add(nw);
        rooms.add(ne);
        rooms.add(sw);
        rooms.add(se);

        return rooms;

    }

    @Test
    public void testMoveAdventurer(){
        provideInput("Testy");

        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        List<Room> rooms = createFourRooms();

        Cave cave  = new Cave(creature, adventurer, rooms);
        Turn turn  = new Turn(1, cave, creature, adventurer);

        cave.printCaveStatus();
        Room firstRoom = cave.getAdventurerRoom();

        turn.moveAdventurer();

        cave.printCaveStatus();
        Room newRoom = cave.getAdventurerRoom();

        assert firstRoom != newRoom;

    }

    @Test
    public void testFight(){
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        List<Room> rooms = createFourRooms();
        Cave cave = new Cave(creature, adventurer, rooms);
        int id = 1;
        Turn turn  = new Turn(id, cave, creature, adventurer);
        turn.fight();
    }

    @Test
    public void testPrintTurn(){
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        List<Room> rooms = createFourRooms();
        Cave cave = new Cave(creature, adventurer, rooms);
        int id = 1;
        Turn turn  = new Turn(id, cave, creature, adventurer);
        turn.printTurn();
    }

    @Test
    public void testFightOrMove() {
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        List<Room> rooms = createFourRooms();
        Cave cave = new Cave(creature, adventurer, rooms);
        int id = 0;


        while (adventurer.isAlive() && creature.isAlive()) {
            id += 1;
            Turn turn = new Turn(id, cave, creature, adventurer);
            turn.takeTurn();
        }
    }

}