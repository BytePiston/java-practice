package system_design.design_patterns.observer_pattern.observer;

import system_design.design_patterns.observer_pattern.observable.IStockObservable;

public class EmailNotificationObserver implements INotificationObserver {

    String emailId;
    IStockObservable observable;

    public EmailNotificationObserver(String emailId, IStockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Email Notification: New Stock Added!!");
    }
}
