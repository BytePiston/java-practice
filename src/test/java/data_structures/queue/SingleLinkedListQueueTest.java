package data_structures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SingleLinkedListQueueTest {

  @Test
  public void testQueueOperations() {
    SingleLinkedListQueue<Integer> queue = new SingleLinkedListQueue<>();
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
    SingleLinkedListQueue<String> queue = new SingleLinkedListQueue<>();
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
