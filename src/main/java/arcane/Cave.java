package arcane;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Cave {
    private List<Room> caveRooms;
    private List<Adventurer> adventurers;
    private List<Creature> creatures;



    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");

    public Cave(List<Creature> lstCreatures, List<Adventurer> lstAdventurers,  List<Room> lstRooms) {

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
        adventurers = lstAdventurers;
    }

    public Cave(Builder builder) {
        this.creatures = builder.creatures;
        this.adventurers = builder.adventurers;
        this.caveRooms = builder.caveRooms;
    }

    private static class Builder {


        // required variables
        private List<Room> caveRooms;
        private List<Adventurer> adventurers;
        private List<Creature> creatures;

        AdventurerFactory adventurerFactory;
        CreatureFactory creatureFactory;
        FoodFactory foodFactory;

        //optional variables
        int numCreatures = 0;
        int numDemons = 0;
        int numAdventurers = 0;
        int numKnights = 0;
        int numGluttons = 0;
        int numCowards = 0;
        private Cave cave = new Cave(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());


        public Builder(AdventurerFactory af, CreatureFactory cf, FoodFactory ff, int _numCreatures, int _numDemons, int _numAdventurers, int _numKnights, int _numGluttons, int _numCowards) {
            adventurerFactory = af;
            creatureFactory = cf;
            foodFactory = ff;

            numCreatures = _numCreatures;
            numDemons = _numDemons;
            numAdventurers = _numAdventurers;
            numKnights = _numKnights;
            numGluttons = _numGluttons;
            numCowards = _numCowards;

        }
        public Room getRandomRoom(){
            if (cave.getCaveRooms().isEmpty()){
                throw new IllegalStateException("Cave is empty");
            }
            Random rand = new Random();
            return cave.getCaveRooms().get(rand.nextInt(cave.caveRooms.size()));
        }

        public Builder createRoom(String builderRoomName){
            Room newRoom = new Room(builderRoomName);
            cave.addRoomToCave(newRoom);
            return this;
        }

        public Builder create2x2Grid(){
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

            caveRooms.add(nw);
            caveRooms.add(ne);
            caveRooms.add(sw);
            caveRooms.add(se);

            return this;
        }

        public Builder create3x3Grid(){
            List<Room> lst_rooms = new ArrayList<>();
            Room nw = new Room("Northwest");
            Room ne = new Room("Northeast");
            Room sw = new Room("Southwest");
            Room se = new Room("Southeast");
            Room n = new Room("North");
            Room s = new Room("South");
            Room w = new Room("West");
            Room e = new Room("East");
            Room c = new Room("Center");
            // adding in the two neighbors of each room
            nw.addNeighbor(n);
            nw.addNeighbor(w);
            n.addNeighbor(nw);
            n.addNeighbor(ne);
            n.addNeighbor(c);
            ne.addNeighbor(n);
            ne.addNeighbor(e);
            e.addNeighbor(ne);
            e.addNeighbor(c);
            e.addNeighbor(se);
            se.addNeighbor(e);
            se.addNeighbor(s);
            s.addNeighbor(c);
            s.addNeighbor(sw);
            s.addNeighbor(se);
            sw.addNeighbor(s);
            sw.addNeighbor(w);
            w.addNeighbor(nw);
            w.addNeighbor(sw);
            w.addNeighbor(c);
            c.addNeighbor(n);
            c.addNeighbor(e);
            c.addNeighbor(s);
            c.addNeighbor(w);

            caveRooms.add(nw);
            caveRooms.add(n);
            caveRooms.add(ne);

            caveRooms.add(e);
            caveRooms.add(c);
            caveRooms.add(w);

            caveRooms.add(sw);
            caveRooms.add(s);
            caveRooms.add(se);

            return this;
        }


        // methods to create creatures of different types
        public Builder createCreatures(){
            creatures = creatureFactory.getCreatures();
            return this;
        }


        // Methods to create adventurers of different types

        public Builder createAdventurers(){
            adventurers = adventurerFactory.getAdventurers();
            return this;
        }
        public Builder createKnights(){

            return this;
        }

        public Builder createAndPlaceFood(){
            List<Food> foods = foodFactory.getFoods();
            for(Food food: foods) {
                Room room =  getRandomRoom();
                room.addFoodPresent(food);
            }
            return this;
        }

        public Cave build(){
            return new Cave(this);
        }

    }
    public void addRoomToCave(Room roomToAdd){
        caveRooms.add(roomToAdd);
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
            logger.info("\tAdventurers: ");
            if (!caveRoom.noAdventurersHere()) {
                String nameAdventurers = "";
                for (Adventurer adventurers: caveRoom.getAdventurersPresent()){
                    nameAdventurers += adventurers.getName() +  "(health: " + adventurers.getHealth() + "), ";
                }
                logger.info("\t\t" + nameAdventurers.substring(0,(nameAdventurers.length() - 2)));
            }
            // prints if creature is present in this room
            logger.info("\tCreatures:  ");
            if (!caveRoom.noCreaturesHere()) {
                String nameCreatures = "";
                for (Creature creatures: caveRoom.getCreaturesPresent()){
                    nameCreatures += creatures.getName() +  "(health: " + creatures.getHealth() + "), ";
                }
                logger.info("\t\t" + nameCreatures.substring(0,(nameCreatures.length() - 2)));
            }
            logger.info("\tFood:  ");
            if (!caveRoom.noFoodsHere()){
                List<Food> lstFoods = caveRoom.getFoodsPresent();
                String nameFoods = "";
                for (Food food: lstFoods){
                    nameFoods += food.getName() + ", ";
                }
                logger.info("\t\t" + nameFoods.substring(0,(nameFoods.length() - 2)));
            }
        }

        logger.info("Actions: ");
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

    public List<Room> getCaveRooms() {
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