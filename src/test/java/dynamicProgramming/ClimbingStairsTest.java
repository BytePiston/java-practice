package dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingStairsTest {

    @Test
    public void testClimbingStairs(){
        ClimbingStairs climbingStairs = new ClimbingStairs();
        assertEquals(climbingStairs.climbStairs(2),2);
        assertEquals(climbingStairs.climbStairs(3),3);
    }
}
