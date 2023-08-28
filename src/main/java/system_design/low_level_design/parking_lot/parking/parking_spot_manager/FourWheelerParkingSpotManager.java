package system_design.low_level_design.parking_lot.parking.parking_spot_manager;

import system_design.low_level_design.parking_lot.parking.parking_strategy.PSNearEntry2;

import java.util.ArrayList;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{
    public FourWheelerParkingSpotManager() {
        super(new ArrayList<>(200), new PSNearEntry2());
    }
}
