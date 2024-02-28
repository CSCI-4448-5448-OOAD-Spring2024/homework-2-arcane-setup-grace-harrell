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

//    public Cave(Builder builder) {
//        this.creatures = builder.creatures;
//        this.adventurers = builder.adventurers;
//        this.caveRooms = builder.caveRooms;
//    }

    private static class Builder {


        // required variables
        public List<Room> caveRooms;
        public List<Adventurer> adventurers;
        public List<Creature> creatures;
        public List<Food> foods;

        AdventurerFactory adventurerFactory;
        CreatureFactory creatureFactory;
        FoodFactory foodFactory;

        public Builder(AdventurerFactory af, CreatureFactory cf, FoodFactory ff) {
            adventurerFactory = af;
            creatureFactory = cf;
            foodFactory = ff;

            adventurers = adventurerFactory.getAdventurers();
            creatures = creatureFactory.getCreatures();
            foods = foodFactory.getFoods();
        }
        public Room getRandomRoom(){
            if (caveRooms.isEmpty()){
                throw new IllegalStateException("Cave is empty");
            }
            Random rand = new Random();
            return caveRooms.get(rand.nextInt(caveRooms.size()));
        }

        public Builder createAndAddRoom(String builderRoomName){
            Room newRoom = new Room(builderRoomName);
            caveRooms.add(newRoom);
            return this;
        }

        public Builder randomlyDistributeAllEntities(){
            for(Adventurer adventurer: adventurers){
                Room room = getRandomRoom();
                room.addAdventurerPresence(adventurer);
            }
            for(Creature creature: creatures){
                Room room = getRandomRoom();
                room.addCreaturePresence(creature);
            }
            for(Food food: foods){
                Room room = getRandomRoom();
                room.addFoodPresent(food);
            }
            return this;
        }

        public Builder create2x2Grid(){
            Room nw = new Room("Northwest");
            Room ne = new Room("Northeast");
            Room sw = new Room("Southwest");
            Room se = new Room("Southeast");

            // adding in the two neighbors of each room
            nw.addNeighbor(Arrays.asList(ne,sw));
            ne.addNeighbor(Arrays.asList(se,nw));
            sw.addNeighbor(Arrays.asList(nw,se));
            se.addNeighbor(Arrays.asList(sw,ne));

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

            nw.addNeighbor(Arrays.asList(n,w));
            n.addNeighbor(Arrays.asList(nw,ne,c));
            ne.addNeighbor(Arrays.asList(n,e));
            e.addNeighbor(Arrays.asList(se,c,ne));
            se.addNeighbor(Arrays.asList(s,e));
            s.addNeighbor(Arrays.asList(sw,c,se));
            sw.addNeighbor(Arrays.asList(w,s));
            w.addNeighbor(Arrays.asList(nw,sw,c));
            c.addNeighbor(Arrays.asList(n,e,s,w));

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

        public Builder createFullyConnectedRooms(int numRooms){
            for (int i = 0; i < numRooms; i++){
                Room roomCreated = new Room("Room " + i);
                caveRooms.add(roomCreated);
            }
            for (Room roomToDrop : caveRooms) {
                for (Room currRoom : caveRooms) {
                    if (roomToDrop != currRoom) {
                        roomToDrop.addNeighbor(List.of(currRoom));
                    }
                }
            }
            return this;
        }

        // methods to create creatures of different types
        public Builder createAndAddCreatures(int numCreatures){
            for(int i = 0; i < numCreatures; i++){
                Creature newlyCreatedCreature = creatureFactory.createCreature();
                creatures.add(newlyCreatedCreature);
                Room room = getRandomRoom();
                room.addCreaturePresence(newlyCreatedCreature);
            }
            return this;
        }

        public Builder createAndAddDemons(int numDemons){
            for(int i = 0; i < numDemons; i++){
                Demon newlyCreatedDemon = creatureFactory.createDemon();
                creatures.add(newlyCreatedDemon);
                Room room = getRandomRoom();
                room.addCreaturePresence(newlyCreatedDemon);
            }
            return this;
        }
        // Methods to create adventurers of different types

        public Builder createAndAddAdventurers(int numAdventurers){
            for(int i = 0; i < numAdventurers; i++){
                Adventurer newlyCreatedAdventurer = adventurerFactory.createAdventurer();
                adventurers.add(newlyCreatedAdventurer);
                Room room = getRandomRoom();
                room.addAdventurerPresence(newlyCreatedAdventurer);
            }
            return this;
        }

        public Builder createAndAddKnights(int numKnights){
            for(int i = 0; i < numKnights; i++){
                Knight newlyCreatedKnight = adventurerFactory.createKnight();
                adventurers.add(newlyCreatedKnight);
                Room room = getRandomRoom();
                room.addAdventurerPresence(newlyCreatedKnight);
            }
            return this;
        }

        public Builder createAndAddCowards(int numCowards){
            for(int i = 0; i < numCowards; i++){
                Coward newlyCreatedCoward = adventurerFactory.createCoward();
                adventurers.add(newlyCreatedCoward);
                Room room = getRandomRoom();
                room.addAdventurerPresence(newlyCreatedCoward);
            }
            return this;
        }

        public Builder createAndAddGluttons(int numGluttons){
            for(int i = 0; i < numGluttons; i++){
                Glutton newlyCreatedGlutton = adventurerFactory.createGlutton();
                adventurers.add(newlyCreatedGlutton);
                Room room = getRandomRoom();
                room.addAdventurerPresence(newlyCreatedGlutton);
            }
            return this;
        }

        public Builder createAndPlaceFood(int numFoods){
            for(int i = 0; i < numFoods; i++) {
                Food newlyCreatedFood =  foodFactory.createFood();
                foods.add(newlyCreatedFood);
                Room room = getRandomRoom();
                room.addFoodPresent(newlyCreatedFood);
            }
            return this;
        }

        public Room getRoomGivenName(String roomName){
            for (Room room: caveRooms){
                if (room.getRoomName().equals(roomName)){
                    return room;
                }
            }
            return null;
        }

        public Builder addToRoom(String roomName, Creature creatureToAdd){
            Room roomToAddCreatureTo = getRoomGivenName(roomName);
            if (roomToAddCreatureTo != null){
                roomToAddCreatureTo.addCreaturePresence(creatureToAdd);
            }
            return this;
        }

        public Builder addToRoom(String roomName, Adventurer adventurerToAdd){
            Room roomToAddAdventurerTo = getRoomGivenName(roomName);
            if (roomToAddAdventurerTo != null){
                roomToAddAdventurerTo.addAdventurerPresence(adventurerToAdd);
            }
            return this;
        }

        public Builder addToRoom(String roomName, Food foodToAdd){
            Room roomToAddFoodTo = getRoomGivenName(roomName);
            if (roomToAddFoodTo != null){
                roomToAddFoodTo.addFoodPresent(foodToAdd);
            }
            return this;
        }

        public Cave build(){
            return new Cave(creatures,adventurers,caveRooms);
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