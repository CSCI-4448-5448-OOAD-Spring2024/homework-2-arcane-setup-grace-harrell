package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArcaneTest {
    public Dice createDice(int numSides){
        return new Dice();
    }
    @Test
    public void testPlayConnected_6(){
        // provideInput("Testy");
        Cave cave = new Cave.Builder().createFullyConnectedRooms(6)
                .createAndAddAdventurers(1)
                .createAndAddCowards(1)
                .createAndAddCreatures(2)
                .createAndAddFood(10)
                .build();

        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        assertNotNull(arcane.play());
    }
    @Test
    public void testPlayConnected_10(){
        // provideInput("Testy");
        Cave cave = new Cave.Builder().createFullyConnectedRooms(10)
                .createAndAddAdventurers(2)
                .createAndAddCowards(2)
                .createAndAddKnights(2)
                .createAndAddCreatures(4)
                .createAndAddDemons(1)
                .createAndAddFood(10)
                .build();
        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        assertNotNull(arcane.play());

    }

    @Test
    public void testPlay2x2Grid(){
        Cave cave = new Cave.Builder().create2x2Grid()
                .createAndAddAdventurers(3)
                .createAndAddCreatures(2)
                .createAndAddDemons(1)
                .createAndAddFood(7)
                .build();
        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        assertNotNull(arcane.play());
    }

    @Test
    public void testPlay3x3Grid(){
        Cave cave = new Cave.Builder().create3x3Grid()
                .createAndAddAdventurers(3)
                .createAndAddCowards(2)
                .createAndAddKnights(1)
                .createAndAddGluttons(1)
                .createAndAddCreatures(4)
                .createAndAddDemons(1)
                .createAndAddFood(15)
                .build();
        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        assertNotNull(arcane.play());
    }
    @Test
    public void testPlayGrid(){
        AdventurerFactory af = new AdventurerFactory(2);
        CreatureFactory cf = new CreatureFactory(4);
        FoodFactory ff = new FoodFactory(10);
        Cave cave = new Cave.Builder(af, cf, ff)
                .createFullyConnectedRooms(7)
                .sequentiallyDistributeAllEntities()
                .createAndAddAdventurers(3)
                .createAndAddCowards(2)
                .createAndAddKnights(1)
                .createAndAddGluttons(1)
                .createAndAddCreatures(4)
                .createAndAddDemons(1)
                .createAndAddFood(15)
                .build();
        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        assertNotNull(arcane.play());
    }


    @Test
    public void testOrderFight(){
        Cave cave = new Cave.Builder().createFullyConnectedRooms(5)
                .createAndAddAdventurers(2)
                .createAndAddKnights(1)
                .createAndAddCreatures(4)
                .createAndAddDemons(1)
                .createAndAddFood(7)
                .build();
        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        arcane.play();
    }
//    @Test
//    public void testMoveAdventurers(){
//        List<Room> lst_rooms = createRoomsThree();
//        List<Adventurer> lst_adventurers = createAdventurers(8);
//        List<Creature> lst_creatures = createCreatures(6);
//        int healthCreatures = 4;
//        for (Creature creature: lst_creatures){
//            creature.setHealth(healthCreatures);
//            healthCreatures -= 1;
//        }
//        int healthAdventurers = 10;
//        for (Adventurer adventurer: lst_adventurers){
//            adventurer.setHealth(healthAdventurers);
//            healthAdventurers -= 1;
//        }
//        Cave cave = createCave(lst_adventurers,lst_creatures,lst_rooms);
//        Dice dice = createDice(6);
//        Arcane arcane = new Arcane(cave, dice);
//        arcane.play();
//    }
}
