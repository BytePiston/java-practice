package dynamicProgramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

  @Test
  public void testFibWithoutMemoization() {
    Fibonacci fibonacci = new Fibonacci();
    assertEquals(fibonacci.fibonacci(7), 13);
    assertEquals(fibonacci.fibonacci(13), 233);
  }

  @Test
  public void testFibWithMemoization() {
    Fibonacci fibonacci = new Fibonacci();
    System.out.println(fibonacci.memoizationFibonacci(50, new HashMap<>()));
    assertEquals(fibonacci.memoizationFibonacci(7, new HashMap<>()), 13);
    assertEquals(fibonacci.memoizationFibonacci(13, new HashMap<>()), 233);

  }


  /*
   * Test Case proving:
   * TimeComplexity with Memoization is very less compared normal Recursion approach.
   *
   * Input for the Normal Recursion approach -> 30; Time Taken to Compute: ~ 17 milliseconds
   * Input for the Memoization approach-> 50; Time Taken to Compute: ~ < 1 milliseconds
   */

 /* @Test
  public void testCompareTimeComplexity() {
    Fibonacci fibonacci = new Fibonacci();
    long computeTimeFibonacci = fibonacci.computeTimeFibonacci(30);
    long computeTimeMemoizationFibonacci = fibonacci.computeTimeMemoizationFibonacci(50);
    System.out.println("Time Taken by Normal Recursion approach: " + computeTimeFibonacci);
    System.out.println("Time Taken by Memoization approach: " + computeTimeMemoizationFibonacci);
    assertTrue(computeTimeMemoizationFibonacci < computeTimeFibonacci);
  }*/
}
