package arcane;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Demon extends Creature{
    private List<String> lstDemonNames = new ArrayList<>(Arrays.asList("Satan","Demon"));
    public Demon(){
        Random ran = new Random();
        int idx = ran.nextInt(lstDemonNames.size());
        String nameUsed = lstDemonNames.get(idx);
        setName(nameUsed);
        setHealth(15);
    }
}
