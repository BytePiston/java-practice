package design_patterns.strategy_pattern.withStrategyPattern.vehicleType;

import design_patterns.strategy_pattern.withStrategyPattern.Vehicle;
import design_patterns.strategy_pattern.withStrategyPattern.drivingStrategy.NormalDrivingStrategy;

public class NormalPassengerVehicle extends Vehicle {
    public NormalPassengerVehicle() {
        super(new NormalDrivingStrategy());
    }
}
