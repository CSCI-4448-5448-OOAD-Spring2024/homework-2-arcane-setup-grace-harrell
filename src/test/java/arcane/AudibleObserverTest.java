package arcane;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class AudibleObserverTest {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    @Test
    public void testAudibleObserver(){
        EventBus eventBus = EventBus.getInstance();
        MockObserver observer = new MockObserver();
        AudibleObserver audibleObserver = new AudibleObserver(3);

        eventBus.attach(observer, EventType.TurnEnded);
        eventBus.attach(audibleObserver, EventType.TurnEnded);

        // Simulate an adventurer eating food
        eventBus.postMessage(EventType.TurnEnded, "Turn 1 has ended");
        assertEquals("Turn 1 has ended", observer.getEventDescription());
    }
}