package system_design.design_patterns.decorator_pattern.toppings;

import system_design.design_patterns.decorator_pattern.pizza_type.BasePizza;

public class Mushroom extends ToppingsDecorator {

    BasePizza basePizza;

    public Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+4;
    }
}
