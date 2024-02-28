package arcane;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.*;
import org.slf4j.Logger;




class TurnTest {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");

    @Test
    public void testMoveAdventurer(){


        Cave cave = new Cave.Builder().createFullyConnectedRooms(4)
                .createAndAddAdventurers(2)
                .createAndAddCowards(2)
                .createAndAddKnights(2)
                .createAndAddCreatures(4)
                .createAndAddDemons(1)
                .createAndAddFood(10)
                .build();
        Dice dice = new Dice();

        int turnId = 1;
        Turn turn  = new Turn(turnId, cave,cave.getAllCreatures().get(0), cave.getAllAdventurers().get(0), dice);

        cave.printCaveStatus(turnId);
        Room firstRoom = cave.getAdventurerRoom(cave.getAllAdventurers().get(0));
        turn.moveAdventurer();
        turnId += 1;
        cave.printCaveStatus(turnId);
        Room newRoom = cave.getAdventurerRoom(cave.getAllAdventurers().get(0));

        assert (firstRoom != newRoom);

    }

//    @Test
//    public void testFight(){
//        //provideInput("Testy");
//        List<Adventurer> adventurer = createAdventurers(1);
//        List<Creature> creature = createCreatures(1);
//        List<Room> lst_rooms = createRoomsTwo();
//        Cave cave = createCave(adventurer,creature,lst_rooms);
//
//        int id = 1;
//        Dice dice = new Dice();
//        Adventurer adventurerTurn = adventurer.get(0);
//        Creature creatureTurn = creature.get(0);
//        Turn turn  = new Turn(id, cave, creatureTurn, adventurerTurn, dice);
//        turn.fight();
//    }
//
//    @Test
//    public void testPrintTurn(){
//        //provideInput("Testy");
//        List<Adventurer> adventurer = createAdventurers(2);
//        List<Creature> creature = createCreatures(5);
//        List<Room> lst_rooms = createRoomsThree();
//        Cave cave = createCave(adventurer,creature,lst_rooms);
//
//        int id = 1;
//        Dice dice = new Dice();
//        for (Adventurer adventurers: adventurer){
//            Turn turn  = new Turn(id, cave,null, adventurers, dice);
//            turn.takeTurn();
//        }
//        List<Creature> creaturesPresent = cave.getAllCreatures();
//        cave.printCaveStatus(id);
//        //logger.info(String.valueOf(creaturesPresent.size()));
//        assert(creaturesPresent.size() == 5);
//    }

//    @Test
//    public void testFightOrMove() {
//        // provideInput("Testy");
//        List<Adventurer> adventurer = createAdventurers(1);
//        List<Creature> creature = createCreatures(1);
//        List<Room> lst_rooms = createRoomsTwo();
//        Cave cave = createCave(adventurer,creature,lst_rooms);
//        int id = 0;
//
//        Creature creatureTurn = creature.get(0);
//        Adventurer adventurerTurn = adventurer.get(0);
//        Dice dice = new Dice();
//        while (adventurerTurn.isAlive() && creatureTurn.isAlive()) {
//            id += 1;
//            Turn turn = new Turn(id, cave, creatureTurn, adventurerTurn, dice);
//            turn.takeTurn();
//            cave.printCaveStatus(id);
//        }
//    }

}