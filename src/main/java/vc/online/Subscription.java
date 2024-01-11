package vc.online;

public class Subscription {
    public int id;
    public int customerId;
    public int monthlyPriceInCents;
    public Subscription(int id, int customerId, int monthlyPriceInCents){
        this.id = id;
        this.customerId = customerId;
        this.monthlyPriceInCents = monthlyPriceInCents;
    }
}
