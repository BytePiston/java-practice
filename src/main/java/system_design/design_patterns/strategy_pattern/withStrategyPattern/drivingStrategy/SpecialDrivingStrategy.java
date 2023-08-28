package system_design.design_patterns.strategy_pattern.withStrategyPattern.drivingStrategy;

public class SpecialDrivingStrategy implements IDrivingStrategy{
    @Override
    public String drive() {
        return "Special Driving Capability!!";
    }
}
