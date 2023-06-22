package dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountConstructTest {

    @Test
    public void testCountConstruct() {
        CountConstruct countConstruct = new CountConstruct();
        assertEquals(countConstruct.countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}), 2);
        assertEquals(countConstruct.countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}), 1);
        assertEquals(countConstruct.countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}), 0);
        assertEquals(countConstruct.countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}), 4);
//        assertEquals(countConstruct.countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeeee", "eeeeeeee", "eeeeeeeeeeee"}),0);
    }

    @Test
    public void testMemoizedCountConstruct() {
        CountConstruct memoizedCountConstruct = new CountConstruct();
        assertEquals(memoizedCountConstruct.memoizedCountConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, new HashMap<>()), 2);
        assertEquals(memoizedCountConstruct.memoizedCountConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()), 1);
        assertEquals(memoizedCountConstruct.memoizedCountConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()), 0);
        assertEquals(memoizedCountConstruct.memoizedCountConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()), 4);
        assertEquals(memoizedCountConstruct.memoizedCountConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()),0);
    }
}
