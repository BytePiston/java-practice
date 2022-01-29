package dataStructures.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoublyLinkedListTest {

    @Test
    public void testInsert(){
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addFirst(1);
        dll.add(2);
        dll.addAt(3,3);
        dll.addLast(4);
        assertTrue(dll.toString().equals("[ 1 2 3 4 ]"));
    }

    @Test
    public void testDelete(){
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.removeFirst();
        assertTrue(dll.toString().equals("[ 2 3 4 ]"));
        dll.removeAt(2);
        assertTrue(dll.toString().equals("[ 2 4 ]"));
        dll.removeLast();
        assertTrue(dll.toString().equals("[ 2 ]"));
        dll.remove(2);
        assertTrue(dll.toString().equals("[ ]"));
    }
}
