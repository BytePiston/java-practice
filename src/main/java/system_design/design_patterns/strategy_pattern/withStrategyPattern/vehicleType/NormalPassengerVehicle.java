package system_design.design_patterns.strategy_pattern.withStrategyPattern.vehicleType;

import system_design.design_patterns.strategy_pattern.withStrategyPattern.Vehicle;
import system_design.design_patterns.strategy_pattern.withStrategyPattern.drivingStrategy.NormalDrivingStrategy;

public class NormalPassengerVehicle extends Vehicle {
    public NormalPassengerVehicle() {
        super(new NormalDrivingStrategy());
    }
}
