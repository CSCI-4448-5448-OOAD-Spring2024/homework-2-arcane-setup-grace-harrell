package arcane;
import java.util.*;

public class EventBus {
    private static EventBus instance = null;
    private final Map<EventType, List<IObserver>> observers;

    private EventBus(){
        this.observers = new HashMap<>();
        for (EventType eventType : EventType.values()){
            this.observers.put(eventType, new ArrayList<>());
        }
    }

    // eager instantiation
    public static EventBus getInstance() {
        if (instance == null){
            instance = new EventBus();
        }
        return instance;
    }

    // attach is the "subscribe" functionality
    public void attach(IObserver observer, EventType eventType){
        observers.get(eventType).add(observer);
    }
    public void postMessage(EventType eventType, String eventDescription){
        List<IObserver> eventObservers = observers.get(eventType);
        for (IObserver observer : eventObservers) {
            observer.update(eventDescription);
        }
    }
}
