package dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanSumTest {

    @Test
    public void testCanSum(){
        CanSum canSumObj = new CanSum();
        assertTrue(canSumObj.canSum(7, new int[]{2,3}));
        assertTrue(canSumObj.canSum(7, new int[]{5,3,4,7}));
        assertFalse(canSumObj.canSum(7, new int[]{2,4}));
        assertTrue(canSumObj.canSum(8, new int[]{2,3,5}));
        assertFalse(canSumObj.canSum(300, new int[]{7,14}));
    }

    @Test
    public void testMemoizedCanSum(){
        CanSum canSumObj = new CanSum();
        assertTrue(canSumObj.memoizedCanSum(7, new int[]{2,3}, new HashMap<>()));
        assertTrue(canSumObj.memoizedCanSum(7, new int[]{5,3,4,7}, new HashMap<>()));
        assertFalse(canSumObj.memoizedCanSum(7, new int[]{2,4}, new HashMap<>()));
        assertTrue(canSumObj.memoizedCanSum(8, new int[]{2,3,5}, new HashMap<>()));
        assertFalse(canSumObj.canSum(300, new int[]{7,14}));
    }

    //To test the time complexity of both solutions.
    @Test
    public void testCompareComputeTimeCanSum(){
        CanSum canSum = new CanSum();
        CanSum memoizedCanSum = new CanSum();
        assertTrue(memoizedCanSum.computeTimeMemoizedCanSum(300, new int[]{7,14}) < canSum.computeTimeCanSum(300, new int[]{7,14}));
    }
}
