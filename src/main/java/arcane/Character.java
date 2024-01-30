package arcane;

public class Character {
    private int health = 5;
    private String name;
    public Character(){
    }
    public void setName(String _name){
        this.name = _name;
    }

    public void decreaseHealth(){
        health -= 1;
    }


// GETTER FUNCTIONS
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
}
