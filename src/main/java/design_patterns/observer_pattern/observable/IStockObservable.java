package design_patterns.observer_pattern.observable;

import design_patterns.observer_pattern.observer.INotificationObserver;

public interface IStockObservable {

    void add(INotificationObserver observer);

    void remove(INotificationObserver observer);

    void notifyObserver();

    void setStock(int stock);

    int getStock();
}
