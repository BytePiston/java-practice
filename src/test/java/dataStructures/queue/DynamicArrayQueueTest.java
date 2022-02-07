package dataStructures.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArrayQueueTest {

    @Test
    public void testQueueOperations(){
        DynamicArrayQueue<Integer> queue = new DynamicArrayQueue<>();
        queue.offer(1);
        queue.offer(2);
        assertEquals(queue.peek(), 1);
        assertEquals(queue.size(), 2);
        assertEquals(queue.poll(), 1);
        assertEquals(queue.size(), 1);
        assertEquals(queue.peek(), 2);
    }

    @Test
    public void testGenericsQueueOperations() {
        DynamicArrayQueue<String> queue = new DynamicArrayQueue<>(1);
        queue.offer("apple");
        queue.offer("banana");
        assertEquals(queue.peek(), "apple");
        assertEquals(queue.size(), 2);
        assertEquals(queue.poll(), "apple");
        assertEquals(queue.size(), 1);
        assertEquals(queue.peek(), "banana");
    }
}
