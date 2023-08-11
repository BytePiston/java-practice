package design_patterns.decorator_pattern.toppings;

import design_patterns.decorator_pattern.pizza_type.BasePizza;

public class Bacon extends ToppingsDecorator {

    BasePizza basePizza;

    public Bacon(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 3;
    }
}
