package system_design.design_patterns.decorator_pattern.pizza_type;

public class Margherita extends BasePizza{

    @Override
    public int cost() {
        return 10;
    }
}
