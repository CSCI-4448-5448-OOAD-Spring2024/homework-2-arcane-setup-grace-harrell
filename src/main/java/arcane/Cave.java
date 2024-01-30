package arcane;
import java.util.*;

public class Cave {
    private List<Room> cave;
    public Cave() {

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
        cave = new ArrayList<>(Arrays.asList(nw, ne, sw, se));
        getRandomRoom().setCreaturePresence(true);
        getRandomRoom().setAdventurerPresence(true);
    }
    public Room getRandomRoom(){

        // if the rooms haven't been created, throw an error
        if (cave.isEmpty()){
            throw new IllegalStateException("Cave is empty");
        }
        // find a random value by getting a random index
        Random rand = new Random();
        return cave.get(rand.nextInt(cave.size()));
    }
    public List<Room> getCave(){
        return cave;
    }
}
