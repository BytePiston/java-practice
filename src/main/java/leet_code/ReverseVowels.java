package leet_code;

import java.util.*;

/**
 * Problem Statement:
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * <p>
 * Example 1:
 * Input: s = "hello"
 * Output: "holle"
 * <p>
 * Example 2:
 * Input: s = "leetcode"
 * Output: "leotcede"
 */
public class ReverseVowels {

    public enum vowels {

    }
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        String[] strArray = new String[s.length()];
        List<Character> charArray = new ArrayList<>(s.length());
        int charIndex = 0;
        int index = 0;
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i))){
                strArray[index] = s.substring(charIndex,i);
                charArray.add(index, s.charAt(i));
                charIndex = i+1;
                index++;
            }
        }
        if(strArray.length ==0)
            return s;
        StringBuilder sb = new StringBuilder();
        for(int i=0, j=charArray.size()-1; i<strArray.length && j>=0; i++, j--){
            if(strArray[i] != null)sb.append(strArray[i]);
            sb.append(charArray.get(j));
        }
        return sb.toString();
    }
}
