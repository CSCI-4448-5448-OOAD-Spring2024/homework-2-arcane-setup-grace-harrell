package arcane;
import java.util.*;

public class Cave {
    private List<Room> caveRooms; // list of the rooms in the cave
    private Adventurer adventurer;
    private Creature creature;

    public Cave(Creature _creature, Adventurer _adventurer) {

        // creating the 4 rooms
        Room nw = new Room("Northwest");
        Room ne = new Room("Northeast");
        Room sw = new Room("Southwest");
        Room se = new Room("Southeast");

        // adding in the two neighbors of each room
        nw.addNeighbor(ne);
        nw.addNeighbor(sw);
        ne.addNeighbor(nw);
        ne.addNeighbor(se);
        sw.addNeighbor(nw);
        sw.addNeighbor(se);
        se.addNeighbor(ne);
        se.addNeighbor(sw);

        // randomly choosing a room to put the creature and adventurer into
        caveRooms = new ArrayList<>(Arrays.asList(nw, ne, sw, se));
        getRandomRoom().setCreaturePresence(true);
        getRandomRoom().setAdventurerPresence(true);

        // creates creature in the cave
        creature = _creature;

        // creates an adventurer in the cave
        // WILL REQUIRE  USER INPUT FOR NAME
        adventurer = _adventurer;
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
    public void printCaveStatus() {
        for (Room caveRoom : caveRooms) {
            System.out.println(caveRoom.getRoomName() + ":");

            // prints if adventurer is present in this room
            if (caveRoom.adventurerHere()) {
                System.out.println("\tAdventurer " + adventurer.getName() + "(health: " + adventurer.getHealth() + ") is here");
            }

            // prints if creature is present in this room
            if (caveRoom.creatureHere()) {
                System.out.println("\tCreature " + creature.getName() + "(health: " + creature.getHealth() + ") is here");
            }
        }
    }

    // returns the room in the cave with the adventurer in it
    public Room getAdventurerRoom(){
        for(Room caveRoom : caveRooms){
            if (caveRoom.adventurerHere()){
                return caveRoom;
            }
        }
        return null;
    }
    public Room getCreatureRoom(){
        for(Room caveRoom : caveRooms){
            if (caveRoom.creatureHere()){
                return caveRoom;
            }
        }
        return null;
    }

        public List<Room> getCaveRooms () {
            return caveRooms;
        }
}
