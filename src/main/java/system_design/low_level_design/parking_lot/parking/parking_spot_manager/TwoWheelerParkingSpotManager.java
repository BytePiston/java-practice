package system_design.low_level_design.parking_lot.parking.parking_spot_manager;

import system_design.low_level_design.parking_lot.parking.parking_spot.ParkingSpot;
import system_design.low_level_design.parking_lot.parking.parking_strategy.PSNearEntry1;

import java.util.ArrayList;
import java.util.List;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager {
    public TwoWheelerParkingSpotManager(List<ParkingSpot> parkingSpots) {
        super(new ArrayList<>(50), new PSNearEntry1());
    }
}
