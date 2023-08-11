package data_structures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

public class StaticArrayStack<T> implements StackOperations<T> {

  private int capacity = 0;
  private int top = -1;
  private T[] stack;

  public StaticArrayStack() {
    this(16);
  }

  public StaticArrayStack(int capacity) {
    this.capacity = capacity;
    this.stack = (T[]) new Object[capacity];
  }

  @Override
  public void push(T data) {
    if (top == capacity) {
      throw new StackOverflowError("Stack is full.");
    }
    stack[++top] = data;
  }

  @Override
  public T pop() {
    if (top == -1) {
      throw new EmptyStackException();
    }
    return stack[top--];
  }

  @Override
  public T peek() {
    if (top == -1) {
      throw new EmptyStackException();
    }
    return stack[top];
  }

  @Override
  public boolean isEmpty() {
    return top == -1;
  }

  @Override
  public int size() {
    return top + 1;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int i = 0;

      @Override
      public boolean hasNext() {
        return i < capacity;
      }

      @Override
      public T next() {
        T data = stack[i];
        i++;
        return data;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException("Method Not Supported.");
      }
    };
  }

  @Override
  public String toString() {
    if (isEmpty())
      return "[ ]";
    Iterator<T> iterator = this.iterator();
    StringBuffer sb = new StringBuffer().append("[ ");
    while (iterator.hasNext())
      sb.append(iterator.next() + " ");
    return sb.append("]").toString();
  }
}
