package leet_code;

class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
    public static int reverse(int x) {
        if(x>=-9 && x<=9){
            return x;
        }
        boolean isNegative = false;
        String integerString = x+"";
        if(integerString.charAt(0)=='-'){
            isNegative = true;    
        }
        long reverseInt = reverseStringToInt(integerString, isNegative);
        if(reverseInt>=Integer.MIN_VALUE && reverseInt<=Integer.MAX_VALUE){
            return ((int)reverseInt);
        }
        return 0;
    }

    static long reverseStringToInt(String integerString, boolean isNegative){
        long result=0;
        if(isNegative){
            integerString = integerString.substring(1);
        }
        for(int i=0; i<integerString.length(); i++){
            char ch = integerString.charAt(integerString.length()-1-i);
            result += (long) ((ch-'0')*Math.pow(10, integerString.length()-1-i));
        }
        return result;
    }
}
