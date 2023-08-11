package data_structures.dynamic_array;

import java.util.Iterator;

public class DynamicArrayUsingStaticArray<T> implements DynamicArrayOperations<T> {

  private int capacity = 0;
  private T[] dynamicArray;
  private int arrayLength = 0;

  public DynamicArrayUsingStaticArray() {
    this(16);
  }

  public DynamicArrayUsingStaticArray(int capacity) {
    if (capacity < 0)
      throw new IllegalArgumentException("Capacity has to be non-negative");
    dynamicArray = (T[]) new Object[capacity];
  }

  @Override
  public void add(T data) {
    if (arrayLength + 1 > capacity) {
      if (capacity == 0)
        capacity = 1;
      else
        capacity *= 2;
      T[] newDynamicArray = (T[]) new Object[capacity];
      for (int i = 0; i < arrayLength; i++)
        newDynamicArray[i] = dynamicArray[i];
      dynamicArray = newDynamicArray;
    }
    dynamicArray[arrayLength++] = data;
  }

  @Override
  public void addAll(T[] staticArray) {
    if (arrayLength < 1) {
      dynamicArray = (T[]) new Object[staticArray.length];
    }
    for (T data : staticArray)
      add(data);
  }

  @Override
  public void set(T data, int index) {
    if (index > arrayLength + 1 || index < 0)
      throw new IllegalArgumentException("Invalid Index please enter correct index.");
    if (index == arrayLength + 1)
      add(data);
    else
      dynamicArray[index] = data;
  }

  @Override
  public T remove(T data) {
    if (isEmpty())
      throw new RuntimeException("Empty dynamic array.");
    int removalIndex = indexOf(data);
    if (removalIndex != -1)
      return removeAt(removalIndex);
    else
      throw new RuntimeException("Deletion failed as no data found.");
  }

  @Override
  public T removeLast() {
    if (isEmpty())
      throw new RuntimeException("Empty dynamic array.");
    return removeAt(arrayLength - 1);
  }

  @Override
  public T removeAt(int index) {
    if (isEmpty())
      throw new RuntimeException("Empty dynamic array.");
    if (index > arrayLength || index < 0)
      throw new IllegalArgumentException("Invalid Index please enter correct index.");
    T[] newDynamicArray = (T[]) new Object[arrayLength - 1];
    T data = null;
    for (int i = 0, j = 0; i < arrayLength; i++, j++) {
      if (i == index) {
        data = dynamicArray[i];
        i++;
      }
      if (i <= newDynamicArray.length)
        newDynamicArray[j] = dynamicArray[i];
    }
    dynamicArray = newDynamicArray;
    capacity = --arrayLength;
    return data;
  }

  @Override
  public void clear() {
    for (int i = 0; i < arrayLength; i++)
      dynamicArray[i] = null;
    arrayLength = 0;
  }

  @Override
  public T get(int index) {
    if (isEmpty())
      throw new RuntimeException("Empty dynamic array.");
    if (index > arrayLength || index < 0)
      throw new IllegalArgumentException("Invalid Index please enter correct index.");
    return dynamicArray[index];
  }

  @Override
  public boolean contains(T data) {
    return indexOf(data) != -1;
  }

  @Override
  public int indexOf(T data) {
    if (isEmpty())
      throw new RuntimeException("Empty dynamic array.");
    for (int i = 0; i < arrayLength; i++) {
      if (dynamicArray[i].equals(data))
        return i;
    }
    return -1;
  }

  @Override
  public int getSize() {
    return arrayLength;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < arrayLength;
      }

      @Override
      public T next() {
        return dynamicArray[index++];
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
    for (T data : dynamicArray)
      if (data != null)
        sb.append(data + " ");
    return sb.append("]").toString();
  }

  private boolean isEmpty() {
    return getSize() == 0;
  }
}
