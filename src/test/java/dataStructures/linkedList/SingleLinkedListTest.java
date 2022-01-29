package dataStructures.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleLinkedListTest {

    @Test
    public void testInsert() {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addFirst(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        assertTrue(singleLinkedList.peekFirst().equals(1));
        assertTrue(singleLinkedList.peekLast().equals(3));
        assertTrue(singleLinkedList.getSize() == (3));
        assertTrue(singleLinkedList.toString().equals("[ 1 2 3 ]"));
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
        assertTrue(singleLinkedListStr.peekFirst().equals("a"));
        assertTrue(singleLinkedListStr.peekLast().equals("e"));
        assertTrue(singleLinkedListStr.getSize() == (6));
        assertTrue(singleLinkedListStr.toString().equals("[ a str b c d e ]"));
    }

    @Test
    public void testRemove() {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addFirst(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        assertTrue(singleLinkedList.getSize() == (3));
        assertTrue(singleLinkedList.removeLast().equals(3));
        assertTrue(singleLinkedList.getSize() == (2));
        assertTrue(singleLinkedList.toString().equals("[ 1 2 ]"));
        assertTrue(singleLinkedList.remove(1).equals(1));
        assertTrue(singleLinkedList.getSize() == (1));
        assertTrue(singleLinkedList.toString().equals("[ 2 ]"));
    }
}
