package vc.online;

import java.time.LocalDate;

public class User {
    public int id;
    public String name;
    public LocalDate activatedon;
    public LocalDate deactivatedon;
    public int customerId;

    public User() {
    }

    public User(int id, String name, LocalDate activatedon, LocalDate deactivatedon, int customerId) {
        this.id = id;
        this.name = name;
        this.activatedon = activatedon;
        this.deactivatedon = deactivatedon;
        this.customerId = customerId;
    }
}
