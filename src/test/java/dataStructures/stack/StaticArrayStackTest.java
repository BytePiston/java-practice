package dataStructures.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticArrayStackTest {

    @Test
    public void testPush(){
        StaticArrayStack<Integer> stack = new StaticArrayStack<>(2);
        stack.push(1);
        stack.push(2);
        assertEquals(stack.peek(), 2);
        assertEquals(stack.size(), 2);
        assertEquals(stack.toString(), "[ 1 2 ]");
    }

    @Test
    public void testPop(){
        StaticArrayStack<Integer> stack = new StaticArrayStack<>(2);
        stack.push(1);
        stack.push(2);
        assertEquals(stack.size(), 2);
        assertEquals(stack.peek(), 2);
        assertEquals(stack.pop(), 2);
        assertEquals(stack.size(), 1);
        assertEquals(stack.peek(), 1);
        assertEquals(stack.pop(), 1);
        assertEquals(stack.size(), 0);
        assertEquals(stack.toString(), "[ ]");
    }

    @Test
    public void testGenerics(){
        StaticArrayStack<String> stack = new StaticArrayStack<>(2);
        stack.push("apple");
        stack.push("banana");
        assertEquals(stack.peek(), "banana");
        assertEquals(stack.size(), 2);
        assertEquals(stack.toString(), "[ apple banana ]");
    }
}
