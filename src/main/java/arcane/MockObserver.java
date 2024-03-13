package arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MockObserver implements IObserver{
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    public List<String> events = new ArrayList<>();

    @Override
    public void update(String eventDescription) {
        events.add(eventDescription);
        logger.info(eventDescription);
    }

    public String getEventDescription(){
        return events.isEmpty() ? null : events.get(events.size() - 1);
    }
}
