package arcane;

import java.util.List;
import java.util.Random;

public class Entity {
    private boolean isAlivePrivate = true;
    private double health = 5;
    private String name;

    public void setIsAlive(boolean alive){
        isAlivePrivate = alive;
    }
    public void setName(String name){
        this.name = name;
    }

    public void decreaseHealth(double decreaseBy){
        health -= decreaseBy;
        if (health <= 0){
            health = 0;
            setIsAlive(false);
        }
    }

    public void setHealth(double setHealthTo){
        health = setHealthTo;
    }


// GETTER FUNCTIONS
    public String getName(){
        return name;
    }
    public double getHealth(){
        return health;
    }
    public boolean isAlive(){
        return (health > 0);
    }
    public void eatFood(Food food){
        health += food.getHealth();
    }
}
