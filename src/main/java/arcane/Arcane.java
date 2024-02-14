package arcane;


import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Arcane {
    private static final Logger logger = Logger.getLogger(Arcane.class.getName());
    private Cave cave;
    private Dice dice;
    public Arcane(Cave cavePlay, Dice dicePlay){
        cave = cavePlay;
        dice = dicePlay;
    }
//    public Cave getCave(){
//        return cave;
//    }
    public void gameOver(Boolean over) {
        if (over){
            logger.info("Yay, the Adventurers won.");
        }
        else{
            logger.info("Boo, the creatures won.");
        }
    }
    public void takeTurnPlay(int turnId, Creature creature, Adventurer adventurer, Dice dice){
        Turn turn = new Turn(turnId, cave, creature, adventurer, this.dice);
        turn.takeTurn();
    }
    public boolean play() {
        boolean adventurerWon = false;
        int turnId = 0;

        logger.info("Starting play...");
        while (!cave.allCreaturesDefeated() && !cave.allAdventurersDefeated()){ // while a player or creature is still alive
            List<Adventurer> currAdventurers = cave.getAllAdventurers();
            List<Adventurer> aliveAdventurers = currAdventurers.stream().collect(Collectors.toList());
            for (Adventurer adventurerCurrent: aliveAdventurers){
                takeTurnPlay(turnId, null, adventurerCurrent, dice);
            }
            cave.printCaveStatus(turnId);
            turnId += 1;
            //logger.info(String.valueOf("idk"+cave.getAllAdventurers().isEmpty()));
        }
        adventurerWon = !cave.allAdventurersDefeated();
        gameOver(adventurerWon);
        return adventurerWon;
    }
    // ctrl b goes to the class definition
}
