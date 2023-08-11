package design_patterns.strategy_pattern.withStrategyPattern.vehicleType;

import design_patterns.strategy_pattern.withStrategyPattern.Vehicle;
import design_patterns.strategy_pattern.withStrategyPattern.drivingStrategy.SpecialDrivingStrategy;

public class SportsVehicle extends Vehicle {
    public SportsVehicle(){
        super(new SpecialDrivingStrategy());
    }
}
