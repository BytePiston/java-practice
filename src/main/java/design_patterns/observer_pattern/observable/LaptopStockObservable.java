package design_patterns.observer_pattern.observable;

import design_patterns.observer_pattern.observer.INotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class LaptopStockObservable implements IStockObservable {

    int stock = 0;

    List<INotificationObserver> observers = new ArrayList<>();

    @Override
    public void add(INotificationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(INotificationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(INotificationObserver observer: observers)
            observer.update();
    }

    @Override
    public void setStock(int quantity) {
        if(this.stock == 0)
            notifyObserver();
        this.stock += quantity;
    }

    @Override
    public int getStock() {
        return stock;
    }
}
