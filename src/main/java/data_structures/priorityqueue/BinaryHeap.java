package data_structures.priorityqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> implements HeapOperations<T> {

  List<T> heap;

  public BinaryHeap() {
    this(1);
  }

  public BinaryHeap(int capacity) {
    heap = new ArrayList<>(capacity);
  }

  public BinaryHeap(T[] array) {
    heap = new ArrayList<>(array.length);
    for (T t : array)
      heap.add(t);
    for (int i = Math.max(0, heap.size() / 2 - 1); i >= 0; i--)
      sinkDown(i);
  }

  public BinaryHeap(Collection<T> collection) {
    heap = new ArrayList<>(collection);
    for (int i = Math.max(0, heap.size() / 2 - 1); i >= 0; i--)
      sinkDown(i);
  }

  @Override
  public boolean isEmpty() {
    return heap.size() == 0;
  }

  @Override
  public void clear() {
    heap.clear();
  }

  @Override
  public T peek() {
    if (isEmpty())
      return null;
    return heap.get(0);
  }

  @Override
  public T poll() {
    return removeAt(0);
  }

  @Override
  public boolean contains(T data) {
    for (T t : heap)
      if (t.equals(data))
        return true;
    return false;
  }

  @Override
  public void add(T data) {
    if (data == null)
      throw new IllegalArgumentException();
    heap.add(data);
    swimUp(heap.size() - 1);
  }

  @Override
  public boolean less(int i, int j) {
    return heap.get(i).compareTo(heap.get(j)) <= 0;
  }

  @Override
  public void swimUp(int k) {

  }

  @Override
  public void sinkDown(int k) {

  }

  @Override
  public boolean remove(T data) {
    for (int i = 0; i < heap.size(); i++) {
      if (heap.get(i).equals(data)) {
        removeAt(i);
        return true;
      }
    }
    return false;
  }

  @Override
  public T removeAt(int i) {
    if (isEmpty())
      return null;
    return null;
  }

  @Override
  public boolean isMinHeap(int k) {
    return false;
  }

}
