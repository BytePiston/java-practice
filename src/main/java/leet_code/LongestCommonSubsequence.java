package leet_code;

class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return lcs(text1, text1.length()-1, text2, text2.length()-1, dp);
    }

    static int lcs(String text1, int index1, String text2, int index2, int[][] dp){
        if(index1<0 || index2<0)
            return 0;
        if(dp[index1][index2] !=-1)
            return dp[index1][index2];
        if(text1.charAt(index1) == text2.charAt(index2)){
            dp[index1][index2] = 1 + lcs(text1, index1-1, text2, index2-1, dp);
            return dp[index1][index2];
        }
        dp[index1][index2] = 0 + Math.max(lcs(text1, index1-1, text2, index2, dp), lcs(text1, index1, text2, index2-1, dp));
        return dp[index1][index2];
    }
}
