package arcane;

public class Character {

    private boolean isAlive = true;
    private int health = 5;
    private String name;

    public void setIsAlive(boolean alive){
        isAlive = alive;
    }
    public void setName(String _name){
        this.name = _name;
    }

    public void decreaseHealth(){
        health -= 1;
        if (health <= 0){
            health = 0;
            setIsAlive(false);
        }
    }


// GETTER FUNCTIONS
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public boolean isAlive(){
        return isAlive;
    }
}
