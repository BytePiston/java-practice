package dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestSumTest {

    @Test
    public void testBestSum(){
        BestSum bestSum = new BestSum();
        assertEquals(bestSum.bestSum(7,new int[] {5,3,4,7}).toString(), "[7]");
        assertEquals(bestSum.bestSum(8,new int[] {2,3,5}).toString(), "[5, 3]");
        assertEquals(bestSum.bestSum(8,new int[] {1,4,5}).toString(), "[4, 4]");
//        assertEquals(bestSum.bestSum(100,new int[] {1,2,5,25}).toString(), "[25, 25, 25, 25]");
    }

    @Test
    public void testMemoizedBestSum(){
        BestSum memoizedBestSum = new BestSum();
        assertEquals(memoizedBestSum.memoizedBestSum(7,new int[] {5,3,4,7}, new HashMap<>()).toString(), "[7]");
        assertEquals(memoizedBestSum.memoizedBestSum(8,new int[] {2,3,5}, new HashMap<>()).toString(), "[5, 3]");
        assertEquals(memoizedBestSum.memoizedBestSum(8,new int[] {1,4,5}, new HashMap<>()).toString(), "[4, 4]");
        assertEquals(memoizedBestSum.memoizedBestSum(100,new int[] {1,2,5,25}, new HashMap<>()).toString(), "[25, 25, 25, 25]");
    }

    @Test
    public void testTabulizedBestSum(){
        BestSum tabulizedBestSum = new BestSum();
        assertEquals(tabulizedBestSum.tabulizedBestSum(7,new int[] {5,3,4,7}).toString(), "[7]");
        assertEquals(tabulizedBestSum.tabulizedBestSum(8,new int[] {2,3,5}).toString(), "[5, 3]");
        assertEquals(tabulizedBestSum.tabulizedBestSum(8,new int[] {1,4,5}).toString(), "[4, 4]");
        assertEquals(tabulizedBestSum.tabulizedBestSum(100,new int[] {1,2,5,25}).toString(), "[25, 25, 25, 25]");
    }
}
