package dynamicProgramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GridTravelerTest {

  @Test
  public void testGridTraveler() {
    GridTraveler gridTraveler = new GridTraveler();
    assertEquals(gridTraveler.gridTraveler(1, 1), 1);
    assertEquals(gridTraveler.gridTraveler(2, 3), 3);
    assertEquals(gridTraveler.gridTraveler(3, 2), 3);
    assertEquals(gridTraveler.gridTraveler(3, 3), 6);
    assertEquals(gridTraveler.gridTraveler(9, 9), 12870);
  }

  @Test
  public void testMemoizationGridTraveler() {
    GridTraveler gridTraveler = new GridTraveler();
    assertEquals(gridTraveler.gridTraveler(1, 1), 1);
    assertEquals(gridTraveler.gridTraveler(2, 3), 3);
    assertEquals(gridTraveler.gridTraveler(3, 2), 3);
    assertEquals(gridTraveler.gridTraveler(3, 3), 6);
    assertEquals(gridTraveler.gridTraveler(18, 18), 2333606220L);
  }

  /*
   * Test Case proving:
   * TimeComplexity with Memoization is very less compared normal Recursion approach.
   *
   * Input for the Normal Recursion approach -> 9X9 Matrix; Total Possible Ways: 12870; Time Taken to Compute: ~ 14 milliseconds
   * Input for the Memoization approach-> 18X18 Matrix; Total Possible Ways: 2333606220; Time Taken to Compute: ~ 5 milliseconds
   */

  /*@Test
  public void testCompareTimeComplexity() {
    GridTraveler gridTraveler = new GridTraveler();
    long computeTimeGridTraveler = gridTraveler.computeTimeGridTraveler(9, 9);
    long computeTimeMemoizationGridTraveler = gridTraveler.computeTimeMemoizationGridTraveler(18,
        18);
    System.out.println("Time Taken by Normal Recursion approach: " + computeTimeGridTraveler);
    System.out.println("Time Taken by Memoization approach: " + computeTimeMemoizationGridTraveler);
    assertTrue(computeTimeMemoizationGridTraveler < computeTimeGridTraveler);
  }*/
}
