package dataStructures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QueueUsingStackTest {

  @Test
  public void testQueueOperations() {
    QueueUsingStack<Integer> queue = new QueueUsingStack<>(2);
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    assertEquals(queue.size(), 3);
    assertEquals(queue.peek(), 1);
    assertEquals(queue.poll(), 1);
    assertEquals(queue.size(), 2);
    assertEquals(queue.peek(), 2);
  }

  @Test
  public void testGenericsQueueOperations() {
    QueueUsingStack<String> queue = new QueueUsingStack<>();
    queue.offer("apple");
    queue.offer("banana");
    queue.offer("orange");
    assertEquals(queue.peek(), "apple");
    assertEquals(queue.size(), 3);
    assertEquals(queue.poll(), "apple");
    assertEquals(queue.size(), 2);
    assertEquals(queue.peek(), "banana");
  }
}
