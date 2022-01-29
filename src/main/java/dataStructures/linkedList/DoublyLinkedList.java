package dataStructures.linkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements LinkedListOperations<T> {

    private int size = 0;
    private Node<T> headNode = null;
    private Node<T> tailNode = null;

    static class Node<T> {
        private T data;
        private Node<T> prevNode;
        private Node<T> nextNode;

        public Node(T data, Node<T> prevNode, Node<T> nextNode) {
            this.data = data;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
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

    private boolean isEmpty() {
        return this.size == 0;
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
            tailNode.nextNode = new Node<>(data, tailNode, null);
            tailNode = tailNode.nextNode;
            size++;
        }
    }

    @Override
    public void addFirst(T data) {
        if (isEmpty())
            headNode = tailNode = new Node<>(data, null, null);
        else {
            headNode.prevNode = new Node<>(data, null, headNode);
            headNode = headNode.prevNode;
        }
        size++;
    }

    @Override
    public void addAt(T data, int index) {
        if (index < 0 || index > size + 1) {
            throw new IllegalArgumentException("Illegal Index.");
        }
        if (index == size + 1) {
            addLast(data);
        } else {
            Node<T> node = headNode;
            for (int i = 0; i < index - 2; i++) {
                node = node.nextNode;
            }
            Node<T> newNode = new Node<>(data, node, node.nextNode);
            node.nextNode.prevNode = newNode;
            node.nextNode = newNode;
            size++;
        }
    }

    @Override
    public T remove(T data) {
        if (isEmpty()) {
            throw new RuntimeException("Empty Linked List");
        }
        Node<T> node = headNode;
        boolean isPresent = false;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(data))
                return remove(node);
            node = node.nextNode;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Linked List");
        }
        T data;
        if (headNode.equals(tailNode)) {
            data = tailNode.data;
            headNode = tailNode = null;
        } else {
            data = tailNode.data;
            tailNode = tailNode.prevNode;
            tailNode.nextNode = null;
        }
        --size;
        return data;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Linked List");
        }
        T data;
        if (headNode.equals(tailNode)) {
            data = headNode.data;
            headNode = tailNode = null;
        } else {
            data = headNode.data;
            headNode = headNode.nextNode;
            headNode.prevNode = null;
        }
        --size;
        return data;
    }

    @Override
    public T removeAt(int index) {
        if (isEmpty())
            throw new RuntimeException("Empty Linked List");
        if (index > size || index < 0)
            throw new IllegalArgumentException("Invalid index.");
        if (index == 1)
            removeFirst();
        if (index == size)
            removeLast();
        Node<T> node = headNode;
        int mid = (int) Math.floor((size + 1) / 2);
        if (index < mid) {
            for (int i = 0; i < index; i++) {
                node = node.nextNode;
            }
        } else {
            for (int i = mid - 1; i < index; i++) {
                node = node.nextNode;
            }
        }
        return remove(node);
    }

    private T remove(Node<T> node) {
        if (node == null) {
            throw new NullPointerException("Null node");
        }

        if (node.nextNode == null) {
            return removeLast();
        }
        if (node.prevNode == null) {
            return removeFirst();
        }
        node.prevNode.nextNode = node.nextNode;
        node.nextNode.prevNode = node.prevNode;
        T nodeData = node.data;
        --size;
        return nodeData;
    }

    @Override
    public T peekFirst() {
        return headNode != null ? headNode.data : null;
    }

    @Override
    public T peekLast() {
        return tailNode != null ? tailNode.data : null;
    }

    @Override
    public void printList() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }
        Iterator<T> iterator = this.iterator();
        StringBuffer sb = new StringBuffer().append("[ ");
        while (iterator.hasNext()) {
            sb.append(iterator.next() + " ");
        }
        return sb.append("]").toString();
    }
}
