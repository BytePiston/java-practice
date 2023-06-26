package dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingStairsTest {

    @Test
    public void testMemoizedClimbingStairs() {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        assertEquals(climbingStairs.memoizedClimbStairs(2), 2);
        assertEquals(climbingStairs.memoizedClimbStairs(3), 3);
        assertEquals(climbingStairs.memoizedClimbStairs(15), 987);
    }

    @Test
    public void testTabulizedClimbingStairs() {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        assertEquals(climbingStairs.tabulizedClimbStairs(2), 2);
        assertEquals(climbingStairs.tabulizedClimbStairs(3), 3);
        assertEquals(climbingStairs.memoizedClimbStairs(15), 987);
    }

    @Test
    public void testClimbingStairsFibonacci() {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        assertEquals(climbingStairs.climbStairsUsingFib(2), 2);
        assertEquals(climbingStairs.climbStairsUsingFib(3), 3);
        assertEquals(climbingStairs.memoizedClimbStairs(15), 987);
    }
}
