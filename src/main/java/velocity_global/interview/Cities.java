package velocity_global.interview;

import java.util.Comparator;

public class Cities {

    String name;
    Region region;
    int pto;

    Cities(String name, int pto, Region region){
        this.name = name;
        this.region = region;
        if(pto>0) {
            this.pto = pto;
        } else{
            this.pto = this.region.pto>0 ? this.region.pto : this.region.country.pto;
        }
    }
}
