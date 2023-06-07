package dataStructures.dynamicArray;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DynamicArrayUsingStaticArrayTest {

  @Test
  public void testAddInitialSize() {
    DynamicArrayUsingStaticArray<Integer> dynamicArray = new DynamicArrayUsingStaticArray<>();
    dynamicArray.add(1);
    dynamicArray.add(2);
    assertEquals(dynamicArray.toString(), "[ 1 2 ]");
  }

  @Test
  public void testAddGenerics() {
    DynamicArrayUsingStaticArray<String> dynamicArray = new DynamicArrayUsingStaticArray<>();
    dynamicArray.add("apple");
    dynamicArray.add("banana");
    assertEquals(dynamicArray.toString(), "[ apple banana ]");
  }

  @Test
  public void testAddDynamicSize() {
    DynamicArrayUsingStaticArray<Integer> dynamicArray = new DynamicArrayUsingStaticArray<>(2);
    dynamicArray.add(1);
    dynamicArray.add(2);
    dynamicArray.add(3);
    dynamicArray.add(4);
    dynamicArray.add(5);
    assertEquals(dynamicArray.toString(), "[ 1 2 3 4 5 ]");
    assertEquals(dynamicArray.removeLast(), 5);
    assertEquals(dynamicArray.getSize(), 4);
    assertEquals(dynamicArray.remove(1), 1);
    assertEquals(dynamicArray.getSize(), 3);
    assertEquals(dynamicArray.toString(), "[ 2 3 4 ]");
  }

  @Test
  public void testStaticToDynamicArray() {
    Integer[] staticArray = new Integer[]{1, 2, 3};
    DynamicArrayUsingStaticArray<Integer> dynamicArray = new DynamicArrayUsingStaticArray<>(
        staticArray.length);
    dynamicArray.addAll(staticArray);
    assertEquals(dynamicArray.getSize(), 3);
    assertEquals(dynamicArray.toString(), "[ 1 2 3 ]");
    dynamicArray.add(4);
    dynamicArray.add(5);
    assertEquals(dynamicArray.getSize(), 5);
    assertEquals(dynamicArray.toString(), "[ 1 2 3 4 5 ]");
  }
}
