package vc.iv;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Country c1 = new Country("C1", 50);
        Country c2 = new Country("C2", 0);
        Country c3 = new Country("C3", 20);


        Region r1 = new Region("R1", 0, c1);
        Region r2 = new Region("R2", 10, c2);
        Region r3 = new Region("R3", 30, c3);

        Cities colorado = new Cities("colorado", 0, r1);
        Cities newYork = new Cities("newYork", 1, r2);
        Cities xyz = new Cities("xyz", 0, r3);

        List<Cities> cities  = new ArrayList<>();
        cities.add(colorado);
        cities.add(newYork);
        cities.add(xyz);

        cities.sort((o1, o2) -> o1.pto - o2.pto);
        System.out.println(cities.size());
    }
    
    
}
