package dataStructures.queue;

public interface QueueOperations<T> extends Iterable<T> {

    //Enqueue
    public void offer(T data);

    //Dequeue
    public T poll();

    public T peek();

    public int size();

    public boolean isEmpty();
}
