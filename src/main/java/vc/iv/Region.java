package vc.iv;

public class Region {
    Country country;
    String name;
    int pto;

    Region(String name, int pto, Country country){
        this.name = name;
        this.pto = pto;
        this.country = country;
    }
}
