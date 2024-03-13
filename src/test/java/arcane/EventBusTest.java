package arcane;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class EventBusTest {
    @Test
    void testDeathMessageEventBus() {
        EventBus eventBus = EventBus.getInstance();
        MockObserver observer = new MockObserver();

        eventBus.attach(observer, EventType.Death);

        eventBus.postMessage(EventType.Death, "Adventurer died");

        assertEquals("Adventurer died", observer.getEventDescription());
    }
    @Test
    void testEatMessageEventBus() {
        EventBus eventBus = EventBus.getInstance();
        MockObserver observer = new MockObserver();
        AudibleObserver audibleObserver = new AudibleObserver(5);

        eventBus.attach(observer, EventType.AteSomething);
        eventBus.attach(audibleObserver, EventType.AteSomething);

        // Simulate an adventurer eating food
        eventBus.postMessage(EventType.AteSomething, "Adventurer ate food");
        assertEquals("Adventurer ate food", observer.getEventDescription());
=======
        eventBus.attach(observer,EventType.GameStart);
        eventBus.postMessage(EventType.GameStart, "ARCANE has started");

        assert(observer.events.size() == 1);
    }


}
