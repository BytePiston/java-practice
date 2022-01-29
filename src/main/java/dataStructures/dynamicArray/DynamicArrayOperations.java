package dataStructures.dynamicArray;

public interface DynamicArrayOperations<T> extends Iterable<T> {
    void add(T data);
    void addAll(T[] staticArray);
    void set(T data, int index);
    T remove(T data);
    T removeLast();
    T removeAt(int index);
    void clear();
    T get(int index);
    boolean contains(T data);
    int indexOf(T data);
    int getSize();
}
