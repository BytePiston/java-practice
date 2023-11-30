//
//package leet_code;
//
//import java.util.HashMap;
//import java.util.Map;
//
//class Solution {
//
//    public static void main(String[] args) {
//        Characte;
//        Character j = i;
//        System.out.println(i == j);
//
//    }
//    public int uniquePaths(int m, int n) {
//       return solve(m, n, new HashMap<>());
//    }
//
//    int solve(int m, int n, Map<String, Integer> memo){
//        if(m<0 || n<0)
//            return 0;
//        if(m==1 && n==1)
//            return 1;
//        String key = m + "," + n;
//        if(memo.containsKey(key))
//            memo.get(key);
//        int count = uniquePaths(m-1, n) + uniquePaths(m, n+1);
//        memo.put(key, count);
//        return count;
//    }
//}
