package arcane;

import org.junit.jupiter.api.Test;

public class EventBusTest {
    @Test
    void testMessageBus(){
        EventBus eventBus = EventBus.getInstance();
        MockObserver observer = new MockObserver();

        eventBus.attach(observer,EventType.GameStart);
        eventBus.postMessage(EventType.GameStart, "ARCANE has started");

        assert(observer.events.size() == 1);
    }
}
