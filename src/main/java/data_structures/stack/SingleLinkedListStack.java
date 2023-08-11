package data_structures.stack;

import data_structures.linked_list.SingleLinkedList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class SingleLinkedListStack<T> implements StackOperations<T> {

  private SingleLinkedList<T> stack;

  public SingleLinkedListStack() {
    stack = new SingleLinkedList<>();
  }

  @Override
  public void push(T data) {
    stack.addLast(data);
  }

  @Override
  public T pop() {
    if (isEmpty())
      throw new EmptyStackException();
    return stack.removeLast();
  }

  @Override
  public T peek() {
    if (isEmpty())
      throw new EmptyStackException();
    return stack.peekLast();
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
