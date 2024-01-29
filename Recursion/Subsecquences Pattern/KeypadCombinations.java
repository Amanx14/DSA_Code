import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KeypadCombinations {
    public static void solve(String digits, int idx, String newStr, List<String> ans, String[] Keypad) {
        // base case
        if(idx >= digits.length()) {
            if(newStr.length() > 0) {
                ans.add(newStr);
            }
            return;
        }

        char ch = digits.charAt(idx);
        int number = ch-'0';
        String mapping = Keypad[number];

        for(int i=0; i<mapping.length(); i++) {
            newStr += mapping.charAt(i);
            solve(digits, idx+1, newStr, ans, Keypad);
            newStr = newStr.substring(0, newStr.length()-1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        String newStr = ""; // output string
        int idx = 0;
        List<String> ans = new ArrayList<>(); // answer store
        String Keypad[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        solve(digits, idx, newStr, ans, Keypad);
        return ans;
    }
    public static void main(String args[]) {
        String str = "23";
        List<String> ans = letterCombinations(str);
        System.out.println(ans);
    }
}