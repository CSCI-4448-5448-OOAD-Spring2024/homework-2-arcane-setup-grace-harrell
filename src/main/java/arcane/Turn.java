package arcane;

import java.util.*;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class Turn {

    private static final Logger logger = Logger.getLogger(Turn.class.getName());
    public int turnID;
    private Cave cave;
    private Creature creature;
    private Adventurer adventurer;

    private Dice dice;

    public Turn(int _turnID, Cave _cave, Creature _creature, Adventurer _adventurer, Dice _dice) {
        turnID = _turnID;
        cave = _cave;
        creature = _creature;
        adventurer = _adventurer;
        dice = _dice;
    }
    public void moveAdventurer(){
        for (Room room: cave.getCaveRooms()) {
            List<Adventurer> adventurersPresent = room.getAdventurersPresent();
            if (adventurersPresent.contains(adventurer)) {
                Room currentRoom = cave.getAdventurerRoom();
                Room newRoom = currentRoom.getRandomNeighbor();
                currentRoom.removeAdventurerPresence(adventurer);
                newRoom.addAdventurerPresence(adventurer);
                return;
            }
        }

    }
    public void fight(){
        if(creature.isAlive() && adventurer.isAlive()){
            int creatureRoll = dice.rollDie();
            int adventurerRoll = dice.rollDie();

            if (creatureRoll > adventurerRoll){
                adventurer.decreaseHealth(creatureRoll - adventurerRoll);
            }
            else if (adventurerRoll > creatureRoll) {
                creature.decreaseHealth(adventurerRoll - creatureRoll);
            }
            return;
        }
        if (!creature.isAlive()){
            cave.removeDefeatedCreature(creature);

        }
        if (!adventurer.isAlive()){
            cave.removeDefeatedAdventurer(adventurer);
        }
    }
    // implement method to see if characters are in the same room
    public List<Creature> inSameRoomAs(){
        for (Room room: cave.getCaveRooms()){
            List<Adventurer> adventurersPresent= room.getAdventurersPresent();
            if (adventurersPresent.contains(adventurer)){
                return room.getCreaturesPresent();
            }
        }
        return null;
    }
    // implement method to see if characters should fight or move
    public void takeTurn(){
        List<Creature> creaturesInRoom = inSameRoomAs();
        if (!creaturesInRoom.isEmpty()){
            creature = creaturesInRoom.get(0);
            fight();
        }
        else
            moveAdventurer();
    }
    // implement method to print the actions of this turn and the current status of the cave
//    public void printTurn(){
//        logger.info("ARCANE Maze: turn " + turnID);
//        cave.printCaveStatus();
//    }
}
