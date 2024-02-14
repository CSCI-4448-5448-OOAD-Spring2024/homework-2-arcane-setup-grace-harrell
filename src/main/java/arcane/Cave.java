package arcane;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Cave {

    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    private List<Room> caveRooms; // list of the rooms in the cave
    private List<Adventurer> adventurers;
    private List<Creature> creatures;

    public Cave(List<Creature> lstCreatures, List<Adventurer> lstAdventurers,  List<Room> lstRooms) { // add dependacy injection list of rooms

        caveRooms = lstRooms;

        // randomly choosing a room to put the creature and adventurer into
        for (Adventurer adventurersIndividual: lstAdventurers){
            getRandomRoom().addAdventurerPresence(adventurersIndividual);
        }
        for (Creature creaturesIndividual: lstCreatures){
            getRandomRoom().addCreaturePresence(creaturesIndividual);
        }
        // creates creature in the cave
        creatures = lstCreatures;

        // creates an adventurer in the cave
        // WILL REQUIRE  USER INPUT FOR NAME
        adventurers = lstAdventurers;
    }

    public Room getRandomRoom(){

        // if the rooms haven't been created, throw an error
        if (caveRooms.isEmpty()){
            throw new IllegalStateException("Cave is empty");
        }
        // find a random value by getting a random index
        Random rand = new Random();
        return caveRooms.get(rand.nextInt(caveRooms.size()));
    }

    // prints the current status of the cave, including locations of characters.
    // returns a bool that is true when the characters are in the same room
    public void printCaveStatus(int turnId) {
        logger.info("ARCANE Maze: turn " + turnId);
        for (Room caveRoom : caveRooms) {
            logger.info(caveRoom.getRoomName() + ":");

            // prints if adventurer is present in this room
            if (!caveRoom.noAdventurersHere()) {
                for (Adventurer adventurers: caveRoom.getAdventurersPresent()){
                    logger.info("\tAdventurer " + adventurers.getName() + "(health: " + adventurers.getHealth() + ") is here");
                }
            }
            // prints if creature is present in this room
            if (!caveRoom.noCreaturesHere()) {
                for (Creature creatures: caveRoom.getCreaturesPresent()){
                    logger.info("\tCreature " + creatures.getName() + "(health: " + creatures.getHealth() + ") is here");
                }
            }
            if (!caveRoom.noFoodsHere()){
                for (Food food: caveRoom.getFoodsPresent()){
                    logger.info("\tFood " + food.getName() + "(health: " + food.getHealth() + ") is here");
                }
            }
        }
    }

    // returns the room in the cave with the adventurer in it
//    public Room getAdventurerRoom(){
//        for(Room caveRoom : caveRooms){
//            if (!caveRoom.noAdventurersHere()){
//                return caveRoom;
//            }
//        }
//        return null;
//    }
    public Room getAdventurerRoom(Adventurer adventurer){
        for (Room room: getCaveRooms()){
            List<Adventurer> lstAdventurers = room.getAdventurersPresent();
            if (lstAdventurers.contains(adventurer)){
                return room;
            }
        }
        return null;
    }
    public Room getCreatureRoom(){
        for(Room caveRoom : caveRooms){
            if (!caveRoom.noCreaturesHere()){
                return caveRoom;
            }
        }
        return null;
    }

    public List<Room> getCaveRooms () {
        return caveRooms;
    }

    public List<Adventurer> getAllAdventurers(){
        return adventurers;
    }
    public List<Creature> getAllCreatures(){
        return creatures;
    }
    public void removeDefeatedAdventurer(Adventurer adventurer){
        adventurers.remove(adventurer);
    }
    public void removeDefeatedCreature(Creature creature){
        creatures.remove(creature);
    }

    public boolean allAdventurersDefeated(){
        return adventurers.isEmpty();
    }

    public boolean allCreaturesDefeated(){
        return creatures.isEmpty();
    }


}