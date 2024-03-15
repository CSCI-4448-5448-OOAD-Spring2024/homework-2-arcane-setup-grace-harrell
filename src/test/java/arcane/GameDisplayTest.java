package arcane;

import csci.ooad.layout.IMazeObserver;
import csci.ooad.layout.MazeObserver;
import io.cucumber.java.bs.A;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GameDisplayTest {
    public Dice createDice(int numSides){
        return new Dice();
    }
    @Test
    public void testPlay(){
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
        AudibleObserver audibleObserver = new AudibleObserver(2);
        IMazeObserver mazeObserver = MazeObserver.getNewBuilder("Arcane Game")
                        .useRadialLayoutStrategy()
                                .setDelayInSecondsAfterUpdate(2)
                                        .build();
        arcane.attach(mazeObserver);
        arcane.attachAudibleObserver(audibleObserver, Arrays.asList(EventType.Death, EventType.GameOver));
        arcane.play();
    }

    @Test
    public void testPlaySmaller(){
        // provideInput("Testy");
        Cave cave = new Cave.Builder().create2x2Grid()
                .createAndAddAdventurers(2)
                .createAndAddCreatures(3)
                .createAndAddFood(2)
                .build();

        Dice dice = createDice(6);
        Arcane arcane = new Arcane(cave, dice);
        AudibleObserver audibleObserver = new AudibleObserver(2);
        IMazeObserver mazeObserver = MazeObserver.getNewBuilder("Arcane Game")
                .useRadialLayoutStrategy()
                .setDelayInSecondsAfterUpdate(2)
                .build();
        arcane.attach(mazeObserver);
        arcane.attachAudibleObserver(audibleObserver, Arrays.asList(EventType.Death, EventType.GameOver));
        arcane.play();
    }
}
