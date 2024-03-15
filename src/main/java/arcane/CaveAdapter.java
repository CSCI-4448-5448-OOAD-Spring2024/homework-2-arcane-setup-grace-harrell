package arcane;

import csci.ooad.layout.IMaze;

import java.util.*;

public class CaveAdapter implements IMaze {
    private Cave cave;
    public CaveAdapter(Cave cave) {
        this.cave = cave;
    }
    @Override
    public List<String> getRooms(){
         List<Room> lstRooms = cave.getCaveRooms();
         List<String> nameResults = new ArrayList<>();
         for (Room room : lstRooms){
             nameResults.add(room.getRoomName());
         }
         return Collections.unmodifiableList(nameResults);
    }

    @Override
    public List<String> getNeighborsOf(String s){
        List<String> result = new ArrayList<>();
        Room room = null;
        // find the room with matching name
        for(Room currRoom: cave.getCaveRooms()) {
            if (Objects.equals(s, currRoom.getRoomName())) {
                room = currRoom;
            }
            // throw an error if the room is not found
        }
        for (Room currRoom: room.getNeighbor()){
            result.add(currRoom.getRoomName());
        }
        return Collections.unmodifiableList(result);
    }

    @Override
    public List<String> getContents(String s) {
        List<String> result = new ArrayList<>();
        Room room = null;
        for (Room currRoom : cave.getCaveRooms()) {
            if (Objects.equals(s, currRoom.getRoomName())) {
                room = currRoom;
            }
        }
        // throw an error if room is still null

        for (Creature creature : room.getCreaturesPresent()) {
            result.add(creature.getName());
        }
        for (Adventurer adventurer : room.getAdventurersPresent()) {
            result.add(adventurer.getName());
        }
        for (Food food : room.getFoodsPresent()) {
            result.add(food.getName());
        }


        return Collections.unmodifiableList(result);
    }
}

