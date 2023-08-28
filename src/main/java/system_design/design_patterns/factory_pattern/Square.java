package system_design.design_patterns.factory_pattern;

public class Square implements IShape {
    @Override
    public void draw() {
        System.out.println("Inside Shape Square!!");
    }
}
