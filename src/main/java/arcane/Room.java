package arcane;
import java.util.*;


public class Room {
    private List<Room> neighbors = new ArrayList<>();
    private String room_name;
    private boolean creature = false;
    private boolean adventurer = false;
    private List<Food> foods_present = new ArrayList<>();

    public Room(String name) {
        room_name = name;
    }

    public String getRoomName() {
        return room_name;
    }

    public void setRoomName(String new_room_name) {
        room_name = new_room_name;
    }

    public List<Room> getNeighbor() {
        return neighbors;
    }
    public Room getRandomNeighbor(){
        // if the rooms haven't been created, throw an error
        if (neighbors.isEmpty()){
            throw new IllegalStateException("Room has no neighbors");
        }
        // find a random value by getting a random index
        Random rand = new Random();
        return neighbors.get(rand.nextInt(neighbors.size()));
    };

    public void addNeighbor(Room new_neighbor) {
        neighbors.add(new_neighbor);
    }

    public boolean creatureHere() {
        return creature;
    }

    public void setCreaturePresence(Boolean creature_presence) {
        creature = creature_presence;
    }

    public boolean adventurerHere() {
        return adventurer;
    }

    public void setAdventurerPresence(Boolean adventurer_presence) {
        adventurer = adventurer_presence;
    }

    public List<Food> getFoodsPresent(){
        return foods_present;
    }

    public void addFoodPresent(Food new_food) {
        foods_present.add(new_food);
    }
}
