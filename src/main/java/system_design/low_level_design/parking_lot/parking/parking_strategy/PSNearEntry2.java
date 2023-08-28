package system_design.low_level_design.parking_lot.parking.parking_strategy;

import system_design.low_level_design.parking_lot.parking.parking_spot.ParkingSpot;

import java.util.List;

public class PSNearEntry2 implements IParkingStrategy {
    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isEmpty())
                return parkingSpot;
        }
        return null;
    }
}
