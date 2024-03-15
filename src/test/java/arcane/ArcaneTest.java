package arcane;

import csci.ooad.layout.IMazeObserver;
import csci.ooad.layout.MazeObserver;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ArcaneTest {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    public Dice createDice(int numSides){
        return new Dice();
    }
    @Test
    public void testPlayConnected_8(){
        // provideInput("Testy");
        Cave cave = new Cave.Builder().createFullyConnectedRooms(8)
                .createAndAddAdventurers(3)
                .createAndAddCowards(2)
                .createAndAddCreatures(4)
                .createAndAddDemons(2)
                .createAndAddFood(10)
                .build();

        Dice dice = createDice(6);

        Arcane arcane = new Arcane(cave, dice);

        arcane.play();
    }
    @Test
    public void testPlayConnected_10(){
        // provideInput("Testy");
        Cave cave = new Cave.Builder().createFullyConnectedRooms(10)
                .createAndAddAdventurers(1)
                .createAndAddGluttons(2)
                .createAndAddCreatures(2)
                .createAndAddDemons(4)
                .createAndAddFood(10)
                .build();

        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);

        arcane.play();
    }

    @Test
    public void testPlay2x2Grid(){
        Cave cave = new Cave.Builder().create2x2Grid()
                .createAndAddAdventurers(1)
                .createAndAddGluttons(4)
                .createAndAddCreatures(2)
                .createAndAddFood(10)
                .build();

        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        arcane.play();
    }

    @Test
    public void testPlay3x3AndTurnEnd(){
        Cave cave = new Cave.Builder().create3x3Grid()
                .createAndAddAdventurers(3)
                .createAndAddKnights(2)
                .createAndAddCreatures(3)
                .createAndAddDemons(1)
                .createAndAddFood(4)
                .build();

        Dice dice = createDice(6);
//        IMazeObserver observer = MazeObserver.getNewBuilder("3x3 grid").build();
//        AudibleObserver audibleObserver = new AudibleObserver(3);
//
        Arcane arcane = new Arcane(cave, dice);
//
//        arcane.attachObservers(observer);
//        arcane.attachAudibleObserver(audibleObserver, Arrays.asList(EventType.Death, EventType.GameOver, EventType.TurnEnded));

        arcane.play();

//        arcane.removeObserver(observer);
//        arcane.removeObserver(audibleObserver);
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
}
