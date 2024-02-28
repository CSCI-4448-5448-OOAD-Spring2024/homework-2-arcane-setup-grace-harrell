package arcane;

import org.slf4j.LoggerFactory;

import java.util.*;
import org.slf4j.Logger;



public class Turn {

    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
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

    public void decreaseHealthStartFight(){
        creature.decreaseHealth(0.5);
        adventurer.decreaseHealth(0.5);

    }
    public void moveAdventurer(){
        Room adventurerRoom = cave.getAdventurerRoom(adventurer);
        Room newRoom = adventurerRoom.getRandomNeighbor();
        adventurerRoom.removeAdventurerPresence(adventurer);
        newRoom.addAdventurerPresence(adventurer);
        logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") has moved from " + adventurerRoom.getRoomName() + " to " + newRoom.getRoomName());
    }

    public void fight(){
        // decrease both healths by 0.5
        decreaseHealthStartFight();
        if(creature.isAlive() && adventurer.isAlive()){
            int creatureRoll = dice.rollDie();
            int adventurerRoll = dice.rollDie();
            logger.info("Adventurer rolled a " + adventurerRoll);
            logger.info("Creature rolled a " + creatureRoll);
            logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") fought " + creature.getName() + "(health: " + creature.getHealth() + ")");
            if (creatureRoll > adventurerRoll){
                adventurer.decreaseHealth(creatureRoll - adventurerRoll);
                logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") lost to " + creature.getName() + "(health: " + creature.getHealth() + ")");
            }
            else if (adventurerRoll > creatureRoll) {
                creature.decreaseHealth(adventurerRoll - creatureRoll);
                logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") beat " + creature.getName() + "(health: " + creature.getHealth() + ")");
            }
            else{
                logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") drew against " + creature.getName() + "(health: " + creature.getHealth() + ")");
            }
            return;
        }
        if (!creature.isAlive()){
            cave.removeDefeatedCreature(creature);
            logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") has defeated " + creature.getName());
            moveAdventurer();
        }
        if (!adventurer.isAlive()){
            cave.removeDefeatedAdventurer(adventurer);
            logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") DEAD was killed.");
        }
    }
    // implement method to see if characters are in the same room
    public List<Creature> inSameRoomAs(){
        Room adventurerRoom = cave.getAdventurerRoom(adventurer);
        return adventurerRoom.getCreaturesPresent();
    }
    // implement method to see if characters should fight or move
    public void takeTurn(){


        Room adventurerRoom = cave.getAdventurerRoom(adventurer);

        if (cave.isDemonPresentInRoom(adventurerRoom)){
            List<Creature> demonsInThisRoom = cave.getDemonBasedOnRoom(adventurerRoom);
            creature = demonsInThisRoom.get(0);
            fight();
        }
        else{
            List<Creature> creaturesInRoom = inSameRoomAs();
            if (!creaturesInRoom.isEmpty()){
                if (adventurer instanceof Coward){
                    adventurer.decreaseHealth(0.5);
                    moveAdventurer();
                    if (!adventurer.isAlive()){
                        cave.removeDefeatedAdventurer(adventurer);
                        logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") DEAD was killed.");
                    }
                }
                else if (adventurer instanceof Glutton){
                    if (adventurerRoom.noFoodsHere()){
                        creature = creaturesInRoom.get(0);
                        fight();
                    }
                    else{
                        List<Food> foodsPresent = adventurerRoom.getFoodsPresent();
                        Food eatenFood = foodsPresent.get(0);
                        adventurer.eatFood(eatenFood);
                        adventurerRoom.removeFoodPresence(eatenFood);
                        logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") just ate " + eatenFood.getName());
                    }
                }
                else{
                    creature = creaturesInRoom.get(0);
                    fight();
                }
            }
            else{
                if (!adventurerRoom.noFoodsHere()){
                    List<Food> foodsPresent = adventurerRoom.getFoodsPresent();
                    Food eatenFood = foodsPresent.get(0);
                    adventurer.eatFood(eatenFood);
                    adventurerRoom.removeFoodPresence(eatenFood);
                    logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") just ate " + eatenFood.getName());
                }
                else{
                    moveAdventurer();
                }
            }
        }
//        if (cave.isDemonPresentInRoom(adventurerRoom)){
//            creature = cave.getDemonFromRoom(adventurerRoom);
//            fight();
//        }
//        else{
//            if (adventurer instanceof Glutton){
//                logger.info("Adventurer is a glutton");
//                List<Food> foodsPresent = adventurerRoom.getFoodsPresent();
//                Food eatenFood = foodsPresent.get(0);
//                adventurer.eatFood(eatenFood);
//                adventurerRoom.removeFoodPresence(eatenFood);
//                logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") just ate " + eatenFood.getName());
//            }
//            else {
//                logger.info("Adventurer is a Knight or something else");
//                if (!creaturesInRoom.isEmpty()) {
//                    if (adventurer instanceof Coward){
//                        logger.info("Adventurer is a coward");
//                        adventurer.decreaseHealth(0.5);
//                        moveAdventurer();
//                    }
//                    creature = creaturesInRoom.get(0);
//                    fight();
//                } else {
//                    if (!adventurerRoom.noFoodsHere()) {
//                        List<Food> foodsPresent = adventurerRoom.getFoodsPresent();
//                        Food eatenFood = foodsPresent.get(0);
//                        adventurer.eatFood(eatenFood);
//                        adventurerRoom.removeFoodPresence(eatenFood);
//                        logger.info("Adventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") just ate " + eatenFood.getName());
//                    } else {
//                        moveAdventurer();
//                    }
//                }
//            }
//        }

    }
}
