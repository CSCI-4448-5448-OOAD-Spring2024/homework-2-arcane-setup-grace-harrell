package arcane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FoodFactory{
    private List<Food> foods = new ArrayList<>();

    public FoodFactory(int numFood){
        for (int i = 0; i < numFood; i++){
            foods.add(createFood());
        }
    }
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

    public List<Food> getFoods() {
        return foods;
    }
}
