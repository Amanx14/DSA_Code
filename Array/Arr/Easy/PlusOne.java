import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        
        for(int i=digits.length-1; i>=0; i--) {
    
            if(digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        
        return digits;
    }
    public static void main(String[] args) {
        // int digits[] = {1,2,3};
        int digits[] = {9,9,9};
        
        int ans[] = plusOne(digits);

        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}