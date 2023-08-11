package design_patterns.strategy_pattern.withStrategyPattern;

import design_patterns.strategy_pattern.withStrategyPattern.vehicleType.NormalPassengerVehicle;
import design_patterns.strategy_pattern.withStrategyPattern.vehicleType.OffRoadVehicle;
import design_patterns.strategy_pattern.withStrategyPattern.vehicleType.SportsVehicle;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle normal = new NormalPassengerVehicle();
        Vehicle offRoad = new OffRoadVehicle();
        Vehicle sports = new SportsVehicle();
        System.out.println("Normal Vehicle: " + normal.drive());
        System.out.println("OffRoad Vehicle: " + offRoad.drive());
        System.out.println("Sports Vehicle: " + sports.drive());
    }
}
