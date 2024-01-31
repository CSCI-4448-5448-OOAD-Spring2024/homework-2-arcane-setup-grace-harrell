package arcane;

public class Arcane {
    public void gameOver(Boolean over, Adventurer adventurer, Creature creature) {
        if (over){
            System.out.println("Yay, Adventurer " + adventurer.getName() + " wins.");
        }
        else{
            System.out.println("Boo, the " + creature.getName() + " wins.");
        }
    }
    public void play() {
        Boolean adventurer_won = false;
        int turn_id = 0;

        Adventurer adventurer = new Adventurer();
        Creature creature = new Creature();
        Cave cave = new Cave(creature,adventurer);

        System.out.println("Starting play...");
        while (adventurer.isAlive() && creature.isAlive()){
            turn_id += 1;
            Turn turn = new Turn(turn_id, cave, creature, adventurer);
            turn.takeTurn();
        }
        adventurer_won = adventurer.isAlive();
        gameOver(adventurer_won, adventurer, creature);
    }
    // ctrl b goes to the class definition
}
