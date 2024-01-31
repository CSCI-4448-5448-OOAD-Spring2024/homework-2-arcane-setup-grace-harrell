package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class TurnTest {

    // function to allow for mock user input
    public void provideInput(String testName) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(testName.getBytes());
        System.setIn(testInput);
    }



    @Test
    public void testMoveAdventurer(){
        provideInput("Testy");

        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        Cave cave  = new Cave(creature, adventurer);
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
        Cave cave = new Cave(creature, adventurer);
        int id = 1;
        Turn turn  = new Turn(id, cave, creature, adventurer);
        turn.fight();
    }

    @Test
    public void testPrintTurn(){
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        Cave cave = new Cave(creature, adventurer);
        int id = 1;
        Turn turn  = new Turn(id, cave, creature, adventurer);
        turn.printTurn();
    }

    @Test
    public void testFightOrMove() {
        provideInput("Testy");
        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        Cave cave = new Cave(creature, adventurer);
        int id = 0;


        while (adventurer.isAlive() && creature.isAlive()) {
            id += 1;
            Turn turn = new Turn(id, cave, creature, adventurer);
            turn.takeTurn();
        }
    }

}