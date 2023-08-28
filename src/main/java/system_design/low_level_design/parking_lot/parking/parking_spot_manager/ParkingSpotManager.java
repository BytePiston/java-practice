package system_design.low_level_design.parking_lot.parking.parking_spot_manager;

import system_design.low_level_design.parking_lot.parking.parking_spot.ParkingSpot;
import system_design.low_level_design.parking_lot.parking.parking_strategy.IParkingStrategy;
import system_design.low_level_design.parking_lot.vehicle.Vehicle;

import java.util.List;

public class ParkingSpotManager {

    List<ParkingSpot> parkingSpots;
    IParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots, IParkingStrategy parkingStrategy) {
        this.parkingSpots = parkingSpots;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingSpot findParkingSpot() {
        return parkingStrategy.findParkingSpot(parkingSpots);
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.remove(parkingSpot);
    }

    public void parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = findParkingSpot();
        parkingSpot.parkVehicle(vehicle);
    }

    public void removeVehicle(ParkingSpot parkingSpot) {
        parkingSpot.removeVehicle();
    }
}
