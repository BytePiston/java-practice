package dataStructures.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoublyLinkedListTest {

    @Test
    public void testInsert(){
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addFirst(1);
        dll.add(2);
        dll.addAt(3,3);
        dll.addLast(4);
        assertEquals(dll.toString(), "[ 1 2 3 4 ]");
    }

    @Test
    public void testDelete(){
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.removeFirst();
        assertEquals(dll.toString(), "[ 2 3 4 ]");
        dll.removeAt(2);
        assertEquals(dll.toString(), "[ 2 4 ]");
        dll.removeLast();
        assertEquals(dll.toString(), "[ 2 ]");
        dll.remove(2);
        assertEquals(dll.toString(), "[ ]");
    }
}
