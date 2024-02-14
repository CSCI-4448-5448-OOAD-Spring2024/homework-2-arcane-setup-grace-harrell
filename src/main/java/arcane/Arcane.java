package arcane;


import org.slf4j.LoggerFactory;

import java.util.*;
import org.slf4j.Logger;
import java.util.stream.Collectors;

public class Arcane {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
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
        Turn turn = new Turn(turnId, cave, creature, adventurer, dice);
        turn.takeTurn();
    }

//    public void moveExtraAdventurers(int turnId, List<Adventurer> moveAdventurers, Dice dice){
//        for (Adventurer move: moveAdventurers){
//            Turn turn = new Turn(turnId,cave,null, move,dice);
//        }
//    }

    // need to add in functionality that adventurer with most health fights and rest of them move.

    public boolean play() {
        boolean adventurerWon = false;
        int turnId = 0;
        logger.info("Starting play...");
        while (!cave.allCreaturesDefeated() && !cave.allAdventurersDefeated()){ // while a player or creature is still alive
            logger.info("\n");
            cave.printCaveStatus(turnId);

            List<Adventurer> currAdventurers = cave.getAllAdventurers();
            List<Adventurer> aliveAdventurers = currAdventurers.stream().toList();
            for (Adventurer adventurerCurrent: aliveAdventurers){
                takeTurnPlay(turnId, null, adventurerCurrent, dice);
//                Room adventurerRoom = cave.getAdventurerRoom(adventurerCurrent);
//                List<Adventurer> allAdventurersInRoom= adventurerRoom.getAdventurersPresent();
//                if (allAdventurersInRoom.size() > 1){
//                    allAdventurersInRoom.remove(adventurerCurrent);
//                    moveExtraAdventurers(turnId, allAdventurersInRoom, dice);
//                }
            }
            turnId += 1;
            //logger.info(String.valueOf("idk"+cave.getAllAdventurers().isEmpty()));
        }
        adventurerWon = !cave.allAdventurersDefeated();
        gameOver(adventurerWon);
        return adventurerWon;
    }
    // ctrl b goes to the class definition
}
