package dataStructures.linkedList;

public interface LinkedListOperations<T> extends Iterable<T> {
    void add(T data);
    void addLast(T data);
    void addFirst(T data);
    void addAt(T data, int index);
    T remove(T data);
    T removeLast();
    T removeFirst();
    T removeAt (int index);
    T peekFirst();
    T peekLast();
    T get(int index);
    int getSize();
}