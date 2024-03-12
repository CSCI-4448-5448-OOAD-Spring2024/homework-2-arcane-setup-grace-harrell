package arcane;

import java.util.*;

public class MockObservable implements IObservable {
    private List<IObserver> observers = new ArrayList<>();
    @Override
    public void registerObserver(IObserver observer){
        observers.add(observer);
    }
    @Override
    public void removeObserver(IObserver observer){
        observers.remove(observer);
    }
    @Override
    public void notifyObservers(String eventDescription){
        for (IObserver observer : observers){
            observer.update(eventDescription);
        }
    }
}
