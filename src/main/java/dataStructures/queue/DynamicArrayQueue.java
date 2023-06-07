package dataStructures.queue;

import dataStructures.dynamicArray.DynamicArrayUsingStaticArray;
import java.util.Iterator;

public class DynamicArrayQueue<T> implements QueueOperations<T> {

  private DynamicArrayUsingStaticArray<T> queue;

  public DynamicArrayQueue() {
    this(16);
  }

  public DynamicArrayQueue(int capcity) {
    queue = new DynamicArrayUsingStaticArray<>(capcity);
  }

  //Enqueue
  @Override
  public void offer(T data) {
    queue.add(data);
  }

  //Dequeue
  @Override
  public T poll() {
    if (isEmpty())
      throw new RuntimeException("Empty Queue.");
    return queue.removeAt(0);
  }

  @Override
  public T peek() {
    if (isEmpty())
      throw new RuntimeException("Empty Queue.");
    return queue.get(0);
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
