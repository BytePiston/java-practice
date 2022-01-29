package dataStructures.stack;

public interface StackOperations<T> extends Iterable<T> {
    void push(T data);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
