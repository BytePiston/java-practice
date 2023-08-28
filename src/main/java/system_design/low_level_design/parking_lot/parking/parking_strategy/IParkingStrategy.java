package system_design.low_level_design.parking_lot.parking.parking_strategy;

import system_design.low_level_design.parking_lot.parking.parking_spot.ParkingSpot;

import java.util.List;

public interface IParkingStrategy {
    ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots);
}
