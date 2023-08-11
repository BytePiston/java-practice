package design_patterns.decorator_pattern;

import design_patterns.decorator_pattern.pizza_type.BasePizza;
import design_patterns.decorator_pattern.pizza_type.Pepperoni;
import design_patterns.decorator_pattern.toppings.Bacon;
import design_patterns.decorator_pattern.toppings.ExtraCheese;
import design_patterns.decorator_pattern.toppings.Mushroom;
import design_patterns.decorator_pattern.toppings.Olive;

public class PizzaShop {

    public static void main(String[] args) {
        BasePizza pizza = new ExtraCheese(new Bacon(new ExtraCheese(new Olive(new Mushroom(new Pepperoni())))));
        System.out.println("Total pizza cost: "+ pizza.cost());
    }
}
