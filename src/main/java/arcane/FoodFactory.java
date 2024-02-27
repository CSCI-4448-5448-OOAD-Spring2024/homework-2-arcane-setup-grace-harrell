package arcane;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class FoodFactory{
    public Food createFood() {
        Food food = new Food();
        food.setName(getRandomFoodName());
        return food;
    }

    private String getRandomFoodName() {
        List<String> foodNames = Arrays.asList("Steak","Cookie","Salad","Banana","Fries","Cake","Pasta","Chicken","Pancake","Tomato","Ice Cream","Egg","Coffee","Chocolate","Apple");
        return getRandomName(foodNames);
    }

    public String getRandomName(List<String> nameList) {
        Random random = new Random();
        return nameList.get(random.nextInt(nameList.size()));
    }
}
