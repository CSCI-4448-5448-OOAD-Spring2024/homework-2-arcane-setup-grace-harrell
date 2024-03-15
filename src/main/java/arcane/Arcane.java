package arcane;


import csci.ooad.layout.IMaze;
import csci.ooad.layout.IMazeObserver;
import csci.ooad.layout.IMazeSubject;
import org.slf4j.LoggerFactory;

import java.util.*;
import org.slf4j.Logger;
import java.util.stream.Collectors;

public class Arcane implements IObservable, IMazeSubject {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    private final Cave cave;
    private final Dice dice;
    private final EventBus eventBus;
    private List<IMazeObserver> observers = new ArrayList<>();
    private List<IObserver> iObservers = new ArrayList<>();

    public Arcane(Cave cavePlay, Dice dicePlay){
        this.cave = cavePlay;
        this.dice = dicePlay;
        this.eventBus = EventBus.getInstance();
    }
    public void registerObserver(IMazeObserver observer){
        Objects.requireNonNull(observer, "Observer can't be null");
        observers.add(observer);
    }
    public void removeObserver(IMazeObserver observer){
        observers.remove(observer);
    }
    @Override
    public void registerObserver(IObserver observer){
        Objects.requireNonNull(observer, "Observer can't be null");
        iObservers.add(observer);
    }
    @Override
    public void removeObserver(IObserver observer){
        iObservers.remove(observer);
    }

    public void notifyObservers(String eventDescription){
        for (IMazeObserver observer : observers){
            observer.update(getMaze(), eventDescription);
        }
    }
    @Override
    public IMaze getMaze() {
        return new CaveAdapter(cave);
    }
    @Override
    public void attach(IMazeObserver observer){
        observers.add(observer);
    }

    private void notifyGameEvent(String eventDescription){
        notifyObservers(eventDescription);
    }
    public void attachObservers(IObserver observer){
        eventBus.attach(observer, EventType.AteSomething);
        eventBus.attach(observer, EventType.Death);
        eventBus.attach(observer, EventType.FightingOutcome);
        eventBus.attach(observer, EventType.GameOver);
        eventBus.attach(observer, EventType.TurnEnded);
    }

    public void attachAudibleObserver(AudibleObserver audibleObserver, List<EventType> eventTypes){
        for (EventType eventType : eventTypes){
            eventBus.attach(audibleObserver, eventType);
        }
    }

    private void appendAdventurerNames(StringBuilder builder, List<Adventurer> adventurers) {
        for (Adventurer adventurer : adventurers) {
            builder.append(adventurer.getName()).append(", ");
        }
    }

    private void appendCreatureNames(StringBuilder builder, List<Creature> creatures) {
        for (Creature creature : creatures) {
            builder.append(creature.getName()).append(", ");
        }
    }

    public void gameOver(Boolean over) {
        if (over){
            StringBuilder aliveAdventurers = new StringBuilder();
            appendAdventurerNames(aliveAdventurers, cave.getAllAdventurers());
            appendAdventurerNames(aliveAdventurers, cave.getAllKnights());
            appendAdventurerNames(aliveAdventurers, cave.getAllCowards());
            appendAdventurerNames(aliveAdventurers, cave.getAllGluttons());

            logger.info("Yay, the Adventurers won.\n");
            eventBus.postMessage(EventType.GameOver, "The game is over. The Adventurers left alive were: " + aliveAdventurers + ". Adventurers won!");
            notifyGameEvent("Adventurers won!");
        }
        else{
            StringBuilder aliveCreatures = new StringBuilder();
            appendCreatureNames(aliveCreatures, cave.getAllDemons());
            appendCreatureNames(aliveCreatures, cave.getAllCreatures());
            logger.info("Boo, the creatures won.\n");
            eventBus.postMessage(EventType.GameOver, "The game is over. The Creatures left alive were: " + aliveCreatures + ". Creatures won!");
            notifyGameEvent("Creatures won!");
        }
    }
    public void takeTurnPlay(int turnId, Creature creature, Adventurer adventurer, Dice dice){
        Turn turn = new Turn(turnId, cave, creature, adventurer, dice);
        turn.takeTurn();
    }

    // need to add in functionality that adventurer with most health fights and rest of them move.

    public boolean play() {
        boolean adventurerWon = false;
        int turnId = 0;
        logger.info("Starting play...");
        while (!cave.allCreaturesDefeated() && !cave.allAdventurersDefeated()){ // while a player or creature is still alive
            logger.info("\n");
            cave.printCaveStatus(turnId);

            List<Adventurer> currAdventurers = cave.getAllAdventurers();
            List<Adventurer> currKnights = cave.getAllKnights();
            List<Adventurer> currCowards = cave.getAllCowards();
            List<Adventurer> currGluttons = cave.getAllGluttons();

            List<Adventurer> aliveAdventurers = currAdventurers.stream().toList();
            List<Adventurer> aliveKnights = currKnights.stream().toList();
            List<Adventurer> aliveCowards = currCowards.stream().toList();
            List<Adventurer> aliveGluttons = currGluttons.stream().toList();

            for (Adventurer currentKnight: aliveKnights){
                Room currentRoom = cave.getAdventurerRoom(currentKnight);
                if (!cave.isDemonPresentInRoom(currentRoom)){
                    currentRoom.moveExtraAdventurers(currentKnight);
                }
                takeTurnPlay(turnId, null, currentKnight,dice);
            }

            for (Adventurer currentCoward: aliveCowards){
                takeTurnPlay(turnId, null, currentCoward,dice);
            }

            for (Adventurer currentGlutton: aliveGluttons){
                takeTurnPlay(turnId, null, currentGlutton,dice);
            }

            for (Adventurer currentAdventurer: aliveAdventurers){
                Room currentRoom = cave.getAdventurerRoom(currentAdventurer);
                if (!cave.isDemonPresentInRoom(currentRoom)){
                    currentRoom.moveExtraAdventurers(currentAdventurer);
                }
                takeTurnPlay(turnId, null, currentAdventurer,dice);
            }
            eventBus.postMessage(EventType.TurnEnded, "Turn number " + turnId + " just ended");
            notifyObservers("Turn number " + turnId + " just ended");
            turnId += 1;
        }
        adventurerWon = !cave.allAdventurersDefeated();
        gameOver(adventurerWon);
        return adventurerWon;
    }
    // ctrl b goes to the class definition
}
