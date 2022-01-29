package dataStructures.dynamicArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class DynamicArrayUsingStaticArrayTest {

    @Test
    public void testAddInitialSize(){
        DynamicArrayUsingStaticArray<Integer> dynamicArray = new DynamicArrayUsingStaticArray<>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        assertTrue(dynamicArray.toString().equals("[ 1 2 ]"));
    }

    @Test
    public void testAddGenerics(){
        DynamicArrayUsingStaticArray<String> dynamicArray = new DynamicArrayUsingStaticArray<>();
        dynamicArray.add("apple");
        dynamicArray.add("banana");
        assertTrue(dynamicArray.toString().equals("[ apple banana ]"));
    }

    @Test
    public void testAddDynamicSize(){
        DynamicArrayUsingStaticArray<Integer> dynamicArray = new DynamicArrayUsingStaticArray<>(3);
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        assertTrue(dynamicArray.toString().equals("[ 1 2 3 4 5 ]"));
        assertTrue(dynamicArray.removeLast().equals(5));
        assertTrue(dynamicArray.getSize() == 4 );
        assertTrue(dynamicArray.remove(1).equals(1));
        assertTrue(dynamicArray.getSize() == 3 );
        assertTrue(dynamicArray.toString().equals("[ 2 3 4 ]"));
    }

    @Test
    public void testStaticToDynamicArray(){
        Integer[] staticArray = new Integer[]{1,2,3};
        DynamicArrayUsingStaticArray<Integer> dynamicArray = new DynamicArrayUsingStaticArray<>(staticArray.length);
        dynamicArray.addAll(staticArray);
        assertTrue(dynamicArray.getSize() == 3 );
        assertTrue(dynamicArray.toString().equals("[ 1 2 3 ]"));
        dynamicArray.add(4);
        dynamicArray.add(5);
        assertTrue(dynamicArray.getSize() == 5 );
        assertTrue(dynamicArray.toString().equals("[ 1 2 3 4 5 ]"));
    }
}
