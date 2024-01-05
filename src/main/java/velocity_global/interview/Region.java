package velocity_global.interview;

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
