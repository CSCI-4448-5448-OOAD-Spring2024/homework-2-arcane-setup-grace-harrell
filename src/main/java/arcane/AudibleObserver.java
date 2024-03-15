package arcane;
import java.io.IOException;
import java.util.*;

public class AudibleObserver implements IObserver {

    private final Integer delayInSeconds;

    public AudibleObserver(Integer delay){
        this.delayInSeconds = delay;
    }

    public void update(String eventDescription){
        try{
            sayEvent(eventDescription);
            Thread.sleep(delayInSeconds*1000);
        } catch (InterruptedException | IOException e){
            e.printStackTrace();
        }
    }

    public void sayEvent(String eventDescription) throws IOException {
        String[] cmd = new String[]{"say", eventDescription};
        Runtime.getRuntime().exec(cmd);

        // Possible windows implementation
//        Runtime.getRuntime().exec("nircmd.exe speak text \"" + eventDescription + "\"");
    }

}
