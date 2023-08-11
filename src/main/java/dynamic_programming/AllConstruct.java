package dynamic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Write a function 'allConstruct(target, wordBank)' that accepts a target string and array of strings.
 * <p>
 * The function should return arrays of different way to construct 'target' string by concatenating elements
 * from the 'wordBank' array and if so then in how many ways we can construct the 'target' string else return Empty array.
 * <p>
 * You may reuse elements of 'wordBank' as many times as needed.
 * <p>
 * Example:
 * allConstruct(abcdef, [ab, abc, cd, def, abcd]) --> return [[abc, def]].
 * allConstruct(purple, [purp, p, ur, le, purpl]) --> return [[purp, le] [p, ur, p, le]].
 * allConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]) --> return [].
 */
public class AllConstruct {

    public List<List<String>> allConstruct(String target, String[] wordBank) {
        if (target.isEmpty()) {
            List<List<String>> emptyList = new ArrayList<>();
            emptyList.add(new ArrayList<>());
            return emptyList;
        }
        List<List<String>> allPaths = new ArrayList<>();
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                List<List<String>> suffixPaths = allConstruct(target.substring(word.length()), wordBank);
                suffixPaths.forEach(i -> i.add(0, word));
                allPaths.addAll(suffixPaths);
            }
        }
        return allPaths;
    }

    public List<List<String>> memoizedAllConstruct(String target, String[] wordBank, Map<String, List<List<String>>> memo) {
        if(memo.containsKey(target))
            return memo.get(target);
        if (target.isEmpty()) {
            List<List<String>> emptyList = new ArrayList<>();
            emptyList.add(new ArrayList<>());
            return emptyList;
        }
        List<List<String>> allPaths = new ArrayList<>();
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                List<List<String>> suffixPaths = memoizedAllConstruct(target.substring(word.length()), wordBank, memo);
                for(List<String> path : suffixPaths){
                    List<String> suffixPath = new ArrayList<>(path);
                    suffixPath.add(0, word);
                    allPaths.add(suffixPath);
                }
            }
        }
        memo.put(target, allPaths);
        return allPaths;
    }
}
