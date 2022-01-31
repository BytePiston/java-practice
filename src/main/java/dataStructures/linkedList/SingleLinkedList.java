package dataStructures.linkedList;

import java.util.Iterator;


public class SingleLinkedList<T> implements LinkedListOperations<T> {

    private int size = 0;
    private Node<T> headNode = null;
    private Node<T> tailNode = null;

    private static class Node<T> {
        private T data;
        private Node<T> nextNode;

        public Node(T data, Node<T> nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }

    @Override
    public void add(T data) {
        addLast(data);
    }

    @Override
    public void addLast(T data) {
        if (isEmpty())
            addFirst(data);
        else {
            tailNode.nextNode = new Node<>(data, null);
            tailNode = tailNode.nextNode;
            size++;
        }
    }

    @Override
    public void addFirst(T data) {
        if (isEmpty())
            headNode = tailNode = new Node<>(data, null);
        else
            headNode = new Node<>(data, headNode);
        size++;
    }

    @Override
    public void addAt(T data, int index) {
        if (index > size + 1 || index < 0)
            throw new IllegalArgumentException("Invalid index.");
        if (isEmpty())
            addFirst(data);
        if (index == size + 1)
            addLast(data);
        else {
            Node<T> node = headNode;
            for (int i = 0; i < index - 2; i++) {
                node = node.nextNode;
            }
            Node<T> newNode = new Node<>(data, node.nextNode);
            node.nextNode = newNode;
            size++;
        }
    }

    @Override
    public T remove(T data) {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");
        if (headNode != null && headNode.data.equals(data))
            return removeFirst();
        if (tailNode != null && tailNode.data.equals(data))
            return removeLast();
        Node<T> node = headNode;
        for (int i = 0; i < size; i++) {
            if (node.nextNode != null && node.nextNode.data.equals(data)) {
                return remove(node, node.nextNode);
            }
            node = node.nextNode;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");
        if (headNode.equals(tailNode))
            return removeFirst();
        Node<T> node = headNode;
        for (int i = 0; i < size - 2; i++)
            node = node.nextNode;
        return remove(node, node.nextNode);
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");
        Node<T> node = headNode;
        T data = node.data;
        if (headNode.equals(tailNode))
            headNode = tailNode = null;
        else
            headNode = headNode.nextNode;
        node.data = null;
        node.nextNode = null;
        --size;
        return data;
    }

    @Override
    public T removeAt(int index) {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");
        if (index > size || index < 0)
            throw new IllegalArgumentException("Invalid index.");
        if (index == 1)
            removeFirst();
        if (index == size)
            removeLast();
        Node<T> node = headNode;
        for (int i = 0; i < index - 2; i++)
            node = node.nextNode;
        return remove(node, node.nextNode);
    }

    @Override
    public T peekFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");
        return headNode != null && headNode.data != null ? headNode.data : null;
    }

    @Override
    public T peekLast() {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");
        return tailNode != null && tailNode.data != null ? tailNode.data : null;
    }

    @Override
    public T get(int index) {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List.");
        if(index == 0)
            return headNode.data;
        if(index == getSize())
            return tailNode.data;
        Node<T> node = headNode;
        for(int i=0; i<index-1; i++)
            node = node.nextNode;
        return node.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = headNode;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T data = node.data;
                node = node.nextNode;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Method not supported.");
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[ ]";
        StringBuffer sb = new StringBuffer().append("[ ");
        Node<T> node = headNode;
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next() + " ");
            node = node.nextNode;
        }
        return sb.append("]").toString();
    }

    private boolean isEmpty() {
        return getSize() == 0;
    }

    private T remove(Node<T> node, Node<T> removeNode) {
        T data = removeNode.data;
        if (removeNode.nextNode == null) {
            tailNode = node;
            tailNode.nextNode = null;
        } else
            node.nextNode = removeNode.nextNode;
        removeNode.data = null;
        --size;
        return data;
    }
}
