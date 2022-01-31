package dataStructures.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleLinkedListTest {

    @Test
    public void testInsert() {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addFirst(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        assertEquals(singleLinkedList.peekFirst(), 1);
        assertEquals(singleLinkedList.peekLast(), 3);
        assertEquals(singleLinkedList.getSize(), 3);
        assertEquals(singleLinkedList.toString(), "[ 1 2 3 ]");
    }

    @Test
    public void testGenerics() {
        SingleLinkedList<String> singleLinkedListStr = new SingleLinkedList<>();
        singleLinkedListStr.addFirst("a");
        singleLinkedListStr.addLast("b");
        singleLinkedListStr.addAt("str", 2);
        singleLinkedListStr.addLast("c");
        singleLinkedListStr.addLast("d");
        singleLinkedListStr.addLast("e");
        assertEquals(singleLinkedListStr.peekFirst(), "a");
        assertEquals(singleLinkedListStr.peekLast(), "e");
        assertEquals(singleLinkedListStr.getSize(), 6);
        assertEquals(singleLinkedListStr.toString(), "[ a str b c d e ]");
    }

    @Test
    public void testRemove() {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addFirst(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        assertEquals(singleLinkedList.getSize(), 3);
        assertEquals(singleLinkedList.removeLast(), 3);
        assertEquals(singleLinkedList.getSize(),2);
        assertEquals(singleLinkedList.toString(), "[ 1 2 ]");
        assertEquals(singleLinkedList.remove(1), 1);
        assertEquals(singleLinkedList.getSize(), 1);
        assertEquals(singleLinkedList.toString(), "[ 2 ]");
    }
}
