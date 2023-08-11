package dynamic_programming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllConstructTest {
    @Test
    public void testAllConstruct(){
        AllConstruct allConstruct = new AllConstruct();
        assertEquals(allConstruct.allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}).toString(),"[[purp, le], [p, ur, p, le]]");
        assertEquals(allConstruct.allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}).toString(),"[[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]");
        assertEquals(allConstruct.allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}).toString(),"[]");
//        assertEquals(allConstruct.allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", new String[]{"a", "aa", "aaa", "aaaa", "aaaaa"}).toString(),"[]");
    }

    @Test
    public void testMemoizedAllConstruct(){
        AllConstruct memoizedAllConstruct = new AllConstruct();
        assertEquals(memoizedAllConstruct.memoizedAllConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, new HashMap<>()).toString(),"[[purp, le], [p, ur, p, le]]");
        assertEquals(memoizedAllConstruct.memoizedAllConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}, new HashMap<>()).toString(),"[[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]");
        assertEquals(memoizedAllConstruct.memoizedAllConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()).toString(),"[]");
        assertEquals(memoizedAllConstruct.memoizedAllConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", new String[]{"a", "aa", "aaa", "aaaa", "aaaaa"}, new HashMap<>()).toString(),"[]");
    }
}
