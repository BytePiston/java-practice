package dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanConstructTest {

    @Test
    public void testCanConstruct(){
        CanConstruct canConstruct = new CanConstruct();
        assertTrue(canConstruct.canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        assertFalse(canConstruct.canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        assertTrue(canConstruct.canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
//        assertFalse(canConstruct.canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeeee", "eeeeeeee", "eeeeeeeeeeee"}));
    }

    @Test
    public void testMemoizedCanConstruct(){
        CanConstruct memoizedCanConstruct = new CanConstruct();
        assertTrue(memoizedCanConstruct.memoizedCanConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        assertFalse(memoizedCanConstruct.memoizedCanConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        assertTrue(memoizedCanConstruct.memoizedCanConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        assertFalse(memoizedCanConstruct.memoizedCanConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeeee", "eeeeeeee", "eeeeeeeeeeee"}, new HashMap<>()));
    }
}
