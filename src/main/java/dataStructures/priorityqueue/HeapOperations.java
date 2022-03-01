package dataStructures.priorityqueue;

public interface HeapOperations<T> {
    boolean isEmpty();
    void clear();
    T peek();
    T poll();
    boolean contains(T data);
    void add(T data);
    boolean less(int i, int j);
    void swimUp(int k);
    void sinkDown(int k);
    boolean remove(T data);
    T removeAt(int i);
    boolean isMinHeap(int k);
}
