package dsa_problems;

class CountPalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    public static int countSubstrings(String s) {

        int totalCount = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                String subString = s.substring(i,j);
                if(isPalindromicSubstrings(subString)){
                    totalCount += 1;
                }
            }
        }
        return totalCount;
    }

    static boolean isPalindromicSubstrings(String subString){
        
        if(subString.length() == 1){
            return true;
        }
        
        int left = 0;
        int right = subString.length()-1;
        while(left < right){
            if(subString.charAt(left) != subString.charAt(right)){
                return false;
            }
        }
        return true;
    }
}
