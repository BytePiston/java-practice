package dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void testMemoizedGridTraveler() {
        GridTraveler gridTraveler = new GridTraveler();
        assertEquals(gridTraveler.gridTraveler(1, 1), 1);
        assertEquals(gridTraveler.gridTraveler(2, 3), 3);
        assertEquals(gridTraveler.gridTraveler(3, 2), 3);
        assertEquals(gridTraveler.gridTraveler(3, 3), 6);
        assertEquals(gridTraveler.gridTraveler(15, 15), 40116600);
    }

    @Test
    public void testTabulizedGridTraveler() {
        GridTraveler gridTraveler = new GridTraveler();
        assertEquals(gridTraveler.tabulizedGridTraveler(1, 1), 1);
        assertEquals(gridTraveler.tabulizedGridTraveler(2, 3), 3);
        assertEquals(gridTraveler.tabulizedGridTraveler(3, 2), 3);
        assertEquals(gridTraveler.tabulizedGridTraveler(3, 3), 6);
        assertEquals(gridTraveler.tabulizedGridTraveler(15, 15), 40116600);
    }

    /*
     * Test Case proving:
     * TimeComplexity with Memoization is very less compared normal Recursion approach.
     *
     * Input for the Normal Recursion approach -> 9X9 Matrix; Total Possible Ways: 12870; Time Taken to Compute: ~ 14 milliseconds
     * Input for the Memoization approach-> 18X18 Matrix; Total Possible Ways: 2333606220; Time Taken to Compute: ~ 5 milliseconds
     */

    @Test
    public void testCompareTimeComplexity() {
        GridTraveler gridTraveler = new GridTraveler();
        GridTraveler memoizedGridTraveler = new GridTraveler();
        assertTrue(memoizedGridTraveler.computeTimeMemoizedGridTraveler(15, 15) < gridTraveler.computeTimeGridTraveler(15, 15));
    }
}
