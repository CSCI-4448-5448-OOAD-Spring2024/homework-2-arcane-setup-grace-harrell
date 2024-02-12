package arcane;
import java.util.*;


public class Room {
    private List<Room> neighbors = new ArrayList<>();
    private String room_name;
    private List<Creature> creaturesPresent;
    private List<Adventurer> adventurersPresent;
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

    public List<Creature> getCreaturesPresent() {
        return creaturesPresent;
    }

    public void addCreaturePresence(Creature creature ) {
        creaturesPresent.add(creature);
    }

    public boolean noCreaturesHere(){
        return creaturesPresent.isEmpty();
    }

    public List<Adventurer> getAdventurersPresent() {
        return adventurersPresent;
    }

    public void addAdventurerPresence(Adventurer adventurer) {
        adventurersPresent.add(adventurer);
    }

    public boolean noAdventurersHere(){
        return adventurersPresent.isEmpty();
    }

    public List<Food> getFoodsPresent(){
        return foods_present;
    }

    public void addFoodPresent(Food new_food) {
        foods_present.add(new_food);
    }
}
