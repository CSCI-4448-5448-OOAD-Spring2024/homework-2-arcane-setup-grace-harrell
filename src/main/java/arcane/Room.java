package arcane;
import java.util.*;

public class Room {
    private List<String> neighbors = new ArrayList<>();
    private String room_name;
    private boolean creature = false;
    private boolean adventurer = false;

    public Room(String name) {
        room_name = name;
    }

    public String getRoomName() {
        return room_name;
    }

    public void setRoomName(String new_room_name) {
        room_name = new_room_name;
    }

    public List<String> getNeighbor() {
        return neighbors;
    }

    public void addNeighbor(String neighbor_name) {
        neighbors.add(neighbor_name);
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
}
