package dataStructures.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArrayStackTest {

    @Test
    public void testDynamicPush(){
        DynamicArrayStack<Integer> dynamicArrayStack = new DynamicArrayStack<>(2);
        dynamicArrayStack.push(18);
        dynamicArrayStack.push(33);
        assertEquals(dynamicArrayStack.size(), 2);
        assertEquals(dynamicArrayStack.peek(), 33);
        dynamicArrayStack.push(92);
        assertEquals(dynamicArrayStack.peek(), 92);
        assertEquals(dynamicArrayStack.size(), 3);
        assertEquals(dynamicArrayStack.toString(), "[ 18 33 92 ]");
    }

    @Test
    public void testDynamicPop(){
        DynamicArrayStack<Integer> dynamicArrayStack = new DynamicArrayStack<>(2);
        dynamicArrayStack.push(18);
        dynamicArrayStack.push(33);
        assertEquals(dynamicArrayStack.peek(), 33);
        assertEquals(dynamicArrayStack.size(), 2);
        dynamicArrayStack.push(92);
        assertEquals(dynamicArrayStack.peek(), 92);
        dynamicArrayStack.push(30);
        assertEquals(dynamicArrayStack.peek(), 30);
        dynamicArrayStack.push(57);
        assertEquals(dynamicArrayStack.peek(), 57);
        assertEquals(dynamicArrayStack.size(), 5);
        assertEquals(dynamicArrayStack.toString(), "[ 18 33 92 30 57 ]");
        assertEquals(dynamicArrayStack.pop(), 57);
        assertEquals(dynamicArrayStack.peek(), 30);
        assertEquals(dynamicArrayStack.pop(), 30);
        assertEquals(dynamicArrayStack.peek(), 92);
        assertEquals(dynamicArrayStack.pop(), 92);
        assertEquals(dynamicArrayStack.peek(), 33);
        assertEquals(dynamicArrayStack.pop(), 33);
        assertEquals(dynamicArrayStack.toString(), "[ 18 ]");
    }


    @Test
    public void testGenerics(){
        DynamicArrayStack<String> stack = new DynamicArrayStack<>();
        stack.push("apple");
        stack.push("banana");
        assertEquals( stack.pop(), "banana");
        assertEquals( stack.toString(), "[ apple ]");
    }
}
