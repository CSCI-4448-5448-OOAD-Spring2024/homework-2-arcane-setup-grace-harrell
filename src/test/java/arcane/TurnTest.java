package arcane;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.*;
import org.slf4j.Logger;




class TurnTest {
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
        nw.addNeighbor(Arrays.asList(ne,sw));
        ne.addNeighbor(Arrays.asList(se,nw));
        sw.addNeighbor(Arrays.asList(nw,se));
        se.addNeighbor(Arrays.asList(sw,ne));

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
        nw.addNeighbor(Arrays.asList(n,w));
        n.addNeighbor(Arrays.asList(nw,ne,c));
        ne.addNeighbor(Arrays.asList(n,e));
        e.addNeighbor(Arrays.asList(se,c,ne));
        se.addNeighbor(Arrays.asList(s,e));
        s.addNeighbor(Arrays.asList(sw,c,se));
        sw.addNeighbor(Arrays.asList(w,s));
        w.addNeighbor(Arrays.asList(nw,sw,c));
        c.addNeighbor(Arrays.asList(n,e,s,w));


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



    @Test
    public void testMoveAdventurer(){


        List<Adventurer> adventurer = createAdventurers(1);
        List<Creature> creature = createCreatures(1);
        List<Room> lst_rooms = createRoomsTwo();
        Cave cave = createCave(adventurer,creature,lst_rooms);
        Dice dice = new Dice();

        int turnId = 1;
        Turn turn  = new Turn(turnId, cave,creature.get(0), adventurer.get(0), dice);

        cave.printCaveStatus(turnId);
        Room firstRoom = cave.getAdventurerRoom(adventurer.get(0));
        turn.moveAdventurer();
        turnId += 1;
        cave.printCaveStatus(turnId);
        Room newRoom = cave.getAdventurerRoom(adventurer.get(0));

        assert (firstRoom != newRoom);

    }

    @Test
    public void testFight(){
        //provideInput("Testy");
        List<Adventurer> adventurer = createAdventurers(1);
        List<Creature> creature = createCreatures(1);
        List<Room> lst_rooms = createRoomsTwo();
        Cave cave = createCave(adventurer,creature,lst_rooms);

        int id = 1;
        Dice dice = new Dice();
        Adventurer adventurerTurn = adventurer.get(0);
        Creature creatureTurn = creature.get(0);
        Turn turn  = new Turn(id, cave, creatureTurn, adventurerTurn, dice);
        turn.fight();
    }

    @Test
    public void testPrintTurn(){
        //provideInput("Testy");
        List<Adventurer> adventurer = createAdventurers(2);
        List<Creature> creature = createCreatures(5);
        List<Room> lst_rooms = createRoomsThree();
        Cave cave = createCave(adventurer,creature,lst_rooms);

        int id = 1;
        Dice dice = new Dice();
        for (Adventurer adventurers: adventurer){
            Turn turn  = new Turn(id, cave,null, adventurers, dice);
            turn.takeTurn();
        }
        List<Creature> creaturesPresent = cave.getAllCreatures();
        cave.printCaveStatus(id);
        //logger.info(String.valueOf(creaturesPresent.size()));
        assert(creaturesPresent.size() == 5);
    }

    @Test
    public void testFightOrMove() {
        // provideInput("Testy");
        List<Adventurer> adventurer = createAdventurers(1);
        List<Creature> creature = createCreatures(1);
        List<Room> lst_rooms = createRoomsTwo();
        Cave cave = createCave(adventurer,creature,lst_rooms);
        int id = 0;

        Creature creatureTurn = creature.get(0);
        Adventurer adventurerTurn = adventurer.get(0);
        Dice dice = new Dice();
        while (adventurerTurn.isAlive() && creatureTurn.isAlive()) {
            id += 1;
            Turn turn = new Turn(id, cave, creatureTurn, adventurerTurn, dice);
            turn.takeTurn();
            cave.printCaveStatus(id);
        }
    }

}