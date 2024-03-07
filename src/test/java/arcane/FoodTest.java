package arcane;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FoodTest {
    //private static final Logger logger = (Logger) LoggerFactory.getLogger(FoodTest.class);
    @Test
    public void testFoodCreation(){
        Food food = new Food();
        String foodName = food.getName();
        double foodHealthBenefit = food.getHealth();
        assert(foodHealthBenefit == 1);
    }

}