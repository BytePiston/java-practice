package system_design.design_patterns.observer_pattern;

import system_design.design_patterns.observer_pattern.observable.IStockObservable;
import system_design.design_patterns.observer_pattern.observable.LaptopStockObservable;
import system_design.design_patterns.observer_pattern.observable.PhoneStockObservable;
import system_design.design_patterns.observer_pattern.observer.EmailNotificationObserver;
import system_design.design_patterns.observer_pattern.observer.INotificationObserver;
import system_design.design_patterns.observer_pattern.observer.MobileNotificationObserver;

public class Store {

    public static void main(String[] args) {
        IStockObservable laptopObservable = new LaptopStockObservable();
        IStockObservable phoneObservable = new PhoneStockObservable();

        INotificationObserver observer = new EmailNotificationObserver("xyz", laptopObservable);
        INotificationObserver observer1 = new MobileNotificationObserver(123, phoneObservable);
        INotificationObserver observer2 = new MobileNotificationObserver(123, phoneObservable);
        laptopObservable.add(observer);
        phoneObservable.add(observer1);
        laptopObservable.add(observer2);

        laptopObservable.setStock(5);
        System.out.println(laptopObservable.getStock());
        laptopObservable.setStock(15);
        System.out.println(laptopObservable.getStock());
        phoneObservable.setStock(12);
        System.out.println(phoneObservable.getStock());
        phoneObservable.setStock(1);
        System.out.println(phoneObservable.getStock());
    }
}
