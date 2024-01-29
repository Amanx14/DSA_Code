public class StringtoIntegerAtoi {
    public static int myAtoi(String s) {
       int i = 0, n = s.length();

        // Skipping space characters at the beginning
        s = s.trim();

        int positive = 0, negative = 0;

        // Detecting and counting positive and negative signs
        if (i < n && s.charAt(i) == '+') {
            positive++; // Number of positive signs at the start of the string
            i++;
        }

        if (i < n && s.charAt(i) == '-') {
            negative++; // Number of negative signs at the start of the string
            i++;
        }

        double ans = 0;

        // Parsing the numeric portion of the string
        while (i < n) {
            if(s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) break;
            int digit = (s.charAt(i) - '0');
            ans = ans * 10 + digit;
            i++;
        }

        // Handling negative sign
        if (negative > 0) {
            ans = -ans;
        }

        // Handling cases where both +ve and -ve signs exist
        if (positive > 0 && negative > 0) {
            return 0;
        }

        // Handling integer overflows and underflows
        if (ans > Integer.MAX_VALUE) {
            ans = Integer.MAX_VALUE;
        }

        if (ans < Integer.MIN_VALUE) {
            ans = Integer.MIN_VALUE;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        String s = "-144";
        System.out.println(myAtoi(s));
    }
}