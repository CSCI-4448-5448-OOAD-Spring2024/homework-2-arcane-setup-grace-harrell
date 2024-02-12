package arcane;

import org.slf4j.LoggerFactory;

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
        Cave cave = new Cave(creature,adventurer);

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
