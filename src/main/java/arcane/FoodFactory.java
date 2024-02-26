package arcane;

public abstract class FoodFactory extends Food {
    public Food createFood(){
        return new Food();
    }

}
