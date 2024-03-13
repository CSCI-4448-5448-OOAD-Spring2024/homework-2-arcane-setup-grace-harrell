package arcane;
import java.util.*;
public interface IObservable {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers(String eventDescription);
}
