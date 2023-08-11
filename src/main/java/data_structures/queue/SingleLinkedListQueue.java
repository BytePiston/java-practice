package data_structures.queue;

import data_structures.linked_list.SingleLinkedList;
import java.util.Iterator;

public class SingleLinkedListQueue<T> implements QueueOperations<T> {

  private SingleLinkedList<T> queue;

  public SingleLinkedListQueue() {
    queue = new SingleLinkedList<>();
  }

  @Override
  public void offer(T data) {
    queue.addLast(data);
  }

  @Override
  public T poll() {
    if (isEmpty())
      throw new RuntimeException("Empty Queue.");
    return queue.removeFirst();
  }

  @Override
  public T peek() {
    if (isEmpty())
      throw new RuntimeException("Empty Queue.");
    return queue.peekFirst();
  }

  @Override
  public int size() {
    return queue.getSize();
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public Iterator<T> iterator() {
    return queue.iterator();
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
