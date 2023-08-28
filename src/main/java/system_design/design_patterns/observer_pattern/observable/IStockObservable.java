package system_design.design_patterns.observer_pattern.observable;

import system_design.design_patterns.observer_pattern.observer.INotificationObserver;

public interface IStockObservable {

    void add(INotificationObserver observer);

    void remove(INotificationObserver observer);

    void notifyObserver();

    void setStock(int stock);

    int getStock();
}
