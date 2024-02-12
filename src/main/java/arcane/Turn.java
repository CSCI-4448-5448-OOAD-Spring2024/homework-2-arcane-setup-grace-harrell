package arcane;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class Turn {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Turn.class);
    int turnID;
    Cave cave;
    Creature creature;
    Adventurer adventurer;

    public Turn(int _turnID, Cave _cave, Creature _creature, Adventurer _adventurer) {
        turnID = _turnID;
        cave = _cave;
        creature = _creature;
        adventurer = _adventurer;

    }
    public void moveAdventurer(){
        Room currentRoom = cave.getAdventurerRoom();
        Room newRoom = currentRoom.getRandomNeighbor();

        currentRoom.setAdventurerPresence(false);
        newRoom.setAdventurerPresence(true);

    }
    public void fight(){
        Dice dice = new Dice();
        if(creature.getHealth() > 0 && adventurer.getHealth() > 0){
            int creatureRoll = dice.rollDie();
            int adventurerRoll = dice.rollDie();

            if (creatureRoll > adventurerRoll){
                adventurer.decreaseHealth(creatureRoll - adventurerRoll);
            }
            else if (adventurerRoll > creatureRoll) {
                creature.decreaseHealth(adventurerRoll - creatureRoll);
            }
        }
    }
    // implement method to see if characters are in the same room
    public boolean inSameRoom(){
        return cave.getCreatureRoom() == cave.getAdventurerRoom();
    }
    // implement method to see if characters should fight or move
    public void fightOrMove(){
        if (inSameRoom())
            fight();
        else
            moveAdventurer();
    }
    // implement method to print the actions of this turn and the current status of the cave
    public void printTurn(){
        logger.info("ARCANE Maze: turn " + turnID);
        cave.printCaveStatus();
        System.out.println();
    }
    public void takeTurn(){
        fightOrMove();
        printTurn();
    }
}
