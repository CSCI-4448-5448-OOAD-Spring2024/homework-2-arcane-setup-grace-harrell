package arcane;

import org.junit.jupiter.api.Test;

public class EventBusTest {
    @Test
    void testMessageBus(){
        EventBus eventBus = EventBus.getInstance();
        MockObserver observer = new MockObserver();
    }
}
