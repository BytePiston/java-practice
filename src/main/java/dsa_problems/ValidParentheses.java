package dsa_problems;

import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * Example 1:
 * Input: s = "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * Input: s = "(]"
 * Output: false
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> opening = Map.ofEntries(
                Map.entry('(',')'),
                Map.entry('{','}'),
                Map.entry('[',']'));
        Map<Character, Character> closing = Map.ofEntries(
                Map.entry(')','('),
                Map.entry('}','{'),
                Map.entry(']','['));
        char[] charArray = s.toCharArray();
        for(char ch : charArray){
            if(opening.containsKey(ch))
                stack.push(ch);
            else{
                if(stack.isEmpty())
                    return false;
                return stack.peek().equals(closing.get(ch));
            }
        }
        return false;
    }
}
