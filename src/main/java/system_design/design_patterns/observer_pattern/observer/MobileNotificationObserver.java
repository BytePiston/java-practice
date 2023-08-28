package system_design.design_patterns.observer_pattern.observer;

import system_design.design_patterns.observer_pattern.observable.IStockObservable;

public class MobileNotificationObserver implements INotificationObserver{

    int phoneNo;
    IStockObservable observable;

    public MobileNotificationObserver(int phoneNo, IStockObservable observable){
        this.phoneNo = phoneNo;
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Mobile Notification: New Stock Added!!");
    }
}
