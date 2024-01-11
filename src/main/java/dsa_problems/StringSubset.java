package dsa_problems;

import java.util.ArrayList;
import java.util.List;

public class StringSubset {
    public static void main(String[] args) {
        System.out.println(subsetRecursion("","abc"));
    }

    static List<String> subsetRecursion(String p, String up) {
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> right = subsetRecursion(p , up.substring(1));
        List<String> left = subsetRecursion(p + up.charAt(0), up.substring(1));
        right.addAll(left);
        return right;
    }

    static List<String> subsetIterative(String p, String up){
        List<String> result = new ArrayList<>();
        while(!up.isEmpty()){

        }
        return result;
    }
}
