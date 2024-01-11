package dsa_problems;

import java.util.Arrays;
import java.util.Base64;

class Test1 {
    public static void main(String[] args) {
        // keep this function call here
        //System.out.println(QuestionsMarks("acc?7??sss?3rr1??????5"));//true

        String input = "neetcode";
        String encode = Arrays.toString(Base64.getEncoder().encode(input.getBytes()));
//        String decode = Arrays.toString(Base64.getDecoder().decode(encode.getBytes()));
        System.out.println(encode);
//        System.out.println(decode);
//        System.out.println(LongestWord("fun&!! time"));//false

    }

    public static String LongestWord(String sen) {
        // code goes here
        String[] strArray = sen.split("[^0-9^a-z]");
        String longestWord = "";
        for(String s: strArray){
            s = s.toLowerCase();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                if((ch >='0' && ch<='9') || (ch >='a' && ch<='z'))
                    sb.append(i);
            }
            System.out.println(sb.toString());
            if(longestWord.length() < sb.length())
                longestWord = sb.toString();
        }
        return longestWord;
    }


}
