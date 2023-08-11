package design_patterns.strategy_pattern.withStrategyPattern.drivingStrategy;

public class NormalDrivingStrategy implements IDrivingStrategy {
    @Override
    public String drive() {
        return "Normal Driving Capability!!";
    }
}
