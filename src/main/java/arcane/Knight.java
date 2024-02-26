package arcane;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Knight extends Adventurer {
    private List<String> lstKnightNames = new ArrayList<>(Arrays.asList("Sir Lancelot","Sir Galahad"));
    public Knight(){
        Random ran = new Random();
        int idx = ran.nextInt(lstKnightNames.size());
        String nameUsed = lstKnightNames.get(idx);
        setName(nameUsed);
        setHealth(8);
    }
}
