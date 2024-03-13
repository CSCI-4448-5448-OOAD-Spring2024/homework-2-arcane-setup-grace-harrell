package arcane;
import java.io.IOException;
import java.util.*;

public class AudibleObserver implements IObserver {
    private final IObservable subject;
    private final List<EventType> eventsOfInterest;
    private final Integer delayInSeconds;
    private boolean isSayEventCalled = false;

    public AudibleObserver(IObservable subject, List<EventType> eventsOfInterest, Integer delay){
        this.subject = subject;
        this.eventsOfInterest = eventsOfInterest;
        this.delayInSeconds = delay;
        subject.registerObserver(this);
    }

    public void update(String eventDescription){
        EventType eventType = EventType.valueOf(eventDescription);
        if (eventsOfInterest.contains(eventType)){
            try{
                sayEvent(eventDescription);
                Thread.sleep(delayInSeconds*1000);
            } catch (InterruptedException | IOException e){
                e.printStackTrace();
            }
        }
    }

    public void sayEvent(String eventDescription) throws IOException {
         isSayEventCalled = true;
//        if (isMac()){
//            cmd = new String[]{"say", eventDescription};
//        }
//        else{
//            cmd = new String[]{"path to nircmd.exe", "say text \"" + eventDescription + "\""};
//        }
        String[] cmd = new String[]{"say", eventDescription};
        Runtime.getRuntime().exec(cmd);
    }
//    private boolean isMac(){
//        String os = System.getProperty("os.name").toLowerCase();
//        return os.contains("mac");
//    }
    public boolean isSayEventCalled(){
        return isSayEventCalled;
    }
}
