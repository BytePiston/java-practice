package system_design.low_level_design.parking_lot.parking.parking_spot;

import lombok.Data;
import system_design.low_level_design.parking_lot.vehicle.Vehicle;

@Data
public class ParkingSpot {

    String id;
    boolean isEmpty = true;
    Vehicle vehicle;

    int price;

    public ParkingSpot(int price){
        this.price = price;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        isEmpty = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        isEmpty = true;
    }
}
