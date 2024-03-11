package arcane;

import jdk.jfr.Event;

public class EventBus {
    private static final EventBus instance = new EventBus();

    private EventBus(){

    }

    // eager instantiation
    public static EventBus getInstance() {
        return instance;
    }

    // attach is the "subscribe" functionality
    public void attach(IObserver observer, EventType eventType){}
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
            }
            case Death -> {
            }
            case All -> {
            }
        }
    }


}
