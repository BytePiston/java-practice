package dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountBitsTest {

    @Test
    public void testCountBits(){
        CountBits bits = new CountBits();
        assertEquals(Arrays.toString(bits.countBits(2)),"[0, 1, 1]");
        assertEquals(Arrays.toString(bits.countBits(5)),"[0, 1, 1, 2, 1, 2]");
        assertEquals(Arrays.toString(bits.countBits(7)),"[0, 1, 1, 2, 1, 2, 2, 3]");
        assertEquals(Arrays.toString(bits.countBits(20)),"[0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2]");
    }
}
