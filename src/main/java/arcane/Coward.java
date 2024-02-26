package arcane;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Coward extends Adventurer {
    private List<String> lstCowardNames = new ArrayList<>(Arrays.asList("Coward","Flee"));
    public Coward(){
        Random ran = new Random();
        int idx = ran.nextInt(lstCowardNames.size());
        String nameUsed = lstCowardNames.get(idx);
        setName(nameUsed);
        setHealth(5);
    }
}
