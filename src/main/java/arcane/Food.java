package arcane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Food extends Entity{
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Food");
    private List<String> lstFoodNames = new ArrayList<>(Arrays.asList("Steak","Cookie","Salad","Banana","Fries","Cake","Pasta","Chicken","Pancake","Tomato","Ice Cream","Egg"));
    // when food is "alive", it is still present in the room and is uneaten
    public Food(){
        setHealth(1);
    }

}
