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

    public static class Builder {

        //private boolean sequentiallyDistributed = false;
        // required variables
        public List<Room> caveRooms;
        public List<Adventurer> adventurers;
        public List<Creature> creatures;
        public List<Food> foods;

        AdventurerFactory adventurerFactory;
        CreatureFactory creatureFactory;
        FoodFactory foodFactory;

        public Builder(){
            adventurers = new ArrayList<>();
            creatures = new ArrayList<>();
            foods = new ArrayList<>();
            caveRooms = new ArrayList<>();

            adventurerFactory = new AdventurerFactory();
            creatureFactory = new CreatureFactory();
            foodFactory = new FoodFactory();
        }
        public Builder(AdventurerFactory af, CreatureFactory cf, FoodFactory ff) {
            adventurerFactory = af;
            creatureFactory = cf;
            foodFactory = ff;

            adventurers = adventurerFactory.getAdventurers();
            creatures = creatureFactory.getCreatures();
            foods = foodFactory.getFoods();
        }

        public static Builder newBuilder() {
            return new Builder();
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
            for (int i = 1; i < numRooms+1; i++){
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
            List<String> lstNamesCreatures = new ArrayList<>();
            int numCreaturesCreated = 0;
            while (numCreaturesCreated < numCreatures){
                Creature newlyCreatedCreature = creatureFactory.createCreature();
                if (!lstNamesCreatures.contains(newlyCreatedCreature.getName())){
                    creatures.add(newlyCreatedCreature);

                    Room room = getRandomRoom();
                    room.addCreaturePresence(newlyCreatedCreature);

                    lstNamesCreatures.add(newlyCreatedCreature.getName());
                    numCreaturesCreated += 1;
                }
            }
            return this;
        }

        public Builder createAndAddDemons(int numDemons){
            List<String> lstNamesDemons = new ArrayList<>();
            int numDemonsCreated = 0;
            while (numDemonsCreated < numDemons){
                Demon newlyCreatedDemon = creatureFactory.createDemon();
                if (!lstNamesDemons.contains(newlyCreatedDemon.getName())){
                    creatures.add(newlyCreatedDemon);

                    Room room = getRandomRoom();
                    room.addCreaturePresence(newlyCreatedDemon);

                    lstNamesDemons.add(newlyCreatedDemon.getName());
                    numDemonsCreated += 1;
                }
            }
            return this;
        }
        // Methods to create adventurers of different types

        public Builder createAndAddAdventurers(int numAdventurers){
            List<String> lstNamesAdventurers = new ArrayList<>();
            int numAdventurersCreated = 0;
            while (numAdventurersCreated < numAdventurers){
                Adventurer newlyCreatedAdventurer = adventurerFactory.createAdventurer();
                if (!lstNamesAdventurers.contains(newlyCreatedAdventurer.getName())){
                    adventurers.add(newlyCreatedAdventurer);

                    Room room = getRandomRoom();
                    room.addAdventurerPresence(newlyCreatedAdventurer);

                    lstNamesAdventurers.add(newlyCreatedAdventurer.getName());
                    numAdventurersCreated += 1;
                }
            }
            return this;
        }

        public Builder createAndAddKnights(int numKnights){
            List<String> lstNamesKnights = new ArrayList<>();
            int numKnightsCreated = 0;
            while (numKnightsCreated < numKnights){
                Knight newlyCreatedKnight = adventurerFactory.createKnight();
                if (!lstNamesKnights.contains(newlyCreatedKnight.getName())){
                    adventurers.add(newlyCreatedKnight);

                    Room room = getRandomRoom();
                    room.addAdventurerPresence(newlyCreatedKnight);

                    lstNamesKnights.add(newlyCreatedKnight.getName());
                    numKnightsCreated += 1;
                }
            }
            return this;
        }

        public Builder createAndAddCowards(int numCowards){
            List<String> lstNamesCowards = new ArrayList<>();
            int numCowardsCreated = 0;
            while (numCowardsCreated < numCowards){
                Coward newlyCreatedCoward = adventurerFactory.createCoward();
                if (!lstNamesCowards.contains(newlyCreatedCoward.getName())){

                    adventurers.add(newlyCreatedCoward);

                    Room room = getRandomRoom();
                    room.addAdventurerPresence(newlyCreatedCoward);

                    lstNamesCowards.add(newlyCreatedCoward.getName());
                    numCowardsCreated += 1;
                }
            }
            return this;
        }

        public Builder createAndAddGluttons(int numGluttons){
            List<String> lstNamesGlutton = new ArrayList<>();
            int numGluttonCreated = 0;
            while (numGluttonCreated < numGluttons){
                Glutton newlyCreatedGlutton = adventurerFactory.createGlutton();
                if (!lstNamesGlutton.contains(newlyCreatedGlutton.getName())){
                    adventurers.add(newlyCreatedGlutton);

                    Room room = getRandomRoom();
                    room.addAdventurerPresence(newlyCreatedGlutton);

                    lstNamesGlutton.add(newlyCreatedGlutton.getName());
                    numGluttonCreated += 1;
                }
            }
            return this;
        }

        public Builder createAndAddFood(int numFoods){
            List<String> lstNamesFoods = new ArrayList<>();
            int numFoodsCreated = 0;
            while (numFoodsCreated < numFoods){
                Food newlyCreatedFood = foodFactory.createFood();
                if (!lstNamesFoods.contains(newlyCreatedFood.getName())){
                    foods.add(newlyCreatedFood);

                    Room room = getRandomRoom();
                    room.addFoodPresent(newlyCreatedFood);

                    lstNamesFoods.add(newlyCreatedFood.getName());
                    numFoodsCreated += 1;
                }
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

//        public Builder sequentiallyDistributeAllEntities(){
//            sequentiallyDistributed = true;
//            return this;
//        }

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
                    if (adventurers.isAlive()) {
                        nameAdventurers += adventurers.getName() + "(health: " + adventurers.getHealth() + "), ";
                    }
                }
                if (!nameAdventurers.isEmpty()){
                    logger.info("\t\t" + nameAdventurers.substring(0,(nameAdventurers.length() - 2)));
                }
            }
            // prints if creature is present in this room
            logger.info("\tCreatures:  ");
            if (!caveRoom.noCreaturesHere()) {
                String nameCreatures = "";
                for (Creature creatures: caveRoom.getCreaturesPresent()){
                    if (creatures.isAlive()) {
                        nameCreatures += creatures.getName() + "(health: " + creatures.getHealth() + "), ";
                    }
                }
                if (!nameCreatures.isEmpty()){
                    logger.info("\t\t" + nameCreatures.substring(0,(nameCreatures.length() - 2)));
                }
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
        List<Adventurer> regularAdventurers = new ArrayList<>();
        for (Adventurer currAdventurer: adventurers){
            if (!(currAdventurer instanceof Knight) && !(currAdventurer instanceof Coward) && !(currAdventurer instanceof Glutton)){
                regularAdventurers.add(currAdventurer);
            }
        }
        return regularAdventurers;
    }

    public List<Adventurer> getAllKnights(){
        List<Adventurer> knights = new ArrayList<>();
        for (Adventurer currAdventurer: adventurers){
            if (currAdventurer instanceof Knight){
                knights.add(currAdventurer);
            }
        }
        return knights;
    }

    public List<Adventurer> getAllGluttons(){
        List<Adventurer> gluttons = new ArrayList<>();
        for (Adventurer currAdventurer: adventurers){
            if (currAdventurer instanceof Glutton){
                gluttons.add(currAdventurer);
            }
        }
        return gluttons;
    }

    public List<Adventurer> getAllCowards(){
        List<Adventurer> cowards = new ArrayList<>();
        for (Adventurer currAdventurer: adventurers){
            if (currAdventurer instanceof Coward){
                cowards.add(currAdventurer);
            }
        }
        return cowards;
    }

    public List<Creature> getAllCreatures(){
        List<Creature> regularCreatures = new ArrayList<>();
        for (Creature currCreature: creatures){
            if (!(currCreature instanceof Demon)){
                regularCreatures.add(currCreature);
            }
        }
        return regularCreatures;
    }
    public List<Creature> getAllDemons(){
        List<Creature> demons = new ArrayList<>();
        for (Creature currCreature: creatures){
            if (currCreature instanceof Demon){
                demons.add(currCreature);
            }
        }
        return demons;
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

    public boolean isDemonPresentInRoom(Room roomCurrent){
        List<Creature> creaturesInRoom = roomCurrent.getCreaturesPresent();
        for (Creature creature: creaturesInRoom){
            if (creature instanceof Demon){
                return true;
            }
        }
        return false;
    }

    public List<Creature> getDemonBasedOnRoom(Room roomCurrent){
        List<Creature> demonsInThisRoom = new ArrayList<>();
        List<Creature> creaturesInRoom = roomCurrent.getCreaturesPresent();
        for (Creature creature: creaturesInRoom){
            if (creature instanceof Demon){
                demonsInThisRoom.add(creature);
            }
        }
        return demonsInThisRoom;
    }

}