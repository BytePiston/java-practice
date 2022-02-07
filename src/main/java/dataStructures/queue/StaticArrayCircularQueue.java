package dataStructures.queue;

import java.util.Iterator;

public class StaticArrayCircularQueue<T> implements QueueOperations<T> {

    private int front = -1, back = -1;
    private T[] queue;

    public StaticArrayCircularQueue() {
        this(16);
    }

    public StaticArrayCircularQueue(int capacity) {
        queue = (T[]) new Object[capacity];
    }

    @Override
    public void offer(T data) {
        if ((back + 1) % (queue.length) == front)
            throw new RuntimeException("Queue is Full");
        if (front == -1)
            front++;
        queue[++back % (queue.length)] = data;
    }

    @Override
    public T poll() {
        if (isEmpty())
            throw new RuntimeException("Queue Empty");
        T data = queue[front];
        queue[front] = null;
        if (front == back)
            front = back = -1;
        else
            front = ++front % (queue.length);

        return data;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Queue Empty");
        return queue[front];
    }

    @Override
    public int size() {
        return Math.abs((back % queue.length) - (front % queue.length)) + 1;
    }

    @Override
    public boolean isEmpty() {
        return front == -1 && back == -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = front;

            @Override
            public boolean hasNext() {
                return queue[i] != null;
            }

            @Override
            public T next() {
                T data = queue[i];
                i++;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Method not Supported.");
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[ ]";
        else {
            StringBuffer sb = new StringBuffer().append("[ ");
            Iterator<T> iterator = this.iterator();
            while (iterator.hasNext())
                sb.append(iterator.next() + " ");
            return sb.append("]").toString();
        }
    }
}
