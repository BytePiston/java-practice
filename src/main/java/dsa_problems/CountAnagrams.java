package dsa_problems;

import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {

    public static void main(String[] args) {
        System.out.println(countAnagrams("abc", "ABcabcbacAa"));
    }

    private static int countAnagrams(String word, String sentence) {
        word = word.toLowerCase();
        sentence = sentence.toLowerCase();
        Map<Character, Integer> mapOfWord = new HashMap<>();
        int count = 0;
        for(int i=0; i<word.length(); i++){
            mapOfWord.put(word.charAt(i), mapOfWord.getOrDefault(word.charAt(i),0)+1);
        }

        for(int i=0; i<sentence.length()-word.length(); i++){
            String subString = sentence.substring(i, i+word.length());
            System.out.println(subString);
            if(isAnagram(subString, mapOfWord)){
                count += 1;
                i = i+word.length()-1;
            }
        }
        return count;
    }

    private static boolean isAnagram(String str, Map<Character, Integer> mapOfWord){
        Map<Character, Integer> copyMapOfWord = new HashMap<>(mapOfWord);

        for(char ch : str.toCharArray()){
            if(copyMapOfWord.containsKey(ch)){
                int charCount = copyMapOfWord.get(ch);
                if(charCount>1){
                    copyMapOfWord.put(ch, charCount-1);
                } else{
                    copyMapOfWord.remove(ch);
                }
            } else{
                return false;
            }
        }
        return copyMapOfWord.isEmpty();
    }
}
