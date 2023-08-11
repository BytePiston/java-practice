package data_structures.stack;

import data_structures.dynamic_array.DynamicArrayUsingStaticArray;
import java.util.EmptyStackException;
import java.util.Iterator;

public class DynamicArrayStack<T> implements StackOperations<T> {

  private int top = -1;
  private DynamicArrayUsingStaticArray<T> stack;


  public DynamicArrayStack() {
    this(16);
  }

  public DynamicArrayStack(int capacity) {
    stack = new DynamicArrayUsingStaticArray<>(capacity);
  }

  @Override
  public void push(T data) {
    stack.add(data);
    top++;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return stack.removeAt(top--);
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return stack.get(top);
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    return stack.getSize();
  }

  @Override
  public Iterator<T> iterator() {
    return stack.iterator();
  }

  @Override
  public String toString() {
    return stack.toString();
  }
}
