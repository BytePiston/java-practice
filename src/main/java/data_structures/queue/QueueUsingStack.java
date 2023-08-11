package data_structures.queue;

import data_structures.stack.DynamicArrayStack;
import java.util.Iterator;

public class QueueUsingStack<T> implements QueueOperations<T> {

  private DynamicArrayStack<T> stack;
  private DynamicArrayStack<T> auxStack;

  public QueueUsingStack() {
    this(16);
  }

  public QueueUsingStack(int capacity) {
    stack = new DynamicArrayStack<>(capacity);
    auxStack = new DynamicArrayStack<>(capacity);
  }

  @Override
  public void offer(T data) {
    if (auxStack != null && !auxStack.isEmpty())
      copyStack(stack, auxStack, auxStack.size());
    stack.push(data);
  }

  @Override
  public T poll() {
    if (auxStack != null && !auxStack.isEmpty())
      return auxStack.pop();
    copyStack(auxStack, stack, stack.size() - 1);
    return stack.pop();
  }

  @Override
  public T peek() {
    if (auxStack != null && !auxStack.isEmpty())
      return auxStack.peek();
    copyStack(auxStack, stack, stack.size());
    return auxStack.peek();
  }

  @Override
  public int size() {
    if (auxStack != null && !auxStack.isEmpty())
      return auxStack.size();
    return stack.size();
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public Iterator<T> iterator() {
    return stack.iterator();
  }

  @Override
  public String toString() {
    return stack.toString();
  }

  private void copyStack(DynamicArrayStack<T> stack, DynamicArrayStack<T> auxStack, int size) {
    for (int i = 0; i < size; i++)
      stack.push(auxStack.pop());
  }
}
