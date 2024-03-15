package arcane;

import csci.ooad.layout.IMaze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CaveAdaptor implements IMaze {

    private Cave cave;

    public CaveAdaptor(Cave cave){
        this.cave = cave;
    }
    @Override
    public List<String> getRooms() {
        List<String> result = new ArrayList<>();
        List<Room> listRooms = cave.getCaveRooms();
        for (Room room : listRooms){
            result.add(room.getRoomName());
        }
        return result;
    }

    @Override
    public List<String> getNeighborsOf(String s) {
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
            result.add(room.getRoomName());
        }
        return result;
    }

    @Override
    public List<String> getContents(String s) {
        return null;
    }

}

}
