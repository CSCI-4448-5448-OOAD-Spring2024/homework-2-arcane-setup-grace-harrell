package arcane;
import java.util.*;
import java.util.logging.Logger;
public abstract class AdventurerFactory extends Adventurer {
    public Adventurer createAdventurer(){
        return new Adventurer();
    }
    public Knight createKnight(){
        return new Knight();
    }
    public Glutton createGlutton(){
        return new Glutton();
    }
    public Coward createCoward(){
        return new Coward();
    }
}
