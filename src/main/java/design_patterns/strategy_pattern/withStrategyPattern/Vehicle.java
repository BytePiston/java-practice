package design_patterns.strategy_pattern.withStrategyPattern;

import design_patterns.strategy_pattern.withStrategyPattern.drivingStrategy.IDrivingStrategy;

public class Vehicle {
    IDrivingStrategy drivingStrategy;

    //Constructor Injection
    public Vehicle(IDrivingStrategy drivingStrategy){
        this.drivingStrategy = drivingStrategy;
    }

    public String drive(){
        return drivingStrategy.drive();
    }
}
