package design_patterns.strategy_pattern.withoutStrategyPattern;

public class OffRoadVehicle extends Vehicle{

    /*TODO:Uses special driving capability functionality so we need to Override drive() method;
        Code is duplicated in other class wherever same fun is required since it is not coming from parent class.
    */
    @Override
    public void drive(){
        System.out.println("Special Driving Capability!!");
    }
}
