package arcane;

import jdk.jfr.Event;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventBus {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    private static final EventBus instance = new EventBus();
    private final Map<EventType, List<IObserver>> observers;

    private EventBus(){
        this.observers = new HashMap<>();
        for (EventType eventType : EventType.values()){
            this.observers.put(eventType, new ArrayList<>());
        }
    }

    // eager instantiation
    public static EventBus getInstance() {
        return instance;
    }

    // attach is the "subscribe" functionality
    public void attach(IObserver observer, EventType eventType){
        observers.get(eventType).add(observer);
    }
    public void postMessage(EventType eventType, String eventDescription) {
        List<IObserver> eventObservers = observers.get(eventType);
        for (IObserver observer : eventObservers) {
            observer.update(eventDescription);
        }
    }
}
