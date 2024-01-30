package arcane;
import java.util.*;

public class Dice {
    private int num_sides;
    public Dice(){
        num_sides = 6;
    }
    public int rollDie(){
        Random rand = new Random();
        return rand.nextInt(num_sides);
    }
}
