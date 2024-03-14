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

}
