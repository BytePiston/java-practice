package system_design.design_patterns.strategy_pattern.withStrategyPattern.vehicleType;

import system_design.design_patterns.strategy_pattern.withStrategyPattern.Vehicle;
import system_design.design_patterns.strategy_pattern.withStrategyPattern.drivingStrategy.SpecialDrivingStrategy;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SpecialDrivingStrategy());
    }
}
