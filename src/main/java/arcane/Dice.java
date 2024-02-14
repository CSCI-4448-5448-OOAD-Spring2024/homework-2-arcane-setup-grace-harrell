package arcane;
import java.util.*;

public class Dice {
    private int numSides;
    public Dice(){
        numSides = 6;
    }
    public int rollDie(){
        Random rand = new Random();
        return 1 + rand.nextInt(numSides);
    }
}
