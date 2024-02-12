package arcane;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Arcane {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Arcane.class);
    public void gameOver(Boolean over, Adventurer adventurer, Creature creature) {
        if (over){
            System.out.println("Yay, Adventurer " + adventurer.getName() + " wins.");
        }
        else{
            System.out.println("Boo, the " + creature.getName() + " wins.");
        }
    }
    public boolean play() {
        boolean adventurer_won = false;
        int turn_id = 0;

        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();

        //Create all the rooms
        //Add all the neighbors to the rooms
        //put them in a list

        // DELETE THIS LATER
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


        Cave cave = new Cave(creature,adventurer, rooms);

        logger.info("Starting play...");
        while (adventurer.isAlive() && creature.isAlive()){
            turn_id += 1;
            Turn turn = new Turn(turn_id, cave, creature, adventurer);
            turn.takeTurn();
        }
        adventurer_won = adventurer.isAlive();
        gameOver(adventurer_won, adventurer, creature);
        return adventurer_won;
    }
    // ctrl b goes to the class definition
}
