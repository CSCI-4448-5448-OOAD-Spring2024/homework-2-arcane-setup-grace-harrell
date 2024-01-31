package arcane;

public class Turn {
    int turnID;
    Cave cave;
    Creature creature;
    Adventurer adventurer;

    public Turn(int _turnID, Cave _cave, Creature _creature, Adventurer _adventurer) {
        turnID = _turnID;
        cave = _cave;
        creature = _creature;
        adventurer = _adventurer;

    }
    public void moveAdventurer(){
        Room currentRoom = cave.getAdventurerRoom();
        Room newRoom = currentRoom.getRandomNeighbor();

        currentRoom.setAdventurerPresence(false);
        newRoom.setAdventurerPresence(true);

    }
    public void fight(){
        Dice dice = new Dice();
        while(creature.getHealth() > 0 && adventurer.getHealth() > 0){
            int creatureRoll = dice.rollDie();
            int adventurerRoll = dice.rollDie();

            if (creatureRoll > adventurerRoll){
                adventurer.decreaseHealth();
            }
            else if (adventurerRoll > creatureRoll) {
                creature.decreaseHealth();
            }
        }
    }
    // implement method to see if characters are in the same room
    // implement method to see if characters should fight or move
    // implement method to print the actions of this turn and the current status of the cave

}
