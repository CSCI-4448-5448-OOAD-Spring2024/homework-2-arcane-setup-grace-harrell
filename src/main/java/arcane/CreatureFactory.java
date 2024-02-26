package arcane;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public abstract class CreatureFactory extends Creature{
    public Creature createCreature(){
        return new Creature();
    }

    public Demon createDemon(){
        return new Demon();
    }
}
