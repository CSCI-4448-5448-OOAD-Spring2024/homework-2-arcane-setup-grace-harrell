package arcane;

public class Character {

    private boolean isAlivePrivate = true;
    private int health = 5;
    private String name;

    public void setIsAlive(boolean alive){
        isAlivePrivate = alive;
    }
    public void setName(String _name){
        this.name = _name;
    }

    public void decreaseHealth(int decreaseBy){
        health -= decreaseBy;
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
        return isAlivePrivate;
    }
}
