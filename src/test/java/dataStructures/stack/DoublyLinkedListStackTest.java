package dataStructures.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListStackTest {

  @Test
  public void testDynamicPush() {
    DoublyLinkedListStack<Integer> stack = new DoublyLinkedListStack<>();
    stack.push(18);
    stack.push(33);
    assertEquals(stack.size(), 2);
    assertEquals(stack.peek(), 33);
    stack.push(92);
    assertEquals(stack.peek(), 92);
    assertEquals(stack.size(), 3);
    assertEquals(stack.toString(), "[ 18 33 92 ]");
  }

  @Test
  public void testDynamicPop() {
    DoublyLinkedListStack<Integer> stack = new DoublyLinkedListStack<>();
    stack.push(18);
    stack.push(33);
    assertEquals(stack.peek(), 33);
    assertEquals(stack.size(), 2);
    stack.push(92);
    assertEquals(stack.peek(), 92);
    stack.push(30);
    assertEquals(stack.peek(), 30);
    stack.push(57);
    assertEquals(stack.peek(), 57);
    assertEquals(stack.size(), 5);
    assertEquals(stack.toString(), "[ 18 33 92 30 57 ]");
    assertEquals(stack.pop(), 57);
    assertEquals(stack.peek(), 30);
    assertEquals(stack.pop(), 30);
    assertEquals(stack.peek(), 92);
    assertEquals(stack.pop(), 92);
    assertEquals(stack.peek(), 33);
    assertEquals(stack.pop(), 33);
    assertEquals(stack.toString(), "[ 18 ]");
  }


  @Test
  public void testGenerics() {
    DoublyLinkedListStack<String> stack = new DoublyLinkedListStack<>();
    stack.push("apple");
    stack.push("banana");
    assertEquals(stack.peek(), "banana");
    assertEquals(stack.size(), 2);
    assertEquals(stack.pop(), "banana");
    assertEquals(stack.size(), 1);
    assertEquals(stack.toString(), "[ apple ]");
  }
}
