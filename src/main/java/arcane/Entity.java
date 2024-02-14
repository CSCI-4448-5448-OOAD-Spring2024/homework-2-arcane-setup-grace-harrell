package arcane;

public class Entity {

    private boolean isAlivePrivate = true;
    private int health = 5;
    private String name;

    public void setIsAlive(boolean alive){
        isAlivePrivate = alive;
    }
    public void setName(String name){
        this.name = name;
    }

    public void decreaseHealth(int decreaseBy){
        health -= decreaseBy;
        if (health <= 0){
            health = 0;
            setIsAlive(false);
        }
    }

    public void setHealth(int setHealthTo){
        health = setHealthTo;
    }


// GETTER FUNCTIONS
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public boolean isAlive(){
        return isAlivePrivate;
    }
}
