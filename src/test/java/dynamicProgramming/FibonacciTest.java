package dynamicProgramming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    assertEquals(fibonacci.memoizedFibonacci(50, new HashMap<>()),12586269025L);
    assertEquals(fibonacci.memoizedFibonacci(7, new HashMap<>()), 13);
    assertEquals(fibonacci.memoizedFibonacci(13, new HashMap<>()), 233);

  }

  @Test
  public void testFibWithTabulation() {
    Fibonacci fibonacci = new Fibonacci();
    assertEquals(fibonacci.tabulizedFibonacci(50),12586269025L);
    assertEquals(fibonacci.tabulizedFibonacci(7), 13);
    assertEquals(fibonacci.tabulizedFibonacci(13), 233);
  }

  @Test
  public void testFibWithSingleIteration() {
    Fibonacci fibonacci = new Fibonacci();
    assertEquals(fibonacci.fibonacciSingleIteration(50),12586269025L);
    assertEquals(fibonacci.fibonacciSingleIteration(7), 13);
    assertEquals(fibonacci.fibonacciSingleIteration(13), 233);
  }

  /*
   * Test Case proving:
   * TimeComplexity with Memoization is very less compared normal Recursion approach.
   *
   * Input for the Normal Recursion approach -> 30; Time Taken to Compute: ~ 17 milliseconds
   * Input for the Memoization approach-> 50; Time Taken to Compute: ~ < 1 milliseconds
   */

  @Test
  public void testCompareTimeComplexity() {
    Fibonacci fibonacci = new Fibonacci();
    Fibonacci memoizedFibonacci = new Fibonacci();
    assertTrue(memoizedFibonacci.computeTimeMemoizedFibonacci(50) < fibonacci.computeTimeFibonacci(35));
  }
}
