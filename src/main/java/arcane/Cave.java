package arcane;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.logging.Logger;

public class Cave {

    private static final Logger logger = Logger.getLogger(String.valueOf(Cave.class));
    private List<Room> caveRooms = new ArrayList<>(); // list of the rooms in the cave
    private List<Adventurer> adventurers;
    private List<Creature> creatures;

    public Cave(List<Creature> _creatures, List<Adventurer> _adventurers,  List<Room> _rooms) { // add dependacy injection list of rooms


        caveRooms = _rooms;

        // randomly choosing a room to put the creature and adventurer into

        getRandomRoom().setCreaturePresence(true);
        getRandomRoom().setAdventurerPresence(true);
        for (int i = 0; i < 10; i++){
            Food addFood = new Food();
            getRandomRoom().addFoodPresent(addFood);
        }
        // creates creature in the cave
        creatures = _creature;

        // creates an adventurer in the cave
        // WILL REQUIRE  USER INPUT FOR NAME
        adventurers = _adventurer;
    }

//    public Room addRooms(String caveName){
//        Room newRoom = new Room(caveName);
//        caveRooms.add(newRoom);
//        return newRoom;
//    }
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
    public void printCaveStatus() {

        for (Room caveRoom : caveRooms) {
            logger.info(caveRoom.getRoomName() + ":");

            // prints if adventurer is present in this room
            if (caveRoom.adventurerHere()) {
                logger.info("\tAdventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") is here");
            }

            // prints if creature is present in this room
            if (caveRoom.creatureHere()) {
                logger.info("\tCreature " + creature.getName() + "(health: " + creature.getHealth() + ") is here");
            }
        }
    }

    // returns the room in the cave with the adventurer in it
    public Room getAdventurerRoom(){
        for(Room caveRoom : caveRooms){
            if (!caveRoom.noAdventurersHere()){
                return caveRoom;
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
}
