package arcane;

import jdk.jfr.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventBus {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    private static final EventBus instance = new EventBus();

    private EventBus(){

    }

    // eager instantiation
    public static EventBus getInstance() {
        return instance;
    }

    // attach is the "subscribe" functionality
    public void attach(IObserver observer, EventType eventType){
        observer.update(eventType.toString());
    }
    public void postMessage(EventType eventType, String eventDescription){
        switch (eventType) {
            case FightingOutcome -> {
            }
            case AteSomething -> {
            }
            case TurnEnded -> {
            }
            case GameOver -> {
            }
            case GameStart -> {
                logger.info(eventDescription);
            }
            case Death -> {
            }
            case All -> {
            }
        }
    }


}
