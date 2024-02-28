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

    // need to add in functionality that adventurer with most health fights and rest of them move.

    public boolean play() {
        boolean adventurerWon = false;
        int turnId = 0;
        logger.info("Starting play...");
        while (!cave.allCreaturesDefeated() && !cave.allAdventurersDefeated()){ // while a player or creature is still alive
            logger.info("\n");
            cave.printCaveStatus(turnId);

            List<Adventurer> currAdventurers = cave.getAllAdventurers();
            List<Adventurer> currKnights = cave.getAllKnights();
            List<Adventurer> currCowards = cave.getAllCowards();
            List<Adventurer> currGluttons = cave.getAllGluttons();

            List<Adventurer> aliveAdventurers = currAdventurers.stream().toList();
            List<Adventurer> aliveKnights = currKnights.stream().toList();
            List<Adventurer> aliveCowards = currCowards.stream().toList();
            List<Adventurer> aliveGluttons = currGluttons.stream().toList();

            for (Adventurer currentKnight: aliveKnights){
                Room currentRoom = cave.getAdventurerRoom(currentKnight);
                if (!cave.isDemonPresentInRoom(currentRoom)){
                    currentRoom.moveExtraAdventurers(currentKnight);
                }
                takeTurnPlay(turnId, null, currentKnight,dice);
            }

            for (Adventurer currentCoward: aliveCowards){
                Room currentRoom = cave.getAdventurerRoom(currentCoward);
                takeTurnPlay(turnId, null, currentCoward,dice);
            }

            for (Adventurer currentGlutton: aliveGluttons){
                Room currentRoom = cave.getAdventurerRoom(currentGlutton);
                takeTurnPlay(turnId, null, currentGlutton,dice);
            }

            for (Adventurer currentAdventurer: aliveAdventurers){
                Room currentRoom = cave.getAdventurerRoom(currentAdventurer);
                if (!cave.isDemonPresentInRoom(currentRoom)){
                    currentRoom.moveExtraAdventurers(currentAdventurer);
                }
                takeTurnPlay(turnId, null, currentAdventurer,dice);
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
