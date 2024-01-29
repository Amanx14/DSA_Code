import java.util.Arrays;

class Code {
    public static String largestOddNumber(String num) {

        for(int i=num.length()-1; i>=0; i--) {
            char currChar = num.charAt(i);
            if(currChar % 2 != 0) {
                return num.substring(0, i+1);
            }
        }        

        return "";
    }
    public static void main(String[] args) {
        String str = "1234";
        System.out.println(largestOddNumber(str));
    }
}