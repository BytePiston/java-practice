package design_patterns.strategy_pattern.withStrategyPattern.vehicleType;

import design_patterns.strategy_pattern.withStrategyPattern.Vehicle;
import design_patterns.strategy_pattern.withStrategyPattern.drivingStrategy.SpecialDrivingStrategy;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SpecialDrivingStrategy());
    }
}
