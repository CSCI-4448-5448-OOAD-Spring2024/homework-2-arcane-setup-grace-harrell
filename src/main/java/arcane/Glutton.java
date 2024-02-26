package arcane;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Glutton extends Adventurer {
    private List<String> lstGluttonNames = new ArrayList<>(Arrays.asList("Chubs","Glutton"));
    public Glutton(){
        Random ran = new Random();
        int idx = ran.nextInt(lstGluttonNames.size());
        String nameUsed = lstGluttonNames.get(idx);
        setName(nameUsed);
        setHealth(3);
    }
}
