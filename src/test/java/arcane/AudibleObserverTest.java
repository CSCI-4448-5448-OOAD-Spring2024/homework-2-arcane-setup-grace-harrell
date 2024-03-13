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
        MockObservable mockObservable = new MockObservable();
        AudibleObserver audibleObserver = new AudibleObserver(mockObservable, List.of(EventType.Death), 1);

        mockObservable.registerObserver(audibleObserver);

        mockObservable.notifyObservers(EventType.Death.name());

        assertTrue(audibleObserver.isSayEventCalled());
    }
}