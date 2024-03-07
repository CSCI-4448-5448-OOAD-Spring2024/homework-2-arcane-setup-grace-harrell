package arcane;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Food extends Entity{
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Food");

    // when food is "alive", it is still present in the room and is uneaten
    public Food(){

        String [] foodTypes = new String[12];
        foodTypes[0] = "Steak";
        foodTypes[1] = "Cookie";
        foodTypes[2] = "Salad";
        foodTypes[3] = "Banana";
        foodTypes[4] = "Fries";
        foodTypes[5] = "Cake";
        foodTypes[6] = "Pasta";
        foodTypes[7] = "Chicken";
        foodTypes[8] = "Pancake";
        foodTypes[9] = "Tomato";
        foodTypes[10] = "Ice Cream";
        foodTypes[11] = "Egg";


        // generates a random indices for 10 food items
        Random ran = new Random();
        int idx = ran.nextInt(11);
        setName(foodTypes[idx]);

        setHealth(1);
    }
}
