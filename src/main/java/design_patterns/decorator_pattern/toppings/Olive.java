package design_patterns.decorator_pattern.toppings;

import design_patterns.decorator_pattern.pizza_type.BasePizza;

public class Olive extends ToppingsDecorator {

    BasePizza basePizza;

    public Olive(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 2;
    }
}
