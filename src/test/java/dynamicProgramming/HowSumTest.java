package dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HowSumTest {

    @Test
    public void testHowSum(){
        HowSum howSum = new HowSum();
        assertEquals(howSum.howSum(7,new int[] {5,3,4,7}).toString(), "[4, 3]");
        assertEquals(howSum.howSum(8,new int[] {2,3,5}).toString(), "[2, 2, 2, 2]");
        assertEquals(howSum.howSum(8,new int[] {1,4,5}).toString(), "[1, 1, 1, 1, 1, 1, 1, 1]");
    }

    @Test
    public void testMemoizedHowSum(){
        HowSum memoizedHowSum = new HowSum();
        assertEquals(memoizedHowSum.memoizedHowSum(7,new int[] {5,3,4,7}, new HashMap<>()).toString(), "[4, 3]");
        assertEquals(memoizedHowSum.memoizedHowSum(8,new int[] {2,3,5}, new HashMap<>()).toString(), "[2, 2, 2, 2]");
        assertEquals(memoizedHowSum.memoizedHowSum(8,new int[] {1,4,5}, new HashMap<>()).toString(), "[1, 1, 1, 1, 1, 1, 1, 1]");
    }
}
