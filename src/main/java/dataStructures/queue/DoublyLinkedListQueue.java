package dataStructures.queue;

import dataStructures.linkedList.DoublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedListQueue<T> implements QueueOperations<T> {

    private DoublyLinkedList<T> queue;

    public DoublyLinkedListQueue(){
        queue = new DoublyLinkedList<>();
    }

    @Override
    public void offer(T data) {
        queue.addLast(data);
    }

    @Override
    public T poll() {
        if(isEmpty())
            throw new RuntimeException("Empty Queue.");
        return queue.removeFirst();
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new RuntimeException("Empty Queue.");
        return queue.peekFirst();
    }

    @Override
    public int size() {
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
