package dataStructures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StaticArrayCircularQueueTest {

  @Test
  public void testQueueOperations() {
    StaticArrayCircularQueue<Integer> queue = new StaticArrayCircularQueue<>(3);
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    assertEquals(queue.size(), 3);
    assertEquals(queue.peek(), 1);
    assertEquals(queue.poll(), 1);
    assertEquals(queue.size(), 2);
    assertEquals(queue.peek(), 2);
    assertEquals(queue.poll(), 2);
    queue.offer(4);
    assertEquals(queue.peek(), 3);
    assertEquals(queue.poll(), 3);
    assertEquals(queue.peek(), 4);
    assertEquals(queue.size(), 1);
  }

  @Test
  public void testGenericsQueueOperations() {
    StaticArrayCircularQueue<String> queue = new StaticArrayCircularQueue<>();
    queue.offer("apple");
    queue.offer("banana");
    queue.offer("orange");
    assertEquals(queue.peek(), "apple");
    assertEquals(queue.size(), 3);
    assertEquals(queue.poll(), "apple");
    assertEquals(queue.size(), 2);
    assertEquals(queue.peek(), "banana");
    assertEquals(queue.poll(), "banana");
    queue.offer("grapes");
    assertEquals(queue.peek(), "orange");
    assertEquals(queue.poll(), "orange");
    assertEquals(queue.peek(), "grapes");
  }
}
