package dynamic_programming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

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

   /* @Test
    public void testCanSumPath(){
        CanSum canSumObj = new CanSum();
        assertEquals(canSumObj.canSumPath(7, new int[]{2,3}), "[3, 2, 2]");
        assertEquals(canSumObj.canSumPath(7, new int[]{5,3,4,7}), "[4, 3]");
        assertEquals(canSumObj.canSumPath(7, new int[]{2,4}), "[]");
        assertEquals(canSumObj.canSumPath(8, new int[]{2,3,5}), "[2, 2, 2, 2]");
        assertEquals(canSumObj.canSumPath(8, new int[]{3,5}), "[5, 3]");
    }*/

    @Test
    public void testMemoizedCanSum(){
        CanSum canSumObj = new CanSum();
        assertTrue(canSumObj.memoizedCanSum(7, new int[]{2,3}, new HashMap<>()));
        assertTrue(canSumObj.memoizedCanSum(7, new int[]{5,3,4,7}, new HashMap<>()));
        assertFalse(canSumObj.memoizedCanSum(7, new int[]{2,4}, new HashMap<>()));
        assertTrue(canSumObj.memoizedCanSum(8, new int[]{2,3,5}, new HashMap<>()));
        assertFalse(canSumObj.memoizedCanSum(300, new int[]{7,14}, new HashMap<>()));
    }

    @Test
    public void testTabulizedCanSum(){
        CanSum canSum = new CanSum();
        assertTrue(canSum.tabulizedCanSum(7, new int[]{2,3}));
        assertTrue(canSum.tabulizedCanSum(7, new int[]{5,3,4,7}));
        assertFalse(canSum.tabulizedCanSum(7, new int[]{2,4}));
        assertTrue(canSum.tabulizedCanSum(8, new int[]{2,3,5}));
        assertFalse(canSum.tabulizedCanSum(300, new int[]{7,14}));
    }

 /*   @Test
    public void testMemoizedCanSumPath(){
        CanSum canSumObj = new CanSum();
        assertEquals(canSumObj.memoizedCanSumPath(7, new int[]{2,3}), "[3, 2, 2]");
        assertEquals(canSumObj.memoizedCanSumPath(7, new int[]{5,3,4,7}), "[4, 3]");
        assertEquals(canSumObj.memoizedCanSumPath(7, new int[]{2,4}), "[]");
        assertEquals(canSumObj.memoizedCanSumPath(8, new int[]{2,3,5}), "[2, 2, 2, 2]");
        assertEquals(canSumObj.memoizedCanSumPath(8, new int[]{3,5}), "[5, 3]");
    }*/

    //To test the time complexity of both solutions.
    @Test
    public void testCompareComputeTimeCanSum(){
        CanSum canSum = new CanSum();
        CanSum memoizedCanSum = new CanSum();
        assertTrue(memoizedCanSum.computeTimeMemoizedCanSum(300, new int[]{7,14}) < canSum.computeTimeCanSum(300, new int[]{7,14}));
    }
}
