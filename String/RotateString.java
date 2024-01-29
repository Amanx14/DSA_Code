import java.util.Arrays;
import java.util.HashMap;

class Code {
    public static boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        String doubleString = s + s;

        if (doubleString.contains(goal)) {
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";

        System.out.println(rotateString(s, goal));
    }
}