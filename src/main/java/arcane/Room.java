package arcane;
import java.util.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;



public class Room {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    private List<Room> neighbors = new ArrayList<>();
    private String roomName;
    private List<Creature> creaturesPresent = new ArrayList<>();
    private List<Adventurer> adventurersPresent = new ArrayList<>();
    private List<Food> foodsPresent = new ArrayList<>();

    public Room(String name) {
        roomName = name;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String newRoomName) {
        roomName = newRoomName;
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

    public void addNeighbor(List<Room> newNeighbors) {
        neighbors.addAll(newNeighbors);
    }

    public List<Creature> getCreaturesPresent() {
        creaturesPresent.sort(Comparator.comparingDouble(Creature::getHealth).reversed());
        return creaturesPresent;
    }

    public void addCreaturePresence(Creature creature ) {
        creaturesPresent.add(creature);
        //creaturesPresent.sort(Comparator.comparingDouble(Creature::getHealth).reversed());
    }

    public void removeCreaturePresence(Creature creature ) {
        creaturesPresent.remove(creature);
    }

    public boolean noCreaturesHere(){
        return creaturesPresent.isEmpty();
    }

    public List<Adventurer> getAdventurersPresent() {
        adventurersPresent.sort(Comparator.comparingDouble(Adventurer::getHealth).reversed());
        return adventurersPresent;
    }

    public void addAdventurerPresence(Adventurer adventurer) {
        adventurersPresent.add(adventurer);
        //adventurersPresent.sort(Comparator.comparingDouble(Adventurer::getHealth).reversed());
    }

    public void removeAdventurerPresence(Adventurer adventurer) {
        adventurersPresent.remove(adventurer);
    }

    public boolean noAdventurersHere(){
        return adventurersPresent.isEmpty();
    }

    public List<Food> getFoodsPresent(){
        return foodsPresent;
    }

    public void addFoodPresent(Food newFood) {
        foodsPresent.add(newFood);
    }
    public boolean noFoodsHere(){
        return foodsPresent.isEmpty();
    }
    public void removeFoodPresence(Food food){
        foodsPresent.remove(food);
    }

    public void moveExtraAdventurers(Adventurer adventurer){
        if (!creaturesPresent.isEmpty() && adventurersPresent.size() > 1){
            List<Adventurer> extraAdventurers = new ArrayList<>(adventurersPresent.stream().toList());
            extraAdventurers.remove(adventurer);
            for (Adventurer extra: extraAdventurers){
                Room room = getRandomNeighbor();
                removeAdventurerPresence(extra);
                room.addAdventurerPresence(extra);
                logger.info("Adventurer " + extra.getName() + "(health: " + extra.getHealth() + ") has moved from " + getRoomName() + " to " + room.getRoomName());
            }
        }
    }
}