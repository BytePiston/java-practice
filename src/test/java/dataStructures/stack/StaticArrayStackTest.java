package dataStructures.stack;

import org.junit.jupiter.api.Test;

public class StaticArrayStackTest {

    @Test
    public void testPush(){
        StaticArrayStack<Integer> stack = new StaticArrayStack<>(2);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
    }
}
